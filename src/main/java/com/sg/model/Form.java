package com.sg.model;

public class Form {

	String formId;
	String formName;
	MetaData metaData;
	public Form() {
		super();
	}
	public Form(String formId, String formName, MetaData metaData) {
		super();
		this.formId = formId;
		this.formName = formName;
		this.metaData = metaData;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public MetaData getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	

}
