package com.task.Course.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.Course.DAO.UserDao;
import com.task.Course.DTO.ResponseStructure;
import com.task.Course.Entity.User;

@Service
public class UserService {
	
	@Autowired
private	UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User u){
		   User u2=dao.saveUser(u);
		   ResponseStructure<User> stru=new ResponseStructure<User>();
		   stru.setStatusCode(HttpStatus.CREATED.value());
		   stru.setMessage("Created");
		   stru.setData(u2);
		   return new ResponseEntity<ResponseStructure<User>>(stru,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User u){
		   User u2=dao.saveUser(u);
		   ResponseStructure<User> stru= new ResponseStructure<User>();
		   stru.setStatusCode(HttpStatus.OK.value());
		   stru.setMessage("Resource Updated Successfully");
		   stru.setData(u2);
		   return new ResponseEntity<ResponseStructure<User>>(stru,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> fetchUserById(int id){
		   User u2=dao.fetchById(id);
		   ResponseStructure<User> stru= new ResponseStructure<User>();
		   stru.setStatusCode(HttpStatus.OK.value());
		   stru.setMessage("Resource Retrived Sucessfully");
		   stru.setData(u2);
		   return new ResponseEntity<ResponseStructure<User>>(stru,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<User>>> fetchAllUser(){
		   List<User> u2=dao.fetchAll();
		   ResponseStructure<List<User>> stru= new ResponseStructure<List<User>>();
		   stru.setStatusCode(HttpStatus.OK.value());
		   stru.setMessage("Resource Retrived Sucessfully");
		   stru.setData(u2);
		   return new ResponseEntity<ResponseStructure<List<User>>>(stru,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id){
		   String u2=dao.deleteUserById(id);
		   ResponseStructure<String> stru= new ResponseStructure<String>();
		   stru.setStatusCode(HttpStatus.OK.value());
		   stru.setMessage("Resource Delete Sucessfully");
		   stru.setData(u2);
		   return new ResponseEntity<ResponseStructure<String>>(stru,HttpStatus.OK);
	}
	
}