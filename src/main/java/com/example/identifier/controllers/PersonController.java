package com.example.identifier.controllers;

import com.example.identifier.dao.PersonDao;
import com.example.identifier.mappers.PersonMapper;
import com.example.identifier.models.Person;
import com.example.identifier.pojo.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    PersonDao personDao;
    @Autowired
    PersonMapper personMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return (List<Person>) personDao.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        return personDao.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable long id) {
        return personDao.findById(id).orElseThrow(() -> new NoSuchElementException("No person with id " + id + " was found"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@RequestBody Person person, @PathVariable long id) {
        person.setId(id);
        return personDao.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deletePerson(@PathVariable long id) {
        Person person = personDao.findById(id).orElseThrow(() -> new NoSuchElementException("No person with id " + id + " was found"));
        personDao.delete(person);
        return true;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Person> search(@RequestBody FilterRequest filterRequest) {
        return personMapper.search(filterRequest);
    }
}
