package com.techelevator.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.dao.ParkDAO;
import com.techelevator.dao.WeatherDAO;
import com.techelevator.model.Weather;

@Controller
@SessionAttributes("temp")
public class ParkController {
	
	@Autowired
	private ParkDAO parkDao;
	
	@Autowired
	private WeatherDAO weatherDao;
	
	
	@RequestMapping("/")
	public String showHomePage(ModelMap map) {
		map.addAttribute("parks", parkDao.getAllParks());
		
		return "home";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String parkDetailPage(ModelMap map, @RequestParam String parkCode) {
		
		List<Weather> fiveDayForecast = weatherDao.getWeatherByParkCode(parkCode);
		Weather weatherObj = fiveDayForecast.get(0);
		
		
		map.addAttribute("parks", parkDao.getParkByCode(parkCode));
		map.addAttribute("weather", weatherDao.getWeatherByParkCode(parkCode));
		boolean temp = false;
		if(map.get("temp") == null) {
			temp = false;
			
		}
		else {
			temp = (boolean) map.get("temp");
		}
	
		
		map.addAttribute("temp", temp);
	
	


		return "parkDetail";
	}

	@RequestMapping(path="/tempToggle", method=RequestMethod.GET)
	public String parkDetailPageToggle(ModelMap map, @RequestParam String parkCode) {
		
		List<Weather> fiveDayForecast = weatherDao.getWeatherByParkCode(parkCode);
		Weather weatherObj = fiveDayForecast.get(0);
		
		
		map.addAttribute("parks", parkDao.getParkByCode(parkCode));
		map.addAttribute("weather", weatherDao.getWeatherByParkCode(parkCode));
		boolean temp = false;
		if(map.get("temp") == null) {
			temp = false;
			
		}
		else {
			temp = (boolean) map.get("temp");
		}
	
		
		map.addAttribute("temp", !temp);
	
		return "parkDetail";
	}
	
	
	

}
