package model;

public class Student extends Account{

	
	private double gpa = 0.0;
	private String major = null;
	private String minor = null;
	private String advisor = null;
	
	
	public Student(int accountId, String email, String pass, String firstname, String lastname, Double gpa, String major, String minor, String advisor) {
		super(accountId, email, pass, firstname, lastname);
		this.gpa = gpa;
		this.major = major;
		this.minor = minor;
		this.advisor  = advisor;
	}
	
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMinor(String minor) {
		this.minor = minor;
	}
	
	public String getMinor() {
		return minor;
	}
	
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	
	public String getAdvisor() {
		return advisor;
	}
	
	public boolean hasMinor() {
		if(getMinor()==null){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static accountType getType(){
		return accountType.STUDENT;	
	}
}
