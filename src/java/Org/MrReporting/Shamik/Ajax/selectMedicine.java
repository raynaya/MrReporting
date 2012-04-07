/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Org.MrReporting.Shamik.Ajax;

import DatabaseConnection.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
public class selectMedicine extends HttpServlet {
   
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
            Connection c=db.createConnection();
            String doctor=request.getParameter("id");


PrintWriter out = response.getWriter();
        try{
          Statement s =c.createStatement();
  ResultSet product=s.executeQuery("select PRODUCTNAME from DOCPRODUCTS where DOCNAME='"+doctor+"'");
 // [ {"optionValue":10, "optionDisplay": "Remy"},]
//  JSONObject j= new JSONObject();
//  out.print("[");
  JSONArray a=new JSONArray();
  while(product.next()){
JSONObject j=new JSONObject();
j.put("optionValue", product.getString("PRODUCTNAME"));
j.put("optionDisplay", product.getString("PRODUCTNAME"));
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
