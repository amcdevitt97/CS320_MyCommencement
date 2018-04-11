package controller;

import database.IDatabase;
import database.DatabaseProvider;
import database.DerbyDatabase;
import model.Student;

/**
 * Controller for the Account Class.
 */

public class StudentController {
	private Student model = null;
	private IDatabase database = null;
	
	public StudentController(Student model) {
		// creating DB instance here
		this.model = model;
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();		
	}
	
	public Double getGPAForEmail(String email){
		Double GPA = database.getGPAForEmail(email);
		return GPA;
	}
	
	public String getMajorForEmail(String email){
		String students = database.getMajorForEmail(email);
		return students;
	}
	
	public String getMinorForEmail(String email){
		String students = database.getMinorForEmail(email);
		return students;
	}

}
