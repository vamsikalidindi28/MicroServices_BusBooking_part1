package com.rk.bb.controller;

import java.util.List;
import java.util.Optional;

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

import com.rk.bb.entity.Route;
import com.rk.bb.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {

	@Autowired
	private RouteService routeService;

	@PostMapping("/createroute")
	public ResponseEntity<Boolean> createroute(@RequestBody Route route) {
		boolean iscreated = routeService.createRoute(route);
		if (iscreated) {
			return new ResponseEntity<Boolean>(iscreated, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Boolean>(iscreated, HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@GetMapping("/getallroutes")
	public ResponseEntity<List<Route>> GetAllRoutes() {
		List<Route> route = routeService.getAllRoutes();
		if (route.isEmpty()) {
			return new ResponseEntity<List<Route>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Route>>(route, HttpStatus.FOUND);
		}
	}

	@GetMapping("/getRouteById/{id}")
	public ResponseEntity<Optional<Route>> getRouteById(@PathVariable long id) {
		Optional<Route> route = routeService.getRouteById(id);
		if (route.isPresent()) {
			return new ResponseEntity<Optional<Route>>(route, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Optional<Route>>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updateRoute")
	public ResponseEntity<Boolean> updateRoute(@RequestBody Route route) {
		boolean isupdated = routeService.updateRoute(route);
		if (isupdated) {
			return new ResponseEntity<Boolean>(isupdated, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isupdated, HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping("deleteRoute/{id}")
	public ResponseEntity<Boolean> DeleteRoute(@PathVariable long id) {
		boolean isdeleted = routeService.deleteRoute(id);
		if (isdeleted) {
			return new ResponseEntity<Boolean>(isdeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isdeleted, HttpStatus.NOT_FOUND);
		}
	}
}
