package com.restapi.webservices.restfulwebservices.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Versioning {
	
	@GetMapping("/person1")
	public personV1 getFirstPerson() {
		return new personV1("Jurgen Klopp");
	}
	
	@GetMapping("/person2")
	public personV2 getSecondPerson() {
		return new personV2(new Name("Jurgen","Klopp"));
	}
	
	@GetMapping(path="/person",params = "version=1")
	public personV1 getFirstPersonRequestParameters() {
		return new personV1("Jurgen Klopp");
	}
	
	@GetMapping(path="/person",params = "version=2")
	public personV2 getSecondPersonRequestParameters() {
		return new personV2(new Name("Jurgen","Klopp"));
	}
	
	@GetMapping(path="/person/header",headers = "X-API-VERSION=1")
	public personV1 getFirstPersonRequestHeaders() {
		return new personV1("Jurgen Klopp");
	}
	
	@GetMapping(path="/person/header",headers = "X-API-VERSION=2")
	public personV2 getSecondPersonRequestHeaders() {
		return new personV2(new Name("Jurgen","Klopp"));
	}
	
	@GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")
	public personV1 getFirstPersonRequestAccept() {
		return new personV1("Jurgen Klopp");
	}
	
	@GetMapping(path="/person/accept", produces = "application/vnd.company.app-v2+json")
	public personV2 getSecondPersonRequestAccept() {
		return new personV2(new Name("Jurgen","Klopp"));
		}
}
