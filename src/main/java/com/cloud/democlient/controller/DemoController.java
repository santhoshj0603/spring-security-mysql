package com.cloud.democlient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.democlient.model.Message;
import com.cloud.democlient.repository.CloudUser;
import com.cloud.democlient.security.CloudUserDetailsService;

@RestController
public class DemoController {
	
	@Value("${com.cloud.hello:}")
	public String message;
	
	@Autowired
	public CloudUserDetailsService service;
	
	@Autowired
	RestTemplate rest;
	
	@GetMapping("/message")
	public Message getMessage() {
		Message m = new Message();
		m.setMessage(message);
		return m;
	}
	@PostMapping("/register")
	public CloudUser[] register(@RequestBody CloudUser user) {
		service.saveUser(user);
		return rest.getForEntity("http://Demo/all", CloudUser[].class).getBody();
	}
	
	@GetMapping("/all")
	public List<CloudUser> all(){
		return service.findAll();
	}

}
