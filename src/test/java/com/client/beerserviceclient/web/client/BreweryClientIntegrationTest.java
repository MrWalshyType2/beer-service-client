package com.client.beerserviceclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.client.beerserviceclient.web.model.BeerDTO;

@SpringBootTest
public class BreweryClientIntegrationTest {

	@Autowired
	private BreweryClient breweryClient;
	
	@Test
	void getBeerById() {
		BeerDTO beerDTO = breweryClient.getBeerById(UUID.randomUUID());
		
		assertNotNull(beerDTO);
	}
}
