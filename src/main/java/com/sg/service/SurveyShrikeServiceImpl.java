package com.sg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sg.exception.DuplicateKeyException;
import com.sg.model.Form;
import com.sg.model.User;

@Service("surveyShrikeDao")
public class SurveyShrikeServiceImpl implements SurveyShrikeService {
	
	static List<Form> forms=new ArrayList<Form>();
	static List<User> users=new ArrayList<User>();
	
	static 
	{
		initUsersAndForm();
	}

	private static void initUsersAndForm() {
		Form form1=new Form("F01","Form1",null);
		Form form2=new Form("F02","Form2",null);
		Form form3=new Form("F03","Form3",null);
		Form form4=new Form("F04","Form4",null);
		forms.add(form1);
		forms.add(form2);
		forms.add(form3);
		forms.add(form4);
		
		User user1=new User();
		user1.setFormId("F01");
		user1.setUserId("U01");
		
		User user2=new User();
		user2.setFormId("F02");
		user2.setUserId("U02");
		
		User user3=new User();
		user3.setFormId("F03");
		user3.setUserId("U02");
		
		User user4=new User();
		user4.setFormId("F03");
		user4.setUserId("U03");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}

	public List<Form> getAllForms() {
		return forms;
	}

	public Form getFormById(String formId) {
		Form emptyForm=new Form();
		for(Form form:forms){
			if(formId.equalsIgnoreCase(form.getFormId()))
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
		List<Form> updatedforms=new ArrayList<Form>();
		for(Form form:forms){
			if(form.getFormId().equals(formId))
				continue;
			else
				updatedforms.add(form);
			
		}
		forms=updatedforms;
		
	}

	public Form createForm(Form form) {
		
		return form;
	}

	public Integer displayForm(Form form) {
		
		if(form!=null)
			return 1;
		
		return 0;
	}

	

}
