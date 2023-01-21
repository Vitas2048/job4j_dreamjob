package ru.job4j.dreamjob.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Vacancy;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public final class MemoryVacancyRepository implements VacancyRepository {

    private AtomicInteger nextId = new AtomicInteger(1);

    private final ConcurrentMap<Integer, Vacancy> vacancies = new ConcurrentHashMap<>();

    public MemoryVacancyRepository() {
        save(new Vacancy(0, "Intern Java Developer", LocalDateTime.now(), "job4j", true, 1, 0));
        save(new Vacancy(0, "Junior Java Developer", LocalDateTime.now(), "job4j", true, 3, 0));
        save(new Vacancy(0, "Junior+ Java Developer", LocalDateTime.now(), "job4j", true, 2, 0));
        save(new Vacancy(0, "Middle Java Developer", LocalDateTime.now(), "job4j", true, 4, 0));
        save(new Vacancy(0, "Middle+ Java Developer", LocalDateTime.now(), "job4j", true, 1, 0));
        save(new Vacancy(0, "Senior Java Developer", LocalDateTime.now(), "job4j", true, 2, 0));
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        vacancy.setId(nextId.incrementAndGet());
        vacancies.put(vacancy.getId(), vacancy);
        return vacancy;
    }

    @Override
    public boolean deleteById(int id) {
        return vacancies.remove(id) != null;
    }

    @Override
    public boolean update(Vacancy vacancy) {
        return vacancies.computeIfPresent(vacancy.getId(), (id, oldVacancy) -> new Vacancy(oldVacancy.getId(),
                vacancy.getTitle(), vacancy.getDateTime(), vacancy.getDescription(), vacancy.getVisible(),
                vacancy.getCityId(), vacancy.getFileId())) != null;
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        return Optional.ofNullable(vacancies.get(id));
    }

    @Override
    public Collection<Vacancy> findAll() {
        return new ArrayList<>(vacancies.values().stream().toList());
    }

}