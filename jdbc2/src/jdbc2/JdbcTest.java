package jdbc2;

import java.sql.*;
public class JdbcTest {
public static void main(String[] args) 
		throws SQLException,ClassNotFoundException 
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection(
	"jdbc:oracle:thin:@localhost:1521:orcl",
	"system","bhargaba");
Statement st=cn.createStatement();
ResultSet rs=st.executeQuery(
		"select id,name,age from emp");
while(rs.next())
{
int id=rs.getInt("id");
String en=rs.getString("name");
int a=rs.getInt("age");
System.out.printf("id : "+id +"\tName : "+en+"\tage : "+a);
}}}