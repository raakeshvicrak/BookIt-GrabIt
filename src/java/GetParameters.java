/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author raakesh-pt503
 */
public class GetParameters extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetParameters</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetParameters at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //processRequest(request, response);
            HttpSession session1=request.getSession();
            String username=session1.getAttribute("username").toString();
            if(username.equals("") || username==null){
             response.sendRedirect("index.jsp?msg=Session Expired");
            }
            
            String height=request.getParameter("height");
            String chest=request.getParameter("chest");
            String thigh=request.getParameter("thigh");
            String hips=request.getParameter("hips");
            
            Connection con=Dbconnection.conn();
            PreparedStatement ps=con.prepareStatement("insert into userParameters (username,height,chest,thigh,hips)values(?,?,?,?,?)");
            ps.setString(1, username);
            ps.setString(2, height);
            ps.setString(3, chest);
            ps.setString(4, thigh);
            ps.setString(5, hips);
            int result=ps.executeUpdate();
                
            if(result>0){
                response.sendRedirect("Dashboard.jsp?msg=Row Inserted Successfully");
            }
            else{
                response.sendRedirect("getParameters.jsp?msg=Entry failed");
            }
            
            
        } catch (SQLException ex) {
             response.sendRedirect("getParameters.jsp?msg=Entry failed");
            Logger.getLogger(GetParameters.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
