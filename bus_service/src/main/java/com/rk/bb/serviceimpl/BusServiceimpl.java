package com.rk.bb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.bb.entity.Bus;
import com.rk.bb.repository.BusRepository;
import com.rk.bb.service.Busservice;

@Service
public class BusServiceimpl implements Busservice {
	@Autowired
	private BusRepository BusRepository;

	@Override
	public boolean createBus(Bus bus) {

		return BusRepository.save(bus) != null;
	}

	@Override
	public List<Bus> getAllBuses() {
		return BusRepository.findAll();
	}

	@Override
	public Bus getBusById(long id) {
		return BusRepository.findById(id).get();
	}

	@Override
	public boolean updateBus(Bus bus) {
		return BusRepository.save(bus) != null;
	}

	@Override
	public boolean deleteBus(long id) {
		try {
			BusRepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
