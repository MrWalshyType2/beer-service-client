package com.client.beerserviceclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.client.beerserviceclient.web.model.BeerDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BreweryClientIntegrationTest {

	@Autowired
	private BreweryClient breweryClient;
	
	@Test
	void getBeerById() {
		BeerDTO beerDTO = breweryClient.getBeerById(UUID.randomUUID());
		
		assertNotNull(beerDTO);
	}
	
	@Test
	void createBeer() {
		BeerDTO beerDTO = BeerDTO.builder()
								 	.name("Beer")
								 .build();
		
		URI uri = breweryClient.createNewBeer(beerDTO);
		
		assertNotNull(uri);
		
		log.info(uri.toString());
	}
	
	@Test
	void updateBeerById() {
		BeerDTO beerDTO = BeerDTO.builder()
			 	.name("Beer")
			 .build();
		
		breweryClient.updateBeerById(UUID.randomUUID(), beerDTO);
	}
	
	@Test
	void deleteBeerById() {
		breweryClient.deleteBeerById(UUID.randomUUID());
	}
}
