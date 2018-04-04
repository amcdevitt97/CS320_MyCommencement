package model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Account;
import model.Account.accountType;

public class AccountTest {
	private Account model;
	int accountId = 4;
	String email = "email@test.com";
	String pass = "password"; 
	String firstname = "Joseph"; 
	String lastname = "Miller";
	
	@Before
	public void setUp() {
		model = new Account(accountId ,email, pass, firstname, lastname);
	}
	
	
	//these two also test "gets" so i won't
	//test for get methods
	@Test
	public void testSetIdl() {
		model.setAccountId(6);
		assertEquals(6, model.getAccountId());
	}
	
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
	
	@Test
	public void testAccountType(){
		assertEquals(Account.getType(), accountType.INVALID);
	}
}
