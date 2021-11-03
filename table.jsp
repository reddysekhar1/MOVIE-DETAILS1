<%@page import="java.sql.*" %>
<%
   
   try{
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","reddy");
       String psql="create table movie(name varchar2(20),actor varchar2(20),actress vachar2(20),director vachar2(20),yor number)";
	   PreparedStatement pstmt = con.prepareStatement(vsql);
	   
	   int n = pstmt.executeUpdate();
	   if( n == 1 ){
		   out.println("Table created successfully<br>");
		   con.close();
	   }
   }catch(Exception e){
	   out.println(e.getMessage());
   }
%>
