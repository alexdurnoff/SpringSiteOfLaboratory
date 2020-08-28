package ru.durnov.entity;

import java.nio.file.Path;

public class Build {
    private String title;
    private String adress;
    private String description;
    private String date_end_of_build;
    private String employer;
    private Path image_of_build;

    public Build(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_end_of_build() {
        return date_end_of_build;
    }

    public void setDate_end_of_build(String date_end_of_build) {
        this.date_end_of_build = date_end_of_build;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public Path getImage_of_build() {
        return image_of_build;
    }

    public void setImage_of_build(Path image_of_build) {
        this.image_of_build = image_of_build;
    }
}

