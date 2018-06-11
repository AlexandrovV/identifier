package com.example.identifier.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    String patronymic;
    @JsonFormat(pattern = "dd.MM.yyyy")
    @Column(name = "birth_date")
    Date birthDate;
    String gender;
    String address;
    @JsonManagedReference
    @OneToMany(mappedBy = "person")
    List<IdentityDocument> identityDocuments;
}
