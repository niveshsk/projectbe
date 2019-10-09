

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String o=request.getParameter("obj");
		if(o.equals("admin")){
			RequestDispatcher rd=request.getRequestDispatcher("/admin.html");
			rd.forward(request, response);
		}
		else if(o.equals("user")){
			RequestDispatcher rd1=request.getRequestDispatcher("/user.html");
			rd1.forward(request, response);
		}
	}

}
