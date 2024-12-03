package com.task.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Course.Entity.Course;

public interface CourseRepository  extends JpaRepository<Course, Integer>{

}
