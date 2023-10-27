/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
//@WebServlet(urlPatterns = {"/userlogin"})
public class userlogin extends HttpServlet {

   
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        PrintWriter out=response.getWriter();
        
        
        String username=request.getParameter("username"); 
            String password=request.getParameter("userpass");
          //  out.println("Email="+email);
          
          try{
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/register","root","12345");
                    Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select name,pass from REGISTER where name='" + username +"' and password='" + password +"'");
                if (rs.next()) {
                    //out.println("Hello");
                    //session.setAttribute("username",username);
                    out.print("you are sucessfully login");
                    //response.sendRedirect("booking.jsp");
                }
                else {
                    response.sendRedirect("login.html");
                    
                }
                //rs.execute
                } catch( SQLException e){
            System.out.println(e);
           
    }

   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
    }
}
