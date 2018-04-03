package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.DBUtil;
import database.DerbyDatabase;
import database.InitialData;
import database.PersistenceException;
import database.DatabaseProvider;
import model.Student;
import model.Account;
import model.Advisor;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	private interface Query<ReturnType>{
		public ReturnType query(Connection conn) throws SQLException;
	}
	/*
	 * TODO:
	 * 		
	 * 		SLIDE RELATED QUERIES:
	 * 		getSlide (select slides where slides.studentEmail=?)
	 * 		getSlideFNforEmail ()
	 * 		getSlideLNforEmail ()
	 * 		getSlideQuoteforEmail()
	 * 		setGpaVisibilityforEmail()
	 * 		setMajorVisibilityforEmail()
	 * 		setAudioVisibilityforEmail()
	 * 		setVideoVisibilityforEmail()
	 * 		setPhotoVisibilityforEmail()
	 * 		getStudentGPA()
	 * 		getStudentMajor()
	 * 		getStudentMinor()
	 * 
	 * 		DEBUGGING ONLY:
	 * 		showAllAccounts(select * from accounts)
	 * 		showAllStudents(select * from students)
	 * 		showAllSlides(select * from slides)
	 * 		showAllPhotos(select * from photos)
	 * 		showAllVideos(select * from videos)
	 * 		showAllAudio(select * from audio)
	 * */
	
	// ACCOUNT RELATED QUERIES
	public Boolean isStudent (String email){
		return executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try {
					stmt = conn.prepareStatement(
							"select students.email" +
							"  from students " +
							" where students.email = ?" 
					);
					stmt.setString(1, email);
					resultSet = stmt.executeQuery();
					if(resultSet.next()){
						System.out.println(email +" is a student");
						return true;
					}
				    else{
				    	System.out.println(email +" is NOT a student");
				    	return false; 
					}
					
				} 
				finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	

	public Boolean queryForValidLogin(String email, String password) {
		return executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				String password = null;
				try {
					stmt = conn.prepareStatement(
							"select accounts.email, accounts.password" +
							"  from accounts " +
							" where accounts.email = ?" +
							" and accounts.password = ?"
					);
					stmt.setString(1, email);
					stmt.setString(2, password);
					
					resultSet = stmt.executeQuery();
					
					
					if(resultSet.next()){
						return true;
					}
				    else{
				    	return false; 
					}
					
				} 
				finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	public String getFirstNameForEmail(String email) {
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				String firstname= null;
				//Account account = new Account();
				try {
					stmt = conn.prepareStatement(
							"select accounts.firstname " +
							"  from accounts " +
							" where accounts.email = ?" 
					);
					stmt.setString(1, email);
					
					resultSet = stmt.executeQuery();
					
					firstname = resultSet.getString(1);
					
					return firstname;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public String getLastNameForEmail(String email) {
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				String lastname= null;
				try {
					stmt = conn.prepareStatement(
							"select accounts.lastname " +
							"  from accounts " +
							" where accounts.email = ?" 
					);
					stmt.setString(1, email);
					
					resultSet = stmt.executeQuery();
					
					lastname = resultSet.getString(1);
					
					return lastname;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	@Override
	public Account returnAccountForEmail(String email) {
		return executeTransaction(new Transaction<Account>() {
			@Override
			public Account execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				Account account = null;
				try {
					stmt = conn.prepareStatement(
							"select * " +
							"  from accounts " +
							" where accounts.email = ?" 
					);
					stmt.setString(1, email);
					
					resultSet = stmt.executeQuery();
					
					
					while (resultSet.next()) {
						
						// create new Author object
						// retrieve attributes from resultSet starting with index 1
						loadAccount(account, resultSet, 1);
					}
					
					return account;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	// SLIDE RELATED QUERIES
	
	
	public void addSlide(String slideFN,String slideLN, boolean hasPhoto,boolean hasAudio, boolean hasVideo, String quote, String honors, boolean showGPA, boolean showMajor, boolean slideApproved, String studentEmail){
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement insertSlide   = null;

				try {

					int photo = hasPhoto? 1 : 0;
					int audio = hasAudio? 1 : 0;
					int video = hasVideo? 1 : 0;
					int gpa = showGPA? 1 : 0;
					int major = showMajor? 1 : 0;
					int approved = slideApproved? 1 : 0;
					
					insertSlide = conn.prepareStatement("insert into slides (slideFN, slideLN, hasPhoto, hasAudio, hasVideo, quote, honors, showGPA, showMajor, slideApproved, studentEmail) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					
					insertSlide.setString(1, slideFN);
					insertSlide.setString(2, slideLN);
					insertSlide.setInt(3, photo);
					insertSlide.setInt(4, audio);
					insertSlide.setInt(5, video);
					insertSlide.setString(6, quote);
					insertSlide.setString(7, honors);
					insertSlide.setInt(8, gpa);
					insertSlide.setInt(9, major);
					insertSlide.setInt(10, approved);
					insertSlide.setString(11, studentEmail);
					
					insertSlide.executeUpdate();
					return true;
				}
				finally{
					DBUtil.closeQuietly(insertSlide);
				}
					
				
			}
			
		});
	}  
	
	public String getSlideFNForEmail(String email) {
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				String firstname= null;
				try {
					stmt = conn.prepareStatement(
							"select slides.slideFN " +
							"  from slides " +
							" where slides.studentEmail = ?" 
					);
					stmt.setString(1, email);
					
					resultSet = stmt.executeQuery();
					
					firstname = resultSet.getString(1);
					
					return firstname;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public String getSlideLNForEmail(String email) {
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				String lastname= null;
				try {
					stmt = conn.prepareStatement(
							"select slides.slideLN " +
							"  from slides " +
							" where slides.studentEmail = ?" 
					);
					stmt.setString(1, email);
					
					resultSet = stmt.executeQuery();
					
					lastname = resultSet.getString(1);
					
					return lastname;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	/* ---------------------------- ------------------------------*/

	private <ReturnType> ReturnType doQueryLoop(Query<ReturnType> query) throws SQLException{
		Connection conn = connect();

		ReturnType ret = null;
		int times = 0;
		boolean done = false;
		try{
			while(!done && times < MAX_ATTEMPTS){
				try{
					ret = query.query(conn);
					conn.commit();
					done = true;
				}catch(SQLException e){
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						times++;
					} else {
						throw e;
					}
				}
			}

			if (!done) {
				throw new SQLException("Query Failed, TIMEOUT. ");
			}
			return ret;
		}finally{
			DBUtil.closeQuietly(conn);
		}
	}

	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}

	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();

		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;

			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}

			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}

			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	public Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");

		// Set autocommit to false to allow execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);

		return conn;
	}

	private void loadStudent(Student student, ResultSet resultSet, int index) throws SQLException {
		student.setEmail(resultSet.getString(index++));
		student.setPassword(resultSet.getString(index++));
		student.setAdvisor(resultSet.getString(index++));
		student.setFirstname(resultSet.getString(index++));
		student.setLastname(resultSet.getString(index++));
		student.setGPA(resultSet.getDouble(index++));
		student.setMajor(resultSet.getString(index++));
		if(student.hasMinor()){
			student.setMinor(resultSet.getString(index++));
		}
	}

	
	private void loadAccount(Account account, ResultSet resultSet, int index) throws SQLException {
		account.setFirstname(resultSet.getString(index++));
		account.setLastname(resultSet.getString(index++));
		account.setEmail(resultSet.getString(index++));
		account.setPassword(resultSet.getString(index++));
	}

	public boolean createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
				PreparedStatement stmt7 = null;
					
				try {
					//CREATING ACCOUNTS
					stmt1 = conn.prepareStatement(
							"create table accounts (" +
									"	account_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +									
									"	firstname varchar(70)," +
									"	lastname varchar(70)," +
									"	email varchar(70)," +
									"	password varchar(70)," +
									")"
							);	

					stmt1.executeUpdate();
					System.out.println("----Successfully Created Accounts Table---- ");
					
					//CREATING STUDENTS
					stmt2 = conn.prepareStatement(
							"create table students (" +
									"	student_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	advisor varchar(70)," +
									"	firstname varchar(70)," +
									"	lastname varchar(70)," +
									"	email varchar(70)," +
									"	password varchar(70)," +
									"	major varchar(70)," +
									"	minor varchar(70)," +
									"   gpa integer, " +
									")"
							);
					stmt2.executeUpdate();
					System.out.println("----Successfully Created Students Table---- ");
					
					//CREATING SLIDES
					stmt3 = conn.prepareStatement(
							"create table slides (" +
									"	slide_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	slideFN varchar(70)," +
									"	slideLN varchar(70)," +
									"	hasPhoto bit," +
									"	hasAudio bit," +
									"	hasVideo bit," +
									"	quote varchar(70)," +
									"	honors varchar(70)," +
									"	showGPA bit," +
									"	showMajor bit," +
									"	slideApproved bit," +
									"	studentEmail varchar(70)," +
									")"
							);
					stmt3.executeUpdate();
					System.out.println("----Successfully Created Slides Table---- ");
					
					//CREATING AUDIO
					stmt4 = conn.prepareStatement(
							"create table audio (" +
									"	audio_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	hours integer," +
									"	mins integer," +
									"	seconds integer," +
									"	file mediumblob," +
									"	studentEmail varchar(70)," +
									")"
							);
					stmt4.executeUpdate();
					System.out.println("----Successfully Created Audio Table---- ");
					
					//CREATING VIDEOS
					stmt5 = conn.prepareStatement(
							"create table videos (" +
									"	video_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	hours integer," +
									"	mins integer," +
									"	seconds integer," +
									"	length integer," +
									"	width integer," +
									"	file mediumblob," +
									"	studentEmail varchar(70)," +
									")"
							);
					stmt5.executeUpdate();
					System.out.println("----Successfully Created Videos Table---- ");
					
					//CREATING PHOTOS
					stmt6 = conn.prepareStatement(
							"create table photos (" +
									"	photo_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	length integer," +
									"	width integer," +
									"	file mediumblob," +
									"	studentEmail varchar(70)," +
									")"
							);
					stmt6.executeUpdate();
					System.out.println("----Successfully Created Photos Table---- ");
					
					// TODO: REVIEW TABLE CREATION
					

					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(stmt5);
					DBUtil.closeQuietly(stmt6);
					DBUtil.closeQuietly(stmt7);
				}
			}
		});
		return true;
	}

	public boolean dropTables(){
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;


				try{
					stmt1 = conn.prepareStatement("DROP TABLE accounts");
					stmt2 = conn.prepareStatement("DROP TABLE students");



					stmt1.executeUpdate();
					stmt2.executeUpdate();

					conn.commit();
				}catch(SQLException e){
					System.out.println(e.getMessage());
					return false;
				}finally{
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
				return true;
			}
		});
		return true;
	}


	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				
				List<Student> studentList;
				List<Account> accountList;

			    try {
					studentList = InitialData.getStudents();
					accountList = InitialData.getAccounts();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertStudent = null;
				PreparedStatement insertAccount   = null;

				try {

					// ADDS ALL STUDENTS
					
					insertStudent = conn.prepareStatement("insert into students (advisor, firstname, lastname, email, password, major, minor, gpa) values (?, ?, ?, ?, ?, ?, ?, ?)");
					for (Student student : studentList) {
						insertStudent.setString(1, student.getAdvisor());
						insertStudent.setString(2, student.getFirstname());
						insertStudent.setString(3, student.getLastname());
						insertStudent.setString(4, student.getEmail());
						insertStudent.setString(5, student.getPassword());
						insertStudent.setString(6, student.getMajor());
						insertStudent.setString(7, student.getMinor());
						insertStudent.setDouble(8, student.getGPA());
						insertStudent.addBatch();
					}
					insertStudent.executeBatch();

					// ADDS ALL ACCOUNTS
					insertAccount = conn.prepareStatement("insert into accounts (firstname, lastname, email, password, id) values (?, ?, ?, ?)");
					for (Account account : accountList) {
												
						insertAccount.setString(1, account.getFirstname());
						insertAccount.setString(2, account.getLastname());
						insertAccount.setString(3, account.getEmail());
						insertAccount.setString(4, account.getPassword());
						insertAccount.addBatch();
					}
					insertAccount.executeBatch();

					return true;
				} finally {
					DBUtil.closeQuietly(insertAccount);
					DBUtil.closeQuietly(insertStudent);
				}
			}
		});
	}

	


	public static void main(String[] args) throws SQLException {
		System.out.println("----Loading Database Driver---- ");
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();

		System.out.println("----Connecting to Database---- ");
		Connection conn = db.connect();

		System.out.println("(C)reate table or (D)rop tables: ");
		Scanner in = new Scanner(System.in);

		if(in.nextLine().toUpperCase().equals("C")){
			System.out.println("----Creating Tables---- ");
			if(db.createTables()){
				System.out.println("Loading initial data...");
				db.loadInitialData();
				System.out.println("----Successfully Created Tables---- ");
			}

			else{
				System.out.println("----Failed to Create Tables---- ");
			}
		}
		else{
			System.out.println("----Preparing to Drop Tables---- ");
			if(db.dropTables()){
				System.out.println("----Successfully Dropped Tables---- ");
			}
			else{
				System.out.println("----Failed To Drop Table---- ");
			}
		}
		in.close();
		DBUtil.closeQuietly(conn);
	}

	

	
}
