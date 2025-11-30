package com.example.TinderREST_API.service;

import com.example.TinderREST_API.dto.Person;

import java.util.List;

public interface TinderService {
  List<Person> getAllPerson();
  List<Person>filterPersonByGender();
  Person addPerson(Person person);
  boolean updatePerson(int id, Person person);
  boolean updateEducation(int id, String education);
  boolean deletePerson(int id);
}
