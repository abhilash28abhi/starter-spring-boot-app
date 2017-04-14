package com.das.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.das.boot.controller.ShipWreckController;

public class DasBootApplicationTests {

	@Test//To junit its a test method
	public void contextLoads() {
		ShipWreckController sc = new ShipWreckController();
		String result = sc.sayHello();
		assertEquals(result, "Hello World");
	}
}
