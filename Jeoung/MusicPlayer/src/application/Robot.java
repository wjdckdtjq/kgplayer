package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

public class Robot {
	
	JButton btnNewButton_1;
	
	MemberJoin mem;
	static int confirm =0;
	
	public Robot() {
		
		JFrame f = new JFrame();
		f.setTitle("·Îº¿È®ÀÎ");
		f.getContentPane().setBackground(Color.WHITE);
		f.setSize(500, 580);
		f.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\\uC0C8 \uD3F4\uB354\\\uC774\uBBF8\uC9C0 8.png"));
		btnNewButton.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setBounds(71, 177, 105, 101);
		f.getContentPane().add(btnNewButton);
		
		JButton button = new JButton();
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button.setEnabled(false);
			}
		});
		button.setBounds(179, 177, 105, 101);
		f.getContentPane().add(button);
		
		JButton button_1 = new JButton();
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button_1.setEnabled(false);
			}
		});
		button_1.setBounds(286, 177, 105, 101);
		f.getContentPane().add(button_1);
		
		JButton button_2 = new JButton();
		button_2.setBackground(Color.WHITE);
		button_2.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button_2.setEnabled(false);
			}
		});
		button_2.setBounds(71, 280, 105, 101);
		f.getContentPane().add(button_2);
		
		JButton button_3 = new JButton();
		button_3.setBackground(Color.WHITE);
		button_3.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button_3.setEnabled(false);
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\\uC0C8 \uD3F4\uB354\\\uC774\uBBF8\uC9C0 8.png"));
		button_3.setBounds(179, 280, 105, 101);
		f.getContentPane().add(button_3);
		
		JButton button_4 = new JButton();
		button_4.setBackground(Color.WHITE);
		button_4.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button_4.setEnabled(false);
			}
		});
		button_4.setBounds(284, 280, 105, 101);
		f.getContentPane().add(button_4);
		
		JButton button_5 = new JButton();
		button_5.setBackground(Color.WHITE);
		button_5.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button_5.setEnabled(false);
			}
		});
		button_5.setBounds(71, 386, 105, 101);
		f.getContentPane().add(button_5);
		
		JButton button_6 = new JButton();
		button_6.setBackground(Color.WHITE);
		button_6.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button_6.setEnabled(false);
			}
		});
		button_6.setBounds(179, 386, 105, 101);
		f.getContentPane().add(button_6);
		
		JButton button_7 = new JButton();
		button_7.setBackground(Color.WHITE);
		button_7.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button_7.setEnabled(false);
			}
		});
		button_7.setBounds(284, 386, 105, 101);
		f.getContentPane().add(button_7);
		
		btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mem = new MemberJoin();
				if(button_2.isEnabled() == false && button_4.isEnabled() == false) {
					JOptionPane.showMessageDialog(f.getContentPane(), "·Îº¿È®ÀÎµÇ¾ú½À´Ï´Ù");
//					confirm = 1;
//					dto = new RobotDTO();
//					dto.setConfirm(2);
					mem.btnNewButton_2.setEnabled(false);
					f.dispose();
					
				}else if(button.isEnabled()== false || button_1.isEnabled()== false || btnNewButton.isEnabled() == false || button_3.isEnabled() == false || button_5.isEnabled() == false || button_6.isEnabled() == false || button_7.isEnabled() == false) {
					JOptionPane.showMessageDialog(f.getContentPane(), "Æ²·È½À´Ï´Ù");
//					confirm = 2;
//					dto = new RobotDTO();
//					dto.setConfirm(1);
					mem.btnNewButton_2.setEnabled(true);
					f.dispose();
					
				}
			}
		});
		
		btnNewButton_1.setBounds(185, 504, 105, 27);
		f.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\uC790\uB3D9\uCC28 \uBE14\uB7ED\uC744 \uACE0\uB974\uC138\uC694");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 16));
		lblNewLabel.setBounds(138, 148, 187, 18);
		f.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("1.PNG"));
		label.setBounds(31, 10, 429, 131);
		f.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("20181210007.png"));
		lblNewLabel_1.setBounds(71, 176, 320, 311);
		f.getContentPane().add(lblNewLabel_1);
		
		btnNewButton.setOpaque(false);
		button.setOpaque(false);
		button_1.setOpaque(false);
		button_2.setOpaque(false);
		button_3.setOpaque(false);
		button_4.setOpaque(false);
		button_5.setOpaque(false);
		button_6.setOpaque(false);
		button_7.setOpaque(false);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		Robot r = new Robot();
	}
	
//	public int confirm() {
//		return confirm;
//	}
}
