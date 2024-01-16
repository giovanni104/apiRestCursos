package com.client.controller;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.client.model.Beer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MyService {

	private final WebClient webClient;

	private static final Logger logger = LogManager.getLogger(MyService.class);

	public MyService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://random-data-api.com").build();
	}

	public Flux<Beer> someRestCall2() {
		return this.webClient.get().uri("/api/v2/beers?size=1").retrieve().bodyToFlux(Beer.class);
	}

	public Flux<Beer> someRestCall1() {

		return webClient.get().uri("/api/v2/beerws?size=1").retrieve().bodyToFlux(Beer.class)
				.onErrorResume(Exception.class, e -> Flux.empty()); // Return an empty collection on error
	}

	public Flux<Beer> someRestCall() {

		return webClient.get().uri("/api/v32/beers?size=5").retrieve().bodyToFlux(Beer.class)
				.onErrorResume(WebClientResponseException.class, ex -> {
					logger.error(ex.getMessage());
					return Flux.empty();

				}

				);
	}

}