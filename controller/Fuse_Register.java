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


@WebServlet("/Fuse_Register")
public class Fuse_Register extends HttpServlet {
	/*
	 * private static final long serialVersionUID = 1L;
	 * 
	 * 
	 * public Fuse_Register() { super(); // TODO Auto-generated constructor stub }
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Fuse_Encapsulation fe=null;
		Fuse_DAO fdc=null;
		boolean f=false;
		
		String n=request.getParameter("name");
		System.out.println(n);
		String c=request.getParameter("country");
		System.out.println(c);
		String b=request.getParameter("birthday");
		System.out.println(b);
		String g=request.getParameter("gender");
		System.out.println(g);
		String em=request.getParameter("emailId");
		System.out.println(em);
		String p=request.getParameter("pwd");
		System.out.println(p);
		String h=request.getParameter("hobbies");
		System.out.println(h);
		
		fe=new Fuse_Encapsulation();
		fe.setName(n);
		fe.setCountry(c);
		fe.setBirthday(b);
		fe.setGender(g);
		fe.setEmailId(em);
		fe.setPwd(p);
		fe.setHobbies(h);
		
		try {
			fdc=new Fuse_DAO(Fuse_DB_Connection.getConnection());
			f=fdc.fuse_insert(fe);
			if(f) {
				System.out.println("Data Inserted...!!!");
				response.sendRedirect("Fuse_TableFormat.jsp");
			}
			
		}
		catch(Exception se) {
			se.printStackTrace();
		}
	}

}
