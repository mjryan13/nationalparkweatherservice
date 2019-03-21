package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Park;

@Component
public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
	
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		
		while (results.next()) {
			Park p = mapRowToPark(results);
			allParks.add(p);
		}
		return allParks;
	}
	
	
	@Override
	public List<Park> getParkByCode(String parkCode) {
		
		List<Park> parkByCode = new ArrayList<>();
		String sqlParkByCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkByCode, parkCode);
		
		while (results.next()) {
			Park p = mapRowToPark(results);
			parkByCode.add(p);
		}
		return parkByCode;
	}

	
	private Park mapRowToPark(SqlRowSet results) {
		Park park = new Park();
		park.setParkCode(results.getString("parkcode"));
		park.setParkName(results.getString("parkname"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFeet(results.getInt("elevationinfeet"));		
		park.setMilesOfTrail(results.getFloat("milesoftrail"));
		park.setNumberOfCampsites(results.getInt("numberofcampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearfounded"));
		park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		park.setInspirationalQuote(results.getString("inspirationalquote"));
		park.setQuoteSource(results.getString("inspirationalquotesource"));
		park.setParkDescription(results.getString("parkdescription"));
		park.setEntryFee(results.getInt("entryfee"));
		park.setNumberOfSpecies(results.getInt("numberofanimalspecies"));
		
		return park;
	}
}
