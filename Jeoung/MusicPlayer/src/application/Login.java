package application;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {
	 JTextField textField;
	 JTextField textField_1;
	private JButton button;
	public JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private MemberDAO dao;
	private JButton btnNewButton_3;
	static boolean confirm; 
	
	public Login() {
		getContentPane().setBackground(Color.WHITE);
		
		setSize(550, 450);
		getContentPane().setLayout(null);

		btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("admin") && textField_1.getText().equals("1234")) {
					JOptionPane.showMessageDialog(getContentPane(),"관리자모드");
					textField.setVisible(false);
					textField_1.setVisible(false);
					button.setVisible(false);
					btnNewButton.setVisible(false);
					btnNewButton_1.setVisible(false);
//					lblNewLabel_1.setVisible(false);;
					label.setVisible(false);;
					label_1.setVisible(false);;
					btnNewButton_2.setVisible(true);
					btnNewButton_3.setVisible(true);
					
				}else {
					try {
						dao = new MemberDAO();
						MemberDTO dto = dao.select(textField.getText());
						if(dto != null) {
							if(dto.getPw().equals(textField_1.getText())) {
							confirm = true;
							MemberDTO.sessionId = textField.getText();
							MemberDTO.sessionPw = textField_1.getText();
							MemberMain main = new MemberMain();
							main.button_1.setVisible(true);
							main.button_2.setVisible(true);
							main.button_3.setVisible(true);
							main.panel_4.setVisible(true);
							main.panel_5.setVisible(true);
							JOptionPane.showMessageDialog(getContentPane(),"로그인성공");
							dispose();
							
								
							}else {
								JOptionPane.showMessageDialog(getContentPane(),"비밀번호가 틀렸습니다");
//						
							}
						}else {
							JOptionPane.showMessageDialog(getContentPane(),"아이디가 없습니다");
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

			}
		});
		btnNewButton.setBounds(293, 225, 107, 54);
		getContentPane().add(btnNewButton);
		
		button = new JButton("회원가입");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberJoin join = new MemberJoin();
			}
		});
		button.setBounds(165, 307, 116, 23);
		getContentPane().add(button);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("1.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(47, 0, 441, 173);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(165, 225, 116, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 258, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("회원찾기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberFind find = new MemberFind();
				
			}
		});
		btnNewButton_1.setBounds(293, 307, 107, 23);
		getContentPane().add(btnNewButton_1);
		
		label = new JLabel("아이디");
		label.setBounds(80, 229, 57, 15);
		getContentPane().add(label);
		
		label_1 = new JLabel("비밀번호");
		label_1.setBounds(80, 264, 57, 15);
		getContentPane().add(label_1);
		
		btnNewButton_2 = new JButton("회원정보");
		btnNewButton_2.setVisible(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MemberList list = new MemberList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(149, 211, 99, 51);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("뒤로");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setVisible(true);
				textField_1.setVisible(true);
				button.setVisible(true);
				btnNewButton.setVisible(true);
				btnNewButton_1.setVisible(true);
//				lblNewLabel_1.setVisible(true);;
				label.setVisible(true);;
				label_1.setVisible(true);;
				btnNewButton_2.setVisible(false);
				btnNewButton_3.setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(260, 211, 107, 51);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.setVisible(false);
		
		setVisible(true);
		
	}
	public static void main(String[] args) throws Exception {
		Login name = new Login();
	}
}
