package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

/**
 * Servlet implementation class AddUnitServlet
 */
@WebServlet("/addUnitServlet")
public class AddUnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUnitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String title = request.getParameter("unitClass");
		
		Unit u = new Unit(name, title);
		UnitHelper uh = new UnitHelper();
		uh.insertUnit(u);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
