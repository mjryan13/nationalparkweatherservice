package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Park;
import com.techelevator.model.Weather;

@Component
public class JDBCWeatherDAO implements WeatherDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	
	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		
			
			List<Weather> weatherByParkCode = new ArrayList<>();
			String sqlWeatherByParkCode = "SELECT * FROM weather WHERE parkcode = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlWeatherByParkCode, parkCode);
			
			while (results.next()) {
				Weather w = mapRowToWeather(results);
				weatherByParkCode.add(w);
			}
			return weatherByParkCode;
		}



	private Weather mapRowToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		weather.setParkCode(results.getString("parkcode"));
		weather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		weather.setLow(results.getInt("low"));
		weather.setHigh(results.getInt("high"));
		weather.setForecast(results.getString("forecast"));
	
		
		return weather;
	}

}
