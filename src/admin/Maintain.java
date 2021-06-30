package admin;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Maintain extends JFrame {

	private JPanel contentPane;
	private JFileChooser fileChooser = new JFileChooser();

	/**
	 * Create the frame.
	 */
	public Maintain() {
		maintainUI();
	}
	
	public void maintainUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("请选择操作：");
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("备份");
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("恢复");
		panel.add(rdbtnNewRadioButton_1);
		
		ButtonGroup option = new ButtonGroup();
		option.add(rdbtnNewRadioButton_1);
		option.add(rdbtnNewRadioButton);
		
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rdbtnNewRadioButton.isSelected() == true)
					{	
						int result = 0;
						String path = null;
						JFileChooser fileChooser = new JFileChooser();
						FileSystemView fsv = FileSystemView.getFileSystemView();  //注意了，这里重要的一句
						System.out.println(fsv.getHomeDirectory());                //得到桌面路径
						fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
						fileChooser.setDialogTitle("请选择要备份的位置...");
						fileChooser.setApproveButtonText("确定");
						fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						result = fileChooser.showOpenDialog(contentPane);
						if (JFileChooser.APPROVE_OPTION == result) {
						    	   path=fileChooser.getSelectedFile().getPath();
						    	   System.out.println(path);
						   }
						SimpleDateFormat sd=new SimpleDateFormat("yyyyMMddHHmmss");			
					    new Backup("root","112358","happyenglish",path,"erpDB_"+sd.format(new Date())+".sql");						
					}
					else if(rdbtnNewRadioButton_1.isSelected() == true)
					{
						int result = 0;
						String path = null;
						JFileChooser fileChooser = new JFileChooser();
						FileSystemView fsv = FileSystemView.getFileSystemView();  //注意了，这里重要的一句
						System.out.println(fsv.getHomeDirectory());                //得到桌面路径
						fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
						fileChooser.setDialogTitle("请选择要恢复的文件...");
						fileChooser.setApproveButtonText("确定");
						fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						result = fileChooser.showOpenDialog(contentPane);
						if (JFileChooser.APPROVE_OPTION == result) {
						    	   path=fileChooser.getSelectedFile().getPath();
						    	   System.out.println(path);
						    	   new Load("root","112358","happy",path);
						   }
						
					}
					else			//没有选按钮便提交
					{
						Notice frame = new Notice("请选择备份或恢复");
						frame.setVisible(true);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
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
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(7, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_3.add(lblNewLabel_3);
	}

}
