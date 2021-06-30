package player;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import login.MyConnection;

public class Words extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Statement sql_statement;

	public Words() {
		try
		 {			
			MyConnection connection = new MyConnection();
			 //第三步：获取连接类实例con，用con创建Statement对象类实例 sql_statement
			 System.out.println("连接数据库...");
			 Connection con = connection.getConnection();
			 System.out.println(" 实例化Statement对象...");
			 sql_statement = con.createStatement();
			 System.out.println("已经创建实例");
			 wordsUI();
		 } catch (SQLException ex) {
		 System.err.println("SQLException: " + ex.getMessage());
		 }
	
	}
	
	public void wordsUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		
		JLabel lblNewLabel = new JLabel("请输入单词：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));		
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("中文意思：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("单词级别：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(20);
		
		JButton btnNewButton_1 = new JButton("\u4E0A\u4E00\u4E2A");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					forsearch();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4E0B\u4E00\u4E2A");
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aftersearch();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton_6 = new JButton("返回");
		btnNewButton_6.setFont(new Font("微软雅黑", Font.PLAIN, 20));		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		panel_3.add(btnNewButton_6);
	}
	
	public void search() {		
				try {
					System.out.print("开始查询");
					ResultSet rs = sql_statement.executeQuery("SELECT * FROM word");
					while(rs.next()){
						String wordTran = rs.getString("wordTran");
					    String level = rs.getString("level");
					    String word = rs.getString("word");
					    if(textField.getText().equals(word)) {
					    	System.out.print(wordTran);
						    System.out.print(level);
						    textField_1.setText(wordTran);
						    textField_2.setText(level);
					    }					    				    
						}				    
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	}

	public void forsearch() {
		try {
			System.out.print("上一个");
			ResultSet rs = sql_statement.executeQuery("SELECT * FROM word");
			while(rs.next()){
				String wordTran = rs.getString("wordTran");
			    String level = rs.getString("level");
			    String word = rs.getString("word");
			    if(textField.getText().equals(word)) {
			    	rs.previous();
					wordTran = rs.getString("wordTran");
				    level = rs.getString("level");
				    word = rs.getString("word");
			    	System.out.print(wordTran);
				    System.out.print(level);
				    textField_1.setText(wordTran);
				    textField_2.setText(level);
				    textField.setText(word);
			    }					    				    
				}				    
		} catch (Exception e1) {
			e1.printStackTrace();
		}
//sql_statement.close();
//con.close();
	}

	public void aftersearch() {
		try {
			System.out.print("下一个");
			ResultSet rs = sql_statement.executeQuery("SELECT * FROM word");
			while(rs.next()){
				String wordTran = rs.getString("wordTran");
			    String level = rs.getString("level");
			    String word = rs.getString("word");
			    if(textField.getText().equals(word)) {
			    	rs.next();
					wordTran = rs.getString("wordTran");
				    level = rs.getString("level");
				    word = rs.getString("word");
			    	System.out.print(wordTran);
				    System.out.print(level);
				    textField_1.setText(wordTran);
				    textField_2.setText(level);
				    textField.setText(word);
			    }					    				    
				}				    
		} catch (Exception e1) {
			e1.printStackTrace();
	}
	}
}

