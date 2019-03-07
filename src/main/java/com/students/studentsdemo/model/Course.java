package com.students.studentsdemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Course {

  @Id
  private Long id;

  @NotBlank
  private String name;

  public Course() {

  }

  public Course(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
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