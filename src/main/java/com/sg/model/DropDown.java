package com.sg.model;

import java.util.List;

public class DropDown {

	String formId;
	String dropDownId;
	List<String> options;
	String selectedValue;

	public DropDown() {
		super();
	}

	public DropDown(String formId, String dropDownId, List<String> options,
			String selectedValue) {
		super();
		this.formId = formId;
		this.dropDownId = dropDownId;
		this.options = options;
		this.selectedValue = selectedValue;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getDropDownId() {
		return dropDownId;
	}

	public void setDropDownId(String dropDownId) {
		this.dropDownId = dropDownId;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}

}
