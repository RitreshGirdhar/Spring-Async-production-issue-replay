package com.example.controller;


import com.example.service.DummyService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RestController
public class WebController {

	@Resource
	private DummyService dummyService;

	@RequestMapping("/")
	public String index() {
		dummyService.dummyService();
		return "Greetings from Spring Boot!";
	}

}
