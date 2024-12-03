package com.task.Course.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String title;
	    private String description;
	    private Double price;
	    @ManyToOne
	    @JsonIgnore
	    private Instructor instructor;
        @JsonIgnore
	    @ManyToMany(mappedBy = "enrolledCourses")
	    private List<User> enrolledUsers;

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Instructor getInstructor() {
			return instructor;
		}

		public void setInstructor(Instructor instructor) {
			this.instructor = instructor;
		}

		public List<User> getEnrolledUsers() {
			return enrolledUsers;
		}

		public void setEnrolledUsers(List<User> enrolledUsers) {
			this.enrolledUsers = enrolledUsers;
		}

		

		
	}

