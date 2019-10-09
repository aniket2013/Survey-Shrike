package com.sg.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.sg.model.Form;

public class SurveyShrikeDaoImplTest {
	
	SurveyShrikeDao dao=new SurveyShrikeDaoImpl();
	
	@Test
	public void shoud_return_all_forms(){
	  List<Form> forms=dao.getAllForms();
	  assertEquals(4,forms.size());
	}
	
	
	@Test
	public void should_return_form_by_formId(){
		Form form1=dao.getFormById("F01");
		Form form2=dao.getFormById("F02");
		assertEquals("Form1",form1.getFormName());
		assertEquals("Form2",form2.getFormName());
	}

	@Test
	public void should_save_form(){
		Form form=new Form("1","ABC",null);
		Form form1=dao.saveForm(form);
		dao.deleteForm("1");
		assertEquals("ABC",form1.getFormName());
	}
	@Test
	public void should_get_enrollments_for_a_formId(){
		Integer a=dao.getNumberOfEnrollmentsInAForm("F03");
		assertEquals(new Integer(2),new Integer(a));
	}
}
