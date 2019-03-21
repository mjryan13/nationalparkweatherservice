package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Park;

public interface ParkDAO {

	public List<Park> getAllParks();
	

	public List<Park> getParkByCode(String parkCode);



}
