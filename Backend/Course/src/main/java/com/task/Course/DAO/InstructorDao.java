package com.task.Course.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.Course.Entity.Instructor;
import com.task.Course.Repository.InstructorRepository;

@Repository
public class InstructorDao  {
	@Autowired
	InstructorRepository repo;
	
	 public Instructor saveInstructor(Instructor i) {
		 return repo.save(i);
	 }
	 
	 public Instructor fetchById(int id) {
		 
		 Optional<Instructor> op= repo.findById(id);
		 if(op.isPresent()) {
			 return op.get();
		 }
		 else {
			 return null;
		 }
	 }
	 
	 public List<Instructor> fetchAll(){
		return repo.findAll();
	 }
	 
	 public String deleteInstructorById(int id) {
		 repo.delete(fetchById(id));
		 return "Deleted";
		 
	 }


}
