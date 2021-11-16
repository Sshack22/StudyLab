package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegister {
	private String dburl = "jdbc:mysql://localhost:9999/userdb";
	private String dbUname = "root";
	private String dbPassword = "mysql";
	private String dbDriver = "com.mysql.jdbc.Driver";

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {

		loadDriver(dbDriver);
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public String insert(Member member) {

		Connection con = getConnection();
		String result = "Data entered succesfully";
		String sql = "insert into userdb.member values(?,?)";
		
		try {
			String uniqueUser = "SELECT * FROM userdb.member WHERE username = ?";			
			
			PreparedStatement ps = con.prepareStatement(uniqueUser);
			ps.setString(1, member.getUserName());
			ResultSet rs = ps.executeQuery(uniqueUser);
			if (rs.absolute(1)) {
				result = "user already exists";
				return result;
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			result = "an error has occured";
			return result;
		}

		try {					
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, member.getUserName());
			ps.setString(2, member.getPassword());
			ps.executeUpdate();
			sql = "CREATE TABLE " + member.getUserName() + " (title VARCHAR(255), body LONGTEXT);";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;

	}

}
