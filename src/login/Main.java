package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import admin.AdminBegin;
import admin.Login;
import player.Begin;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane;

	static Main frame;
	private AdminBegin frame2;
	private Login frame3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main();
					frame.setTitle("HAPPY ENGLISH");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		mainUI();
	}
	
	public void mainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 150));
		
		JLabel lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("”√ªß");
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Begin frame1 = new Begin();
				frame1.setTitle("HAPPY ENGLISH (”√ªß)");
				frame1.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		JLabel label = new JLabel("«Î—°‘Òƒ˙µƒ…Ì∑›");
		label.setForeground(new Color(169, 169, 169));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("π‹¿Ì‘±");
		btnNewButton_1.setForeground(new Color(128, 128, 128));
		btnNewButton_1.setBackground(new Color(255, 192, 203));
		btnNewButton_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame3 = new Login(frame);
				frame3.setTitle("µ«¬º");
				frame3.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("ÕÀ≥ˆ");
		btnNewButton_2.setForeground(new Color(128, 128, 128));
		btnNewButton_2.setBackground(new Color(250, 240, 230));
		btnNewButton_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					System.exit(0);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_1);
	}	

}
