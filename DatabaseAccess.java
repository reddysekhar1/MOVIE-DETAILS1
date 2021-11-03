package movies;

import java.io.*;
import java.servlet.*;
import java.servlet.http.*;
import java.sql.*;
 
public class DatabaseAccess extends HttpServlet{

	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
      final String DB_URL="jdbc:oracle:thin:@localhost:1521:xe";

      final String USER = "system";
      final String PASS = "reddy";

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");
      try {
         // Register JDBC driver
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         Statement stmt = conn.createStatement();
         String sql;
         sql = "SELECT name,actor,actress,director,yor FROM movie";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            String name  = rs.getString("name");
            String actor = rs.getString("actor");
            String actress = rs.getString("actress");
            String director = rs.getString("director");
            String yor = rs.getString("yor");
            
           
            //Display values
            out.println("name: " + name + "<br>");
            out.println("actor: " + actor + "<br>");
            out.println(" actress: " + actress + "<br>");
            out.println(" director: " + director + "<br>");
            out.println(" yor: " + yor + "<br>");
           
         }
         out.println("</body></html>");

        
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) {
         
         se.printStackTrace();
      } catch(Exception e) {
        
         e.printStackTrace();
      }  
      } 
   }
 