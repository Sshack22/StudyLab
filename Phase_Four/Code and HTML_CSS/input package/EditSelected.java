package input;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.Member;

/**
 * Servlet implementation class EditSelected
 */
@WebServlet("/EditSelected")
public class EditSelected extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSelected() {
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

	/**Edits the selected title and body from the entry sent from the {Edit} page, sends the new body
	 * and title to the {editBody} method in MenuMethods
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = (Member) request.getSession().getAttribute("member");
		HttpSession session = request.getSession();
		
		String selected = (String) session.getAttribute("tempTitle");
		String newBody = request.getParameter("newbody");
		String newTitle = request.getParameter("newtitle");
		if(request.getParameter("menu") != null) {
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		}
		//String selected = (String) request.getSession().getAttribute("title12");
		MenuMethods.editBody(member, selected, newTitle, newBody);
		request.getRequestDispatcher("Menu.jsp").forward(request, response);
		
		
		//System.out.println(selected);
		//response.getWriter().print(selected);
	}

}
