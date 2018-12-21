package application;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class KgPlayerWriteBbs extends JFrame{
	
	private JTextField textField = null;
	private JTextField textField1 = null;
	KgPlayerBbsDAO dao = new KgPlayerBbsDAO();
	KgPlayerBbsDTO dto = new KgPlayerBbsDTO();
	MemberDTO memDTO;
	public KgPlayerWriteBbs() {
		
		setSize(707,637);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(115, 187, 534, 356);
		getContentPane().add(textField);
		textField.setColumns(200);
		
		textField1 = new JTextField();
		textField1.setBounds(115, 139, 534, 28);
		getContentPane().add(textField1);
		textField1.setColumns(20);
		
		JLabel contentLabel = new JLabel("내용");
		contentLabel.setBounds(37, 300, 93, 47);
		getContentPane().add(contentLabel);
		
		JLabel titleLabel = new JLabel("제목");
		titleLabel.setBounds(37, 129, 93, 47);
		getContentPane().add(titleLabel);
		
		JLabel nameLabel = new JLabel("작성자");
		nameLabel.setBounds(37, 72, 93, 47);
		getContentPane().add(nameLabel);
		memDTO = new MemberDTO();
		JLabel loadNameLabel = new JLabel(memDTO.sessionId+" 님");
		loadNameLabel.setBounds(115, 76, 164, 38);
		getContentPane().add(loadNameLabel);


		setVisible(true);
		

		JButton confirmButton = new JButton("등록");
		confirmButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
				
			if (textField.getText().equals("") || textField1.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"등록 할 수 없습니다. 내용을 작성해주세요");
			} else {
				memDTO = new MemberDTO();
				dto.setId(memDTO.sessionId); //db연결해서 아이디 가져오기
				dto.setTitle(textField1.getText());
				dto.setContent(textField.getText());
				try {
					dao.write(dto);
				} catch (Exception e) {
					e.printStackTrace();
				}		
				JOptionPane.showMessageDialog(null,"등록되었습니다");
				setVisible(false);
				try {
					KgPlayerListBbs main = new KgPlayerListBbs();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}});
		confirmButton.setBounds(185, 553, 164, 38);
		getContentPane().add(confirmButton);
		
		
		JButton backButton = new JButton("목록으로");
		backButton.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
				
			if (JOptionPane.showConfirmDialog(null,"       작성이 취소됩니다","",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
				setVisible(false);
				try {
					KgPlayerListBbs main = new KgPlayerListBbs();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			} else {
			}
			}
		});
		backButton.setBounds(361, 553, 164, 38);
		getContentPane().add(backButton);
		
	}
	
}

