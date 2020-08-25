package ru.durnov.service;

public class TestBean {
    private String name;

    public TestBean(String name) {
        this.name = name;
    }

    public TestBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
