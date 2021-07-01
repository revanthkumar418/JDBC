package jdbc;

import java.sql.Connection;
import java.sql.*;
import com.mysql.jdbc.Statement;

public class FirstInsert {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
			 statement=(Statement) connection.createStatement();
			int result =statement.executeUpdate("insert into student values(3,'vikas','ec')");
			if(result!=0) {
				System.out.println(result+"rows effected");
				System.out.println("data upload succesfully ");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null) {
				
					connection.close();
				}
			if(statement!=null) {
				
					statement.close();
			}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
	}


