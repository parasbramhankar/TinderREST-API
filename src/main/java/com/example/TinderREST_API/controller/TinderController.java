package com.example.TinderREST_API.controller;

import com.example.TinderREST_API.dto.Person;
import com.example.TinderREST_API.service.TinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TinderController {

    @Autowired
    TinderService tinderService;

    @GetMapping("/persons")
    public List<Person>getPersons(){
       return tinderService.filterPersonByGender();
    }

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person){
        return tinderService.addPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestBody Person person){

       boolean updated=tinderService.updatePerson(id,person);

       if(updated){
           return ResponseEntity.status(HttpStatus.OK).body("Person details updated successfully");
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateEducation(@PathVariable int id, @RequestBody String education){

        boolean updated=tinderService.updateEducation(id,education);
        if(updated){
            return ResponseEntity.status(HttpStatus.OK).body("Education updated Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id){
        boolean deleted=tinderService.deletePerson(id);

        if(deleted){
            return ResponseEntity.status(HttpStatus.OK).body("Person deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person Not found");
    }

}

