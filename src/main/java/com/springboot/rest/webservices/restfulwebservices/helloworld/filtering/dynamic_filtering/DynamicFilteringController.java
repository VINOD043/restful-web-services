package com.springboot.rest.webservices.restfulwebservices.helloworld.filtering.dynamic_filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {
	
	// filter all except field1, field2
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retriveSomeBean() {
		SomeBean someBean = new SomeBean("field1", "field2", "field3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1", "field2");
		
		FilterProvider provider = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		mappingJacksonValue.setFilters(provider);
		
		return mappingJacksonValue;
	}
	
	// filter all except field2, field3
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retriveSomeBeanList() {
		List<SomeBean> list =  Arrays.asList(
				new SomeBean("field11", "field21", "field31"),
				new SomeBean("field12", "field22", "field32"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field2", "field3");
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter );
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(list);
		jacksonValue.setFilters(filters);
		
		return jacksonValue;
	}
}
