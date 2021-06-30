package player;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.MyConnection;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;

public class TestWord extends JFrame {

	private JPanel contentPane;
	private Statement sql_statement;
	private int trueNum = 0;
	private int falseNum = 0;
	private int level = 0;
	private ArrayList<String> wordTran1 = new ArrayList<String>();
	private ArrayList<String> wordTran2 = new ArrayList<String>();
	private ArrayList<String> wordTran3 = new ArrayList<String>();
	private ArrayList<String> wordTran4 = new ArrayList<String>();
	private ArrayList<String> word = new ArrayList<String>();
	private int wordNum;
	private boolean rePaint = false;
	private int im = 0;
	private int m = 1;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	/**
	 * Create the frame.
	 */
	public TestWord(int level) {	
		this.level = level+1;
		try
		 {		
			MyConnection connection = new MyConnection();
			 //第三步：获取连接类实例con，用con创建Statement对象类实例 sql_statement
			 System.out.println("连接数据库...");
			 Connection con = connection.getConnection();
			 System.out.println(" 实例化Statement对象...");
			 sql_statement = con.createStatement();
			 System.out.println("已经创建实例");
			 oneTest();
			 testWordUI();
		 } catch (SQLException ex) {
		 System.err.println("SQLException: " + ex.getMessage());
		 }
	}
	
	public void testWordUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 20));

		
		JLabel lblNewLabel = new JLabel("单词：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setText(word.get(im));
		lblNewLabel_1.paintImmediately(lblNewLabel_1.getBounds());
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("请选择正确的翻译");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbtnNewRadioButton_1 = new JRadioButton(wordTran1.get(im));
		panel_1.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton = new JRadioButton(wordTran2.get(im));
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_2 = new JRadioButton(wordTran3.get(im));
		panel_1.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton(wordTran4.get(im));
		panel_1.add(rdbtnNewRadioButton_3);
		
		ButtonGroup option = new ButtonGroup();
		option.add(rdbtnNewRadioButton_1);
		option.add(rdbtnNewRadioButton);
		option.add(rdbtnNewRadioButton_2);
		option.add(rdbtnNewRadioButton_3);		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(0, 2, 0, 20));
		
		JLabel lblNewLabel_3 = new JLabel("目前测试结果");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("答对题数");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_5);
		
		String s = String.valueOf(trueNum);
		JLabel lblNewLabel_6 = new JLabel(s);
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("答错题数：");
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_8);
		
		String s1 = String.valueOf(falseNum);
		JLabel lblNewLabel_7 = new JLabel(s1);
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_7);	
		
		JButton btnNewButton = new JButton("下一题");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(rdbtnNewRadioButton_1.isSelected() == true)
				{
					trueNum++;
				}
				else if(rdbtnNewRadioButton.isSelected() == true)
				{
					falseNum++;
				}
				else if(rdbtnNewRadioButton_2.isSelected() == true)
				{
					falseNum++;
				}
				else if(rdbtnNewRadioButton_3.isSelected() == true)
				{
					falseNum++;
				}
				else			//没有选按钮便提交
				{
					falseNum++;
				}
				//重置按钮的值
				im++;
				lblNewLabel_1.setText(word.get(im));
				rdbtnNewRadioButton_1.setText(wordTran1.get(im));
				rdbtnNewRadioButton.setText(wordTran2.get(im));
				rdbtnNewRadioButton_2.setText(wordTran3.get(im));
				rdbtnNewRadioButton_3.setText(wordTran4.get(im));
				String s = String.valueOf(trueNum);
				lblNewLabel_6.setText(s);
				String s1 = String.valueOf(falseNum);
				lblNewLabel_7.setText(s1);
				System.out.print(word.get(im));
				System.out.print(trueNum);
				System.out.print(falseNum);
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				dispose();
			}
		});
		panel_2.add(btnNewButton_1);
	}
	
	public void oneTest() {
		try {
			
			System.out.print("开始查询");
			String sql = "select * from test where level = \""+level+"\";";
			ResultSet rs = sql_statement.executeQuery(sql);			
			while(rs.next()) {
				wordTran1.add(rs.getString("wordTran1"));
				wordTran2.add(rs.getString("wordTran2"));
				wordTran3.add(rs.getString("wordTran3"));
				wordTran4.add(rs.getString("wordTran4"));
				word.add(rs.getString("word"));
			}	    
		    System.out.print(word);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
