package com.client.service;

import java.util.Optional;

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

import com.client.model.custumer.CustomerInfo;
import com.client.model.movementHistory.MovementHistory;
import com.client.model.personalAccount.PersonalAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PasivasServices {

	private final WebClient webClient;

	private static final Logger logger = LogManager.getLogger(PasivasServices.class);

	public PasivasServices(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://172.31.0.44:30088/querys").build();
	}

	public Optional<CustomerInfo> userInfo(String identification,String type,String language,String token) {
		
		try {
			

			JsonObject empObject = Json.createObjectBuilder()
					.add("identification", identification).add("type", type)
					.add("language", language).build();

			ResponseEntity<CustomerInfo> cusInfo = webClient.post().uri("/customerInfo")
					.header("X-Auth-Token", token).contentType(MediaType.APPLICATION_JSON)
					.body(BodyInserters.fromValue(empObject.toString())).retrieve().toEntity(CustomerInfo.class)
					.block();

			if (cusInfo.getStatusCode().value() == 200) {

				Optional<CustomerInfo> respuesta = Optional.ofNullable(cusInfo.getBody());
				return respuesta;

			} else {
				System.out.println(cusInfo.getStatusCode());

				Optional<CustomerInfo> respuesta = Optional.empty();
				return respuesta;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			Optional<CustomerInfo> respuesta = Optional.empty();
			return respuesta;
		}

	}

	public Optional<PersonalAccount> userAccounts(String identification,String type, String token) {

		try {

			JsonObject empObject = Json.createObjectBuilder()
					.add("identification", identification)
					.add("type", type)
					.build();
 
			ResponseEntity<PersonalAccount> cusInfo = webClient.post()
					.uri("/accountList")
					.header("X-Auth-Token", token)
					.header("pageNumber", "1")
					.header("pageSize", "100")
					.contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(empObject.toString()))
					.retrieve().toEntity(PersonalAccount.class).block();

			if (cusInfo.getStatusCode().value() == 200) {

				Optional<PersonalAccount> respuesta = Optional.ofNullable(cusInfo.getBody());
				return respuesta;

			} else {
				logger.error(cusInfo.getStatusCode());

				Optional<PersonalAccount> respuesta = Optional.empty();
				return respuesta;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			Optional<PersonalAccount> respuesta = Optional.empty();
			return respuesta;
		}

	}
	
	
	public Optional<MovementHistory> userHistoryMovements(String accountNumber,String fromDate, String toDate,String token) {

	 
		try {

			JsonObject empObject = Json.createObjectBuilder()
					.add("accountNumber", accountNumber)
					.add("fromDate", fromDate)
					.add("toDate", toDate)
					.build();
 
			ResponseEntity<MovementHistory> cusInfo = webClient.post()
					.uri("/history")
					.header("X-Auth-Token", token)
					.header("pageNumber", "1")
					.header("pageSize", "100")
					.contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(empObject.toString()))
					.retrieve().toEntity(MovementHistory.class).block();

			if (cusInfo.getStatusCode().value() == 200) {

				Optional<MovementHistory> respuesta = Optional.ofNullable(cusInfo.getBody());
				return respuesta;

			} else {
				logger.error(cusInfo.getStatusCode());

				Optional<MovementHistory> respuesta = Optional.empty();
				return respuesta;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			Optional<MovementHistory> respuesta = Optional.empty();
			return respuesta;
		}

	}
	

}