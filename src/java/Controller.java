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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author raakesh-pt503
 */
public class Controller extends HttpServlet {

    static boolean success=false;
    
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
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
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
            ArrayList<String> list=new ArrayList<String>();
            list.add(request.getParameter("book1"));
            list.add(request.getParameter("book2"));
            list.add(request.getParameter("book3"));
            list.add(request.getParameter("book4"));
            list.add(request.getParameter("book5"));
            
            byte productid=0;
            
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)!=null){
                    productid=(byte) (i+1);
                }
            }
            
            HttpSession session1=request.getSession();
            String username=session1.getAttribute("username").toString();
            if(username.equals("") || username==null){
                response.sendRedirect("index.jsp?msg=Session Expired");
            }
            
            double randomcode=Math.random();
            String temp=String.valueOf(randomcode);
            String randomCode1=temp.replace(".", "");
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            String dateOfBooking=dateFormat.format(date);
            
            
            Calendar now = Calendar.getInstance();
            System.out.println(now.get(Calendar.DATE)+" "+Calendar.MONTH+1+" "+Calendar.YEAR);
            now.add(Calendar.DATE, 7);
            date=now.getTime();
            System.err.println(date);
            System.out.println(now.get(Calendar.DATE)+" "+Calendar.MONTH+1+" "+Calendar.YEAR);
            
            //DO THIS PART.....
            String nearestplace="nearby showroom";
            
            
            Connection con=Dbconnection.conn();
            PreparedStatement ps=con.prepareStatement("insert into ProductDetails (username,productid,randomcode,status,deliverydate,nearestshop)values(?,?,?,?,?,?)");
            ps.setString(1, username);
            ps.setString(2, String.valueOf(productid));
            ps.setString(3, String.valueOf(randomCode1));
            ps.setString(4, "notdelivered");
            ps.setString(5, String.valueOf(date));
            ps.setString(6, nearestplace);
            int result=ps.executeUpdate();
            if(result>0){
                //response.sendRedirect("ResultPage.jsp?msg=Registered Succcessfully");
                //call for sending email
                
                
            }
            else{
                success=false;
                response.sendRedirect("ResultFailure.jsp?msg=Registration Failed");
            }
            ps=con.prepareStatement("select emailid from logindetails where username=?");
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            String useremailid="";
            if(rs.next()){
                useremailid=rs.getString(1);
            }
           /* String to=useremailid;
            String from="bookitgrabit@gmail.com";
            String host="localhost";
            Properties properties=System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            Session session2=Session.getDefaultInstance(properties);*/
            String message1="Your booking code is"+String.valueOf(randomCode1);
           /* try
            {
                MimeMessage message=new MimeMessage(session2);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
                message.setSubject("Booking confirmation");
                message.setText(message1);
                Transport.send(message);
                System.out.println("booking code send successfully....");
                
            }*/ 
            final String username1 = "cloudcomputingnvs@gmail.com";
		final String password = "Ab@nvs123";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username1, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.addRecipients(Message.RecipientType.TO,
				InternetAddress.parse(useremailid));
			message.setSubject("book code");
			message.setText(message1);
 
			Transport.send(message);
 
			System.out.println("Done");
                        success=true;
                        response.sendRedirect("ResultPage.jsp?msg=Registered Succcessfully");
                }
            catch (MessagingException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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
