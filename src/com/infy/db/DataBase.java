package com.infy.db;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.infy.bean.BuildDetails;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataBase {

	public String checkDetails(BuildDetails buildDetails)throws Exception
    { 
		String s=null;
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			java.sql.Connection con=DriverManager.getConnection(  
			"jdbc:mysql://10.123.126.130:3306/userdb","admin","admin");  
			//here sonoo is database name, root is username and password 
			String sql = "Select * from usertable Where username='" + buildDetails.getUserName() + "' and password='" + buildDetails.getPassword() + "'";
			Statement stmt=(Statement) con.createStatement();  
	        ResultSet rs = stmt.executeQuery(sql);
	        if (rs.next())
	        {
	                //in this case enter when at least one result comes it means user is valid
	            s="Success";
	         } 
	        else 
	        {
	                //in this case enter when  result size is zero  it means user is invalid
	            s="Failure";
	        }	        
			con.close();  
			}
		   catch(Exception e)
		   { 
			   System.out.println(e);
		  }
		return s;  
			}  
	
	/*public static void main(String[] args) throws Exception {
		BuildDetails b1=new BuildDetails();
		b1.setUserName("admin");
		b1.setPassword("ain");
		DataBase dd=new DataBase();
		String s=dd.checkDetails(b1);
		System.out.println(s);
		
		
	}*/
}



