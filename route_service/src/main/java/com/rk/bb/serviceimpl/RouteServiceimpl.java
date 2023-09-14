package com.rk.bb.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.bb.entity.Route;
import com.rk.bb.repository.routeRepository;
import com.rk.bb.service.RouteService;

@Service
public class RouteServiceimpl implements RouteService {

	@Autowired
	private routeRepository Routerepository;

	@Override
	public boolean createRoute(Route route) {
		return Routerepository.save(route).getRoute_id() > 0;
	}

	@Override
	public List<Route> getAllRoutes() {
		return Routerepository.findAll();
	}

	@Override
	public Optional<Route> getRouteById(long id) {
		return Routerepository.findById(id);
	}

	@Override
	public boolean updateRoute(Route route) {
		return Routerepository.save(route).getRoute_id() > 0;
	}

	@Override
	public boolean deleteRoute(long id) {
		try {
			Routerepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
