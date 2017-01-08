/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raakesh-pt503
 */

import java.sql.*;
public class Dbconnection {
	static Connection c;
	public static String path="D:";
        public  static Connection conn()
        {
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookitgetit", "root","");
				
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return c;
    }
}