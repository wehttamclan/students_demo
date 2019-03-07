package com.students.studentsdemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @ManyToMany(
    fetch = FetchType.LAZY,
    cascade = { CascadeType.PERSIST, CascadeType.MERGE },
    mappedBy = "courses")
  @JsonIgnoreProperties("course_list")
  private Set<Student> students = new HashSet<>();

  public Course() {
  }
  
  public Course(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
  }
  
  @JsonProperty("roster")
  public Set<Student> getStudents() {
    return students;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}