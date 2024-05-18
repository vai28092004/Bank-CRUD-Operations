package bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.RegisterDao;
import bank.dao.RegisterDaoImpl;
import bank.model.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int regNo=Integer.parseInt(request.getParameter("regNo"));
		String password=request.getParameter("password");
		Login lobj=new Login(regNo, password);
		RegisterDao regdao=new RegisterDaoImpl();
		List<Login> lstlog=new ArrayList<Login>();
		lstlog.add(lobj);
		int i=regdao.LoginRecord(lstlog);
		if(i>0) {
			response.sendRedirect("Home.html");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
