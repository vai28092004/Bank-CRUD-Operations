package bank.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.dao.RegisterDao;
import bank.dao.RegisterDaoImpl;
import bank.model.Register;

@WebServlet("/RetriveController")
public class RetriveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RetriveController() {
        super();
      
    }

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regNo=Integer.parseInt(request.getParameter("regno"));
		RegisterDao regdao=new RegisterDaoImpl();
		List<Register> lstreg=regdao.RetriveRecord(regNo);
		//new session is created
		HttpSession session=request.getSession();
		
		if(lstreg!=null)
		{
			session.setAttribute("data",lstreg);
			response.sendRedirect("RetriveView.jsp");
			Register reg=lstreg.get(0);
			System.out.println(reg.getRegNo()+"\t"+reg.getCustName());
		}


	}*/
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int regNo = Integer.parseInt(request.getParameter("regno"));
		    
		    // Create an instance of your DAO implementation
		    RegisterDao regdao = new RegisterDaoImpl();
		    
		    // Attempt to delete the record by registration number
		    int success = regdao.RetriveRecord(regNo);
		    
		    // Check if the record was successfully deleted
		    if (success==regNo) {
		        // Record found successfully, you can set a success message if needed
		        HttpSession session = request.getSession();
		        session.setAttribute("message", "Record with Registration Number " + regNo + " retrived successfully.");
		        response.sendRedirect("RetriveView.jsp"); // Redirect to a success page
		    } else {
		        // Record not found or deletion failed, you can set an error message if needed
		        HttpSession session = request.getSession();
		        session.setAttribute("error", "Record with Registration Number " + regNo + " not found.");
		        response.sendRedirect("RetriveView.jsp"); // Redirect to an error page
		    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
