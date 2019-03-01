package com.students.studentsdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @GetMapping("/students/{id}")
  public Student getStudent(@PathVariable Long id) {
    return studentRepository.findById(id);
  }
}