package com.students.studentsdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Course {

  @Id
  @GeneratedValue(generator = "course_generator")
  @SequenceGenerator(name = "course_generator",
                     sequenceName = "course_sequence",
                     initialValue = 1)
  private Long id;


}