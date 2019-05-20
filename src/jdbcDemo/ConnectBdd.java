package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBdd {

	public Connection myConn = null;
	public Statement myStmt = null;
	public ResultSet myRs = null;
    public String timeZone ="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public void Connect () throws SQLException	{
		
	
		
		try {
			
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loran"+timeZone, "root" , "");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from levels");
			
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("carte") + ", " + myRs.getString("ID"));
			}
		}catch (Exception exc) {
			exc.printStackTrace();
		}finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();

			}
			
			if (myConn != null) {
				myConn.close();

			}
		}
	}
		
		
		
	}

