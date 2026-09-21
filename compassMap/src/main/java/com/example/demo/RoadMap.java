package com.example.demo;

public class RoadMap {

    //fields
    private String id;
    private String name;
    private String description;
    private int steps;
    private boolean completed;

    //constructor
    public RoadMap() {}

    public RoadMap(String name, String description, int steps, boolean completed) {
        this.name = name;
        this.description = description;
        this.steps = steps;
        this.completed = completed;
    }

    //methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
