package com.students.studentsdemo.controller;

import com.students.studentsdemo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

  @Autowired
  private CourseRepository courseRepository;
}