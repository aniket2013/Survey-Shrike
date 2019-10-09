package com.sg.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sg.dao.SurveyShrikeDao;
import com.sg.model.Form;


@RunWith(SpringRunner.class)
@WebMvcTest(DashboardController.class)
public class SurveyShrikeControllerTest {

	@Autowired
	private MockMvc mvc;
	
	
	@MockBean
	SurveyShrikeDao surveyShrikeDao;
	
	@Test
	public void getAllForms(){
		Form form1=new Form();
		Form form2=new Form();
		List<Form> forms=new ArrayList<Form>();
		forms.add(form1);
		forms.add(form2);
		Mockito.when(surveyShrikeDao.getAllForms()).thenReturn(forms);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/forms").accept(
				MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mvc.perform(requestBuilder).andReturn();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
    
}
