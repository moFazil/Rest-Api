package com.restapi.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.webservices.restfulwebservices.user.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
