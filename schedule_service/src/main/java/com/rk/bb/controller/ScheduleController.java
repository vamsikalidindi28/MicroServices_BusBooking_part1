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

import com.rk.bb.entity.Schedule;
import com.rk.bb.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleservice;

	@PostMapping("/registerSchedule")
	public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
		boolean isregister = scheduleservice.createSchedule(schedule);
		if (isregister) {
			return new ResponseEntity<Schedule>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Schedule>(HttpStatus.NOT_EXTENDED);
		}
	}

	@GetMapping("/getSchedules")
	public ResponseEntity<List<Schedule>> getAllSchedules() {
		return new ResponseEntity<List<Schedule>>(scheduleservice.getAllSchedules(), HttpStatus.FOUND);
	}

	@GetMapping("/getScheduleById/{id}")
	public ResponseEntity<Schedule> getScheduleById(@PathVariable("id") long id) {
		Schedule schedule = scheduleservice.getScheduleById(id);
		return new ResponseEntity<Schedule>(schedule, HttpStatus.FOUND);

	}

	@PutMapping("/updateSchedule")
	public ResponseEntity<Schedule> updateSchedule(@RequestBody Schedule schedule) {
		boolean isupdated = scheduleservice.updateSchedule(schedule);
		if (isupdated) {
			return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
		} else {
			return new ResponseEntity<Schedule>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteSchedule/{id}")
	public ResponseEntity<Void>deleteSchedule(@PathVariable ("id") long id){
		scheduleservice.deleteSchedule(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
