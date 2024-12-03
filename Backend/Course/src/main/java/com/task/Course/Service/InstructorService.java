package com.task.Course.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.Course.DAO.InstructorDao;
import com.task.Course.DTO.ResponseStructure;
import com.task.Course.Entity.Instructor;

@Service
public class InstructorService {
@Autowired
private InstructorDao dao;

public ResponseEntity<ResponseStructure<Instructor>> saveInstructor(Instructor i){
	   Instructor i2=dao.saveInstructor(i);
	   ResponseStructure<Instructor> stru=new ResponseStructure<Instructor>();
	   stru.setStatusCode(HttpStatus.CREATED.value());
	   stru.setMessage("Created");
	   stru.setData(i2);
	   return new ResponseEntity<ResponseStructure<Instructor>>(stru,HttpStatus.CREATED);
}

public ResponseEntity<ResponseStructure<Instructor>> updateInstructor(Instructor i){
	   Instructor i2=dao.saveInstructor(i);
	   ResponseStructure<Instructor> stru= new ResponseStructure<Instructor>();
	   stru.setStatusCode(HttpStatus.OK.value());
	   stru.setMessage("Resource Updated Successfully");
	   stru.setData(i2);
	   return new ResponseEntity<ResponseStructure<Instructor>>(stru,HttpStatus.OK);
}

public ResponseEntity<ResponseStructure<Instructor>> fetchInstructorById(int id){
	   Instructor t2=dao.fetchById(id);
	   ResponseStructure<Instructor> stru= new ResponseStructure<Instructor>();
	   stru.setStatusCode(HttpStatus.OK.value());
	   stru.setMessage("Resource Retrived Sucessfully");
	   stru.setData(t2);
	   return new ResponseEntity<ResponseStructure<Instructor>>(stru,HttpStatus.OK);
}

public ResponseEntity<ResponseStructure<List<Instructor>>> fetchAllInstructor(){
	   List<Instructor> i2=dao.fetchAll();
	   ResponseStructure<List<Instructor>> stru= new ResponseStructure<List<Instructor>>();
	   stru.setStatusCode(HttpStatus.OK.value());
	   stru.setMessage("Resource Retrived Sucessfully");
	   stru.setData(i2);
	   return new ResponseEntity<ResponseStructure<List<Instructor>>>(stru,HttpStatus.OK);
}

public ResponseEntity<ResponseStructure<String>> deleteInstructorById(int id){
	   String t2=dao.deleteInstructorById(id);
	   ResponseStructure<String> stru= new ResponseStructure<String>();
	   stru.setStatusCode(HttpStatus.OK.value());
	   stru.setMessage("Resource Delete Sucessfully");
	   stru.setData(t2);
	   return new ResponseEntity<ResponseStructure<String>>(stru,HttpStatus.OK);
}
}
