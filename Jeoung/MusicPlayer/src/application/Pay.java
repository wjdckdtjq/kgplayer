package application;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import application.Pay;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Pay extends JPanel {
	int point = 0;
	MemberDAO dao;
	MemberDTO dto;

	int totalP;
	int price;
	String payment;
	String totalC;
	JTextArea textArea;
	public Pay() {
		setSize(954, 555);
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(491, 36, 424, 373);
		add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(58, 36, 408, 373);
		add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("\uD3EC\uC778\uD2B8100\uACB0\uC7AC");
		lblNewLabel.setBounds(57, 82, 94, 18);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("10,000\uC6D0 / + 50\uD3EC\uC778\uD2B8");
		rdbtnNewRadioButton.setBounds(170, 78, 175, 27);
		panel.add(rdbtnNewRadioButton);
		
		JLabel label = new JLabel("\uD3EC\uC778\uD2B8200\uACB0\uC7AC");
		label.setBounds(57, 128, 94, 18);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\uD3EC\uC778\uD2B8300\uACB0\uC7AC");
		label_1.setBounds(57, 174, 94, 18);
		panel.add(label_1);
		
		JRadioButton radioButton = new JRadioButton("20,000\uC6D0 / + 100\uD3EC\uC778\uD2B8");
		radioButton.setBounds(170, 124, 183, 27);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("30,000\uC6D0 / + 150\uD3EC\uC778\uD2B8");
		radioButton_1.setBounds(170, 170, 183, 27);
		panel.add(radioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uACB0\uC7AC\uC218\uB2E8:");
		lblNewLabel_1.setBounds(83, 239, 61, 18);
		panel.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uD604\uAE08");
		rdbtnNewRadioButton_1.setBounds(170, 235, 57, 27);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\uCE74\uB4DC");
		rdbtnNewRadioButton_2.setBounds(254, 235, 57, 27);
		
//		ButtonGroup group = new ButtonGroup();
//		group.add(rdbtnNewRadioButton_1);
//		group.add(rdbtnNewRadioButton_2);
		
//		Enumeration<AbstractButton> enums = group.getElements();
//		int gibonCode = 0;
//		while(enums.hasMoreElements()) {
//			AbstractButton ab = enums.nextElement();
//			JRadioButton jb = (JRadioButton) ab;
//			if(jb.isSelected()) {gibonCode = Integer.parseInt(jb.getText().trim());} 
//			
//		}
		panel.add(rdbtnNewRadioButton_1);
		panel.add(rdbtnNewRadioButton_2);
		
		
		
		JButton btnNewButton = new JButton("\uACB0\uC7AC");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				
				if(rdbtnNewRadioButton_1.isSelected() == false & rdbtnNewRadioButton_2.isSelected() == false) {
					JOptionPane.showMessageDialog(panel,"��������� �������ּ���");
				}else {
					if(rdbtnNewRadioButton.isSelected() == false & radioButton.isSelected() == false & radioButton_1.isSelected() == false) {
						JOptionPane.showMessageDialog(panel,"������ ����Ʈ�� �������ּ���"); 
							
					}else {
								
								JOptionPane.showMessageDialog(panel, "����Ϸ�!!");
								
//								int start = textArea.getSelectionStart(); //���úκ��� ������
//								int end = textArea.getSelectionEnd(); //���úκ��� ����
//								textArea.replaceRange("", start, end); //���ۺκа� ���� ���̸� �������� ��ü
								
								int pay = 0;
								String choice = null;
								
								
								if(rdbtnNewRadioButton.isSelected() == true) {// ����Ʈ 100���� +50
									dao = new MemberDAO();
									dto = new MemberDTO();
									point = 150;
									try {
										dao.pointId(dto.sessionId, point);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									pay = 1;
									choice = "����Ʈ100";
								}else if(radioButton.isSelected() == true) {// ����Ʈ 200���� +100
									dao = new MemberDAO();
									dto = new MemberDTO();
									point = 300;
									try {
										dao.pointId(dto.sessionId, point);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									pay = 2;
									choice= "����Ʈ200";
								}else if(radioButton_1.isSelected() == true) {// ����Ʈ 300���� +150
									dao = new MemberDAO();
									dto = new MemberDTO();
									point = 450;
									try {
										dao.pointId(dto.sessionId, point);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									pay = 3;
									choice = "����Ʈ300";
								}
								int receipt = JOptionPane.showConfirmDialog(panel, "������ ����Ͻðڽ��ϱ� ", "����â",
										JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
								
								if (receipt == 0) {
									
									totalP = 0;
									price = 0;
									
									totalC = choice;
									
//									String totalSum = totalC+ " ";
									payment = null;
									
									if(rdbtnNewRadioButton_1.isSelected() == true) {
										payment = "����";
									}else if(rdbtnNewRadioButton_2.isSelected() == true) {
										payment = "ī��";
									}
									
									if(pay == 1) {
										price += 10000;
									}else if(pay == 2) {
										price += 20000;
									}else if(pay == 3) {
										price += 30000;
									}	
									totalP += price;
									String timeStamp = new SimpleDateFormat("yyy.MM.dd_HH.mm").format(Calendar.getInstance().getTime());
									dto = new MemberDTO();
									String fileName = dto.sessionId+"���� ������("+timeStamp+")";

									try {
//										File name = new File("c://temp//" + fileName + ".txt");
//										OutputStream output = new FileOutputStream(fileName + ".txt");
										FileWriter f = new FileWriter("c://temp//" + fileName + ".txt");
										f.write("===========������===========" + "\r\n");
										f.write("----------���Ÿ��----------" + "\r\n");
										f.write(totalC+ "\r\n");
										f.write("==========�������==========" + "\r\n");
										f.write(payment+ "\r\n");
										f.write("============�ݾ�===========" + "\r\n");
										f.write(totalP+"��");
										f.flush();
										f.close();
										
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									
									textArea.append("===========������===========" + "\r\n");
									textArea.append("----------���Ÿ��----------" + "\r\n");
									textArea.append(totalC+ "\r\n");
									textArea.append("==========�������==========" + "\r\n");
									textArea.append(payment+ "\r\n");
									textArea.append("============�ݾ�===========" + "\r\n");
									textArea.append(totalP+"��\r\n");
								
									
								} else {
									
								}
							
							
					}
						
				
				}
//				
				
					
				
			}
		});
		btnNewButton.setBounds(173, 293, 61, 27);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("KGPlayer\uACB0\uC7AC");
		lblNewLabel_2.setBounds(63, 29, 88, 18);
		panel.add(lblNewLabel_2);
		
		
		setVisible(true);
	}
	public String totalC() {
		return totalC;
	}
	public String payment() {
		return payment;
	}
	public int totalP() {
		return totalP;
	}
	
	
}
