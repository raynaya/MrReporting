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
public class storeCcr extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
     
        try {
            DbConnection db = new DbConnection();
            Connection c=db.createConnection();

            Mr userInfo= (Mr) request.getSession().getAttribute("UserInfo");
    String groupname=userInfo.getGroupName();
    String hqname=userInfo.getHqName();
    String statename=userInfo.getStateName();
    String loginid=userInfo.getLoginId();
    String targetdcrdate= request.getParameter("date");
    String areacode= request.getParameter("area");
    String name= request.getParameter("name");
    float ORDERNUMBER= Float.parseFloat(request.getParameter("ORDERNUMBER"));
     float ORDERAMOUNT= Float.parseFloat(request.getParameter("ORDERVALUE"));
PreparedStatement p=c.prepareStatement("insert into CHEMISTDCR (GROUPNAME,HQNAME,STATENAME,LOGINID,DCRDATE,TARGETDCRDATE,AREACODE,NAME,ORDERNUMBER,ORDERAMOUNT)values (?,?,?,?,sysdate,to_date('"+targetdcrdate+"','dd/mm/yyyy'),?,?,?,?)");
p.setString(1,groupname);
p.setString(2, hqname);
p.setString(3, statename);
p.setString(4, loginid);
p.setString(5,areacode);
p.setString(6,name);
p.setFloat(7,ORDERNUMBER);
p.setFloat(8,ORDERAMOUNT);
p.execute();
response.sendRedirect("/ccrmaintenance.jsp");
   /* groupName varchar2(50)
hqName varchar2(50)
stateName varchar2(50)
loginID varchar2(20)
dcrDate Date
targetDcrDate Date
lateDCR boolean
areacode varchar2(50)
name varchar2(50) – chemist name
orderNumber(50) – order number
orderAmount(15,2) – Order Amount
*/


    }
        catch(Exception e){

            e.printStackTrace();
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
