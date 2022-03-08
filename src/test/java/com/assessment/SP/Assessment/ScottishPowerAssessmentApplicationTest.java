package com.assessment.SP.Assessment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ScottishPowerAssessmentApplicationTest {

	@Autowired
	private MeterReadingController controller;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void testContainsFirstAccountId() {	
		String response = controller.getCustomerMeterReadingsById(111111l);
		
		assertTrue(response.contains("accountId"));
		assertTrue(response.contains("111111"));
	}
	
	@Test
	public void testContainsSecondAccountId() {	
		String response = controller.getCustomerMeterReadingsById(222222l);
		
		assertTrue(response.contains("accountId"));
		assertTrue(response.contains("222222"));
	}
	
	@Test
	public void testContainsBothGasAndElectricFirst() {	
		String response = controller.getCustomerMeterReadingsById(111111l);
		
		assertTrue(response.contains("GAS"));
		assertTrue(response.contains("ELECTRIC"));
		assertTrue(response.contains("83"));
		assertTrue(response.contains("meterReadingType"));
		
	}
	
	@Test
	public void testContainsBothGasAndElectricSecond() {	
		String response = controller.getCustomerMeterReadingsById(222222l);
		
		assertTrue(response.contains("GAS"));
		assertTrue(response.contains("ELECTRIC"));
		assertTrue(response.contains("222123"));
		assertTrue(response.contains("meterReadingType"));
	}

	@Test
	public void testFullRequest() {
		
		  ResponseEntity<String> response = restTemplate
		            .getForEntity("http://localhost:" + this.port + "/api/smart/reads/222222", String.class);
		    assertEquals(HttpStatus.OK, response.getStatusCode());
		    assertTrue(response.getBody().contains("accountId"));
		    assertTrue(response.getBody().contains("222123"));
		    assertTrue(response.getBody().contains("elecReadings"));
	}
}
