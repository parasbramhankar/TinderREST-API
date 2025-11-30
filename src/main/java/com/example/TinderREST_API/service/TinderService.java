package com.example.TinderREST_API.service;

import com.example.TinderREST_API.dto.Person;

import java.util.List;

public interface TinderService {
  List<Person> getAllPerson();
  List<Person> filterPerson();
}
