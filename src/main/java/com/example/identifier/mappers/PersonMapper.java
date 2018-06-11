package com.example.identifier.mappers;

import com.example.identifier.models.Person;
import com.example.identifier.pojo.FilterRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    List<Person> search(FilterRequest filterRequest);
}
