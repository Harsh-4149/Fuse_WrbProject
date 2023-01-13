package com.fuse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fuse.bo.Fuse_Encapsulation;
import com.fuse.connection.Fuse_DB_Connection;
import com.fuse.dao.Fuse_DAO;


@WebServlet("/Fuse_Edit")
public class Fuse_Edit extends HttpServlet {
	/*
	 * private static final long serialVersionUID = 1L;
	 * 
	 * 
	 * public Fuse_Edit() { super(); // TODO Auto-generated constructor stub }
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Fuse_Encapsulation fe=null;
		
		String s=request.getParameter("loginId");
		int i=Integer.parseInt(s);
		
		String x=request.getParameter("name");
		String y=request.getParameter("country");
		String z=request.getParameter("birthday");
		String xx=request.getParameter("gender");
		String yy=request.getParameter("emailId");
		String zz=request.getParameter("pwd");
		String xxx=request.getParameter("hobbies");
		
		
		fe=new Fuse_Encapsulation();
		fe.setName(x);
		fe.setCountry(y);
		fe.setBirthday(z);
		fe.setGender(xx);
		fe.setEmailId(yy);
		fe.setPwd(zz);
		fe.setHobbies(xxx);
		fe.setLoginId(i);
		try {
			Fuse_DAO fdc= new Fuse_DAO(Fuse_DB_Connection.getConnection());
			boolean f=fdc.update(fe);
			if(f==true) {
				System.out.println("Fuse Data Edit succesfully...!!! ");
				response.sendRedirect("Fuse_TableFormat.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
