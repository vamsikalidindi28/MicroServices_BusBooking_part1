package com.rk.bb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bus_table")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bus_id;
	private String bus_number;
	private String model;
	private int capacity;
	private int year_of_manufacture;
	private String bus_type;
	private String amenities;
	private String status;

	
}
