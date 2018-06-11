package com.example.identifier.mappers;

import com.example.identifier.models.IdentityDocument;
import com.example.identifier.pojo.FilterRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IdentityDocumentMapper {
    List<IdentityDocument> search(FilterRequest filterRequest);
}
