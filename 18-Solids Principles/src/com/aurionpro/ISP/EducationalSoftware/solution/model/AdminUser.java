package com.aurionpro.ISP.EducationalSoftware.solution.model;

public class AdminUser implements IAdminService{

	@Override
	public void createQuestionBank() {
		// TODO Auto-generated method stub
		 System.out.println("Admin created a new question bank.");
	}

	@Override
	public void assignTeacher() {
		// TODO Auto-generated method stub
		 System.out.println("Admin assigned teacher to exam.");
	}

}
