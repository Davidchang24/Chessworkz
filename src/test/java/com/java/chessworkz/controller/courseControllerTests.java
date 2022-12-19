package com.java.chessworkz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.chessworkz.entities.Course;
import com.java.chessworkz.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class courseControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetAllCourses() throws Exception {
        Course course = new Course();
        course.setId(1l);
        course.setCourseName("Opening");
        course.setCourseDescription("This is a chess course about openings");

        when(courseService.getAllCourses()).thenReturn(Arrays.asList(course));

        mockMvc.perform(MockMvcRequestBuilders.get("/course/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1l))
                .andExpect(jsonPath("$[0].courseName").value("Opening"))
                .andExpect(jsonPath("$[0].courseDescription").value("This is a chess course about openings"));
    }

    @Test
    void shouldPostCourse() throws Exception {
        Course postCourse = new Course();
        postCourse.setCourseName("Opening");
        postCourse.setCourseDescription("This is a chess course about openings");

        String courseAsString = objectMapper.writeValueAsString(postCourse);

        when(courseService.postCourse(any(Course.class))).thenReturn(postCourse);

        mockMvc.perform(MockMvcRequestBuilders.post("/course/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(courseAsString)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.courseName").value("Opening"))
                .andExpect(jsonPath("$.courseDescription").value("This is a chess course about openings"));
    }

    @Test
    void shouldDeleteCourseById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/course/delete/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateCourseById() throws Exception {
        Course postCourse = new Course();
        postCourse.setId(1l);
        postCourse.setCourseName("Opening");
        postCourse.setCourseDescription("This is a chess course about openings");
        String courseAsString = objectMapper.writeValueAsString(postCourse);

        when(courseService.updateCourse(postCourse)).thenReturn(postCourse);

        mockMvc.perform(MockMvcRequestBuilders.put("/course/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(courseAsString)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1l))
                .andExpect(jsonPath("$.courseName").value("Opening"))
                .andExpect(jsonPath("$.courseDescription").value("This is a chess course about openings"));
    }
}