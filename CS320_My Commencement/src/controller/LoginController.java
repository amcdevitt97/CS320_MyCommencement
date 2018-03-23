package controller;

import javax.servlet.http.HttpServletRequest;
  
import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Account;
import model.ObjectHandler;

public class LoginController {
	
	private IDatabase database = null;

	public LoginController(){
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();
	}


	//return new login id
	public Boolean loginUser(String email, String password){
		Boolean loginCorrect = this.database.queryForValidLogin(email, password);
		
		return loginCorrect;
	}
	
}

