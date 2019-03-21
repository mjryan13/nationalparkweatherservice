package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.ParkDAO;
import com.techelevator.dao.SurveyDAO;
import com.techelevator.model.Survey;


@Controller
public class SurveyController {
	
	@Autowired
	private SurveyDAO surveyDao;
	
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String getSurveyPage(ModelMap map) {
		
		if(!map.containsAttribute("survey")) {
			map.addAttribute("survey", new Survey());
		}
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String parkSurveyInput(@Valid @ModelAttribute("survey")Survey survey, 
								BindingResult result, RedirectAttributes attr, @RequestParam String parkCode, @RequestParam String emailAddress, 
								@RequestParam String state, @RequestParam String activityLevel) {
		
		if(result.hasErrors()) {
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			attr.addFlashAttribute("survey", survey);
			return "redirect:/survey";
		}
		Survey newSurvey = new Survey();
		newSurvey.setParkCode(parkCode);
		newSurvey.setEmailAddress(emailAddress);
		newSurvey.setState(state);
		newSurvey.setActivityLevel(activityLevel);
	
		
		surveyDao.insertSurvey(newSurvey);
		
		return "redirect:/surveyResults";
	}
	
	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String surveyResultsPage(ModelMap map) {
		
		map.addAttribute("surveys", surveyDao.getAllSurveys());
		
		
		return "surveyResults";
	}

}
