package edu.ycp.cs320.amcdevitt.model;

//DO NOT EDIT

import java.util.Random;

//model class for GuessingGame
//only the controller should be allowed to call the set methods
//the JSP will call the "get" and "is" methods implicitly
//when the JSP specifies game.min, that gets converted to
//  a call to model.getMin()
//when the JSP specifies if(game.done), that gets converted to
//  a call to model.isDone()
public class Account {
	private String email = null;
	private String pass = null;
	private String firstname = null; 
	private String lastname = null;
	private int loginId = -1;
	
	public enum accountType {
		INVALID, STUDENT, ADVISOR
	}
	
	
	public Account(String email, String pass, String firstname, String lastname, int id) {
		this.email = email;
		this.pass = pass;
		this.firstname = firstname;
		this.lastname = lastname;
		this.loginId = id;
	}
	
	public Account() {
		this.email = "";
		this.pass = "";
		this.firstname = "";
		this.lastname = "";
		this.loginId = 0;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String pass) {
		this.pass = pass;
	}
	
	public String getPassword() {
		return pass;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public int getLoginId(){
		return this.loginId;
	}
	
	public void setLoginId(int id){
		this.loginId = id;
	}
	
	public static accountType getType(){
		return accountType.INVALID;	
	}
	
	/*
	 * -------------------------HELPER METHODS----------------------------
	 */
		
	public int createLoginId() {
		Random r = new Random();
		this.loginId = r.nextInt(99999999);
		return this.loginId;
	}
	
	public int resetLoginId(){
		this.loginId = -1;
		return this.loginId;
	}
	
	
}

