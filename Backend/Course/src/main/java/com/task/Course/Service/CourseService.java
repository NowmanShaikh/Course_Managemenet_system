package com.task.Course.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.Course.DAO.CourseDao;
import com.task.Course.DTO.ResponseStructure;
import com.task.Course.Entity.Course;

@Service
public class CourseService {
	@Autowired
	private CourseDao dao;
	
	public ResponseEntity<ResponseStructure<Course>> saveCourse(Course c){
		   Course c2=dao.saveCourse(c);
		   ResponseStructure<Course> stru=new ResponseStructure<Course>();
		   stru.setStatusCode(HttpStatus.CREATED.value());
		   stru.setMessage("Created");
		   stru.setData(c2);
		   return new ResponseEntity<ResponseStructure<Course>>(stru,HttpStatus.CREATED);
	   }
	   
	   public ResponseEntity<ResponseStructure<Course>> updateCourse(Course c){
		   Course c2=dao.saveCourse(c);
		   ResponseStructure<Course> stru= new ResponseStructure<Course>();
		   stru.setStatusCode(HttpStatus.OK.value());
		   stru.setMessage("Resource Updated Successfully");
		   stru.setData(c2);
		   return new ResponseEntity<ResponseStructure<Course>>(stru,HttpStatus.OK);
	   }
	   
	   public ResponseEntity<ResponseStructure<Course>> fetchCourseById(int id){
		   Course c=dao.fetchById(id);
		   ResponseStructure<Course> stru= new ResponseStructure<Course>();
		   stru.setStatusCode(HttpStatus.OK.value());
		   stru.setMessage("Resource Retrived Sucessfully");
		   stru.setData(c);
		   return new ResponseEntity<ResponseStructure<Course>>(stru,HttpStatus.OK);
	   }
	   
	   public ResponseEntity<ResponseStructure<List<Course>>> fetchAllCourse(){
		   List<Course> c=dao.fetchAll();
		   ResponseStructure<List<Course>> stru= new ResponseStructure<List<Course>>();
		   stru.setStatusCode(HttpStatus.OK.value());
		   stru.setMessage("Resource Retrived Sucessfully");
		   stru.setData(c);
		   return new ResponseEntity<ResponseStructure<List<Course>>>(stru,HttpStatus.OK);
	   }
	   
	   public ResponseEntity<ResponseStructure<String>> deleteCourseById(int id){
		   String c=dao.deleteCourseById(id);
		   ResponseStructure<String> stru= new ResponseStructure<String>();
		   stru.setStatusCode(HttpStatus.OK.value());
		   stru.setMessage("Resource Delete Sucessfully");
		   stru.setData(c);
		   return new ResponseEntity<ResponseStructure<String>>(stru,HttpStatus.OK);
	   }

}
