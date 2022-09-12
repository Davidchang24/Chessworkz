package com.java.chessworkz.controller;

import com.java.chessworkz.entities.Course;
import com.java.chessworkz.respository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController {
    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Course> all() {
        return repository.findAll();
    }
}
