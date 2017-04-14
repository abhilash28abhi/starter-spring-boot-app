package com.das.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.das.boot.model.Shipwreck;
import com.das.boot.repository.ShipwreckRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DasBootApplication.class)
public class ShipwreckRepositoryIntegrationTest {
	
	@Autowired
	private ShipwreckRepository shipRepository;
	
	public void testFindAll() {
		List<Shipwreck> wrecks = shipRepository.findAll();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}
}
