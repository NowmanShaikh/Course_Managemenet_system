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
import com.task.Course.Entity.Course;
import com.task.Course.Service.CourseService;

@RestController
@CrossOrigin
public class CourseController {
	
		@Autowired
		public CourseService service;
		
		@PostMapping("/cou")
		public ResponseEntity<ResponseStructure<Course>> saveCourse(@RequestBody Course c){
			return service.saveCourse(c);
		}
		
		@PutMapping("/cou/{id}")
		public ResponseEntity<ResponseStructure<Course>> updateCourse(@RequestBody Course c){
			return service.updateCourse(c);
		}
		
		@GetMapping("/cou/fetch/{id}")
		public ResponseEntity<ResponseStructure<Course>> fetchById(@PathVariable int id){
			return service.fetchCourseById(id);
		}
		
		@GetMapping("/cou")
		public ResponseEntity<ResponseStructure<List<Course>>> fetchAll(){
			return service.fetchAllCourse();
		}
		
		@DeleteMapping("/cou/del/{id}")
		public ResponseEntity<ResponseStructure<String>> deleteCourse(@PathVariable int id){
			return service.deleteCourseById(id);
		}
		
}
