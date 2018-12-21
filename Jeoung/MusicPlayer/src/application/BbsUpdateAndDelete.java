package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import com.teamdev.jxbrowser.chromium.HostPortPair;

public class BbsUpdateAndDelete extends JFrame {

	private JTextField textField_1;
	private JTextField textField = null;
	private JTextField textField1 = null;
	KgPlayerBbsDAO dao = new KgPlayerBbsDAO();
	KgPlayerBbsDTO dto = new KgPlayerBbsDTO();
	MemberDTO memDTO;
	
	public BbsUpdateAndDelete () {
		
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
	contentLabel.setBounds(37, 313, 93, 47);
	getContentPane().add(contentLabel);
	
	JLabel titleLabel = new JLabel("제목");
	titleLabel.setBounds(37, 129, 93, 47);
	getContentPane().add(titleLabel);
	
	JLabel nameLabel = new JLabel("작성자(id)");
	nameLabel.setBounds(37, 72, 93, 47);
	getContentPane().add(nameLabel);
	memDTO = new MemberDTO();
	JLabel loadNameLabel = new JLabel(memDTO.sessionId);
	loadNameLabel.setBounds(115, 76, 184, 38);
	getContentPane().add(loadNameLabel);

	setVisible(true);
	
	JButton confirmButton = new JButton("수정");
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
				dao.update(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}		
			JOptionPane.showMessageDialog(null,"수정되었습니다");
			setVisible(false);
			try {
				KgPlayerListBbs main = new KgPlayerListBbs();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}});
	confirmButton.setBounds(113, 553, 164, 38);
	getContentPane().add(confirmButton);
	
	
	JButton backButton = new JButton("목록");
	backButton.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
			
		if (JOptionPane.showConfirmDialog(null,"       작성이 취소됩니다","",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
			setVisible(false);
			try {
				KgPlayerListBbs main = new KgPlayerListBbs();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		} else {
		}
		}
	});
	
	backButton.setBounds(485, 553, 164, 38);
	getContentPane().add(backButton);
	
	JButton deteleButton = new JButton("삭제");
	deteleButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

			String delete = JOptionPane.showInputDialog(null, "정말 삭제하시려면 아이디를 한번더 입력하세요");
			if (delete.equals("")) {
				JOptionPane.showMessageDialog(null,"삭제 할 수 없습니다. 아이디를 입력해주세요");
			} else {
				try {
					dao.delete(delete);
				} catch (Exception e) {
					e.printStackTrace();
				}		
				JOptionPane.showMessageDialog(null,"삭제되었습니다");
				setVisible(false);
				try {
					KgPlayerListBbs main = new KgPlayerListBbs();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	});
	deteleButton.setBounds(297, 553, 164, 38);
	getContentPane().add(deteleButton);
	
	textField_1 = new JTextField();
	textField_1.setColumns(20);
	textField_1.setBounds(115, 85, 184, 28);
	getContentPane().add(textField_1);
	
}
}