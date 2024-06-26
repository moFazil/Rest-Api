package com.restapi.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {
	
	protected User() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2 ,message="Name should have atleast 2 letters")
	//@JsonProperty("user_name")
	private String name;
	@Past(message = "Date of birth should be from past")
	private LocalDate BirthDate;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<posts> posts;
	
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		BirthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		BirthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", BirthDate=" + BirthDate + "]";
	}
	public List<posts> getPosts() {
		return posts;
	}
	public void setPosts(List<posts> posts) {
		this.posts = posts;
	}
	
}
