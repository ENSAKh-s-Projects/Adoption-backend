package com.jwtTest.jwtAuth.repository;

import com.jwtTest.jwtAuth.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Integer> {
}
