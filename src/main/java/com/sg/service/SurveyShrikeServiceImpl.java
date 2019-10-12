package com.sg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sg.Dtos.FormView;
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

	private static final String DROPDOWN_META_ID = "DD";
	private static final String CHECKBOX_META_ID = "CB";
	private static final String BUTTON_META_ID = "BT";
	private static final String TEXTAREA_META_ID = "TA";
	private static final String TEXTBOX_META_ID = "TB";
	static List<Form> forms = new ArrayList<Form>();
	static List<User> users = new ArrayList<User>();
	static List<FormView> formDtos = new ArrayList<FormView>();

	static {
		initUsersAndForm();
		initDisplayForms();
	}

	private static void initUsersAndForm() {

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

		TextArea ta1 = new TextArea("F01", "TA01", "Enter Your First Text Area");
		TextArea ta2 = new TextArea("F01", "TA02",
				"Enter Your Second Text Area");
		TextArea ta3 = new TextArea("F02", "TA03", "Enter Your Third Text Area");
		TextArea ta4 = new TextArea("F02", "TA04",
				"Enter Your Fourth Text Area");
		List<TextArea> textAreas1 = new ArrayList<TextArea>();
		List<TextArea> textAreas2 = new ArrayList<TextArea>();
		textAreas1.add(ta1);
		textAreas1.add(ta2);

		textAreas2.add(ta3);
		textAreas2.add(ta4);

		Button btn1 = new Button("F01", "B01");
		Button btn2 = new Button("F01", "B02");
		Button btn3 = new Button("F01", "B03");
		List<Button> buttons1 = new ArrayList<Button>();
		List<Button> buttons2 = new ArrayList<Button>();
		buttons1.add(btn1);
		buttons1.add(btn2);
		buttons2.add(btn3);

		CheckBox cbox1 = new CheckBox();
		CheckBox cbox2 = new CheckBox();
		CheckBox cbox3 = new CheckBox();
		List<String> options1 = new ArrayList<String>();
		options1.add("Yes");
		options1.add("No");
		List<String> options2 = new ArrayList<String>();
		options2.add("Yes");
		options2.add("No");
		options2.add("May Be");
		List<String> options3 = new ArrayList<String>();
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

		List<CheckBox> cboxes1 = new ArrayList<CheckBox>();
		List<CheckBox> cboxes2 = new ArrayList<CheckBox>();

		cboxes1.add(cbox1);
		cboxes1.add(cbox2);
		cboxes2.add(cbox3);

		DropDown down1 = new DropDown();
		DropDown down2 = new DropDown();
		DropDown down3 = new DropDown();
		List<String> optionsd1 = new ArrayList<String>();
		optionsd1.add("Yes");
		optionsd1.add("No");
		List<String> optionsd2 = new ArrayList<String>();
		optionsd2.add("Yes");
		optionsd2.add("No");
		optionsd2.add("May Be");
		List<String> optionsd3 = new ArrayList<String>();
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

		List<DropDown> downList1 = new ArrayList<DropDown>();
		List<DropDown> downList2 = new ArrayList<DropDown>();

		downList1.add(down1);
		downList1.add(down2);
		downList2.add(down3);

		MetaData md1 = new MetaData();
		md1.setFormId("F01");
		md1.setTexBoxes(textboxes1);
		md1.setButons(buttons1);
		md1.setCheckboxes(cboxes1);
		md1.setDropDowns(downList1);
		md1.setTextArea(textAreas1);

		MetaData md2 = new MetaData();
		md2.setFormId("F02");
		md2.setTexBoxes(textboxes2);
		md2.setButons(buttons2);
		md2.setCheckboxes(cboxes2);
		md2.setDropDowns(downList2);
		md2.setTextArea(textAreas2);

		Form form1 = new Form("F01", "Form1", md1);
		Form form2 = new Form("F02", "Form2", md2);
		forms.add(form1);
		forms.add(form2);

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

		TextArea ta1 = new TextArea("F01", "TA01", "Enter Your First Text Area");
		TextArea ta2 = new TextArea("F01", "TA02",
				"Enter Your Second Text Area");
		TextArea ta3 = new TextArea("F02", "TA03", "Enter Your Third Text Area");
		TextArea ta4 = new TextArea("F02", "TA04",
				"Enter Your Fourth Text Area");
		List<TextArea> textAreas1 = new ArrayList<TextArea>();
		List<TextArea> textAreas2 = new ArrayList<TextArea>();
		textAreas1.add(ta1);
		textAreas1.add(ta2);

		textAreas2.add(ta3);
		textAreas2.add(ta4);

		Button btn1 = new Button("F01", "B01");
		Button btn2 = new Button("F01", "B02");
		Button btn3 = new Button("F01", "B03");
		List<Button> buttons1 = new ArrayList<Button>();
		List<Button> buttons2 = new ArrayList<Button>();
		buttons1.add(btn1);
		buttons1.add(btn2);
		buttons2.add(btn3);

		CheckBox cbox1 = new CheckBox();
		CheckBox cbox2 = new CheckBox();
		CheckBox cbox3 = new CheckBox();
		List<String> options1 = new ArrayList<String>();
		options1.add("Yes");
		options1.add("No");
		List<String> options2 = new ArrayList<String>();
		options2.add("Yes");
		options2.add("No");
		options2.add("May Be");
		List<String> options3 = new ArrayList<String>();
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

		List<CheckBox> cboxes1 = new ArrayList<CheckBox>();
		List<CheckBox> cboxes2 = new ArrayList<CheckBox>();

		cboxes1.add(cbox1);
		cboxes1.add(cbox2);
		cboxes2.add(cbox3);

		DropDown down1 = new DropDown();
		DropDown down2 = new DropDown();
		DropDown down3 = new DropDown();
		List<String> optionsd1 = new ArrayList<String>();
		optionsd1.add("Yes");
		optionsd1.add("No");
		List<String> optionsd2 = new ArrayList<String>();
		optionsd2.add("Yes");
		optionsd2.add("No");
		optionsd2.add("May Be");
		List<String> optionsd3 = new ArrayList<String>();
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

		List<DropDown> downList1 = new ArrayList<DropDown>();
		List<DropDown> downList2 = new ArrayList<DropDown>();

		downList1.add(down1);
		downList1.add(down2);
		downList2.add(down3);

		FormView form1 = new FormView();
		FormView form2 = new FormView();

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

	public FormView displayFormByName(String formId) {

		for (FormView dto : formDtos) {
			if (formId.equals(dto.getFormName()))
				return dto;
		}
		return new FormView();
	}

	public List<FormView> displayAllForms() {
		return formDtos;
	}

	public FormView saveFormDto(String url) {

		url = url.trim();
		String ar[] = url.split(";");

		FormView formDto = preapreDtoToSaveEntity(ar);

		return formDto;
	}

	public FormView preapreDtoToSaveEntity(String[] ar) {
		FormView formDto = new FormView();
		List<TextBox> textBoxes = new ArrayList<TextBox>();
		List<TextArea> textAreas = new ArrayList<TextArea>();
		List<Button> buttons = new ArrayList<Button>();
		List<CheckBox> cboxes = new ArrayList<CheckBox>();
		List<DropDown> dropDowns = new ArrayList<DropDown>();
		for (int i = 1; i < ar.length; i++) {
			String str1 = ar[i];

			String typeOfEntity = str1.substring(0, 2);
			storeMetaInformationForTextBox(textBoxes, str1, typeOfEntity);
			storeMetaInformationForTextArea(textAreas, str1, typeOfEntity);
			storeMetaInformationForButton(buttons, str1, typeOfEntity);
			storMetaInformationForCheckBoxes(cboxes, str1, typeOfEntity);
			storeMetaInformationForDropDown(dropDowns, str1, typeOfEntity);
		}

		String formName = ar[0].substring(5);
		setValuesOfMetaDataForTheForms(formDto, textBoxes, textAreas, buttons,
				formName);

		formDtos.add(formDto);
		return formDto;
	}

	public void setValuesOfMetaDataForTheForms(FormView formDto,
			List<TextBox> textBoxes, List<TextArea> textAreas,
			List<Button> buttons, String formName) {
		formDto.setFormName(formName);
		formDto.setButtons(buttons);
		formDto.setTextAreas(textAreas);
		formDto.setTextboxes(textBoxes);
	}

	public void storeMetaInformationForDropDown(List<DropDown> dropDowns,
			String str1, String typeOfEntity) {
		if (typeOfEntity.equals(DROPDOWN_META_ID)) {
			DropDown dropDown = new DropDown();
			dropDown.setSelectedValue(str1.substring(3));
			dropDowns.add(dropDown);
		}
	}

	public void storMetaInformationForCheckBoxes(List<CheckBox> cboxes,
			String str1, String typeOfEntity) {
		if (typeOfEntity.equals(CHECKBOX_META_ID)) {
			CheckBox checkBox = new CheckBox();
			checkBox.setCheckBoxValue(str1.substring(3));
			cboxes.add(checkBox);
		}
	}

	public void storeMetaInformationForButton(List<Button> buttons,
			String str1, String typeOfEntity) {
		if (typeOfEntity.equals(BUTTON_META_ID)) {
			Button button = new Button();
			button.setButtonType(str1.substring(3));
			buttons.add(button);
		}
	}

	public void storeMetaInformationForTextArea(List<TextArea> textAreas,
			String str1, String typeOfEntity) {
		if (typeOfEntity.equals(TEXTAREA_META_ID)) {
			TextArea textArea = new TextArea();
			textArea.setPlaceholderValue(str1.substring(3));
			textAreas.add(textArea);
		}
	}

	public void storeMetaInformationForTextBox(List<TextBox> textBoxes,
			String str1, String typeOfEntity) {
		if (typeOfEntity.equals(TEXTBOX_META_ID)) {
			TextBox textBox = new TextBox();

			textBox.setPlaceholderValue(str1.substring(3));
			textBoxes.add(textBox);
		}
	}

}
