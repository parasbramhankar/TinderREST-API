package com.example.TinderREST_API.service;

import com.example.TinderREST_API.dto.Person;

import java.util.List;

public interface TinderService {
  List<Person> getAllPerson();
  List<Person>filterPersonByGender();
  Person addPerson(Person person);
  boolean updatePerson(int id, Person person);
  boolean updateAgeAndEducation(int id, int age, String education);
  boolean deletePerson(int id);
}
