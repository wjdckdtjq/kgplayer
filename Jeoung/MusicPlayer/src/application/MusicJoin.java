package application;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import application.MemberDAO;
import application.MemberDTO;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MusicJoin extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public MusicJoin() {
		setSize(400, 350);
		getContentPane().setLayout(null);
		
		JLabel label1 = new JLabel("\uB178\uB798\uC81C\uBAA9");
		label1.setFont(new Font("노래제목", Font.PLAIN, 20));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(55, 44, 115, 33);
		getContentPane().add(label1);
		
		JLabel label = new JLabel("\uAC00\uC218");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("가수", Font.PLAIN, 20));
		label.setBounds(55, 93, 115, 33);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uCE74\uC6B4\uD2B8");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("카운트", Font.PLAIN, 20));
		label_1.setBounds(55, 136, 115, 33);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uB178\uB798\uC21C\uC11C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("노래순서", Font.PLAIN, 20));
		label_2.setBounds(55, 184, 115, 33);
		getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("", Font.PLAIN, 20));
		textField.setBounds(168, 47, 150, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(168, 94, 150, 25);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(168, 139, 150, 25);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(168, 187, 150, 25);
		getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("노래등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MusicDAO dao = new MusicDAO();
					MusicDTO dto = new MusicDTO();
					dto.setSongName(textField.getText());
					dto.setSinger(textField_1.getText());
					dto.setCount((Integer.parseInt(textField_2.getText())));
					dto.setNum((Integer.parseInt(textField_3.getText())));
					
					dao.insert(dto);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "등록완료");
			}
		});
		btnNewButton.setBounds(86, 265, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("나가기");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		btnNewButton_1.setBounds(209, 265, 97, 23);
		getContentPane().add(btnNewButton_1);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MusicJoin();
	}
}
