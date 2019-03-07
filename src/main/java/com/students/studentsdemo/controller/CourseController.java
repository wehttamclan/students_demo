package com.students.studentsdemo.controller;

import java.util.List;
import java.util.Optional;

import com.students.studentsdemo.model.Course;
import com.students.studentsdemo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

  @Autowired
  private CourseRepository courseRepository;

  @GetMapping("/api/v1/courses")
  public List<Course> getCourses() {
    return courseRepository.findAll();
  }

  @GetMapping("/api/v1/courses/{id}")
  public Optional<Course> getCourse(@PathVariable Long id) {
    return courseRepository.findById(id);
  }

  @PostMapping("/api/v1/courses")
  public Course addCourse(@RequestBody Course course) {
    return courseRepository.save(course);
  }

  @PutMapping("/api/v1/courses/{id}")
  public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
    return courseRepository.save(course);
  }

  @DeleteMapping("/api/v1/courses/{id}")
  public void deleteCourse(@PathVariable Long id) {
    courseRepository.deleteById(id);
  }
}