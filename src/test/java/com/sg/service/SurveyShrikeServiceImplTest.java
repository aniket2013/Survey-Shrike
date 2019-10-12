package com.sg.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.sg.Dtos.FormView;
import com.sg.model.Form;
import com.sg.service.SurveyShrikeService;
import com.sg.service.SurveyShrikeServiceImpl;

public class SurveyShrikeServiceImplTest {

	private static final String FORM22 = "Form2";
	private static final String F02 = "F02";
	private static final String F01 = "F01";
	private static final String F03 = "F03";
	private static final String FORM1 = "Form1";
	private static final String TEST_URL = "Name_Form5;TB_Tbox1;TB_Tbox2;TA_TArea1;TA_TArea2;BT_UploadFile;BT_UploadFile;";
	SurveyShrikeService service = new SurveyShrikeServiceImpl();

	@Test
	public void shoud_return_all_forms() {
		List<Form> forms = service.getAllForms();
		assertEquals(2, forms.size());
	}

	@Test
	public void should_return_form_by_formId() {
		Form form1 = service.getFormById(F01);
		Form form2 = service.getFormById(F02);
		assertEquals(FORM1, form1.getFormName());
		assertEquals(FORM22, form2.getFormName());
	}

	@Test
	public void should_save_form() {
		Form form = new Form("1", "ABC", null);
		Form form1 = service.saveForm(form);
		service.deleteForm("1");
		assertEquals("ABC", form1.getFormName());
	}

	@Test
	public void should_get_enrollments_for_a_formId() {
		Integer a = service.getNumberOfEnrollmentsInAForm(F03);
		assertEquals(new Integer(2), new Integer(a));
	}

	@Test
	public void should_get_all_forms_to_view() {
		List<FormView> formViews = service.displayAllForms();
		assertEquals(new Integer(2), new Integer(formViews.size()));
	}

	@Test
	public void should_get_form_to_view_by_name() {
		FormView formView = service.displayFormByName(FORM1);
		assertEquals(FORM1, formView.getFormName());
	}

	@Test
	public void should_prepare_form_from_url() {
		FormView formView = service.saveFormDto(TEST_URL);
		assertEquals("Form5", formView.getFormName());
		assertEquals(new Integer(2),
				new Integer(formView.getTextAreas().size()));
	}
}
