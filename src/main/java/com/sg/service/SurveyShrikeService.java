package com.sg.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sg.Dtos.FormView;
import com.sg.model.Form;

@Repository
public interface SurveyShrikeService {

	public List<Form> getAllForms();

	public Form getFormById(String formId);

	public Form saveForm(Form form);

	public Integer getNumberOfEnrollmentsInAForm(String formId);
	
	public void deleteForm(String formId);
	
	public Form createForm(Form form);
	
	public Integer displayForm(Form form);
	
	public FormView displayFormByName(String formId);
	
	public List<FormView> displayAllForms();
	
	public FormView saveFormDto(String url);

}
