package ru.job4j.dreamjob.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Query;
import ru.job4j.dreamjob.configuration.DatasourceConfiguration;
import ru.job4j.dreamjob.model.User;

import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class Sql2oUserRepositoryTest {

    private static Sql2oUserRepository sql2oUserRepository;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oCandidateRepositoryTest.class.getClassLoader().getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);

        sql2oUserRepository = new Sql2oUserRepository(sql2o);
    }

    @AfterEach
    public void clearUsers() {
        var users = sql2oUserRepository.findAll();
        for (var user : users) {
            sql2oUserRepository.deleteById(user.getId());
        }
    }

    @Test
    public void whenSave() {
        User user = new User(0, "google", "gogle", "1010");
        sql2oUserRepository.save(user);
        assertThat(user).isEqualTo(sql2oUserRepository.findByEmailAndPassword("google", "1010").get());
    }

    @Test
    public void whenDoubleSave() {
        User user = new User(0, "google", "gogle", "1010");
        sql2oUserRepository.save(user);
        assertThatThrownBy(() -> sql2oUserRepository.save(user));
    }

    @Test
    public void whenMultipleSave() {
        User user = new User(0, "google", "gog1le", "1010");
        User user2 = new User(0, "googl1e", "gogl2e", "1010");
        User user3 = new User(0, "googl2e", "gogl3e", "1010");
        sql2oUserRepository.save(user);
        sql2oUserRepository.save(user2);
        sql2oUserRepository.save(user3);
        assertThat(sql2oUserRepository.findByEmailAndPassword("googl1e", "1010")).get().isEqualTo(user2);
        assertThat(sql2oUserRepository.findByEmailAndPassword("googl2e", "1010")).get().isEqualTo(user3);
        assertThat(sql2oUserRepository.findByEmailAndPassword("google", "1010")).get().isEqualTo(user);
    }

}