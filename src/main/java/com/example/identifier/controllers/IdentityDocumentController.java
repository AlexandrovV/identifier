package com.example.identifier.controllers;

import com.example.identifier.dao.IdentityDocumentDao;
import com.example.identifier.dao.PersonDao;
import com.example.identifier.mappers.IdentityDocumentMapper;
import com.example.identifier.models.IdentityDocument;
import com.example.identifier.models.Person;
import com.example.identifier.pojo.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/identityDocuments")
public class IdentityDocumentController {
    @Autowired
    IdentityDocumentDao identityDocumentDao;
    @Autowired
    IdentityDocumentMapper identityDocumentMapper;
    @Autowired
    PersonDao personDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<IdentityDocument> getAllIdentityDocuments() {
        return (List<IdentityDocument>) identityDocumentDao.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public IdentityDocument createIdentityDocument(@RequestBody IdentityDocument identityDocument) {
        Person person = personDao.findById(identityDocument.getPerson().getId()).orElseThrow(() -> new NoSuchElementException("No person with id " + identityDocument.getPerson().getId() + " was found"));
        identityDocument.setPerson(person);
        return identityDocumentDao.save(identityDocument);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public IdentityDocument getIdentityDocumentById(@PathVariable long id) {
        return identityDocumentDao.findById(id).orElseThrow(() -> new NoSuchElementException("No identity document with id " + id + " was found"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public IdentityDocument updateIdentityDocument(@RequestBody IdentityDocument identityDocument, @PathVariable long id) {
        identityDocument.setId(id);
        return identityDocumentDao.save(identityDocument);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteIdentityDocument(@PathVariable long id) {
        IdentityDocument identityDocument = identityDocumentDao.findById(id).orElseThrow(() -> new NoSuchElementException("No identity document with id " + id + " was found"));
        identityDocumentDao.delete(identityDocument);
        return true;
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<IdentityDocument> search(@RequestBody FilterRequest filterRequest) {
        return identityDocumentMapper.search(filterRequest);
    }
}
