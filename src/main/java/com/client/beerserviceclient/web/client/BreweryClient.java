package com.client.beerserviceclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.client.beerserviceclient.web.model.BeerDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ConfigurationProperties(value = "brewery", ignoreUnknownFields = false)
@ConstructorBinding
public class BreweryClient {

	public final String BEER_PATH_V0 = "/api/v0/beer/";
	
	private final String apiHost;
	
	@Autowired
	private RestTemplate restTemplate;

	public BreweryClient(String apiHost) {
		super();
		this.apiHost = apiHost;
		log.info("API HOST        : " + apiHost);
		log.info("BEER API V0 PATH: " + BEER_PATH_V0);
	}
	
	public BeerDTO getBeerById(UUID id) {
		return restTemplate.getForObject(apiHost + BEER_PATH_V0 + id.toString(), BeerDTO.class);
	}
	
	public URI createNewBeer(BeerDTO beerDTO) {
		return restTemplate.postForLocation(apiHost + BEER_PATH_V0, beerDTO);
	}
	
	public void updateBeerById(UUID id, BeerDTO beerDTO) {
		restTemplate.put(apiHost + BEER_PATH_V0 + id.toString(), beerDTO);
	}
}
