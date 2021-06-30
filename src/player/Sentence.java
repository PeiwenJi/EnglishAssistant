package player;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

public class Sentence extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Statement sql_statement;

	
	public Sentence() {
		try
		 {			
			MyConnection connection = new MyConnection();
			 //����������ȡ������ʵ��con����con����Statement������ʵ�� sql_statement
			 System.out.println("�������ݿ�...");
			 Connection con = connection.getConnection();
			 System.out.println(" ʵ����Statement����...");
			 sql_statement = con.createStatement();
			 System.out.println("�Ѿ�����ʵ��");
			 senUI();
		 } catch (SQLException ex) {
		 System.err.println("SQLException: " + ex.getMessage());
		 }
	
	}
	
	public void senUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		
		JLabel lblNewLabel = new JLabel("������ؼ��ʣ�");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 2, 0, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Ӣ�ģ�");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(100);
		
		JLabel lblNewLabel_2 = new JLabel("���ģ�");
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(100);
		
		JButton btnNewButton_1 = new JButton("\u4E0A\u4E00\u4E2A");
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
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
		btnNewButton_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
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
		
		JButton btnNewButton_6 = new JButton("����");
		btnNewButton_6.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
			System.out.print("��ʼ��ѯ");
			ResultSet rs = sql_statement.executeQuery("SELECT * FROM sentence");
			while(rs.next()){
				String sentence = rs.getString("sentence");
			    String senTran = rs.getString("senTran");
			    String keyWord = rs.getString("keyWord");
			    if(textField.getText().equals(keyWord)) {
				    textField_1.setText(sentence);
				    textField_2.setText(senTran);
			    }					    				    
				}				    
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//sql_statement.close();
		//con.close();
	}

	public void forsearch() {
		try {
			System.out.print("��һ��");
			ResultSet rs = sql_statement.executeQuery("SELECT * FROM sentence");
			while(rs.next()){
				String sentence = rs.getString("sentence");
			    String senTran = rs.getString("senTran");
			    String keyWord = rs.getString("keyWord");
				if(textField.getText().equals(keyWord)) {
					rs.previous();
					sentence = rs.getString("sentence");
				    senTran = rs.getString("senTran");
				    keyWord = rs.getString("keyWord");
					textField_1.setText(sentence);
					textField_2.setText(senTran);
					textField.setText(keyWord);
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
			System.out.print("��һ��");
			ResultSet rs = sql_statement.executeQuery("SELECT * FROM sentence");
			while(rs.next()){
				String sentence = rs.getString("sentence");
			    String senTran = rs.getString("senTran");
			    String keyWord = rs.getString("keyWord");
				if(textField.getText().equals(keyWord)) {
					rs.next();
					sentence = rs.getString("sentence");
				    senTran = rs.getString("senTran");
				    keyWord = rs.getString("keyWord");
					textField_1.setText(sentence);
					textField_2.setText(senTran);
					textField.setText(keyWord);
				}					    				    
			}				    
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
}
