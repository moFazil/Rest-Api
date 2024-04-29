package com.restapi.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapi.webservices.restfulwebservices.jpa.UserJpaRepository;

import jakarta.validation.Valid;

@RestController
public class userJpaResources {
	
	private UserJpaRepository repository;
	
	public userJpaResources(userDaoServices services, UserJpaRepository repository) {
		this.repository=repository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retrieveUser(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveSingleUser(@PathVariable int id){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new userNotFound("id : "+id);
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveUser());
		entityModel.add(link.withRel("add-users"));
		return entityModel;
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		repository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<posts>retrievePostOfUser(@PathVariable int id){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new userNotFound("id : "+id);
		return user.get().getPosts();
	}
	
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
				return ResponseEntity.created(location ).build();
	}
}
