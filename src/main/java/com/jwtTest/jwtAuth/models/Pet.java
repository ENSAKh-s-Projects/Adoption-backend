package com.jwtTest.jwtAuth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;
    private String animal;
    private String city;
    private String description;
    private String breed;
    private String userEmail;

    private int idPhoto1;
    private int idPhoto2;
    private int idPhoto3;

    public Pet() {
    }

    public Pet(String name, String animal, String city, String description, String breed, String userEmail, int idPhoto1, int idPhoto2, int idPhoto3) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.city = city;
        this.description = description;
        this.breed = breed;
        this.userEmail = userEmail;
        this.idPhoto1 = idPhoto1;
        this.idPhoto2 = idPhoto2;
        this.idPhoto3 = idPhoto3;
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

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getIdPhoto1() {
        return idPhoto1;
    }

    public void setIdPhoto1(int idPhoto1) {
        this.idPhoto1 = idPhoto1;
    }

    public int getIdPhoto2() {
        return idPhoto2;
    }

    public void setIdPhoto2(int idPhoto2) {
        this.idPhoto2 = idPhoto2;
    }

    public int getIdPhoto3() {
        return idPhoto3;
    }

    public void setIdPhoto3(int idPhoto3) {
        this.idPhoto3 = idPhoto3;
    }
}
