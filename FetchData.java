package com.gettoken;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/token")
@Controller
public class FetchData {
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public  @ResponseBody String getToken() {
		String result = "";
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", 
			"root", "pass");
			  Statement st=con.createStatement();
			  ResultSet rs=st.executeQuery("select * from token");
			  
			 while(rs.next()){
				 result=result+rs.getString(1)+"--"+rs.getString(2)+"\n";
				
			 }
			  
			  } catch (Exception e) {
			  System.out.println("HHHHHHHHHHHH"+e.getMessage());
			  }
	  
	  return result;
		
}

}
