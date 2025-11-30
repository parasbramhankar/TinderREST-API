package com.example.TinderREST_API.controller;

import com.example.TinderREST_API.dto.Person;
import com.example.TinderREST_API.service.TinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TinderController {

    List<Person>personList;
    List<Person>personListByGender;

    @Autowired
    TinderService tinderService;

    @Value("${User.gender}")
    String userGender;

    @GetMapping("/persons")
    public List<Person>getAllPerson(){
        personList=tinderService.getAllPerson();
        personListByGender=tinderService.filterPerson();
        return personListByGender;
    }

    @PostMapping("/create-person")
    public Person createPerson(@RequestBody Person person){
        personList.add(person);

        if(!userGender.equalsIgnoreCase(person.getGender())){
            personListByGender.add(person);
        }

        return person;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable int id, @RequestBody Person person){

        Person finalObj=null;
        for(Person obj:personList){
            if(obj.getId()==id){
                finalObj=obj;
                break;
            }
        }

        if(finalObj!=null){
            finalObj.setName(person.getName());
            finalObj.setAge(person.getAge());
            finalObj.setGender(person.getGender());
            finalObj.setCity(person.getCity());
            finalObj.setEducation(person.getEducation());

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
