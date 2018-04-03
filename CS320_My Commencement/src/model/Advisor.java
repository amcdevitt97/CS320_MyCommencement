package model;

public class Advisor extends Account{	
	
	public Advisor(String email, String pass, String firstname, String lastname) {
		super(email, pass, firstname, lastname);
	}
	
	public static accountType getType(){
		return accountType.ADVISOR;	
	}
}
