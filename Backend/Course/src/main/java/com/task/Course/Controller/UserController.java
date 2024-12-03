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
import com.task.Course.Entity.User;
import com.task.Course.Service.UserService;

@RestController
@CrossOrigin
public class UserController {
		@Autowired
		public UserService service;
		
		@PostMapping("/use")
		public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u){
			return service.saveUser(u);
		}
		
		@PutMapping("/use/{id}")
		public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User u){
			return service.updateUser(u);
		}
		
		@GetMapping("/use/fetch/{id}")
		public ResponseEntity<ResponseStructure<User>> fetchById(@PathVariable int id){
			return service.fetchUserById(id);
		}
		
		@GetMapping("/use")
		public ResponseEntity<ResponseStructure<List<User>>> fetchAll(){
			return service.fetchAllUser();
		}
		
		@DeleteMapping("/use/del/{id}")
		public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id){
			return service.deleteUserById(id);
		}
		

}
