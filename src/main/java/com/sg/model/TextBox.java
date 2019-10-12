package com.sg.model;

public class TextBox {

	String formId;
	String textBoxId;
	String placeholderValue;

	public TextBox() {
		super();
	}

	public TextBox(String formId, String textBoxId, String placeholderValue) {
		super();
		this.formId = formId;
		this.textBoxId = textBoxId;
		this.placeholderValue = placeholderValue;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getTextBoxId() {
		return textBoxId;
	}

	public void setTextBoxId(String textBoxId) {
		this.textBoxId = textBoxId;
	}

	public String getPlaceholderValue() {
		return placeholderValue;
	}

	public void setPlaceholderValue(String placeholderValue) {
		this.placeholderValue = placeholderValue;
	}

	@Override
	public String toString() {
		return "TextBox [formId=" + formId + ", textBoxId=" + textBoxId
				+ ", placeholderValue=" + placeholderValue + "]";
	}
	

}
