package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Weather;

public interface WeatherDAO {
	
	List<Weather> getWeatherByParkCode(String parkCode);
//	List<Weather> getWeatherByParkCodeCelcius(String parkCode);
	
}
