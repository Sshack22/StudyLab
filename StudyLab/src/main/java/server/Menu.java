package server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Member member = (Member) request.getSession().getAttribute("member");
		if (member.getUserName().equals(null)) {
			response.sendRedirect("InvalidUser.jsp");
		}
		if (request.getParameter("button1") != null) {
			response.getWriter().print(member.getUserName());
		}
		if (request.getParameter("button2") != null) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("memberRegister.jsp");
		}
		if (request.getParameter("button3") != null) {
			
			
			
		}
		
	}

}
