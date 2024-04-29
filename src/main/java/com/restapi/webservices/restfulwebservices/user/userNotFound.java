package com.restapi.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class userNotFound extends RuntimeException {
	
	public userNotFound(String message) {
		super(message);
	}
	
}
