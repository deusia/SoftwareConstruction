package sc.ch8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {
	
	public static void main(String[] args) {
		String driverName="com.mysql.jdbc.Driver";//指明驱动程序
//		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//指明驱动程序
		
		String dbURL="jdbc:mysql://47.102.133.86:3306/SoftwareConstruction?useSSL=false";
//		String dbURL ="jdbc:sqlserver://localhost:1433;DatabaseName=SC";
		
		String userName ="root";
//		String userName ="sa";
		
		String userPassword="123456";
//		String userPassword="wyl-6054";
		
		Connection dbCon;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driverName);
			System.out.println("加载驱动成功！");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		
		try {
			dbCon= DriverManager.getConnection(dbURL,userName,userPassword);
			System.out.println("数据库连接成功！");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
}
