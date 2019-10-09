package com.sg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.dao.SurveyShrikeDao;
import com.sg.model.Form;


public class SurveyShrikeService {

	@Autowired
	SurveyShrikeDao surveyShrikeDao;

	public List<Form> getAllForms() {
		List<Form> forms = surveyShrikeDao.getAllForms();
		return forms;
	}

	public Form getFormById(String id) {
		Form form = surveyShrikeDao.getFormById(id);
		return form;
	}

	public Form saveForm(Form form) {
		Form formSaved=surveyShrikeDao.saveForm(form);
		return form;
	}

	public Integer getNumberOfEnrollmentsInAForm(String id) {
		Integer enrollments = surveyShrikeDao.getNumberOfEnrollmentsInAForm(id);
		return enrollments;
	}
}
