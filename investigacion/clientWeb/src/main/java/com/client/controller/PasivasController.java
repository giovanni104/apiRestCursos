package com.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.model.Beer;
import com.client.model.CustomerInfo;
import com.client.service.MyService;
import com.client.service.PasivasServices;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pasivas")
public class PasivasController {

	@Autowired
	PasivasServices pasivasServices;

	@PostMapping("/customerInfo")
	//Flux<CustomerInfo> getRandom() {
	List<CustomerInfo>  getRandom() throws InterruptedException {
		ArrayList<CustomerInfo> data = new ArrayList<>();

		Flux<CustomerInfo> customerInfo = pasivasServices.customerInfo2();
 

		List<CustomerInfo> streamData = new ArrayList<>();
		
		
		/*customerInfo.collectList().subscribe(				
				
                // onSuccess - process the collected list
			streamData::addAll,
                // onError - handle errors if they occur
                throwable -> System.err.println("Error: " + throwable.getMessage()),
                // onComplete - handle the completion of the Flux
                () -> {
                    System.out.println("Request completed");
                    // Process the complete list here, if needed
                    System.out.println("Received List: " + streamData);
                }
	
			 ).wait();*/
		
		Mono<List<CustomerInfo>> responseListMono = customerInfo.collectList();
		
		 List<CustomerInfo> responseList = responseListMono.block();
		
		
		
		return responseList;
		
		//return customerInfo;

	}

	@PostMapping("/customerInfo2")
	List<CustomerInfo> getRandom2() {
		List<CustomerInfo> streamData = new ArrayList<>();
		 
		
		Mono<CustomerInfo> customerInfo = pasivasServices.customerInfo();

		customerInfo.subscribe(person -> {
			  streamData.add(person);  
			  System.out.print(person.getName());
		});

		  
		
		return streamData;

	}

	@PostMapping("/customerInfo3")
	void getRandom3() {
 
		 
		
		  pasivasServices.addInvoice();

		 
		
		//return streamData;

	}

	
	
	
}
