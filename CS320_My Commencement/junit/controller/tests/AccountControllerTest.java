package controller.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.AccountController;
import model.Account;

public class AccountControllerTest {
	private Account model;
	private AccountController controller;
	
	@Before
	public void setUp() {
		model = new Account("Joe@gmail.com", "badPassword", "Joe", "Miller");
		controller = new AccountController();
	}

}
