package edu.ycp.cs320.amcdevitt.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.amcdevitt.model.Account;
import edu.ycp.cs320.amcdevitt.model.Account.accountType;

public class AccountTest {
	private Account model;
	String email = "email@test.com";
	String pass = "password"; 
	String firstname = "Joseph"; 
	String lastname = "Miller";
	int id = 0;
	
	@Before
	public void setUp() {
		model = new Account(email, pass, firstname, lastname, id);
	}
	
	
	//these two also test "gets" so i won't
	//test for get methods
	@Test
	public void testSetEmail() {
		model.setEmail("my@email.com");
		assertEquals("my@email.com", model.getEmail());
	}
	
	@Test
	public void testSetPassword() {
		model.setPassword("1234");
		assertEquals("1234", model.getPassword());
	}
	
	@Test
	public void testSetFirstname() {
		model.setFirstname("Jane");
		assertEquals("Jane", model.getFirstname());
	}
	
	@Test
	public void testSetLastname() {
		model.setLastname("Doe");
		assertEquals("Doe", model.getLastname());
	}
	
	/*@Test
	public void verifyLoginCorrect(){
		assertTrue(model.verifyLogin(email, pass));
	}
	
	@Test
	public void verifyLoginIncorrect(){
		assertFalse(model.verifyLogin(email, "notCorrect"));
	}*/
	
	@Test
	public void testAccountType(){
		assertEquals(Account.getType(), accountType.INVALID);
	}
}

