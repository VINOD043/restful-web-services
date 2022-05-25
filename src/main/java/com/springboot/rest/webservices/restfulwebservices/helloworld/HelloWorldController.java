package com.springboot.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource source;

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World "+name);
	}
	
	/** Implementing Internationalization
	 * @return
	 */
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(
			//@RequestHeader(name = "Accept-Language", required = false) Locale locale
			) {
		return source.getMessage(
				"good.morning.message", null, "Default message"
				//, locale
				,LocaleContextHolder.getLocale());
	}
}
