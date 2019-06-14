package com.hrd.homework_spring.homework_spring.repository.model;

public class Category {
    int id;
    String name;

    public Category(int id, String category) {
        this.id = id;
        this.name = category;
    }

    public Category() {
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categories='" + name + '\'' +
                '}';
    }
}
