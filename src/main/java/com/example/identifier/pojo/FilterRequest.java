package com.example.identifier.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class FilterRequest {
    String firstName;
    String lastName;
    String patronymic;
    Date birthDate;
    String documentNumber;
}