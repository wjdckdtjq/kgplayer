package application;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.ImageIcon;

public class MyPage extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JTable table;
	static JPanel panel;
	private JPanel panel1;
	private JPanel panel_1;
	private JTable table_1;
	private JTabbedPane tabbedPane;
	private JPanel wrapper_panel;
	private JScrollPane scrollList;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private MemberDAO dao;
	private MemberDTO dto;
	private Vector<Object> dataSet;
	private Vector<String> col;
	static String id;
	static String pw;
	static String name;
	static String tel;
	static String adress;
	static boolean delete;
	
	public MyPage() throws Exception {
		getContentPane().setBackground(Color.WHITE);
		
		id = dto.sessionId;
	    pw = dto.sessionPw;

		setSize(553, 617);
		setTitle("마이페이지");
		getContentPane().setLayout(null);
		
		
		panel1 = new JPanel();
		panel1.setBounds(1, 1, 232, 294);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setBounds(41, 65, 57, 15);
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(41, 111, 57, 15);
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("전화번호");
		lblNewLabel_2.setBounds(41, 155, 57, 15);
		panel1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setBounds(41, 204, 57, 15);
		panel1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 62, 116, 21);
		panel1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 108, 116, 21);
		panel1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 152, 116, 21);
		panel1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.GRAY);
		textField_4.setText("상세주소");
		textField_4.setBounds(179, 201, 230, 23);
		panel1.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("회원수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {		
					if(textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "정보를 입력해주세요");
						
					}else if(textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "정보를 입력해주세요");
						
					}else if(textField_3.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "정보를 입력해주세요");
						
					}else {
						dao = new MemberDAO();
						String search = comboBox.getSelectedItem().toString();
						dao.update(id, textField_1.getText(), textField_2.getText(), textField_3.getText(), search+" "+textField_4.getText());
						col = new Vector<>();
						col.add("Id");
						col.add("Pw");
						col.add("Name");
						col.add("Tel");
						col.add("Address");
						col.add("Point");
						dto = new MemberDTO();
						dto = dao.selectId(id);
						Vector<Comparable> row = new Vector<>();
						row.add(dto.getId());
						row.add(dto.getPw());
						row.add(dto.getName());
						row.add(dto.getTel());
						row.add(dto.getAdress());
						row.add(dto.getPoint());
						dataSet = new Vector<>();
						dataSet.add(row);
						table_1 = new JTable(dataSet, col);
						scrollList = new JScrollPane(table_1);
						scrollList.setBounds(11, 17, 452, 42);
						panel.add(scrollList);
						JOptionPane.showMessageDialog(getContentPane(), "수정되었습니다");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(115, 244, 97, 23);
		panel1.add(btnNewButton_1);
		
		JButton button = new JButton("회원탈퇴");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					dao.delete(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(getContentPane(), "회원탈퇴되었습니다");
				boolean delete =true;
				
				
				dispose();
			}
		});
		button.setBounds(223, 244, 97, 23);
		panel1.add(button);
		String[] locate = { "서울", "광주", "대구", "대전", "부산", "울산", "인천", "제주도", "울릉도", "강원도" };
		comboBox = new JComboBox(locate);
		comboBox.setBounds(100, 201, 67, 21);
		panel1.add(comboBox);
		wrapper_panel = new JPanel(new FlowLayout());
		col = new Vector<>();
		col.add("Id");
		col.add("Pw");
		col.add("Name");
		col.add("Tel");
		col.add("Address");
		col.add("Point");
		dao = new MemberDAO();
		dto = new MemberDTO();
		dto = dao.selectId(id);
		Vector<Comparable> row = new Vector<>();
		row.add(dto.getId());
		row.add(dto.getPw());
		row.add(dto.getName());
		row.add(dto.getTel());
		row.add(dto.getAdress());
		row.add(dto.getPoint());
		dataSet = new Vector<>();
		dataSet.add(row);
		
		btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(textField.getText().equals(pw)) {
						JOptionPane.showMessageDialog(getContentPane(), "확인성공");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField.setVisible(false);
						label.setVisible(false);
						scrollList.setVisible(true);
						scrollPane.setVisible(true);
						btnNewButton.setVisible(false);
						panel_1.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(getContentPane(), "틀렸습니다");
					}
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(389, 120, 97, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(251, 121, 126, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		label = new JLabel("회원비밀번호");
		label.setBounds(169, 124, 83, 15);
		getContentPane().add(label);
		
		label_1 = new JLabel("회원아이디:");
		label_1.setBounds(42, 124, 83, 15);
		getContentPane().add(label_1);
		
		lblNewLabel = new JLabel(id);
		lblNewLabel.setBounds(112, 124, 57, 15);
		getContentPane().add(lblNewLabel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(24, 153, 487, 404);
		getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		
		tabbedPane.addTab("회원수정", null, panel, null);
		
		table_1 = new JTable(dataSet, col);
		scrollList = new JScrollPane(table_1);
		scrollList.setBounds(11, 17, 452, 42);
		scrollList.setVisible(false);
		panel.setLayout(null);
		
		panel.add(scrollList);
		
		scrollPane = new JScrollPane(panel1);
		
		JLabel label_2 = new JLabel("아이디");
		label_2.setBounds(41, 23, 57, 15);
		panel1.add(label_2);
		
		JLabel label_3 = new JLabel(id);
		label_3.setBounds(150, 23, 57, 15);
		panel1.add(label_3);
		
		
		scrollPane.setBounds(11, 69, 452, 296);
		scrollPane.setVisible(false);
		panel.add(scrollPane);
		
		//mylist
		panel_1 = new JPanel(new BorderLayout());
		MemberSong list = new MemberSong();
		panel_1.add(list);
		
		tabbedPane.addTab("mylist", null, panel_1, null);
		
		table = new JTable();
		panel_1.add(table);
		panel_1.setVisible(false);
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setIcon(new ImageIcon("1.PNG"));
		lblNewLabel_4.setBounds(10, 0, 427, 117);
		getContentPane().add(lblNewLabel_4);
		
		
		setVisible(true);
		
		
	}
}
