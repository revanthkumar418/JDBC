package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FirstUpdate {
	public static void main(String[] args) {
		
	
	Connection connection=null;
	Statement statement =null;

	try {
//		FileInputStream fileinputStream=new FileInputStream("sql.properties");
//		Properties properties=new Properties();
//		properties.load(fileinputStream);
		Class.forName("com.mysql.jdbc.Driver");
		 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
		 statement=connection.createStatement();
	int result=statement.executeUpdate("update student set id=6 ,name='karan',branch='eee' where id=2");
		if(result!=0) {
			System.out.println(result+"rows effected");
			System.out.println("data update is succesfull");
		}else {
			System.out.println("data update is not succesfull");
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






