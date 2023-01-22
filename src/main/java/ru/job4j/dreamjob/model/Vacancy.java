package ru.job4j.dreamjob.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Vacancy {

    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "title", "title",
            "description", "description",
            "creation_date", "dateTime",
            "visible", "visible",
            "city_id", "cityId",
            "file_id", "fileId"
    );


    private int id;

    private String title;

    private String description;

    private LocalDateTime dateTime = LocalDateTime.now();

    private boolean visible;

    private int cityId;

    private int fileId;

    public Vacancy(int id, String title, LocalDateTime dateTime, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }
    public Vacancy(int id, String title, LocalDateTime dateTime, String description, boolean visible) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.visible = visible;
    }

    public Vacancy(int id, String title, LocalDateTime dateTime, String description, boolean visible, int cityId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.visible = visible;
        this.cityId = cityId;
    }

    public Vacancy(int id, String title, LocalDateTime dateTime, String description, boolean visible,
                   int cityId, int fileId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.visible = visible;
        this.cityId = cityId;
        this.fileId = fileId;
    }

    public Vacancy() {
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return id == vacancy.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}