package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import login.Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {
	private JPanel contentPane1;
	private JTextField textField;
	private boolean ifSuccess = false;
	/**
	 * Create the frame.
	 */
	public Login(JFrame frame) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane1.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane1);
		
		JLabel lblNewLabel = new JLabel("π‹¿Ì‘±µ«¬º");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		contentPane1.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane1.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("«Î ‰»Î√‹¬Î");
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		textField = new JPasswordField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("»∑»œ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(textField.getText().equals("112358")) {
					dispose();
					System.out.print(1111);
					AdminBegin frame2 = new AdminBegin();
					frame2.setTitle("HAPPY ENGLISH (π‹¿Ì‘±)");
					frame2.setVisible(true);
				}
				else {
					Notice frame4 = new Notice("√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ ‰»Î°£");
					frame4.setVisible(true);
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		contentPane1.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("∑µªÿ");
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				frame.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnNewButton);	
	}
	
	public boolean loginSuccess() {
		return ifSuccess;
	}
}
