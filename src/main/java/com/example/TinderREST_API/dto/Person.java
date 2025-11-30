package com.example.TinderREST_API.dto;

public class Person {

    private int id;
    private String name;
    private String city;
    private String gender;
    private int age;
    private String Education;

    public Person(int id, String name, String city, String gender, int age, String education) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.age = age;
        Education = education;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", Education='" + Education + '\'' +
                '}';
    }
}
