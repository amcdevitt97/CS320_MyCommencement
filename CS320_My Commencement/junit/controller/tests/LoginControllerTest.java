package controller.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import controller.LoginController;
import model.Account;

public class LoginControllerTest {
	private Account model;
	private LoginController controller;
	
	@Before
	public void setUp() {
		model = new Account();
		model.setAccountId(1);
		model.setEmail("djhake2@ycp.edu");
		model.setFirstname("Donald");
		model.setLastname("Hake");
		model.setPassword("Password");
		controller = new LoginController(model);
	}
	
	@Test
	public void testLoginUser(){
		String email = model.getEmail();
		String password = model.getPassword();
		Boolean correct = controller.loginUser(email,password);
		assertEquals(correct, true);
	}
	
	@Test
	public void testIsStudent(){
		String email = model.getEmail();
		boolean isStudent = controller.isStudent(email);
		assertEquals(isStudent, false);
	}
		
		
	
	

}
