package com.client.beerserviceclient.web.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.client.beerserviceclient.web.model.BeerDTO;

@Component
@ConfigurationProperties(value = "brewery", ignoreUnknownFields = false)
public class BreweryClient {

	public final String BEER_PATH_V0 = "/api/v0/beer/";
	
	private String apiHost;
	
	private final RestTemplate restTemplate;

	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public BeerDTO getBeeryById(UUID id) {
		return restTemplate.getForObject(apiHost + BEER_PATH_V0 + id.toString(), BeerDTO.class);
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
}
