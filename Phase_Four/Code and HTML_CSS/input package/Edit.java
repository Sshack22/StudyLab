package input;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.Member;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {

	private String dburl = "jdbc:mysql://localhost:9999/userdb";
	private String dbUname = "root";
	private String dbPassword = "mysql";
	private String dbDriver = "com.mysql.jdbc.Driver";


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**Calls [titleList] to fill the selection box upon landing on the {Edit} page
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("member");

		try {
			titleList(member, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			request.getRequestDispatcher("Edit.jsp").forward(request, response);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	/**Sends the selected entry to be edited to the {EditSelected} jsp and servlet
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("member");
		HttpSession session = request.getSession();


		String selected = request.getParameter("title");

		String tempSelected = new String(selected);
		session.setAttribute("tempTitle", tempSelected);

		String oldSelected = new String(selected);
		String textBody = MenuMethods.textBody(member, selected);
		request.setAttribute("oldTitle", selected);
		request.setAttribute("tempTitle", selected);
		request.setAttribute("textBody", textBody);

		if(request.getParameter("menu") != null) {
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		}

		if (request.getParameter("select") != null) {			


			request.getRequestDispatcher("EditSelected.jsp").forward(request, response);
			System.out.println(textBody);
			System.out.println(request.getAttribute("tempTitle"));

		}
		if (request.getParameter("save") != null) {

			response.getWriter().print(oldSelected);

		}

	}
	//Database connection
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
	//
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



}
