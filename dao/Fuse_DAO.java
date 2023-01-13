package com.fuse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fuse.bo.Fuse_Encapsulation;

public class Fuse_DAO {
	public static Connection com;
	
	//constructor
	public Fuse_DAO(Connection com) {
		//super();
		this.com=com;
	}
	
	public boolean fuse_insert(Fuse_Encapsulation e)throws SQLException {
		//query
		final String INSERT_QUERY="INSERT INTO FUSE_LOGINDATA(NAME,COUNTRY,BIRTHDAY,GENDER,EMAILID,PWD,HOBBIES) VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement ps=null;
		boolean fdc=false;
		
		
		ps=com.prepareStatement(INSERT_QUERY);
		
		ps.setString(1, e.getName());
		ps.setString(2, e.getCountry());
		ps.setString(3, e.getBirthday());
		ps.setString(4, e.getGender());
		ps.setString(5, e.getEmailId());
		ps.setString(6, e.getPwd());
		ps.setString(7, e.getHobbies());
		

		
		int i=ps.executeUpdate();
		System.out.println(i);
		if(i==1) {
			System.out.println("Registration Succesfully Completed...!!!");
			fdc=true;
		}
		return fdc;
	}//insert method
	
	
	public List<Fuse_Encapsulation> showAllRecord() throws SQLException{
		//query
		final String SHOW_ALLRECORD="SELECT * FROM FUSE_LOGINDATA";
		
		List<Fuse_Encapsulation> l=new ArrayList<Fuse_Encapsulation>();
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		Fuse_Encapsulation fe=null;
		
		ps=com.prepareStatement(SHOW_ALLRECORD);
		rs=ps.executeQuery();
		while(rs.next()) {
		fe=new Fuse_Encapsulation();
		fe.setLoginId(rs.getInt(1));
		fe.setName(rs.getString(2));
		fe.setCountry(rs.getString(3));
		fe.setBirthday(rs.getString(4));
		fe.setGender(rs.getString(5));
		fe.setEmailId(rs.getString(6));
		fe.setPwd(rs.getString(7));
		fe.setHobbies(rs.getString(8));
	
		l.add(fe);
		}
		return l;
	}//showAllRecord method
	
	
	public Fuse_Encapsulation search(int i) throws SQLException{
		//query
		final String SEARCH="SELECT * FROM FUSE_LOGINDATA WHERE LOGINID=?";
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		Fuse_Encapsulation fe=null;
		
		ps=com.prepareStatement(SEARCH);
		ps.setInt(1, i);
		rs=ps.executeQuery();
		while(rs.next()) {
			fe=new Fuse_Encapsulation();
			fe.setLoginId(rs.getInt(1));
			fe.setName(rs.getString(2));
			fe.setCountry(rs.getString(3));
			fe.setBirthday(rs.getString(4));
			fe.setGender(rs.getString(5));
			fe.setEmailId(rs.getString(6));
			fe.setPwd(rs.getString(7));
			fe.setHobbies(rs.getString(8));
			
		}
		return fe;
	}//search method
	
	
	public boolean update(Fuse_Encapsulation fe) throws SQLException {
		//query
		final String UPDATE="UPDATE FUSE_LOGINDATA SET NAME=?,COUNTRY=?,BIRTHDAY=?,GENDER=?,EMAILID=?,PWD=?,HOBBIES=? WHERE LOGINID=?";
		
		PreparedStatement ps=null;
		boolean f=false;
		
		ps=com.prepareStatement(UPDATE);
		ps.setString(1, fe.getName());
		ps.setString(2, fe.getCountry());
	    ps.setString(3, fe.getBirthday()); 
		ps.setString(4, fe.getGender());
		ps.setString(5, fe.getEmailId());
		ps.setString(6, fe.getPwd());
		ps.setString(7, fe.getHobbies());
		ps.setInt(8, fe.getLoginId());
		
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("sjasasaiias");
			f=true;
		}
		return f;
	}//update method
	
	
	public boolean delete(int i) throws SQLException{
		//query
		final String DELETE="DELETE FROM FUSE_LOGINDATA WHERE LOGINID=?";
		
		PreparedStatement ps=null;
		boolean f=false;
		
		ps=com.prepareStatement(DELETE);
		ps.setInt(1, i);
		int iii=ps.executeUpdate();
		if(iii==1) {
			System.out.println("Delete Data Done");
			f=true;
		}
		return f;
	}//delete method
	
	
	public String Fuse_validate(String ei, String pass) throws SQLException {
		//query
		final String CHECH_VALIDATE="SELECT * FROM FUSE_LOGINDATA WHERE EMAILID=? AND PWD=?";
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		Fuse_Encapsulation fen=null;
		String login=null;
		
		ps=com.prepareStatement(CHECH_VALIDATE);
		ps.setString(1, ei);
		ps.setString(2, pass);
		
		rs=ps.executeQuery();
		while(rs.next()) {
			fen=new Fuse_Encapsulation();
			fen.setLoginId(rs.getInt(1));
			fen.setName(rs.getString(2));
			/*
			 * fen.setCountry(rs.getString(3)); fen.setBirthday(rs.getString(4));
			 * fen.setGender(rs.getString(5)); */
			 fen.setEmailId(rs.getString(6));
			fen.setPwd(rs.getString(7));
			/* fen.setHobbies(rs.getString(8)); */
			if(ei.equals(fen.getEmailId()) && (pass.equals(fen.getPwd()))) {
				login=fen.getName();
				break;
			}
		}
		return login;
	}//validate method
	
}//class
