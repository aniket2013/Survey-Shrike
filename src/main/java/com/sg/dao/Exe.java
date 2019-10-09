package com.sg.dao;

public class Exe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SurveyShrikeDao dao=new SurveyShrikeDaoImpl();
		System.out.println(dao.getAllForms().size());

	}

}
