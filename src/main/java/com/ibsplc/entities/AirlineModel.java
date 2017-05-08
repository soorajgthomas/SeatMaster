package com.ibsplc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airlineModel")
public class AirlineModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String airlineModel;
	
	@Column
	private String location;
	
	@JoinColumn(nullable = true, referencedColumnName="id")
	@ManyToOne(fetch = FetchType.EAGER)
	JsonLayout jsonLayout;

	public AirlineModel() {
	}

	public AirlineModel(Long id) {
		this.id = id;
	}

	public AirlineModel(String airlineModel, String location, JsonLayout jsonLayout) {
		this.airlineModel = airlineModel;
		this.location = location;
		this.jsonLayout = jsonLayout;
	}

	public AirlineModel(Long id, String airlineModel, String location, JsonLayout jsonLayout) {
		this.id = id;
		this.airlineModel = airlineModel;
		this.location = location;
		this.jsonLayout = jsonLayout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirlineModel() {
		return airlineModel;
	}

	public void setAirlineModel(String airlineModel) {
		this.airlineModel = airlineModel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public JsonLayout getJsonLayout() {
		return jsonLayout;
	}

	public void setJsonLayout(JsonLayout jsonLayout) {
		this.jsonLayout = jsonLayout;
	}
		
}
