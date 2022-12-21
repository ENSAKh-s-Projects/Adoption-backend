package com.jwtTest.jwtAuth.controllers;

import com.jwtTest.jwtAuth.models.Photo;
import com.jwtTest.jwtAuth.payload.response.IdResponse;
import com.jwtTest.jwtAuth.payload.response.MessageResponse;
import com.jwtTest.jwtAuth.repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Optional;

@RestController
public class PhotoController {
    @Autowired
    PhotoRepo photoRepo;

    @GetMapping("/photos/{id}")
    public Optional<Photo> get(@PathVariable int id){
        Optional<Photo> photo = photoRepo.findById(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable int id){
        photoRepo.deleteById(id);
    }

    @CrossOrigin
    @PostMapping("/photos")
    public ResponseEntity<?> create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setContentType(file.getContentType());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());

        photoRepo.save(photo);
        return ResponseEntity.ok(new IdResponse(photo.getId()));
    }
}
