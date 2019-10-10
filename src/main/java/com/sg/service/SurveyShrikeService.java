package com.sg.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sg.model.Form;

@Repository
public interface SurveyShrikeService {

	public List<Form> getAllForms();

	public Form getFormById(String formId);

	public Form saveForm(Form form);

	public Integer getNumberOfEnrollmentsInAForm(String formId);
	
	public void deleteForm(String formId);

}
