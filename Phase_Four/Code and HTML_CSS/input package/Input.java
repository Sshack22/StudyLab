package input;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.Member;

/**
 * Servlet implementation class Input
 */
@WebServlet("/Input")
public class Input extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Input() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**Creates a new entry by passing the user entered title and body into the {userInput} method
	 * inside MenuMethods
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("member");
		if(request.getParameter("menu") != null) {
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		}
		if (request.getParameter("print") != null) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			String result = MenuMethods.userInput(member, title, body);
			if (result.equals("1")) {
				request.getRequestDispatcher("/Menu.jsp").forward(request, response);
			} else { response.getWriter().append("Served at: ").append(request.getContextPath()); }
			
		}
	}

}
