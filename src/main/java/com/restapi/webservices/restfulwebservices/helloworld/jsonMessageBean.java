package com.restapi.webservices.restfulwebservices.helloworld;

public class jsonMessageBean {

	private String message;

	public jsonMessageBean(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "jsonMessageBean [message=" + message + "]";
	}

}
