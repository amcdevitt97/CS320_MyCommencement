package controller.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import controller.StudentController;
import model.Student;

public class StudentControllerTest {
	private Student model;
	private StudentController controller;
	
	@Before
	public void setUp() {
		model = new Student(0, null, null, null, null, 0.0, null, null, null);
		
		model.setEmail("amcdevitt@ycp.edu");
		model.setFirstname("Alyssa");
		model.setLastname("McDevitt");
		model.setGPA(2.0);
		model.setMajor("Computer Science");
		model.setMinor("null");
		model.setAdvisor("djhake2@ycp.edu");
		controller = new StudentController(model);
	}
	
	@Test
	public void testGetGPAForEmail(){
		String email = model.getEmail();
		System.out.println(email);
		Double gpa = controller.getGPAForEmail(email);
		assertEquals(gpa, model.getGPA(), 0.01);
	}
	
	@Test
	public void testGetMajorForEmail(){
		String email = model.getEmail();
		String major = controller.getMajorForEmail(email);
		assertEquals(major, model.getMajor());
	}
	
	@Test
	public void testGetMinorForEmail(){
		String email = model.getEmail();
		String minor = controller.getMinorForEmail(email);
		assertEquals(minor, model.getMinor());
	}
	
	@Test
	public void testGetStudentForEmail(){
		String email = model.getEmail();
		Student student = controller.getStudentForEmail(email);
		assertEquals(student.getFirstname(), model.getFirstname());
		assertEquals(student.getLastname(), model.getLastname());
		assertEquals(student.getMajor(), model.getMajor());
	}
		
		
	
	

}
