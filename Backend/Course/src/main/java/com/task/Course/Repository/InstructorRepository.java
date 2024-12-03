package com.task.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Course.Entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
