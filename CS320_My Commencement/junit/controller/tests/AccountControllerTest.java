package controller.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import controller.AccountController;
import model.Account;

public class AccountControllerTest {
	private Account model;
	private AccountController controller;
	private String email;
	
	@Before
	public void setUp() {
		email="joe@gmail.com";
		model = new Account();
		model.setAccountId(4);
		model.setEmail(email);
		model.setFirstname("Joe");
		model.setLastname("Miller");
		model.setPassword("password");
		controller = new AccountController(model);
	}
	
	@Test
	public void testGetFirstName(String email){
		String fn = controller.getFirstnameForEmail(email);
		assertEquals(fn, "Joe");
	}
		
		
	
	

}
