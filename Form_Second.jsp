<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="a" class="Demo.democlss"></jsp:useBean>
<jsp:setProperty property="*" name="a"/>
Records: <br>
 UserName:<jsp:getProperty property="username" name="a"/> <br>
Email:<jsp:getProperty property="email" name="a"/><br>
PassWord:<jsp:getProperty property="pwd" name="a"/><br>
<br> <br> <br> 


<jsp:useBean id="u" class="Demo.democlss"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
Records: <br>
 UserName:<jsp:getProperty property="username" name="u"/> <br>
Email:<jsp:getProperty property="email" name="u"/><br>
PassWord:<jsp:getProperty property="pwd" name="u"/><br>
<br> <br> <br>


<jsp:useBean id="x" class="Demo.democlss"></jsp:useBean>  
<%  
String name="Tejas";  
%>  
<jsp:setProperty property="username" name="x" value="<%=name %>"/>  
  
Record:<br>  
<jsp:getProperty property="username" name="x"/><br>
</body>
</html>