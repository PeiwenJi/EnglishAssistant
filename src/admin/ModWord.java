package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import login.MyConnection;

public class ModWord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Statement sql_statement;
	/**
	 * Create the frame.
	 */
	public ModWord() {
		try
		 {			
			MyConnection connection = new MyConnection();
			 //第三步：获取连接类实例con，用con创建Statement对象类实例 sql_statement
			 System.out.println("连接数据库...");
			 Connection con = connection.getConnection();
			 System.out.println(" 实例化Statement对象...");
			 sql_statement = con.createStatement();
			 System.out.println("已经创建实例");
			 modWordUI();
		 } catch (SQLException ex) {
		 System.err.println("SQLException: " + ex.getMessage());
		 }
	}
	
	public void modWordUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("请输入需要编辑的单词");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("单词");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.setLayout(new GridLayout(0, 2, 0, 50));
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("翻译");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("级别");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("low");
		comboBox.addItem("middle");
		comboBox.addItem("high");
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word = textField.getText();
				String wordTran="";
				try {
					wordTran = new String(textField_1.getText().getBytes("utf-8"), "utf-8");
				} catch (UnsupportedEncodingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String level="";
				if(comboBox.getSelectedIndex()==0) {
					level = "low";
				}
				if(comboBox.getSelectedIndex()==1) {
					level = "middle";
				}
				if(comboBox.getSelectedIndex()==2) {
					level = "high";
				}
				try {										
					String sql = "update word set wordTran='"+wordTran+"',level='"+level+"' where word='"+word+"'";
					sql_statement.executeUpdate(sql);
					Notice frame4 = new Notice("编辑成功！");
					frame4.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
					Notice frame4 = new Notice("编辑错误！请重试。");
					frame4.setVisible(true);
				}
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(btnNewButton_1);
	}

}
