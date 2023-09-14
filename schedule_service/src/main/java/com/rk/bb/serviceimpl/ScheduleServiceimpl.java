package com.rk.bb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.bb.entity.Schedule;
import com.rk.bb.repository.schedulRepository;
import com.rk.bb.service.ScheduleService;
@Service
public class ScheduleServiceimpl implements ScheduleService {

	@Autowired
	private schedulRepository schedulerepository;
	@Override
	public boolean createSchedule(Schedule schedule) {
		return schedulerepository.save(schedule).getSchedule_id()>0;
	}

	@Override
	public List<Schedule> getAllSchedules() {
		return schedulerepository.findAll();
	}

	@Override
	public Schedule getScheduleById(long id) {
		return schedulerepository.findById(id).get();
	}

	@Override
	public boolean updateSchedule(Schedule schedule) {
		return schedulerepository.save(schedule) != null;
	}

	@Override
	public boolean deleteSchedule(long id) {
		try {
			schedulerepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	
	}

}
