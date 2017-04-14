package com.das.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.das.boot.model.Shipwreck;
import com.das.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("/api/v1/")
public class ShipWreckController {
	
	@Autowired
	private ShipwreckRepository shipRepository;
	
	@RequestMapping(value = "shipwrecks" , method = RequestMethod.GET)
	public List<Shipwreck> list() {
		//return ShipwreckStub.list();
		return shipRepository.findAll();
	}
	
	@RequestMapping(value = "shipwrecks" , method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipWreck) {
		//return ShipwreckStub.create(shipWreck);
		return shipRepository.saveAndFlush(shipWreck);
	}
	
	@RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id) {
		//return ShipwreckStub.get(id);
		return shipRepository.findOne(id);
	}
	
	@RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipWreck) {
		//return ShipwreckStub.update(id, shipWreck);
		Shipwreck exsitingShipwreck = shipRepository.findOne(id);
		BeanUtils.copyProperties(shipWreck, exsitingShipwreck);
		return shipRepository.saveAndFlush(exsitingShipwreck);
	}
	
	@RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id) {
		//return ShipwreckStub.delete(id);
		Shipwreck exsitingShipwreck = shipRepository.findOne(id);
		shipRepository.delete(exsitingShipwreck);
		return exsitingShipwreck;
	}
	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello World";
	}
}
