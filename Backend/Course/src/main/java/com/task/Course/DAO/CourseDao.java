package com.task.Course.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.Course.Entity.Course;
import com.task.Course.Repository.CourseRepository;

@Repository
public class CourseDao {
		@Autowired
		CourseRepository repo;
		
	 public Course saveCourse(Course c) {
		 return repo.save(c);
	 }
	 
	 public Course fetchById(int id) {
		 
		 Optional<Course> op= repo.findById(id);
		 if(op.isPresent()) {
			 return op.get();
		 }
		 else {
			 return null;
		 }
	 }
	 
	 public List<Course> fetchAll(){
		return repo.findAll();
	 }
	 
	 public String deleteCourseById(int id) {
		 repo.delete(fetchById(id));
		 return "Deleted";
		 
	 }


}
