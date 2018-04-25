package controller.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import java.util.List;
import org.junit.Test;
import controller.AccountController;
import model.Account;
import model.Student;

public class AccountControllerTest {
	private Account model;
	private AccountController controller;
	
	@Before
	public void setUp() {
		model = new Account();
		model.setAccountId(1);
		model.setEmail("djhake2@ycp.edu");
		model.setFirstname("Donald");
		model.setLastname("Hake");
		model.setPassword("Password");
		controller = new AccountController(model);
	}
	
	@Test
	public void testGetFirstName(){
		String email = model.getEmail();
		String fn = controller.getFirstnameForEmail(email);
		assertEquals(fn, model.getFirstname());
	}
	
	@Test
	public void testGetStudentsForAdvisor(){
		String email = model.getEmail();
		List<Student> students= controller.getStudentsForAdvisor(email);
		assertEquals(students.get(0).getFirstname(), "Alyssa");
		assertEquals(students.get(0).getLastname(), "McDevitt");
		assertEquals(students.get(0).getEmail(), "amcdevitt@ycp.edu");
	}
		
		
	
	

}
