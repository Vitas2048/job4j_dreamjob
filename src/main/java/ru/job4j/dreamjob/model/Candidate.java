package ru.job4j.dreamjob.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Candidate {
    private int id;

    private String name;

    private String description;

    private LocalDateTime dateTime = LocalDateTime.now();

    private boolean visible;

    private int cityId;

    private int fileId;

    public Candidate(int id, String name, LocalDateTime dateTime, String description) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.description = description;
    }
    public Candidate(int id, String name, LocalDateTime dateTime, String description, boolean visible) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.description = description;
        this.visible = visible;
    }
    public Candidate(int id, String name, LocalDateTime dateTime, String description, boolean visible, int cityId) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.description = description;
        this.visible = visible;
        this.cityId = cityId;
    }

    public Candidate(int id, String name, LocalDateTime dateTime, String description, boolean visible, int cityId, int fileId) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.description = description;
        this.visible = visible;
        this.cityId = cityId;
        this.fileId = fileId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }


    public Candidate() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Candidate candidate = (Candidate) o;
        return id == candidate.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
