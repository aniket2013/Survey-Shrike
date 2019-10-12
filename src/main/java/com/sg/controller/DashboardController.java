package com.sg.controller;

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
	public ModelAndView dashboard() {
		ModelAndView model = new ModelAndView();
		model.addObject("forms", surveyShrikeService.getAllForms());
		model.setViewName("dashboard");
		return model;
	}

	@RequestMapping(value = "/forms", method = RequestMethod.GET)
	public List<Form> getAllForms() {
		return surveyShrikeService.getAllForms();
	}

	@RequestMapping(value = "/form/formId", method = RequestMethod.GET)
	public Form getFormById(@RequestParam String id) {
		return surveyShrikeService.getFormById(id);
	}

	@RequestMapping(value = "/form/enrollments/formId", method = RequestMethod.GET)
	public Integer getNumberOfEnrollmentsByFormId(@RequestParam String id) {
		return surveyShrikeService.getNumberOfEnrollmentsInAForm(id);
	}

	@RequestMapping(value = "/form/displayForm", method = RequestMethod.GET)
	public FormView displayFormById(@RequestParam String id) {
		return surveyShrikeService.displayFormByName(id);
	}

	@RequestMapping(value = "/form/displayAllForms", method = RequestMethod.GET)
	public List<FormView> displayAllForms() {
		return surveyShrikeService.displayAllForms();
	}

	@RequestMapping(value = "/form/saveForm", method = RequestMethod.GET)
	public FormView saveForm(@RequestParam String url) {
		return surveyShrikeService.saveFormDto(url);
	}

}
