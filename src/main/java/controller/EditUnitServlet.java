package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

/**
 * Servlet implementation class EditUnitServlet
 */
@WebServlet("/editUnitServlet")
public class EditUnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUnitServlet() {
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
		// TODO Auto-generated method stub
		UnitHelper uh = new UnitHelper();
		
		String name = request.getParameter("name");
		String type = request.getParameter("unitClass");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Unit toUpdate = uh.searchForUnitById(tempId);
		toUpdate.setName(name);
		toUpdate.setType(type);
		
		uh.updateUnit(toUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllUnitsServlet").forward(request, response);
	}

}
