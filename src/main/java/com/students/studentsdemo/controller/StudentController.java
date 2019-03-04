package com.students.studentsdemo.controller;

import java.util.Optional;

import com.students.studentsdemo.model.Student;
import com.students.studentsdemo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @Autowired
  private StudentRepository studentRepository;

  @GetMapping("/api/v1/students/{id}")
  public Optional<Student> getStudent(@PathVariable Long id) {
    return studentRepository.findById(id);
  }
}