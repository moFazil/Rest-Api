package com.restapi.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping(path="/simbb")
	public String message() {
		return "Ena da veetla adikureenga";
	}
	
	@GetMapping(path="/message")
	public jsonMessageBean jsonmessage() {
		return new jsonMessageBean("yeh KK velakenna");
	}
	
	@GetMapping(path="/message/path-variable/{name}")
	public jsonMessageBean jsonMessageName(@PathVariable String name) {
		return new jsonMessageBean(String.format("Welcome %s", name));
	}
	
	@GetMapping(path="/internationale")
	public String morningMessage() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default", locale);
	}
}
