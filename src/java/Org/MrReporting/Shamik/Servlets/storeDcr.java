/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Org.MrReporting.Shamik.Servlets;

import DatabaseConnection.DbConnection;
import Org.MrReporting.Shamik.BeanClass.Mr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shamik
 */
public class storeDcr extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        DbConnection db = new DbConnection();
            Connection c=db.createConnection();
       
            Mr userInfo= (Mr) request.getSession().getAttribute("UserInfo");
			String groupname=userInfo.getGroupName();
    String hqname=userInfo.getHqName();
    String statename=userInfo.getStateName();
    String loginid=userInfo.getLoginId();
    String targetdcrdate= request.getParameter("date");
    String areacode= request.getParameter("area");
    String docname= request.getParameter("Dr");
    char visittype=request.getParameter("time").charAt(0);
    char visitstatus=request.getParameter("visitstatus").charAt(0);
    char prodstatus=request.getParameter("prodstatus").charAt(0);
     String [] productlist=request.getParameterValues("productname");
    String [] quantity=request.getParameterValues("quantity");
 
        try {
PreparedStatement p=c.prepareStatement("insert into DOCTOR_DCR (GROUPNAME,HQNAME,STATENAME,LOGINID,DCRDATE,TARGETDCRDATE,AREACODE,DOCNAME,VISITTYPE,VISITSTATUS,PRODSTATUS) values (?,?,?,?,sysdate,to_date('"+targetdcrdate+"','dd/mm/yyyy'),?,?,'"+visittype+"','"+visitstatus+"','"+prodstatus+"')");

p.setString(1,groupname);
p.setString(2,hqname);
p.setString(3,statename);
p.setString(4,loginid);
p.setString(5,areacode);
p.setString(6,docname);
p.execute();
PreparedStatement ps=c.prepareStatement("insert into DOCDCRPRODUCT (GROUPNAME,HQNAME,STATENAME,LOGINID,DCRDATE,PRODUCTNAME,QTY,SAMPLE) values (?,?,?,?,to_date('"+targetdcrdate+"','dd/mm/yyyy'),?,?,'Y')");
for(int i=0;i<productlist.length;i++){
    ps.setString(1,groupname);
    ps.setString(2,hqname);
    ps.setString(3,statename);
    ps.setString(4,loginid);
    ps.setString(5,productlist[i]);
    ps.setInt(6,Integer.parseInt(quantity[i]));
    ps.execute();
}
/*   DOCDCRPRODUCT
 GROUPNAME	VARCHAR2(50)	Yes	 -	 -
HQNAME	VARCHAR2(50)	Yes	 -	 -
STATENAME	VARCHAR2(50)	Yes	 -	 -
LOGINID	VARCHAR2(20)	Yes	 -	 -
DCRDATE	DATE	Yes	 -	 -
PRODUCTNAME	VARCHAR2(50)	Yes	 -	 -
QTY	NUMBER(5,0)	Yes	 -	 -
SAMPLE	CHAR(1)	Yes	 -	 D
 DOCTORREMARK	VARCHAR2(200)	*/
response.sendRedirect("/dcrmaintenance.jsp");
//getServletContext().getRequestDispatcher("/dcrmaintenance.jsp").forward(request, response);

        }
        catch(Exception e){

        }
        finally {
            
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
