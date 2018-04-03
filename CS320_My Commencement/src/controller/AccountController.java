package controller;

import database.IDatabase;
import database.DatabaseProvider;
import database.DerbyDatabase;
import model.Account;

/**
 * Controller for the Account Class.
 */

public class AccountController {
	private Account model=null;
	private IDatabase db = null;
	
	public AccountController() {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}
	
	public String getFirstnameForEmail(String email){
		System.out.println(email);
		String firstname = db.getFirstNameForEmail(email);
		return firstname;
	}
	

}
