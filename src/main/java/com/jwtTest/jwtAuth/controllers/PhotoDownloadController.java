package com.jwtTest.jwtAuth.controllers;

import com.jwtTest.jwtAuth.models.Photo;
import com.jwtTest.jwtAuth.repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class PhotoDownloadController {
    @Autowired
    PhotoRepo repo;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable int id){
        //Photo photo = photozService.get(id);
        Optional<Photo> photoOpt = repo.findById(id);
        if(photoOpt == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Photo photo = photoOpt.get();

        byte[] data = photo.getData();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        //wrapper and stuff
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();
        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
