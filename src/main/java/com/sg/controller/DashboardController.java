package com.sg.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sg.dao.SurveyShrikeDao;
import com.sg.model.Form;
import com.sg.model.User;
import com.sg.service.SurveyShrikeService;

@RestController
public class DashboardController {

	@Autowired
	SurveyShrikeDao surveyShrikeDao;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView model = new ModelAndView();
		model.addObject("forms", surveyShrikeDao.getAllForms());
		model.setViewName("dashboard");
		return model;
	}

	@RequestMapping(value = "/forms", method = RequestMethod.GET)
	public List<Form> getAllForms() {
		return surveyShrikeDao.getAllForms();
	}

	@RequestMapping(value = "/form/formId", method = RequestMethod.GET)
	public Form getFormById(@RequestParam String id) {
		// http://localhost:8080/form/formId?id=F01
		return surveyShrikeDao.getFormById(id);
	}

	@RequestMapping(value = "/form/enrollments/formId", method = RequestMethod.GET)
	public Integer getNumberOfEnrollmentsByFormId(@RequestParam String id) {
		return surveyShrikeDao.getNumberOfEnrollmentsInAForm(id);
	}

}
