package controller;

import javax.servlet.http.HttpServletRequest;
  
import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Account;

public class LoginController {
	private Account model = null;
	private IDatabase database = null;
	
	public LoginController(Account model) {
		this.model = model;
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();
	}

	public Boolean loginUser(String email, String password){
		Boolean loginCorrect = this.database.queryForValidLogin(email, password);
		return loginCorrect;
	}
	
	public Boolean isStudent(String email){
		Boolean isStudentValue = this.database.isStudent(email);
		return isStudentValue;
	}
	
}

