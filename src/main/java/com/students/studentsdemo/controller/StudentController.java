package com.students.studentsdemo.controller;

import java.util.List;
import java.util.Optional;

import com.students.studentsdemo.model.Course;
import com.students.studentsdemo.model.Student;
import com.students.studentsdemo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @Autowired
  private StudentRepository studentRepository;

  @GetMapping("/api/v1/students")
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @GetMapping("/api/v1/students/{id}")
  public Optional<Student> getStudent(@PathVariable Long id) {
    return studentRepository.findById(id);
  }

  @PostMapping("/api/v1/students")
  public void addStudent(@RequestBody Student student) {
    studentRepository.save(student);
  }

  @PutMapping("/api/v1/students/{id}")
  public void updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
    Optional<Student> student = studentRepository.findById(id);
    student.map(s -> {
                  if(newStudent.getName() != null) {
                    s.setName(newStudent.getName());
                  }
                  return studentRepository.save(s);
              });
    }

  @DeleteMapping("/api/v1/students/{id}")
  public void deleteStudent(@PathVariable Long id) {
    studentRepository.deleteById(id);
  }

  // @GetMapping("/api/v1/students/{id}/courses")
  // public List<Course> getCourses(@PathVariable Long id) {
  //   return studentRepository.getCoursesByStudentId(id);
  // }

  @GetMapping("/api/v1/students/find")
  public List<Student> getStudentsByName(@RequestParam(value = "name") String name) {
    return studentRepository.findByName(name);
  }
}