package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Account;
import model.Student;
import model.Advisor;

public interface IDatabase {
	public boolean createTables();
	public boolean dropTables();
	public Connection connect() throws SQLException;
	public void loadInitialData();
	public Account returnAccountForEmail(String email);
	/*public int queryForLoginIdByEmail(String email);
	public boolean updateAccountByEmail(String email, Account account);
	public String queryForPasswordByEmail(String email);
	public boolean insertNewAccountIntoDatabase(Account newb);
*/
	public String queryForPasswordByEmail(String email);
	
}
