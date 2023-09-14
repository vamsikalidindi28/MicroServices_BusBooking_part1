package com.rk.bb.service;

import java.util.List;

import com.rk.bb.entity.Bus;

public interface Busservice {

	
	boolean createBus(Bus bus);
	
	List<Bus> getAllBuses();
	
	Bus getBusById(long id);
	
	boolean updateBus(Bus bus);
	
	boolean deleteBus(long id);
}
