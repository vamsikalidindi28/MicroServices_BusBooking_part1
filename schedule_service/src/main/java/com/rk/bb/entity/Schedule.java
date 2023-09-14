package com.rk.bb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.RouteMatcher.Route;

import lombok.Data;

@Data
@Entity
@Table(name="schedule_table")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schedule_id;
	private double fare;
	private int available_seats;
	private String status;
	// Getters and setters
}
