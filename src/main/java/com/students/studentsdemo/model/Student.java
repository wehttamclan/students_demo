package com.students.studentsdemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

  @ManyToMany(
    fetch = FetchType.LAZY, 
    cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(
    name = "student_courses", 
    joinColumns = { @JoinColumn(name = "student_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "course_id") })
  @JsonIgnoreProperties("roster")  
  private Set<Course> courses = new HashSet<>();

  public Student() {
  }

  public Student(Long id, String name, Long age) {
    super();
    this.id = id;
    this.name = name;
    this.age = age;
  }

  @JsonProperty("course_list")
  public Set<Course> getCourses() {
    return courses;
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