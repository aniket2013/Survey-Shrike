package com.sg.model;

import java.util.List;

public class CheckBox {

	String formId;
	String checkBoxId;
	String checkBoxValue;
	List<String> optionValues;

	public CheckBox() {
		super();
	}

	public CheckBox(String formId, String checkBoxId, String checkBoxValue) {
		super();
		this.formId = formId;
		this.checkBoxId = checkBoxId;
		this.checkBoxValue = checkBoxValue;
	}
	

	public CheckBox(String formId, String checkBoxId, String checkBoxValue,
			List<String> optionValues) {
		super();
		this.formId = formId;
		this.checkBoxId = checkBoxId;
		this.checkBoxValue = checkBoxValue;
		this.optionValues = optionValues;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getCheckBoxId() {
		return checkBoxId;
	}

	public void setCheckBoxId(String checkBoxId) {
		this.checkBoxId = checkBoxId;
	}

	public String getCheckBoxValue() {
		return checkBoxValue;
	}

	public void setCheckBoxValue(String checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}

	public List<String> getOptionValues() {
		return optionValues;
	}

	public void setOptionValues(List<String> optionValues) {
		this.optionValues = optionValues;
	}
	

}
