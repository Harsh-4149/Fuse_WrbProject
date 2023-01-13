<%@page import="com.fuse.bo.Fuse_Encapsulation"%>
<%@page import="com.fuse.connection.Fuse_DB_Connection"%>
<%@page import="com.fuse.dao.Fuse_DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="Dashboard_Sidebar.jsp" %>
<!DOCTYPE html>
<%
String id=request.getParameter("loginId");
 int i=Integer.parseInt(id);
 System.out.println(i);
 
 Fuse_DAO fdc=new Fuse_DAO(Fuse_DB_Connection.getConnection());
 Fuse_Encapsulation fe=fdc.search(i);
%>

<form action="Fuse_Edit" method="post">
  EDIT Name : <input type="text" name="name" value="<%=fe.getName() %>"> <br>
  EDIT Country :<input type="text" name="country" value="<%=fe.getCountry() %>"> <br>
  EDIT Birthday :<input type="text" name="birthday" value="<%=fe.getBirthday() %>"> <br>
  
  EDIT Gender :<input type="text" name="gender" value="<%=fe.getGender() %>"> <br>
  EDIT EmailId :<input type="text" name="emailId" value="<%=fe.getEmailId() %>"><br>
  EDIT PassWord :<input type="text" name="pwd" value="<%=fe.getPwd() %>"><br>
  EDIT Hobbies :<input type="text" name="hobbies" value="<%=fe.getHobbies() %>"><br>
    <input type="Submit" value="Update" style="background-color: blue;">
   
  
</form>
</body>
</html>