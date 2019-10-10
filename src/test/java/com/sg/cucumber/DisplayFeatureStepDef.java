package com.sg.cucumber;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import com.sg.model.Form;
import com.sg.service.SurveyShrikeService;
import com.sg.service.SurveyShrikeServiceImpl;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class DisplayFeatureStepDef {
	
	
	SurveyShrikeService service=new SurveyShrikeServiceImpl();
	Integer result=0;
	
	Form form=new Form();
	
	@Given("^the name of the form is Form(\\d+)$")
	public void the_name_of_the_form_is_Form(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    form.setFormName(arg1);
	}

	@Given("^the id of the form is (\\d+)$")
	public void the_id_of_the_form_is(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    form.setFormId(arg1);
	}

	@When("^I perform display form operation$")
	public void I_perform_display_form_operation() {
	    // Express the Regexp above with the code you wish you had
		result=service.displayForm(form);
	}

	@Then("^the message is \"([^\"]*)\"$")
	public void the_message_is(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    assertEquals(result,new Integer(arg1.charAt(0)-'0'));
	}


}
