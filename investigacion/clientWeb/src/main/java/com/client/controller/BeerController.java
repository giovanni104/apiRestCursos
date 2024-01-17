package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.model.Beer;
import com.client.service.MyService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

	@Autowired
	MyService myService;
	
	
	
	@GetMapping("/random")
	Flux<Beer> getRandom() {

		 

		 
		Flux<Beer> someRestCall = myService.someRestCall(); 
		
 
		return someRestCall;

	}

}
