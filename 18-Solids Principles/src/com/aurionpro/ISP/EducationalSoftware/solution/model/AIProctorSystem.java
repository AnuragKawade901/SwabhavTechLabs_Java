package com.aurionpro.ISP.EducationalSoftware.solution.model;

public class AIProctorSystem implements IStudentExamService, IAIGradingService{

	@Override
	public void gradeExam() {
		// TODO Auto-generated method stub
		System.out.println("AI system has launched exam environment.");
	}

	@Override
	public void startExam() {
		// TODO Auto-generated method stub
        System.out.println("AI system has graded the exam automatically.");

	}

}
