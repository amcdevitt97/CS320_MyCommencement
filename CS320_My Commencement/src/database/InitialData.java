package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Student;
import model.Account;

public class InitialData {
	public static List<Student> getStudents() throws IOException {
		List<Student> studentList = new ArrayList<Student>();
		ReadCSV readStudents = new ReadCSV("students.csv");
		try {
			while (true) {
				List<String> tuple = readStudents.next();
				if (tuple == null) {

					break;
				}
				Iterator<String> i = tuple.iterator();

				Student student = new Student(null, null, null, null, 4.0, null, null, null, 0);	
				student.setAdvisor(i.next());
				student.setFirstname(i.next());
				student.setLastname(i.next());
				student.setEmail(i.next());
				student.setPassword(i.next());
				student.setMajor(i.next());
				student.setMinor(i.next());
				student.setGPA(Double.parseDouble(i.next()));
				student.setLoginId(-1);
				System.out.println(student.getFirstname()+" "+student.getLastname()+" "+ student.getGPA());
				studentList.add(student);
			}
			return studentList;
		} finally {
			readStudents.close();
		}
	}
	public static List<Account> getAccounts() throws IOException {
		List<Account> accountList = new ArrayList<Account>();
		ReadCSV readAdvisor = new ReadCSV("advisors.csv");
		ReadCSV readStudent = new ReadCSV("students.csv");
		try {
			while (true) {
				List<String> tuple = readAdvisor.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Account account = new Account(null, null, null, null, 0);
				account.setFirstname(i.next());
				account.setLastname(i.next());
				account.setEmail(i.next());
				account.setPassword(i.next());
				account.setLoginId(-1);
				System.out.println(account.getFirstname()+" "+account.getLastname()+" "+account.getEmail()+" "+account.getPassword());
				accountList.add(account);
			}
			while (true) {
				List<String> tuple = readStudent.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Account account = new Account(null, null, null, null, 0);
				i.next();
				account.setFirstname(i.next());
				account.setLastname(i.next());
				account.setEmail(i.next());
				account.setPassword(i.next());
				account.setLoginId(-1);
				System.out.println(account.getFirstname()+" "+account.getLastname()+" "+account.getEmail()+" "+account.getPassword());
				accountList.add(account);
			}
			return accountList;
		} finally {
			readAdvisor.close();
		}
	}
}
