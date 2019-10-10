package com.sg.cucumber;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sg.model.CheckBox;
import com.sg.model.Form;
import com.sg.model.MetaData;
import com.sg.model.TextBox;
import com.sg.service.SurveyShrikeService;
import static org.junit.Assert.assertEquals;
import com.sg.service.SurveyShrikeServiceImpl;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;


public class CreateAFormFeatureStepDef {
	
	SurveyShrikeService service=new SurveyShrikeServiceImpl();
	
	Form form=new Form();
	@Given("^the form name is Form(\\d+)$")
	public void the_form_name_is_Form(String arg1) {
	    // Express the Regexp above with the code you wish you had
	   
	   form.setFormName(arg1);
	}

	@Given("^the form Id id F(\\d+)$")
	public void the_form_Id_id_F(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    form.setFormId(arg1);
	}

	@Given("^the textbox(\\d+) is T(\\d+)$")
	public void the_textbox_is_T(String arg1, String arg2) {
	    // Express the Regexp above with the code you wish you had
	    MetaData md=new MetaData();
	    TextBox tx1=new TextBox();
	    TextBox tx2=new TextBox();
	    tx1.setTextBoxId(arg1);
	    tx1.setTextBoxId(arg2);
	    List<TextBox> list=new ArrayList<TextBox>();
	    list.add(tx1);
	    list.add(tx2);
	    md.setTexBoxes(list);
	    form.setMetaData(md);
	}

	@Given("^the checkbox(\\d+) is C(\\d+)$")
	public void the_checkbox_is_C(String arg1, String arg2) {
	    // Express the Regexp above with the code you wish you had
		MetaData md=new MetaData();
	    CheckBox tx1=new CheckBox();
	    CheckBox tx2=new CheckBox();
	    tx1.setCheckBoxId(arg1);
	    tx1.setCheckBoxId(arg2);
	    List<CheckBox> list=new ArrayList<CheckBox>();
	    list.add(tx1);
	    list.add(tx2);
	    md.setCheckboxes(list);
	    form.setMetaData(md);
	}

	@When("^I perform create form operation$")
	public void I_perform_create_form_operation() {
	    // Express the Regexp above with the code you wish you had
	    form=service.createForm(form);
	}

	@Then("^I have a form with the Id as \"([^\"]*)\"$")
	public void I_have_a_form_with_the_Id_as(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    assertEquals(arg1, form.getFormId());
	}

}
