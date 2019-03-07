package com.students.studentsdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {

  @Id
  @GeneratedValue(
    generator = "student_generator",
    strategy = GenerationType.IDENTITY)
  @SequenceGenerator(
    name = "student_generator",
    sequenceName = "student_sequence",
    initialValue = 1)
  private Long id;
  
  @NotBlank
  private String name;
  private Long age;

  public Student() {
    
  }

  public Student(Long id, String name, Long age) {
    super();
    this.id = id;
    this.name = name;
    this.age = age;
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
  
  public Long getAge() {
    return age;
  }
  
  public void setAge(Long age) {
    this.age = age;
  }
}