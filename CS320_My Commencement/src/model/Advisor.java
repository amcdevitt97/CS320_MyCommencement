package model;

public class Advisor extends Account{	
	
	public Advisor(int id, String email, String pass, String firstname, String lastname) {
		super(id, email, pass, firstname, lastname);
	}
	
	public static accountType getType(){
		return accountType.ADVISOR;	
	}
}
