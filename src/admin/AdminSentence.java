package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class AdminSentence extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminSentence() {
		AdminSentenceUI();
	}
	
	public void AdminSentenceUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("¼������");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NewSentence frame = new NewSentence();
					frame.setTitle("¼�뵥��");
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�༭����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModSentence frame1 = new ModSentence();
					frame1.setTitle("�༭����");
					frame1.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ɾ������");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DeleteSentence frame2 = new DeleteSentence();
					frame2.setTitle("�༭����");
					frame2.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("����");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(btnNewButton_3);
	}

}
