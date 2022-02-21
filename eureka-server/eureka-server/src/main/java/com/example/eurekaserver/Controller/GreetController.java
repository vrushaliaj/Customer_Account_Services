package com.example.eurekaserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class GreetController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/greet")
	public String greet() {
		
		return restTemplate.exchange("http://greet-client/greeting",
		          HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
	}
	

}
