package controller;

import database.IDatabase;

import java.util.ArrayList;
import java.util.List;

import database.DatabaseProvider;
import database.DerbyDatabase;
import model.Account;
import model.Student;

/**
 * Controller for the Account Class.
 */

public class AccountController {
	private Account model = null;
	private IDatabase database = null;
	
	public AccountController(Account model) {
		// creating DB instance here
		this.model = model;
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();		
	}
	
	public String getFirstnameForEmail(String email){
		String firstname = database.getFirstNameForEmail(email);
		return firstname;
	}
	
	public List<Student> getStudentsForAdvisor(String email){
		List<Student> students = database.getStudentsForAdvisorEmail(email);
		return students;
	}
}
