package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
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

public class NewSentence extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Statement sql_statement;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public NewSentence() {
		try
		 {			
			MyConnection connection = new MyConnection();
			 //����������ȡ������ʵ��con����con����Statement������ʵ�� sql_statement
			 System.out.println("�������ݿ�...");
			 Connection con = connection.getConnection();
			 System.out.println(" ʵ����Statement����...");
			 sql_statement = con.createStatement();
			 System.out.println("�Ѿ�����ʵ��");
			 NewSentenceUI();
		 } catch (SQLException ex) {
		 System.err.println("SQLException: " + ex.getMessage());
		 }
	}
	
	public void NewSentenceUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("¼��������");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel_1.setLayout(new GridLayout(0, 2, 0, 50));
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("����");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("�ؼ���");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int senNum = searchNum()+1;				
				String sentence = textField.getText();
				String senTran="";
				try {
					senTran = new String(textField_1.getText().getBytes("utf-8"), "utf-8");
				} catch (UnsupportedEncodingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String keyWord="";
				try {
					keyWord = new String(textField_2.getText().getBytes("utf-8"), "utf-8");
				} catch (UnsupportedEncodingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {					
					String sql = "INSERT INTO sentence (senNum, senTran, sentence, keyWord) VALUES ('"+senNum+"','"+senTran+"','"+sentence+"','"+keyWord+"')";
					sql_statement.executeUpdate(sql);
					Notice frame4 = new Notice("¼��ɹ���");
					frame4.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
					Notice frame4 = new Notice("¼����������ԡ�");
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
	
	public int searchNum() {
		int sentenceNum=-1;
		try {
			System.out.print("��ʼ��ѯ");
			ResultSet rs = sql_statement.executeQuery("SELECT * FROM sentence");
			while(rs.next()){
				sentenceNum = rs.getInt("senNum");
			}					    				    			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return sentenceNum;
	}

}
