package com.task.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Course.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
