package org.example;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person{name='" + name + "'}";
    }
}