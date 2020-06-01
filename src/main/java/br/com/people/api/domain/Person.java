package br.com.people.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Person {
    private long id;
    private String name;
    private int age;
}
