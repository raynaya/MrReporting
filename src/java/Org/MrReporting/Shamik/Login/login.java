/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Org.MrReporting.Shamik.Login;

import DatabaseConnection.*;
import Org.MrReporting.Shamik.BeanClass.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

/**
 *
 * @author shamik
 */
public class login extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String name =request.getParameter("name");
         String password=request.getParameter("password");
         /* Other details will follow
          *
          *
          *
          */

        try {
            DbConnection db = new DbConnection();
            Connection c=db.createConnection();
            Statement s =c.createStatement();
                   /*Here we need to check if password and other things are correct or not
                    * Then modelling has to be done and we have to set the session
                     and application objects after this.
                    *
                    */
                   
                   s.execute("insert into mr (name) values ('"+name+"')");
                   out.println("Database");
                   HashSet set=(HashSet) getServletContext().getAttribute("OnlineList");
                   out.println("hashset");
            if(!set.add(set)){

                out.println("The name exists");
                response.sendRedirect("/index.jsp");
                //request.getSession().invalidate();
                return;
            }
                   out.println("The name doesnt exist");
                   Mr user=new Mr();
                   user.setMr(name);
                   request.getSession().setAttribute("userInfo",user);
                   out.println("Succesfull");


        }
        catch(Exception e ){
        }

        finally {
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
