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
			//��һ��������MySQL��JDBC������
			   Class.forName("com.mysql.jdbc.Driver");
			   //ȡ�����ӵ�url,�ܷ���MySQL���ݿ���û���,���룻jsj�����ݿ���
			   String url = "jdbc:mysql://localhost:3307/happyenglish?autoReconnect=true&characterEncoding=utf8";
			   String username = "root";
			   String password = "112358";
			   //�ڶ�����������MySQL���ݿ���������ʵ��
			   System.out.print("1111");
			   Connection con = (Connection) DriverManager.getConnection(url,username,password);
			   System.out.print("���ӳɹ�");
			   return con;
		}catch (SQLException e) {
			System.out.println("���ݿ�����ʧ�ܣ������û��������롢���ݿ����Ƿ���ȷ��");
			System.out.println("�����µ�¼��");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("222");
			e.printStackTrace();		
	 }
		System.out.print("222");
		return null;		
 }
}
