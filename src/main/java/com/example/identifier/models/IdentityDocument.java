package com.example.identifier.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "identity_document")
public class IdentityDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "document_number")
    String documentNumber;
    @Column(name = "document_type")
    String documentType;
    @Column(name = "issuing_authority")
    String issuingAuthority;
    @JsonFormat(pattern = "dd.MM.yyyy")
    @Column(name = "issue_date")
    Date issueDate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    @Column(name ="expiration_date")
    Date expirationDate;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    Person person;
}
