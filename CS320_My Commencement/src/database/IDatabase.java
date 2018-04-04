package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Account;
import model.Student;
import model.Advisor;

public interface IDatabase {
	//	CREATION
	public boolean createTables();
	public boolean dropTables();
	public Connection connect() throws SQLException;
	public void loadInitialData();
	
	// LOGIN
	public Account returnAccountForEmail(String email);
	public Boolean queryForValidLogin(String email, String password);
	public Boolean isStudent (String email);
	
	// UX DATA
	public String getFirstNameForEmail(String email);
	public String getLastNameForEmail(String email);
	
	// SLIDE DATA
	public void addSlide(String slideFN,String slideLN, boolean hasPhoto,boolean hasAudio, boolean hasVideo, String quote, String honors, boolean showGPA, boolean showMajor, boolean slideApproved, String studentEmail);
	
	//TESTING 
	public String showAllAccounts();
	
	/*public int queryForLoginIdByEmail(String email);
	public boolean updateAccountByEmail(String email, Account account);
	public String queryForPasswordByEmail(String email);
	public boolean insertNewAccountIntoDatabase(Account newb);*/
	
}
