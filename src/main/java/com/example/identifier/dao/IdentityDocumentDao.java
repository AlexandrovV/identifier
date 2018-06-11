package com.example.identifier.dao;

import com.example.identifier.models.IdentityDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityDocumentDao extends CrudRepository<IdentityDocument, Long> {
}
