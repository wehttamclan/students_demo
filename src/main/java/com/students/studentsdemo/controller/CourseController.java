package com.students.studentsdemo.controller;

import java.util.List;

import com.students.studentsdemo.model.Course;
import com.students.studentsdemo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

  @Autowired
  private CourseRepository courseRepository;

  @GetMapping("/api/v1/students/{studentId}/courses")
  public List<Course> getCoursesByStudentId(@PathVariable Long studentId) {
    return courseRepository.findByStudentId(studentId);
  }
}