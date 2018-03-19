package model;

public class Advisor extends Account{	
	
	public Advisor(String email, String pass, String firstname, String lastname, int id) {
		super(email, pass, firstname, lastname, id);
	}
	
	public static accountType getType(){
		return accountType.ADVISOR;	
	}
}
