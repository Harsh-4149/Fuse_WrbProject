
<!DOCTYPE html>

<%@page import="com.fuse.bo.Fuse_Encapsulation"%>
<%@page import="com.fuse.connection.Fuse_DB_Connection"%>
<%@page import="com.fuse.dao.Fuse_DAO"%>
<%@page import="java.util.List"%>
<%@include file="Dashboard_Sidebar.jsp" %>

<div class="container" style="background-color: white;">
  <h2>Fuse Personal Details </h2>
  <p>Table Format:</p>            
  <table class="table table-bordered" >
    <thead >
      <tr >
        <th style="border-color: blue" >Name</th>
        <th style="border-color: blue">Country</th>
        <th style="border-color: blue">Date Of Birth</th>
        <th style="border-color: blue">Gender</th>
        <th style="border-color: blue">Email</th>
        <th style="border-color: blue">PassWord</th>
        <th style="border-color: blue">Hobbies</th>
        <th style="border-color: blue">EDIT</th>
        <th style="border-color: blue">DELETE</th>
      </tr>
    </thead>
    <%
    Fuse_DAO fdc=new Fuse_DAO(Fuse_DB_Connection.getConnection());
                    List<Fuse_Encapsulation> l=fdc.showAllRecord();
                    int i=0;
                    for(Fuse_Encapsulation fs:l){
                    	i++;
    %>
   
    <tbody>
      <tr>
      <td style="border-color: red;" ><%=fs.getName() %></td>
      <td style="border-color: red"><%=fs.getCountry() %></td>
      <td style="border-color: red"><%=fs.getBirthday() %></td>
      <td style="border-color: red"><%=fs.getGender() %></td>
      <td style="border-color: red"><%=fs.getEmailId() %></td>
      <td style="border-color: red"><%=fs.getPwd() %></td>
      <td style="border-color: red"><%=fs.getHobbies() %></td>
      
        <td style="border-color: red;"><a href="Fuse_EditPage.jsp?loginId=<%=fs.getLoginId() %>"><button style="background-color: blue;" onclick="updateAleret();">EDIT</button> </a> </td>
         <td style="border-color: red;"><a href="Fuse_Delete?loginId=<%=fs.getLoginId() %>"><button style="background-color: red" onclick="deleteAleret();">DELETE</button> </a> </td>
          </tr>
      
      
    </tbody>
    <%
    }
    %>
    
  </table>
</div>
  <script >
  function deleteAleret() {
	 alert(" Delete..!! Are You Sure ");

	 }
  function updateAleret() {
		 alert(" Update..!! Are You Sure ");

		 }


</script>
</body>
</html>
    