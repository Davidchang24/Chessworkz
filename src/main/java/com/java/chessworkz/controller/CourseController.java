package com.java.chessworkz.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.java.chessworkz.entities.Course;
import com.java.chessworkz.respository.CourseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository repository) {
        this.courseRepository = repository;
    }

    @GetMapping(value = "/all")
    public List<Course> all() {
        return courseRepository.findAll();
    }

    @PostMapping(value = "/course")
    public Course postCourse(@RequestBody Course course) {

        return courseRepository.save(course);
    }

    @GetMapping(value = "/{id}")
    public Course getCourseById(@PathVariable("id") long Id) {
        return courseRepository.getById(Id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCourseById(@PathVariable("id") long Id) {
        courseRepository.deleteById(Id);
    }

}
