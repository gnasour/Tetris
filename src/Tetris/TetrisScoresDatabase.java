import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.util.Properties;

public class TetrisScoresDatabase{
	
	private static Connection connect;
	private static Properties connectionProperties;
	private static Statement stmt;
	private static ResultSet rs;
	private static ResultSetMetaData rsmd;
	private static String userName;
	private static String password;
	private static String dbms;
	private static String serverName;
	private static String portNo;
	private static String sqlStmt;
	//Constructor to create a new database connection
	public TetrisScoresDatabase(String database){
		try {
		}catch(Exception e) {
			
		}
		if(database.toLowerCase().equals("mysql")) {
			dbms = "mysql://";
			serverName = "localhost:";
			portNo = "3306/";
		}else {
			//Enter info on connecting to other databases here
		}
		try {
			connect = DriverManager.getConnection("jdbc:" + this.dbms + this.serverName + this.portNo, "root", "root");
			stmt = connect.createStatement();
			sqlStmt = "SELECT * FROM school.classroom";
			rs = stmt.executeQuery(sqlStmt);
			rsmd = rs.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println(rsmd.getColumnName(i));
			}
		}catch(SQLException iSQL) {
			System.out.println(iSQL);
		}
		
		
		
		
	}
	
	public TetrisScoresDatabase(Connection connect, Properties connectionProperties) {
		this.connect = connect;
		this.connectionProperties = connectionProperties;
	}

}