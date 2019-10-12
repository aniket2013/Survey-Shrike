package com.sg.model;

import java.util.List;

public class MetaData {

	String formId;
	List<TextBox> texBoxes;
	List<DropDown> dropDowns;
	List<CheckBox> checkboxes;
	List<Button> butons;
	List<TextArea> textAreas;

	public MetaData() {
		super();
	}

	public MetaData(String formId, List<TextBox> texBoxes,
			List<DropDown> dropDowns, List<CheckBox> checkboxes,
			List<Button> butons) {
		super();
		this.formId = formId;
		this.texBoxes = texBoxes;
		this.dropDowns = dropDowns;
		this.checkboxes = checkboxes;
		this.butons = butons;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public List<TextBox> getTexBoxes() {
		return texBoxes;
	}

	public void setTexBoxes(List<TextBox> texBoxes) {
		this.texBoxes = texBoxes;
	}

	public List<DropDown> getDropDowns() {
		return dropDowns;
	}

	public void setDropDowns(List<DropDown> dropDowns) {
		this.dropDowns = dropDowns;
	}

	public List<CheckBox> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(List<CheckBox> checkboxes) {
		this.checkboxes = checkboxes;
	}

	public List<Button> getButons() {
		return butons;
	}

	public void setButons(List<Button> butons) {
		this.butons = butons;
	}

	public List<TextArea> getTextArea() {
		return textAreas;
	}

	public void setTextArea(List<TextArea> textArea) {
		this.textAreas = textArea;
	}
	

}
