<%@page import="java.sql.*" %>
<%
   //capture the data from second form
   String fname = request.getParameter("name");
   String sname = request.getParameter("actor");
   String username = request.getParameter("actress");
   String password = request.getParameter("director");
   String email = request.getParameter("yor");
   
	
  

   try{
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","reddy");
	   String vsql = "insert into movie values(?,?,?,?,?)";
	   PreparedStatement pstmt = con.prepareStatement(vsql);
	   pstmt.setString(1,name);
	   pstmt.setString(2,actor);
	   pstmt.setString(3,actress);
	   pstmt.setString(4,director);
	   pstmt.setString(5,yor);
	   int n = pstmt.executeUpdate();
	   if( n == 1 ){
		   out.println("Data stored successfully<br>");
		   out.println("Goto login<a href=index.html>login</a>");
		   con.close();
	   }
   }catch(Exception e){
	   out.println(e.getMessage());
   }
%>
