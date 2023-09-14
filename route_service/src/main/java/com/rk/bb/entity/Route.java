package com.rk.bb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "route_table")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long route_id;
	private String source;
	private String destination;
	private double distance;
	private String intermediate_stops;
	private String route_type;
}
