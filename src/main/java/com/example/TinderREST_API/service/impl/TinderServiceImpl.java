package com.example.TinderREST_API.service.impl;

import com.example.TinderREST_API.dto.Person;
import com.example.TinderREST_API.service.TinderService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TinderServiceImpl implements TinderService {


    Person amit=new Person(1,"Amit","Gondia","M",20,"B.Sc");
    Person lokesh=new Person(2,"Lokesh","Nagpur","M",23,"B.tech");
    Person dimple=new Person(3,"Dimple","Pune","F",25,"B.Com");
    Person pinky= new Person(4,"Pinky","chennai","F",23,"B.tech");

    List<Person>personList=new ArrayList<>();

    public List<Person> getAllPerson(){
        personList.add(amit);
        personList.add(lokesh);
        personList.add(dimple);
        personList.add(pinky);

        return personList;
    }

    @Value("${User.gender}")
    String userGender;

    public List<Person>filterPerson(){

        List<Person>per=new ArrayList<>();

        for(Person obj:personList){
            if(!userGender.equalsIgnoreCase(obj.getGender())){
                per.add(obj);
            }
        }

        return per;
    }





}
