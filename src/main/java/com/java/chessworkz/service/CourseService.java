package com.java.chessworkz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Service;

import com.java.chessworkz.entities.Course;
import com.java.chessworkz.respository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course postCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(long Id) {
        return courseRepository.getReferenceById(Id);
    }

    public void deleteCourseById(long Id) {
        courseRepository.deleteById(Id);
    }
}
