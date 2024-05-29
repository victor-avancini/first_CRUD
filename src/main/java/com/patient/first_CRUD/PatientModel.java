package com.patient.first_CRUD;

public class PatientModel {
    private Long id;
    private String name;
    private int age;
    private String addres;

    public PatientModel(Long id, String name, int age, String addres) {
        this.id = id;
        this.name = name; 
        this.age = age;
        this.addres = addres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
