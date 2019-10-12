package com.sg.Dtos;

import java.util.List;

import com.sg.model.Button;
import com.sg.model.CheckBox;
import com.sg.model.DropDown;
import com.sg.model.TextArea;
import com.sg.model.TextBox;

public class FormView {

	String formId;
	String formName;
	List<TextBox> textboxes;
	List<TextArea> textAreas;
	List<Button> buttons;
	List<CheckBox> checkBoxes;
	List<DropDown> dropdDowns;

	public FormView(String formId, String formName, List<TextBox> textboxes,
			List<Button> buttons, List<CheckBox> checkBoxes) {
		super();
		this.formId = formId;
		this.formName = formName;
		this.textboxes = textboxes;
		this.buttons = buttons;
		this.checkBoxes = checkBoxes;
	}

	
	public FormView(String formId, String formName, List<TextBox> textboxes,
			List<TextArea> textAreas, List<Button> buttons,
			List<CheckBox> checkBoxes) {
		super();
		this.formId = formId;
		this.formName = formName;
		this.textboxes = textboxes;
		this.textAreas = textAreas;
		this.buttons = buttons;
		this.checkBoxes = checkBoxes;
	}


	public FormView() {
		super();
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

	public List<TextBox> getTextboxes() {
		return textboxes;
	}

	public void setTextboxes(List<TextBox> textboxes) {
		this.textboxes = textboxes;
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	public List<CheckBox> getCheckBoxes() {
		return checkBoxes;
	}

	public void setCheckBoxes(List<CheckBox> checkBoxes) {
		this.checkBoxes = checkBoxes;
	}

	public List<TextArea> getTextAreas() {
		return textAreas;
	}

	public void setTextAreas(List<TextArea> textAreas) {
		this.textAreas = textAreas;
	}


	public List<DropDown> getDropdDowns() {
		return dropdDowns;
	}


	public void setDropdDowns(List<DropDown> dropdDowns) {
		this.dropdDowns = dropdDowns;
	}


	@Override
	public String toString() {
		return "FormDto [formId=" + formId + ", formName=" + formName
				+ ", textboxes=" + textboxes + ", textAreas=" + textAreas
				+ ", buttons=" + buttons + ", checkBoxes=" + checkBoxes
				+ ", dropdDowns=" + dropdDowns + "]";
	}
	

}
