package com.cutm;
import java.sql.*; 
import java.util.*;

public class ProfileDao {
	public static Connection getConnection() {
		 Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bhargaba");  
	        }catch(Exception e){System.out.println(e);}  
	        return con; 	
	}
	public static int save(Profile pr) {
		int res=0;
		 Connection con=null;  
		 Statement st=null;
		 try {
			 con=getConnection();
			 st=con.createStatement();
			 res=st.executeUpdate("insert into profile(userid,name,email,mobile) values ('"+pr.getUserid()+"','"+pr.getName()+"','"+pr.getEmail()+"',"+pr.getMobile()+" )");
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return res; 
	}
   
	
	public static List<Profile> fetchAll()
	{
		List<Profile> list=null;
		Connection con=null;  
		 Statement st=null;
		 try {
			 con=getConnection();
			 st=con.createStatement();
			 ResultSet rs=st.executeQuery("select * from profile ");
			 list=new ArrayList<>();
			 while(rs.next()){  
	                Profile pr=new Profile();  
	                pr.setUserid(rs.getString("userid"));  
	                pr.setName(rs.getString("name"));  
	                pr.setEmail(rs.getString("email"));  
	                pr.setMobile(rs.getLong("mobile"));  
	                list.add(pr);  
	            }  
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally {
			 try {
				st.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			 
		 }
		return list;
		
	}
}
