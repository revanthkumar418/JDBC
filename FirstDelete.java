package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class FirstDelete {
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement =null;
	
		try {
			FileInputStream fileinputStream=new FileInputStream("sql.properties");
			Properties properties=new Properties();
			
			properties.load(fileinputStream);
			
			Class.forName(properties.getProperty("driverpath"));
			
			 connection=DriverManager.getConnection(properties.getProperty("dbUrl"));
			 statement=connection.createStatement();
		int result=statement.executeUpdate(properties.getProperty("deletequery"));
			if(result!=0) {
				System.out.println(result+"rows effected");
				System.out.println("data deletion is succesfull");
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



