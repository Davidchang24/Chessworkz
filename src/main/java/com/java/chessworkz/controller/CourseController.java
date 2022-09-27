package com.java.chessworkz.controller;

import com.java.chessworkz.entities.Course;
import com.java.chessworkz.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService service) {
        this.courseService = service;
    }

    @GetMapping(value = "/all")
    public List<Course> all() {
        return courseService.getAllCourses();
    }

    @PostMapping(value = "/create")
    public Course postCourse(@RequestBody Course course) {

        return courseService.postCourse(course);
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@RequestBody Course course)
    {
        return courseService.updateCourse(course);
    }
    @GetMapping(value = "/{id}")
    public Course getCourseById(@PathVariable("id") long Id) {
        return courseService.getCourseById(Id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCourseById(@PathVariable("id") long Id) {
        courseService.deleteCourseById(Id);
    }

}
