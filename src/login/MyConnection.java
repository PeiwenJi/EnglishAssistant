package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	public MyConnection() {
		
	}
	
	public Connection getConnection()
	{
		try {			
			//第一步：加载MySQL的JDBC的驱动
			   Class.forName("com.mysql.jdbc.Driver");
			   //取得连接的url,能访问MySQL数据库的用户名,密码；jsj：数据库名
			   String url = "jdbc:mysql://localhost:3307/happyenglish?autoReconnect=true&characterEncoding=utf8";
			   String username = "root";
			   String password = "112358";
			   //第二步：创建与MySQL数据库的连接类的实例
			   System.out.print("1111");
			   Connection con = (Connection) DriverManager.getConnection(url,username,password);
			   System.out.print("连接成功");
			   return con;
		}catch (SQLException e) {
			System.out.println("数据库连接失败，请检查用户名、密码、数据库名是否正确！");
			System.out.println("请重新登录！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("222");
			e.printStackTrace();		
	 }
		System.out.print("222");
		return null;		
 }
}
