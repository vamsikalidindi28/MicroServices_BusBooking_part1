package com.rk.bb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.bb.entity.Bus;
import com.rk.bb.service.Busservice;

@RestController
@RequestMapping("/bus")
public class BusController {

	@Autowired
	private Busservice busService;

	@PostMapping("/registerbus")
	public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
		boolean isregister = busService.createBus(bus);
		if (isregister) {
			return new ResponseEntity<Bus>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Bus>(HttpStatus.NOT_EXTENDED);
		}
	}

	@GetMapping("/getbuses")
	public ResponseEntity<List<Bus>> getAllBuses() {
		return new ResponseEntity<List<Bus>>(busService.getAllBuses(), HttpStatus.FOUND);
	}

	@GetMapping("/getBusById/{id}")
	public ResponseEntity<Bus> getBusById(@PathVariable("id") long id) {
		Bus bus = busService.getBusById(id);
		return new ResponseEntity<Bus>(bus, HttpStatus.FOUND);

	}

	@PutMapping("/updateBus/{id}")
	public ResponseEntity<Bus> updateBus(@PathVariable("id") long id, @RequestBody Bus bus) {
		boolean isupdated = busService.updateBus(bus);
		if (isupdated) {
			return new ResponseEntity<Bus>(bus, HttpStatus.OK);
		} else {
			return new ResponseEntity<Bus>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteBus/{id}")
	public ResponseEntity<Void>deleteBus(@PathVariable ("id") long id){
		busService.deleteBus(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
