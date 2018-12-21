package application;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Checkbox;
import javax.swing.ImageIcon;

public class MemberJoin extends JFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JButton btnNewButton_2;
	String[] locate;
	JComboBox comboBox;
	Robot r;
	boolean confirm;
	
	public MemberJoin() {
		getContentPane().setBackground(Color.WHITE);
		
		setSize(490, 648);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(87, 238, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setBounds(87, 283, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setBounds(87, 335, 57, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("전화번호");
		lblNewLabel_4.setBounds(87, 383, 57, 15);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(180, 232, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 280, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 329, 116, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 380, 116, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.setBounds(192, 491, 97, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = new MemberDAO();
				try {
					confirm = dao.idCheck(textField.getText());
					System.out.println(confirm);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(btnNewButton_2.isEnabled() == true) {
					JOptionPane.showMessageDialog(getContentPane(),"로봇확인해주세요");	
				}else {
					
					if (textField.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(),"회원정보를입력하세요");	
						
					}else if(textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(),"회원정보를입력하세요");	
						
					}else if(textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(),"회원정보를입력하세요");	
						
					}else if(textField_3.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(),"회원정보를입력하세요");	
						
					}else if(textField_4.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(),"회원정보를입력하세요");	
						
					}else if(confirm == true){
						JOptionPane.showMessageDialog(getContentPane(),"아이디중복입니다");
					}else if(confirm == false) {
						MemberDTO dto = new MemberDTO();
						try {
							int point = 100;
							
							dto.setId(textField.getText());
							dto.setPw(textField_1.getText());
							dto.setName(textField_2.getText());
							dto.setTel(textField_3.getText());
							String search = comboBox.getSelectedItem().toString();
							dto.setAdress(search + " " +textField_4.getText());
							dto.setPoint(point);
							dao.insert(dto);
							dao.insertSongList(textField.getText());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						File desti = new File("C:\\Users\\user\\Desktop\\"+textField.getText());
						if(!desti.exists()){
								desti.mkdirs(); 
								}else{
									
								}
						JOptionPane.showMessageDialog(getContentPane(),"회원가입완료");	
					}
					
				}		
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(303, 491, 103, 36);
		getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("주소");
		label.setBounds(87, 440, 57, 15);
		getContentPane().add(label);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.GRAY);
		textField_4.setText("상세주소");
		textField_4.setToolTipText("상세주소를 입력해주세요");
		textField_4.setColumns(10);
		textField_4.setBounds(213, 437, 154, 21);
		getContentPane().add(textField_4);
		
		String[] locate = { "서울", "광주", "대구", "대전", "부산", "울산", "인천", "제주도", "울릉도", "강원도" };
		comboBox = new JComboBox(locate);
		comboBox.setBounds(139, 437, 62, 21);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(new ImageIcon("2.jpg"));
		lblNewLabel_5.setBounds(19, 0, 453, 192);
		getContentPane().add(lblNewLabel_5);
		
		btnNewButton_2 = new JButton("로봇확인");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r = new Robot();
				dispose();	
			}
		});
		btnNewButton_2.setBounds(61, 493, 108, 33);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("중복");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberDAO dao = new MemberDAO();
				try {
					confirm = dao.idCheck(textField.getText());
					System.out.println(confirm);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(confirm == true) {
					JOptionPane.showMessageDialog(getContentPane(), "아이디중복");
					
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "사용가능 ");
				}
				
			}
		});
		btnNewButton_3.setBounds(317, 230, 62, 23);
		getContentPane().add(btnNewButton_3);
		setVisible(true);
	}

}
