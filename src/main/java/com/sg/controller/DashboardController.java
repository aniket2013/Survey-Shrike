package com.sg.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sg.Dtos.FormView;
import com.sg.model.Form;
import com.sg.service.SurveyShrikeService;

@RestController
public class DashboardController {

	@Autowired
	SurveyShrikeService surveyShrikeService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	@ApiOperation(value = "Show the HTML rendered",
    notes = "Fetches the client side entities rendered to show the dashboard")
	public ModelAndView dashboard() {
		ModelAndView model = new ModelAndView();
		model.addObject("forms", surveyShrikeService.getAllForms());
		model.setViewName("dashboard");
		return model;
	}

	@ApiOperation(value = "Get all the forms",
		    notes = "Fecthes the json contents of all the forms")
	@RequestMapping(value = "/forms", method = RequestMethod.GET)
	public List<Form> getAllForms() {
		return surveyShrikeService.getAllForms();
	}
    
	@ApiOperation(value = "Get the form by form Id",
		    notes = "Fecthes the json data of the form by Id passed")
	@RequestMapping(value = "/form/formId", method = RequestMethod.GET)
	public Form getFormById(@RequestParam String id) {
		return surveyShrikeService.getFormById(id);
	}

	@ApiOperation(value = "Get the number of enrollements in a form",
		    notes = "Number of enroolemts for a form based on the formId passed")
	@RequestMapping(value = "/form/enrollments/formId", method = RequestMethod.GET)
	public Integer getNumberOfEnrollmentsByFormId(@RequestParam String id) {
		return surveyShrikeService.getNumberOfEnrollmentsInAForm(id);
	}

	
	@RequestMapping(value = "/form/displayForm", method = RequestMethod.GET)
	public FormView displayFormByName(@RequestParam String id) {
		return surveyShrikeService.displayFormByName(id);
	}

	@RequestMapping(value = "/form/displayAllForms", method = RequestMethod.GET)
	public List<FormView> displayAllForms() {
		return surveyShrikeService.displayAllForms();
	}

	@RequestMapping(value = "/form/saveForm", method = RequestMethod.POST)
	public FormView saveForm(@RequestParam String url) {
		return surveyShrikeService.saveFormDto(url);
	}

}
