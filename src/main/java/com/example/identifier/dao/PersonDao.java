package com.example.identifier.dao;

import com.example.identifier.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends CrudRepository<Person, Long> {
}
