package com.students.studentsdemo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(generator = "course_generator")
  @SequenceGenerator(name = "course_generator",
                     sequenceName = "course_sequence",
                     initialValue = 1)
  private Long id;

  @ManyToMany(mappedBy = "courses")
  private List<Student> students;

  @NotBlank
  private String name;

  public void setName(String name) {
    this.name = name;
  }

}