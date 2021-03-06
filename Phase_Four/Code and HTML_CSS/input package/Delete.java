package input;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.Member;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {

	private String dburl = "jdbc:mysql://localhost:9999/userdb";
	private String dbUname = "root";
	private String dbPassword = "mysql";
	private String dbDriver = "com.mysql.jdbc.Driver";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** Calls [titleList] to fill titles when landing on {Delete} page
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member) request.getSession().getAttribute("member");

		try {
			titleList(member, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**Selects the title and body from {Delete.jsp} and drops them from the user table
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member) request.getSession().getAttribute("member");


		String selected = request.getParameter("title");
		String textBody = MenuMethods.textBody(member, selected);


		if (request.getParameter("select") != null) {		
			try (Connection con = getConnection()) {
				String sql = "DELETE FROM " + member.getUserName() + " WHERE title ='" + selected + "' AND body ='" + textBody + "'";
				PreparedStatement ps = con.prepareStatement(sql);
				//ps.setString(1, member.getUserName());
				ps.executeUpdate();


				request.getRequestDispatcher("Menu.jsp").forward(request, response);


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
		if(request.getParameter("menu") != null) {
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		}


	}

	/**creates an array of titles from the user table to be passed into {Delete.jsp} to fill the selection box
	 * @param x: member object being passed into the method
	 */
	private void titleList(Member x, HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		List<String> titles = new ArrayList<>();
		Member member = x;


		try (Connection con = getConnection()) {
			String sql = "SELECT * FROM " + member.getUserName();
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1, member.getUserName());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				titles.add(rs.getString(1));

			}
			request.setAttribute("titleList", titles);
			request.getRequestDispatcher("Delete.jsp").forward(request, response);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//connection to database
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
	//database driver
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



}
