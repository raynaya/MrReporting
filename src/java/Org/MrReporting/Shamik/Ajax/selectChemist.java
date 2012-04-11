/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Org.MrReporting.Shamik.Ajax;

import DatabaseConnection.DbConnection;
import Org.MrReporting.Shamik.BeanClass.Mr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.lang.Object;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author shamik
 */
public class selectChemist extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
response.setContentType("application/json");
DbConnection db = new DbConnection();
         try{   Connection c=db.createConnection();
            String area=request.getParameter("id");
            Mr userInfo= (Mr) request.getSession().getAttribute("UserInfo");
            String hqname=userInfo.getHqName();
    String statename=userInfo.getStateName();
System.out.print(hqname+" "+statename);

PrintWriter out = response.getWriter();
        
          Statement s =c.createStatement();
  ResultSet chemist=s.executeQuery("select NAME from CHEMISTMASTER where  AREACODE='"+area+"'");
 // [ {"optionValue":10, "optionDisplay": "Remy"},]
//  JSONObject j= new JSONObject();
//  out.print("[");
  JSONArray a=new JSONArray();
  JSONObject b=new JSONObject();
  b.put("optionValue","");
  b.put("optionDisplay", "SelectChemist");
  a.add(b);
  while(chemist.next()){
JSONObject j=new JSONObject();
j.put("optionValue", chemist.getString("NAME"));
j.put("optionDisplay", chemist.getString("NAME"));
a.add(j);
  //out.print("{\"optionValue\":\""+doctor.getString("DOCNAME")+"\",\"optionDisplay\":\""+doctor.getString("DOCNAME")+"\"},");
            }
  out.print(a);
c.close();
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
