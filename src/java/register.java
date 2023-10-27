

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class register extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        
        String n=request.getParameter("username");
        String p=request.getParameter("userpass");
        String eu=request.getParameter("useremail");
        String c=request.getParameter("usercountry");
        
        
        
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/register","root","12345");
    
        PreparedStatement ps;
            ps = con.prepareStatement("insert into REGISTER values(?,?,?,?)");
          ps.setString(1,n);
          ps.setString(2,p);
          ps.setString(3,eu);
          ps.setString(4,c);
          
          int i=ps.executeUpdate();
          if(i>0)
              out.print("you are sucessfully register");
         response.sendRedirect("login.html");
           
           } catch( ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        }

    
    }


    



   

