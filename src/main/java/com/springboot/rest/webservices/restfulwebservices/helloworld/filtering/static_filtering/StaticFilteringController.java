package com.springboot.rest.webservices.restfulwebservices.helloworld.filtering.static_filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retriveSomeBean() {
		return new SomeBean("field1", "field2", "field3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retriveSomeBeanList() {
		return Arrays.asList
				(new SomeBean("field11", "field21", "field31"),
				new SomeBean("field12", "field22", "field32"));
	}
}
