package com.cutm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response); 
		Profile pr=new Profile();
		pr.setUserid(request.getParameter("userid"));
		pr.setName(request.getParameter("name"));
		pr.setEmail(request.getParameter("email"));
		pr.setMobile(Long.parseLong(request.getParameter("mobile")));
		
		//database
		int res= new ProfileDao().save(pr);
		request.setAttribute("RES", res);
		request.getRequestDispatcher("/ViewServlet").forward(request, response);
		
		
	}
	

}
