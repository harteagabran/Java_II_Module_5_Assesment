package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToUnit");
		UnitHelper uh = new UnitHelper();
		WeaponHelper wh = new WeaponHelper();
		String path = "/viewAllUnitsServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Unit toDelete = uh.searchForUnitById(tempId);
				uh.deleteUnit(toDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a unit");
			}
		} else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Unit toEdit = uh.searchForUnitById(tempId);
				
				request.setAttribute("toEdit", toEdit);
				request.setAttribute("allWeapons", wh.showAllWeapons());
				
				if(wh.showAllWeapons().isEmpty()) {
					request.setAttribute("allWeapons", " ");
				}
				
				path = "/edit.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a unit");
			}
		} else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
