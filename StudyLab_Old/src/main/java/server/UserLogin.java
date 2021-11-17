package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {
	private String dburl = "jdbc:mysql://localhost:9999/userdb";
	private String dbUname = "root";
	private String dbPassword = "mysql";
	private String dbDriver = "com.mysql.jdbc.Driver";
	
	
	public Connection getConnection() {

		loadDriver(dbDriver);
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbUname, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public String userLogin(Member member) {
		
		Connection con = getConnection();
		String status = "";
		String sql = "select * from userdb.member where username = '" + member.getUserName() + "' and password = '" + member.getPassword() + "'";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			if (rs.next()) {
				status = "true";
				return status;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			status = "false";
		}
		
		
		return status;
	}
	
	
	
	
	

}
