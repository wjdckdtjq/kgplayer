package application;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberFind extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	MemberDAO dao = new MemberDAO();
	public MemberFind() {
		getContentPane().setBackground(Color.WHITE);
		setSize(407, 326);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(134, 65, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 213, 116, 21);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel = new JLabel("아이디찾기");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(47, 29, 75, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("회원찾기");
		label.setBounds(47, 68, 75, 15);
		getContentPane().add(label);
		
		JButton btnNewButton = new JButton("찾기"); 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				try {
					MemberDTO dto = new MemberDTO();
					dto = dao.selectName(textField.getText());
					if(dto.getName() != null) {
						JOptionPane.showMessageDialog(getContentPane(), "확인완료");
						textField_2.setText(dto.getId());
					}else {
						JOptionPane.showMessageDialog(getContentPane(), "회원이름이 없습니다");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(272, 64, 69, 23);
		getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("회원아이디");
		label_1.setBounds(47, 219, 75, 15);
		getContentPane().add(label_1);
		
		JButton button = new JButton("찾기"); 
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					MemberDTO dto = new MemberDTO();
					dto = dao.selectId(textField_1.getText());
				
					if(dto.getId() != null) {
						JOptionPane.showMessageDialog(getContentPane(), "확인완료");
						textField_3.setText(dto.getPw());
					}else {
						JOptionPane.showMessageDialog(getContentPane(), "회원아이디가없습니다");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(272, 212, 69, 23);
		getContentPane().add(button);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(134, 96, 116, 21);
		getContentPane().add(textField_2);
		
		JLabel label_2 = new JLabel("비밀번호찾기");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setBounds(47, 183, 75, 15);
		getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(134, 244, 116, 21);
		getContentPane().add(textField_3);
		
		JLabel label_3 = new JLabel("찾는아이디>>");
		label_3.setBounds(47, 99, 81, 15);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("찾는비밀번호>>");
		label_4.setBounds(41, 247, 97, 15);
		getContentPane().add(label_4);
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		MemberFind f = new MemberFind();
	}
}
