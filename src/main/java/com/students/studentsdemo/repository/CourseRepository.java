package com.students.studentsdemo.repository;

import java.util.List;
import com.students.studentsdemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByStudentId(Long studentId);
}