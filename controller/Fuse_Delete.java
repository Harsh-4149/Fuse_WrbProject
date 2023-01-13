package com.fuse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fuse.connection.Fuse_DB_Connection;
import com.fuse.dao.Fuse_DAO;


@WebServlet("/Fuse_Delete")
public class Fuse_Delete extends HttpServlet {
	/*
	 * private static final long serialVersionUID = 1L;
	 * 
	 * 
	 * public Fuse_Delete() { super(); // TODO Auto-generated constructor stub }
	 */
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.getWriter().append("Served at: ").append(req.getContextPath());
		String id=req.getParameter("loginId");
		int i=Integer.parseInt(id);
		System.out.println(i);
		try {
			Fuse_DAO fdc=new Fuse_DAO(Fuse_DB_Connection.getConnection());
			boolean f=fdc.delete(i);
			if(f) {
				System.out.println("Fuse Data Delete Succesfully...!!!");
				res.sendRedirect("Fuse_TableFormat.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
