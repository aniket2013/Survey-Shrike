package com.sg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sg.Dtos.FormDto;
import com.sg.exception.DuplicateKeyException;
import com.sg.model.Button;
import com.sg.model.CheckBox;
import com.sg.model.DropDown;
import com.sg.model.Form;
import com.sg.model.MetaData;
import com.sg.model.TextArea;
import com.sg.model.TextBox;
import com.sg.model.User;

@Service("surveyShrikeDao")
public class SurveyShrikeServiceImpl implements SurveyShrikeService {

	static List<Form> forms = new ArrayList<Form>();
	static List<User> users = new ArrayList<User>();
	static List<FormDto> formDtos = new ArrayList<FormDto>();

	static {
		initUsersAndForm();
		initDisplayForms();
	}

	private static void initUsersAndForm() {
		MetaData meta = new MetaData();
		TextBox box1 = new TextBox();
		TextBox box2 = new TextBox();
		List<TextBox> txboxes = new ArrayList<TextBox>();
		txboxes.add(box1);
		txboxes.add(box2);
		meta.setTexBoxes(txboxes);
		Form form1 = new Form("F01", "Form1", meta);
		Form form2 = new Form("F02", "Form2", meta);
		Form form3 = new Form("F03", "Form3", null);
		Form form4 = new Form("F04", "Form4", null);
		forms.add(form1);
		forms.add(form2);
		forms.add(form3);
		forms.add(form4);

		User user1 = new User();
		user1.setFormId("F01");
		user1.setUserId("U01");

		User user2 = new User();
		user2.setFormId("F02");
		user2.setUserId("U02");

		User user3 = new User();
		user3.setFormId("F03");
		user3.setUserId("U02");

		User user4 = new User();
		user4.setFormId("F03");
		user4.setUserId("U03");

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}

	private static void initDisplayForms() {
		TextBox tx1 = new TextBox();
		TextBox tx2 = new TextBox();
		TextBox tx3 = new TextBox();
		TextBox tx4 = new TextBox();

		tx1.setFormId("F01");
		tx1.setTextBoxId("T01");
		tx1.setPlaceholderValue("Enter your first value");

		tx2.setFormId("F01");
		tx2.setTextBoxId("T02");
		tx2.setPlaceholderValue("Enter your second value");

		tx3.setFormId("F02");
		tx3.setTextBoxId("T03");
		tx3.setPlaceholderValue("Enter your third value");

		tx4.setFormId("F02");
		tx4.setTextBoxId("T04");
		tx4.setPlaceholderValue("Enter your fourth value");

		List<TextBox> textboxes1 = new ArrayList<TextBox>();
		List<TextBox> textboxes2 = new ArrayList<TextBox>();

		textboxes1.add(tx1);
		textboxes1.add(tx2);

		textboxes2.add(tx3);
		textboxes2.add(tx4);
		
		
		TextArea ta1=new TextArea("F01","TA01","Enter Your First Text Area");
		TextArea ta2=new TextArea("F01","TA02","Enter Your Second Text Area");
		TextArea ta3=new TextArea("F02","TA03","Enter Your Third Text Area");
		TextArea ta4=new TextArea("F02","TA04","Enter Your Fourth Text Area");
		List<TextArea> textAreas1=new ArrayList<TextArea>();
		List<TextArea> textAreas2=new ArrayList<TextArea>();
		textAreas1.add(ta1);
		textAreas1.add(ta2);
		
		textAreas2.add(ta3);
		textAreas2.add(ta4);
		
		Button btn1=new Button("F01","B01");
		Button btn2=new Button("F01","B02");
		Button btn3=new Button("F01","B03");
		List<Button> buttons1=new ArrayList<Button>();
		List<Button> buttons2=new ArrayList<Button>();
		buttons1.add(btn1);
		buttons1.add(btn2);
		buttons2.add(btn3);
		
		
		CheckBox cbox1=new CheckBox();
		CheckBox cbox2=new CheckBox();
		CheckBox cbox3=new CheckBox();
		List<String> options1=new ArrayList<String>();
		options1.add("Yes");
		options1.add("No");
		List<String> options2=new ArrayList<String>();
		options2.add("Yes");
		options2.add("No");
		options2.add("May Be");
		List<String> options3=new ArrayList<String>();
		options3.add("Yes");
		options3.add("No");
		options3.add("May Be");
		cbox1.setFormId("F01");
		cbox1.setCheckBoxId("CB01");
		cbox1.setCheckBoxValue("What will happen");
		cbox1.setOptionValues(options1);
		cbox2.setFormId("F01");
		cbox2.setCheckBoxId("CB02");
		cbox2.setCheckBoxValue("When will it happen");
		cbox2.setOptionValues(options2);
		cbox3.setFormId("F02");
		cbox3.setCheckBoxId("CB03");
		cbox3.setCheckBoxValue("How Will it happen");
		cbox3.setOptionValues(options3);
		
		List<CheckBox> cboxes1=new ArrayList<CheckBox>();
		List<CheckBox> cboxes2=new ArrayList<CheckBox>();
		
		cboxes1.add(cbox1);
		cboxes1.add(cbox2);
		cboxes2.add(cbox3);
		
		
		DropDown down1=new DropDown();
		DropDown down2=new DropDown();
		DropDown down3=new DropDown();
		List<String> optionsd1=new ArrayList<String>();
		optionsd1.add("Yes");
		optionsd1.add("No");
		List<String> optionsd2=new ArrayList<String>();
		optionsd2.add("Yes");
		optionsd2.add("No");
		optionsd2.add("May Be");
		List<String> optionsd3=new ArrayList<String>();
		optionsd3.add("Yes");
		optionsd3.add("No");
		optionsd3.add("May Be");
		down1.setFormId("F01");
		down1.setDropDownId("DB01");
		down1.setSelectedValue("What will happen");
		down1.setOptions(optionsd1);
		down2.setFormId("F01");
		down2.setDropDownId("DB02");
		down2.setSelectedValue("When will happen");
		down2.setOptions(optionsd2);
		down3.setFormId("F02");
		down3.setDropDownId("DB03");
		down3.setSelectedValue("How will happen");
		down3.setOptions(optionsd3);
		
		
		List<DropDown> downList1=new ArrayList<DropDown>();
		List<DropDown> downList2=new ArrayList<DropDown>();
		
		downList1.add(down1);
		downList1.add(down2);
		downList2.add(down3);
		
		FormDto form1 = new FormDto();
		FormDto form2 = new FormDto();

		form1.setFormId("F01");
		form1.setFormName("Form1");
		form1.setTextboxes(textboxes1);
		form1.setTextAreas(textAreas1);
		form1.setButtons(buttons1);
		form1.setCheckBoxes(cboxes1);
		form1.setDropdDowns(downList1);

		form2.setFormId("F02");
		form2.setFormName("Form2");
		form2.setTextboxes(textboxes2);
		form2.setTextAreas(textAreas2);
		form2.setButtons(buttons2);
		form2.setCheckBoxes(cboxes1);
		form2.setDropdDowns(downList1);

		formDtos.add(form1);
		formDtos.add(form2);

	}

	public List<Form> getAllForms() {
		return forms;
	}

	public Form getFormById(String formId) {
		Form emptyForm = new Form();
		for (Form form : forms) {
			if (formId.equalsIgnoreCase(form.getFormId()))
				return form;
		}
		return emptyForm;
	}

	public Form saveForm(Form formToSave) {
		for (Form form : forms) {
			if (formToSave.equals(form.getFormId())) {
				try {
					throw new DuplicateKeyException("Id Already Exists");
				} catch (DuplicateKeyException e) {

					e.printStackTrace();
				}
			}
		}
		forms.add(formToSave);
		return formToSave;
	}

	public Integer getNumberOfEnrollmentsInAForm(String formId) {
		Map<String, List<User>> formIdToUsers = new HashMap<String, List<User>>();
		for (User user : users) {
			if (formIdToUsers.get(user.getFormId()) != null) {
				List<User> existingUser = formIdToUsers.get(user.getFormId());
				existingUser.add(user);
				formIdToUsers.put(user.getFormId(), existingUser);
			} else {
				List<User> newUser = new ArrayList<User>();
				newUser.add(user);
				formIdToUsers.put(user.getFormId(), newUser);

			}
		}
		if (formIdToUsers.get(formId) != null)
			return formIdToUsers.get(formId).size();
		else
			return 0;
	}

	public void deleteForm(String formId) {
		List<Form> updatedforms = new ArrayList<Form>();
		for (Form form : forms) {
			if (form.getFormId().equals(formId))
				continue;
			else
				updatedforms.add(form);

		}
		forms = updatedforms;

	}

	public Form createForm(Form form) {

		return form;
	}

	public Integer displayForm(Form form) {

		if (form != null)
			return 1;

		return 0;
	}

	public FormDto displayFormById(String formId) {
		for (FormDto dto : formDtos) {
			if (formId.equals(dto.getFormName()))
				return dto;
		}
		return new FormDto();
	}

	public List<FormDto> displayAllForms() {
		return formDtos;
	}
	

}
