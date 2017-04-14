package com.das.boot;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.das.boot.controller.ShipWreckController;
import com.das.boot.model.Shipwreck;
import com.das.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipWreckController controller;
	
	@Mock
	private ShipwreckRepository shipRepository;
	
	@Before //This method runs before any test cases
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		//throws NPE since spring is not able to inject shipRepository on itself so we will mock the controller
		/*ShipWreckController sc = new ShipWreckController();
		Shipwreck wreck = sc.get(1L);
		assertEquals(1L, wreck.getId().longValue());*/
		
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(shipRepository.findOne(1L)).thenReturn(sw);
		Shipwreck wreck = controller.get(1L);
		
		//assertEquals(1L, wreck.getId().longValue());
		//Using Hamcrest matchers (Easy to use, provides more matchers and declarative)
		assertThat(wreck.getId(), is(1L));
	}
}
