package com.das.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * The Class ShipwreckControllerWebIntegrationTest.
 * Similar to a rest client
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DasBootApplication.class)
@WebIntegrationTest
public class ShipwreckControllerWebIntegrationTest {
	
	public void testAllList() {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.getForEntity("http://localhost:8001/api/v1/shipwrecks", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
}
