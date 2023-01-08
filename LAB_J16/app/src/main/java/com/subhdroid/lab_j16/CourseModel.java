package com.subhdroid.lab_j16;

public class CourseModel {
    String name, duration, description;

    CourseModel(String name, String duration, String description) {
        this.name = name;
        this.duration = duration;
        this.description = description;
    }

    public CourseModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
