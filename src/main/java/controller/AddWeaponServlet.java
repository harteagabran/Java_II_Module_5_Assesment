package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Weapon;

/**
 * Servlet implementation class AddWeaponServlet
 */
@WebServlet("/addWeaponServlet")
public class AddWeaponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWeaponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int damage = Integer.parseInt(request.getParameter("damage"));
		
		Weapon a = new Weapon(name, damage);
		WeaponHelper wh = new WeaponHelper();
		wh.insertWeapon(a);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
