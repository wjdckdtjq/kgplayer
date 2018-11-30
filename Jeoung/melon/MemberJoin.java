package melon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

import javafx.scene.control.ComboBox;

import java.awt.Color;
import java.awt.Checkbox;
import javax.swing.ImageIcon;

public class MemberJoin extends JFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	String[] locate;
	JComboBox comboBox;
	String locate1 = "서울"; 
	String locate2 = "인천"; 
	String locate3 = "대구"; 
	String locate4 = "부산"; 
	String locate5 = "울산"; 
	String locate6 = "제주도"; 
	String locate7 = "강원도"; 
	
	public MemberJoin() {
		setSize(500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setBounds(87, 108, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setBounds(87, 153, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC774\uB984");
		lblNewLabel_3.setBounds(87, 202, 57, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_4.setBounds(87, 253, 57, 15);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(180, 105, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 150, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 199, 116, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 250, 116, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("가입");
		btnNewButton.setBounds(199, 366, 97, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"회원정보를 입력하세요");	
					
				}else if(textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"회원정보를 입력하세요");	
					
				}else if(textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"회원정보를 입력하세요");	
					
				}else if(textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"회원정보를 입력하세요");	
					
				}else if(textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"회원정보를 입력하세요");	
				
				}else {
					try {
						int point = 100;
						MemberDAO dao = new MemberDAO();
						MemberDTO dto = new MemberDTO();
						dto.setId(textField.getText());
						dto.setPw(textField_1.getText());
						dto.setName(textField_2.getText());
						dto.setTel(textField_3.getText());
						String search = comboBox.getSelectedItem().toString();
						dto.setAdress(search + textField_4.getText());
						dto.setPoint(point);
						dao.insert(dto);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null,"가입완료");	
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
		btnNewButton_1.setBounds(305, 366, 103, 36);
		getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("\uC8FC\uC18C");
		label.setBounds(87, 305, 57, 15);
		getContentPane().add(label);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.GRAY);
		textField_4.setText("\uC0C1\uC138\uC8FC\uC18C");
		textField_4.setToolTipText("\uC0C1\uC138\uC8FC\uC18C");
		textField_4.setColumns(10);
		textField_4.setBounds(205, 302, 154, 21);
		getContentPane().add(textField_4);
		
		String[] locate = { "서울", "광주", "대구", "대전", "부산", "울산", "인천", "제주도", "울릉도", "강원도" };
		comboBox = new JComboBox(locate);
		comboBox.setBounds(131, 302, 62, 21);
		getContentPane().add(comboBox);
		
		Checkbox checkbox = new Checkbox("");
		checkbox.setBounds(148, 378, 12, 15);
		getContentPane().add(checkbox);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uCEA1\uCCD0\\025.jpg"));
		lblNewLabel_5.setBounds(87, 25, 129, 62);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uCEA1\uCCD0\\033.jpg"));
		lblNewLabel.setBounds(181, 24, 190, 64);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("로봇확인");
		btnNewButton_2.setBounds(63, 368, 108, 33);
		getContentPane().add(btnNewButton_2);
		
		
		setVisible(true);
	}

	
	
	
	
	
	
	public static void main(String[] args) {
		
		MemberJoin mem = new MemberJoin();
	}
}
