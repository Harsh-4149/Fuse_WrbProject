package com.fuse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fuse.connection.Fuse_DB_Connection;
import com.fuse.dao.Fuse_DAO;


@WebServlet("/Fuse_Login")
public class Fuse_Login extends HttpServlet {
	/*
	 * private static final long serialVersionUID = 1L;
	 * 
	 * 
	 * public Fuse_Login() { super(); // TODO Auto-generated constructor stub }
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		Fuse_DAO fdc=null;
		String login=null;
		
		String ei=request.getParameter("emailId");
		String pass=request.getParameter("pwd");
		
		try {
			fdc=new Fuse_DAO(Fuse_DB_Connection.getConnection());
			
			login=fdc.Fuse_validate(ei,pass);
			HttpSession se=request.getSession();
			if(login!=null) {
				se.setAttribute("login", login);
				response.sendRedirect("Fuse_WelcomePage.jsp");
			}
			else{
				System.out.println("EmailId And PassWord Is Incorrect...!!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
