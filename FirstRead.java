package jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class FirstRead {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement =null;
	
		try {
//			FileInputStream fileinputStream=new FileInputStream("sql.properties");
//			
//			Properties properties=new Properties();
//			
//			properties.load(fileinputStream);
			
			Class.forName("com.mysql.jdbc.Driver");
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
			 
			 statement=connection.createStatement();
			 
			ResultSet resultSet=statement.executeQuery("select * from student");
			
			while(resultSet.next()) {
				System.out.println("id    "+resultSet.getInt(1));
				System.out.println("name   "+ resultSet.getString(2));
				System.out.println("branch    "+resultSet.getString(3));
				System.out.println("--------------");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null)
			{		
				
					connection.close();
				}
				if(statement!=null) {
					statement.close();
				}
			}catch (Exception e) {
					
					e.printStackTrace();
				}
			
			}
			
	}
}

