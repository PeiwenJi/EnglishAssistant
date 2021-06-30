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

public class DeleteWord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Statement sql_statement;
	/**
	 * Create the frame.
	 */
	public DeleteWord() {
		try
		 {			
			MyConnection connection = new MyConnection();
			 //����������ȡ������ʵ��con����con����Statement������ʵ�� sql_statement
			 System.out.println("�������ݿ�...");
			 Connection con = connection.getConnection();
			 System.out.println(" ʵ����Statement����...");
			 sql_statement = con.createStatement();
			 System.out.println("�Ѿ�����ʵ��");
			 deleteWordUI();
		 } catch (SQLException ex) {
		 System.err.println("SQLException: " + ex.getMessage());
		 }
	}
	
	public void deleteWordUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("������ɾ���ĵ���");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel_1.setLayout(new GridLayout(6, 2, 0, 0));
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String word = textField.getText();
				try {					
					String sql = "delete from word where word = '"+word+"'";
					sql_statement.executeUpdate(sql);
					Notice frame4 = new Notice("ɾ���ɹ���");
					frame4.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
					Notice frame4 = new Notice("ɾ�����������ԡ�");
					frame4.setVisible(true);
				}
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("����");
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
