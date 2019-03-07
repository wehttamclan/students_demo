package com.students.studentsdemo.repository;

import java.util.List;

import com.students.studentsdemo.model.Course;
import com.students.studentsdemo.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Course> findCoursesById(Long id);
  
  List<Student> findByName(String name);
  
}