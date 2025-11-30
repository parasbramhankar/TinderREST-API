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
    public List<Person>personList=new ArrayList<>();

    @Value("${user.gender}")
    String userGender;

    public TinderServiceImpl(){
        personList.add(new Person(1,"Amit","Gondia","M",20,"B.Sc"));
        personList.add(new Person(2,"Lokesh","Nagpur","M",23,"B.tech"));
        personList.add(new Person(3,"Dimple","Pune","F",25,"B.Com"));
        personList.add(new Person(4,"Pinky","Chennai","F",23,"B.tech"));
    }

    @Override
    public List<Person> getAllPerson(){
        return personList;
    }

    @Override
    public List<Person>filterPersonByGender(){
        List<Person>per=new ArrayList<>();

        for(Person obj:personList){
            if(!userGender.equalsIgnoreCase(obj.getGender())){
                per.add(obj);
            }
        }
        return per;
    }

    @Override
    public Person addPerson(Person person){
        personList.add(person);
        return person;
    }

    @Override
    public boolean updatePerson(int id, Person person){

        for(Person p:personList){
            if(p.getId()==id){
                p.setName(person.getName());
                p.setCity(person.getCity());
                p.setEducation(person.getEducation());
                p.setGender(person.getGender());
                p.setAge(person.getAge());

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateEducation(int id, String education){
        for(Person p:personList){
            if(p.getId()==id){
                p.setEducation(education);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deletePerson(int id){
        for(Person p:personList){
            if(p.getId()==id){
                personList.remove(p);
                return true;
            }
        }
        return false;
    }
}
