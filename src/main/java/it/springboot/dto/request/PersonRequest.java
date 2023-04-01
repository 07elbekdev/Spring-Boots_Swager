package it.springboot.dto.request;

import lombok.Data;

@Data
public class PersonRequest {
    private String name;
    private int age;
}