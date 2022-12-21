package com.jwtTest.jwtAuth.controllers;

import com.jwtTest.jwtAuth.models.Pet;
import com.jwtTest.jwtAuth.payload.request.PetRegisterRequest;
import com.jwtTest.jwtAuth.payload.response.MessageResponse;
import com.jwtTest.jwtAuth.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class PetController {

    @Autowired
    PetRepository petRepo;

    @CrossOrigin
    @GetMapping("/pets")
    public List<Pet> get(@RequestParam(required = false) String animal,
                         @RequestParam(required = false) String city,
                         @RequestParam(required = false) String breed,
                         @RequestParam(required = false) String userEmail){
        if(userEmail != null){
            return petRepo.findByUserEmail(userEmail);
        }
        else if((animal != "") && (city != "") && (breed != "")) {
            return petRepo.findByAnimalAndCityAndBreed(animal, city, breed);
        }else if((animal != "") && (city != "")){
            return petRepo.findByAnimalAndCity(animal, city);
        }else if (animal != ""){
            return petRepo.findByAnimal(animal);
        }else{
            return petRepo.findAll();
        }
    }

    @CrossOrigin
    @GetMapping("/pets/{id}")
    public Optional<Pet> get(@PathVariable int id){
        Optional<Pet> pet = petRepo.findById(id);
        if (pet == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return pet;
    }

    @CrossOrigin
    @DeleteMapping("/pets/{id}")
    public void delete(@PathVariable int id){
        petRepo.deleteById(id);
    }

    @CrossOrigin
    @PostMapping("/pets")
    public ResponseEntity<?> create(@Valid @RequestBody PetRegisterRequest petRegisterRequest) throws IOException {
        Pet pet = new Pet(petRegisterRequest.getName(), petRegisterRequest.getAnimal(),
                petRegisterRequest.getCity(), petRegisterRequest.getDescription(),
                petRegisterRequest.getBreed(),petRegisterRequest.getUserEmail(),
                petRegisterRequest.getIdPhoto1(), petRegisterRequest.getIdPhoto2(),
                petRegisterRequest.getIdPhoto3());
        petRepo.save(pet);
        return ResponseEntity.ok(new MessageResponse("Pet registered successfully!"));
    }

    @CrossOrigin
    @PutMapping("/pets/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PetRegisterRequest petRegisterRequest) throws IOException{
        Optional<Pet> pet = petRepo.findById(id);

        Pet updatePet = pet.get();

        updatePet.setAnimal(petRegisterRequest.getAnimal());
        updatePet.setBreed(petRegisterRequest.getBreed());
        updatePet.setCity(petRegisterRequest.getCity());
        updatePet.setDescription(petRegisterRequest.getDescription());
        updatePet.setName(petRegisterRequest.getName());
        updatePet.setIdPhoto1(petRegisterRequest.getIdPhoto1());
        updatePet.setIdPhoto2(petRegisterRequest.getIdPhoto2());
        updatePet.setIdPhoto3(petRegisterRequest.getIdPhoto3());
        updatePet.setUserEmail(petRegisterRequest.getUserEmail());

        petRepo.save(updatePet);

        return ResponseEntity.ok(new MessageResponse("Pet modified successfully!"));
    }

}
