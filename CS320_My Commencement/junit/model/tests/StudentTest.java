package model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Student;
import model.Account.accountType;

public class StudentTest {
	private Student model;
	int accountId = 5;
	String email = "email@test.com";
	String pass = "password"; 
	String firstname = "Joseph"; 
	String lastname = "Miller";
	Double gpa = 2.3;
	String major = "History";
	String minor = "null";
	String advisorEmail = "advisor@ycp.edu";
	
	@Before
	public void setUp() {
		model = new Student(accountId, email, pass, firstname, lastname, gpa, major, minor, advisorEmail);
	}
	
	
	//these two also test "gets" so i won't
	//test for get methods
	@Test
	public void testSetId() {
		model.setAccountId(7);
		assertEquals(7, model.getAccountId());
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
	public void testSetGPA() {
		model.setGPA(3.8);
		assertEquals(3.8, model.getGPA(), 0.001);
	}
	
	@Test
	public void testSetMajor() {
		model.setMajor("Computer Science");
		assertEquals("Computer Science", model.getMajor());
	}
	
	@Test
	public void testSetMinor() {
		model.setMinor("Math");
		assertEquals("Math", model.getMinor());
	}
	
	@Test
	public void testSetAdvisor() {
		model.setAdvisor("djhake2@ycp.edu");
		assertEquals("djhake2@ycp.edu", model.getAdvisor());
	}
	
	@Test
	public void testAccountType(){
		assertEquals(Student.getType(), accountType.STUDENT);
	}
}
