<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="Dashboard_Sidebar.jsp" %>
<!DOCTYPE html>

<%
 String s=(String)session.getAttribute("login");

out.print("<h3 > Welcome Dear </h3>" + s);
%>

</body>
</html>