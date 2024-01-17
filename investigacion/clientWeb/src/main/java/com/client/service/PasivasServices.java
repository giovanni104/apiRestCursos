package com.client.service;

import javax.json.Json;
import javax.json.JsonObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import com.client.model.CustomerInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PasivasServices {

	private final WebClient webClient;

	private static final Logger logger = LogManager.getLogger(PasivasServices.class);

	public PasivasServices(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://172.31.0.44:30088/querys").build();
	}

	public Flux<CustomerInfo> customerInfo2() {

		
		JsonObject empObject = Json.createObjectBuilder()
				.add("identification", "25346789")
				.add("type", "CED")
				.add("language", "ES")				
				.build();
		
		return webClient.post().uri("/customerInfo")
				.header("X-Auth-Token", "12345687")
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(empObject.toString()))
				
				.retrieve().bodyToFlux(CustomerInfo.class)
				.onErrorResume(WebClientResponseException.class, ex -> {
					logger.error(ex.getMessage());
					return Flux.empty();				}

				);
	}
	
	
	
	public Mono<CustomerInfo> customerInfo() {
		
		
		JsonObject empObject = Json.createObjectBuilder()
				.add("identification", "25346789")
				.add("type", "CED")
				.add("language", "ES")				
				.build();
		
		
		 
 
		
		
		 	return webClient.post()
		.uri("/customerInfo")
		.header("X-Auth-Token", "12345687")
		.contentType(MediaType.APPLICATION_JSON)
		.body(BodyInserters.fromValue(empObject.toString()))
		.retrieve()
		.bodyToMono(CustomerInfo.class);
 
				 
	}
	
	
	
	
	
	  public   CustomerInfo addInvoice() {
		  
		  String body = "{\n"
					+ "    \"identification\":\"24252939\",\n"
					+ "    \"type\" :\"CED\",\n"
					+ "    \"language\":\"ES\"\n"
					+ "}";
		  
		  
		  
			
		  ResponseEntity<CustomerInfo> cusInfo = webClient.post()
					.uri("http://172.31.0.44:30088/querys/customerInfo")
					.header("X-Auth-Token", "12345687")
					.contentType(MediaType.APPLICATION_JSON)
					.body(BodyInserters.fromObject(body))
					.retrieve()				
					.toEntity(CustomerInfo.class)
					.block();
		  
		  
		  
		  

		  System.out.println(cusInfo.getStatusCodeValue() + ""+cusInfo.getBody());
		  System.out.println(cusInfo.getStatusCode().is2xxSuccessful() + ""+cusInfo.getBody());
		  System.out.println(cusInfo.getStatusCode().is4xxClientError() + ""+cusInfo.getBody());
		
		return null;
	   }

	
	
	
	
	

}