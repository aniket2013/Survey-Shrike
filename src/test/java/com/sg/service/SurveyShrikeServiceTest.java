package com.sg.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.sg.dao.SurveyShrikeDao;
import com.sg.model.Form;

public class SurveyShrikeServiceTest {

	@InjectMocks
	SurveyShrikeService surveyShrikeService;

	@Mock
	SurveyShrikeDao surveySrikeDAO;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void should_return_all_forms() {
		Form form1 = new Form();
		Form form2 = new Form();
		List<Form> formsActual = new ArrayList<Form>();
		formsActual.add(form1);
		formsActual.add(form2);
		Mockito.when(surveySrikeDAO.getAllForms()).thenReturn(formsActual);

		List<Form> formsExpected = surveyShrikeService.getAllForms();
		assertEquals(formsActual.size(), formsExpected.size());

	}

	@Test
	public void should_return_form_by_Id() {
		Form actualform1 = new Form("1", "Form1", null);
		Form actualform2 = new Form("2", "Form2", null);
		Mockito.when(surveySrikeDAO.getFormById("1")).thenReturn(actualform1);
		Mockito.when(surveySrikeDAO.getFormById("2")).thenReturn(actualform2);

		Form expectedForm1 = surveyShrikeService.getFormById(actualform1
				.getFormId());
		Form expectedForm2 = surveyShrikeService.getFormById(actualform2
				.getFormId());

		assertEquals(actualform1.getFormName(), expectedForm1.getFormName());
		assertEquals(actualform2.getFormName(), expectedForm2.getFormName());

	}

	@Test
	public void should_return_saved_form() {
		Form actualform1 = new Form("1", "Form1", null);
		Form actualform2 = new Form("2", "Form2", null);

		Mockito.when(surveySrikeDAO.saveForm(actualform1)).thenReturn(
				actualform1);
		Mockito.when(surveySrikeDAO.saveForm(actualform1)).thenReturn(
				actualform1);

		Form expectedForm1 = surveyShrikeService.saveForm(actualform1);
		Form expectedForm2 = surveyShrikeService.saveForm(actualform2);

		assertEquals(actualform1.getFormName(), expectedForm1.getFormName());
		assertEquals(actualform2.getFormName(), expectedForm2.getFormName());

	}

	@Test
	public void should_return_number_of_enrollments_for_a_form() {
		Form actualform1 = new Form("1", "Form1", null);
		Form actualform2 = new Form("2", "Form2", null);

		Mockito.when(
				surveySrikeDAO.getNumberOfEnrollmentsInAForm(actualform1
						.getFormId())).thenReturn(3);
		Mockito.when(
				surveySrikeDAO.getNumberOfEnrollmentsInAForm(actualform2
						.getFormId())).thenReturn(5);

		Integer result1 = surveyShrikeService
				.getNumberOfEnrollmentsInAForm(actualform1.getFormId());
		Integer result2 = surveyShrikeService
				.getNumberOfEnrollmentsInAForm(actualform2.getFormId());

		assertEquals(new Integer(result1), new Integer(3));
		assertEquals(new Integer(result2), new Integer(5));

	}
}
