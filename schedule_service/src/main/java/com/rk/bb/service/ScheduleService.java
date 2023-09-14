package com.rk.bb.service;

import java.util.List;

import com.rk.bb.entity.Schedule;

public interface ScheduleService {

	
	boolean createSchedule(Schedule schedule);
	
	List<Schedule> getAllSchedules();
	
	Schedule getScheduleById(long id);
	
	boolean updateSchedule(Schedule schedule);
	
	boolean deleteSchedule(long id);
}
