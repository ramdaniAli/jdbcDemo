package jdbcDemo;

import java.sql.SQLException;

public class Launcher {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ConnectBdd jdbc = new ConnectBdd()	;
		jdbc.Connect();

	}

}
