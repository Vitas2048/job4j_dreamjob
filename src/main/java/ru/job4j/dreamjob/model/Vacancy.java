package ru.job4j.dreamjob.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Vacancy {

    private int id;

    private String title;

    private String description;

    private LocalDateTime dateTime = LocalDateTime.now();

    private boolean visible;

    private int cityId;

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


    public Vacancy() {
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