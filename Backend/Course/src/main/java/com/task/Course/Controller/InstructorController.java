package com.task.Course.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.Course.DTO.ResponseStructure;
import com.task.Course.Entity.Instructor;
import com.task.Course.Service.InstructorService;
@RestController
@CrossOrigin
public class InstructorController {
    @Autowired
	 InstructorService service;
    	
    	@PostMapping("/ins")
    	public ResponseEntity<ResponseStructure<Instructor>> saveInstructor(@RequestBody Instructor i){
    		return service.saveInstructor(i);
    	}
    	
    	@PutMapping("/ins/{id}")
    	public ResponseEntity<ResponseStructure<Instructor>> updateInstructor(@RequestBody Instructor i){
    		return service.updateInstructor(i);
    	}
    	
    	@GetMapping("/ins/fetch/{id}")
    	public ResponseEntity<ResponseStructure<Instructor>> fetchById(@PathVariable int id){
    		return service.fetchInstructorById(id);
    	}
    	
    	@GetMapping("/ins")
    	public ResponseEntity<ResponseStructure<List<Instructor>>> fetchAll(){
    		return service.fetchAllInstructor();
    	}
    	
    	@DeleteMapping("/ins/del/{id}")
    	public ResponseEntity<ResponseStructure<String>> deleteInstructor(@PathVariable int id){
    		return service.deleteInstructorById(id);
    	}
    	
}
