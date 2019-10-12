package com.sg.model;

public class TextArea {
	
	String formId;
	String textAreaId;
	String placeholderValue;
	public TextArea(String formId, String textAreaId, String placeholderValue) {
		super();
		this.formId = formId;
		this.textAreaId = textAreaId;
		this.placeholderValue = placeholderValue;
	}
	public TextArea() {
		super();
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getTextAreaId() {
		return textAreaId;
	}
	public void setTextAreaId(String textAreaId) {
		this.textAreaId = textAreaId;
	}
	public String getPlaceholderValue() {
		return placeholderValue;
	}
	public void setPlaceholderValue(String placeholderValue) {
		this.placeholderValue = placeholderValue;
	}
	@Override
	public String toString() {
		return "TextArea [formId=" + formId + ", textAreaId=" + textAreaId
				+ ", placeholderValue=" + placeholderValue + "]";
	}
	
	

}
