package com.cutm;
import java.sql.*;
public class JdbcTest1 {
	public static void main(String[] args) 
	{
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection cn=DriverManager.getConnection(
	"jdbc:oracle:thin:@localhost:1521:orcl","system","bhargaba");
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e) {
		System.out.println("invalid driver class");
	}
	catch(SQLException a) {
		System.out.println("unable to establish connection");
	}

}
}