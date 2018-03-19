package edu.ycp.cs320.amcdevitt.controller;



import javax.servlet.http.HttpServletRequest;
  
import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import edu.ycp.cs320.amcdevitt.model.Account;
import edu.ycp.cs320.amcdevitt.model.ObjectHandler;

public class LoginController {
	
	private Idatabase database;

	public LoginController(){
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();
	}
	
	public boolean handleLoginCheck(HttpServletRequest req){
		String email = ObjectHandler.castObject(req.getSession().getAttribute("email"));
		if(email != null){
			Integer loginId = ObjectHandler.castObject(req.getSession().getAttribute("login_id"));
			//loginId = this.validateLogin(email, loginId);
			if(loginId >= 0){
				req.getSession().setAttribute("login_id", loginId);
				req.setAttribute("account", database.returnAccountForEmail(email));
				req.setAttribute("loggedin", true);
				return true;
			}
		}
		req.setAttribute("loggedin", false);
		return false;
	}


	//return new login id
	public int loginUser(String email, String password){
		int loginId = -1;
		String pass = this.database.queryForPasswordByEmail(email);
		System.out.println(pass);
		if(pass!= null && password!=null){
			if(pass.equals(password)){
				//Account account = this.database.queryForUserAccountByEmail(email);
				//System.out.println(account.getEmail() + account.getPassword());
				//loginId = account.createLoginId();
				//this.database.updateAccountByEmail(email, account);
			}
		}
		return loginId;
	}
	
	/*public Account returnAccountForUsername(String email){
		return this.database.queryForUserAccountByEmail(email);
	}*/
}
