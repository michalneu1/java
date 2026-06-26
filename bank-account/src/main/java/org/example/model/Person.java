package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Person {
    protected final String name;
    protected String lastName;
    protected int age;
}
