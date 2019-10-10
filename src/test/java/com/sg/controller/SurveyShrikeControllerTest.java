package com.sg.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sg.config.Application;
import com.sg.model.Form;
import com.sg.service.SurveyShrikeService;

@RunWith(SpringRunner.class)
@WebMvcTest(DashboardController.class)
@ContextConfiguration(classes = { Application.class })
public class SurveyShrikeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	SurveyShrikeService surveyShrikeService;

	@Test
	public void should_return_correct_status_on_calling_getAllForms_endpoint()
			throws Exception {
		Form form1 = new Form();
		Form form2 = new Form();
		List<Form> forms = new ArrayList<Form>();
		forms.add(form1);
		forms.add(form2);
		Mockito.when(surveyShrikeService.getAllForms()).thenReturn(forms);

		mvc.perform(
				MockMvcRequestBuilders.get("/forms")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void should_get_correct_status_on_calling_getFormById_endpoint()
			throws Exception {
		Form form1 = new Form();
		form1.setFormId("F01");
		form1.setFormId("Form1");

		Mockito.when(surveyShrikeService.getFormById(Mockito.anyString())).thenReturn(form1);

		mvc.perform(
				MockMvcRequestBuilders.get("/form/formId?id=F01")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
   
	@Test
	public void should_get_correct_status_on_calling_getNumberOfEnrollmentsInAform() throws Exception{
		Mockito.when(
				surveyShrikeService.getNumberOfEnrollmentsInAForm(Mockito
						.anyString())).thenReturn(3);
		
		mvc.perform(
				MockMvcRequestBuilders.get("/form/enrollments/formId?id=F03")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		
	}
}
