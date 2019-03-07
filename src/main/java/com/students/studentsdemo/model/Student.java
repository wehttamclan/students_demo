package com.students.studentsdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {

  @Id
  @GeneratedValue(generator = "student_generator")
  @SequenceGenerator(
    name = "student_generator",
    sequenceName = "student_sequence",
    initialValue = 1)
  private Long id;
  
  @NotBlank
  private String name;

  @NotBlank
  private Integer age;

  public Student() {
    
  }

  public Student(Long id, String name, Integer age) {
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
  
  public Integer getAge() {
    return age;
  }
  
  public void setAge(Integer age) {
    this.age = age;
  }
}