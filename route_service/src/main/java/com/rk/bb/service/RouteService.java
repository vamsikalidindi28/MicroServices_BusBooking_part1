package com.rk.bb.service;

import java.util.List;
import java.util.Optional;

import com.rk.bb.entity.Route;

public interface RouteService {

	boolean createRoute(Route route);

	List<Route> getAllRoutes();

	Optional<Route> getRouteById(long id);

	boolean updateRoute(Route route);

	boolean deleteRoute(long id);
}
