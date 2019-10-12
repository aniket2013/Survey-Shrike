package com.sg.Dtos;

import java.util.ArrayList;
import java.util.List;

import com.sg.model.Form;

public class ConvertEntityToDto {
	
	
	public static List<FormView> convertEntityToDto(List<Form> forms){
		
		List<FormView> formDtos=new ArrayList<FormView>();
		for(Form form:forms){
			FormView formDto=new FormView();
			formDto.setFormId(form.getFormId());
			formDto.setFormName(form.getFormName());
			formDto.setTextboxes(form.getMetaData().getTexBoxes());
			formDto.setTextAreas(form.getMetaData().getTextArea());
			formDto.setButtons(form.getMetaData().getButons());
			formDto.setCheckBoxes(form.getMetaData().getCheckboxes());
			formDto.setDropdDowns(form.getMetaData().getDropDowns());
			formDtos.add(formDto);
		}
		return formDtos;
	}

		
		
	}


