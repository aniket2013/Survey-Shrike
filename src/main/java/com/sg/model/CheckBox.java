package com.sg.model;

public class CheckBox {

	String formId;
	String checkBoxId;
	String checkBoxValue;

	public CheckBox() {
		super();
	}

	public CheckBox(String formId, String checkBoxId, String checkBoxValue) {
		super();
		this.formId = formId;
		this.checkBoxId = checkBoxId;
		this.checkBoxValue = checkBoxValue;
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

}
