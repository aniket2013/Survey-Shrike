package com.sg.model;

public class Button {

	String formId;
	String buttonId;
	String buttonType;

	public Button() {
		super();
	}

	public Button(String formId, String buttonId, String buttonType) {
		super();
		this.formId = formId;
		this.buttonId = buttonId;
		this.buttonType = buttonType;
	}
    
	public Button(String formId, String buttonId) {
		super();
		this.formId = formId;
		this.buttonId = buttonId;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getButtonId() {
		return buttonId;
	}

	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}

	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

}
