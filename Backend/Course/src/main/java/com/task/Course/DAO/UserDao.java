package com.task.Course.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.Course.Entity.User;
import com.task.Course.Repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository repo;
	
	public User saveUser(User u) {
		 return repo.save(u);
	 }
	 
	 public User fetchById(int id) {
		 
		 Optional<User> op= repo.findById(id);
		 if(op.isPresent()) {
			 return op.get();
		 }
		 else {
			 return null;
		 }
	 }
	 
	 public List<User> fetchAll(){
		return repo.findAll();
	 }
	 
	 public String deleteUserById(int id) {
		 repo.delete(fetchById(id));
		 return "Deleted";
		 
	 }
	

}
