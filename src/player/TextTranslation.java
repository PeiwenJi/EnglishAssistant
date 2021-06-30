package player;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import login.MyConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TextTranslation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Statement sql_statement;

	public TextTranslation() {
		try{
			MyConnection connection = new MyConnection();
			//����������ȡ������ʵ��con����con����Statement������ʵ�� sql_statement
			 System.out.println("�������ݿ�...");
			 Connection con = connection.getConnection();
			 System.out.println(" ʵ����Statement����...");
			 sql_statement = con.createStatement();
			 System.out.println("�Ѿ�����ʵ��");
			 textTranUI();		
		}catch (SQLException ex) {
		 System.err.println("SQLException: " + ex.getMessage());
		 }
		
	}

	public void textTranUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 1, 20, 5));
		
		JLabel lblNewLabel = new JLabel("������Ҫ����Ķ���");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("������");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("����");
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(getTranslateResult(textField.getText()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);
		

		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(btnNewButton_1);
	}
	
	public String getTranslateResult(String text){
	    StringTokenizer st = new StringTokenizer(text," ,?.!:\"\"''\n#");
	    List<String> wordList = new ArrayList<>();
	    StringBuffer wordTranList = new StringBuffer();
	    while (st.hasMoreElements()) {
	    	wordList.add(st.nextToken().toLowerCase());
	    }
	    try {
			System.out.print("��ʼ��ѯ");
			for(int i=0;i<wordList.size();i++) {
				String sql = "select * from word where word = \""+wordList.get(i)+"\";";
				ResultSet rs = sql_statement.executeQuery(sql);
				while(rs.next()) {
					String wordTran = rs.getString("wordTran");
					wordTranList.append(wordTran);
				}
			}			    
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	    //sql_statement.close();
	    //con.close();
		return wordTranList.toString();  
	 }	
}
