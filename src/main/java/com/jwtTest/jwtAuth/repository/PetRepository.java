package com.jwtTest.jwtAuth.repository;

import com.jwtTest.jwtAuth.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findByAnimal(String animal);

    List<Pet> findByAnimalAndCity(String animal, String city);

    List<Pet> findByAnimalAndCityAndBreed(String animal, String city, String breed);

    List<Pet> findByUserEmail(String userEmail);
}
