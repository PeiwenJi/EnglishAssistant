package player;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Begin extends JFrame {

	private JPanel contentPane;
	
	
	public Begin() {
		setBackground(new Color(255, 250, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10,10, 10, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_2 = new JButton("µ¥´Ê·­Òë");
		btnNewButton_2.setBackground(new Color(255, 240, 245));
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					Words frame1 = new Words();
					frame1.setTitle("µ¥´Ê");
					frame1.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Àý¾ä²éÑ¯");
		btnNewButton_3.setBackground(new Color(224, 255, 255));
		btnNewButton_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					Sentence frame2 = new Sentence();
					frame2.setTitle("Àý¾ä");
					frame2.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("´Ê»ã²âÊÔ");
		btnNewButton_7.setBackground(new Color(230, 230, 250));
		btnNewButton_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					Test frame3 = new Test();
					frame3.setVisible(true);
					frame3.setTitle("´Ê»ã²âÊÔ");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_4 = new JButton("¶ÌÎÄ·­Òë");
		btnNewButton_4.setBackground(new Color(250, 240, 230));
		btnNewButton_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					TextTranslation frame4 = new TextTranslation();
					frame4.setVisible(true);
					frame4.setTitle("¶ÌÎÄ·­Òë");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("ÖÆ×÷");
		btnNewButton_5.setBackground(new Color(255, 228, 225));
		btnNewButton_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					Author frame6 = new Author();
					frame6.setVisible(true);
					frame6.setTitle("ÖÆ×÷");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_5);		
		
		JButton btnNewButton_6 = new JButton("ÍË³ö");
		btnNewButton_6.setBackground(new Color(245, 255, 250));
		btnNewButton_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					System.exit(0);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_6);
		
		ImageIcon image = new ImageIcon("begin.png");
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBackground(new Color(255, 255, 240));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}
	

}
