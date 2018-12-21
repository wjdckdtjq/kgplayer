package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import application.Login;
import application.MemberDTO;
import application.MyPage;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MultipartDataSource;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class  Main extends JFrame implements ActionListener{
 private JLabel intro, img;
 private MediaPlayer p;
 private JTextField textField;
 private JTable table;
 private JButton b1;
 private JPanel wrapper_panel;
 private MusicDAO dao = new MusicDAO();
 private JTextField textField_1;
 JButton button;
 JButton button_1;
 JButton button_2; 
 JButton button_3;
 
 static String id;
 static String pw;
 Pay pay;
 MyPage2 my2;
 
 public Main() throws Exception{
 MemberDTO dto = new MemberDTO();
 
 
  setTitle("KG Player");
  setSize(1000, 1000);
  getContentPane().setLayout(null);
   
  textField = new JTextField();
  textField.setBounds(49, 48, 569, 67);
  getContentPane().add(textField);
  textField.setColumns(10);
  
  JButton btnNewButton = new JButton("검색");
  btnNewButton.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent arg0) {
  		JOptionPane.showMessageDialog(getContentPane(), "로그인후 이용해주세요");
  	}
  });
  btnNewButton.setBounds(644, 47, 80, 68);
  getContentPane().add(btnNewButton);
  
  JButton btnPlay = new JButton("play");
  btnPlay.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(getContentPane(), "로그인후 이용해주세요");
	}
});
  btnPlay.setBounds(629, 287, 97, 23);
  getContentPane().add(btnPlay);
  
  JButton btnNewButton_1 = new JButton("stop");
  btnNewButton_1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(getContentPane(), "로그인후 이용해주세요");
		}
	});
  btnNewButton_1.setBounds(728, 287, 97, 23);
  getContentPane().add(btnNewButton_1);
  
  JButton btnNewButton_2 = new JButton("pause");
  btnNewButton_2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(getContentPane(), "로그인후 이용해주세요");
		}
	});
  btnNewButton_2.setBounds(829, 287, 97, 23);
  getContentPane().add(btnNewButton_2);
  
  JButton btnNewButton_5 = new JButton("파일 불러오기");
  btnNewButton_5.setBounds(410, 287, 207, 23);
  getContentPane().add(btnNewButton_5);
  
  JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
  tabbedPane.setBounds(12, 395, 960, 556);
  getContentPane().add(tabbedPane);
  
  MusicList list = new MusicList();
  JPanel panel_1 = new JPanel(new BorderLayout()); 
  tabbedPane.addTab("최신노래", null, panel_1, null);
  panel_1.add(list.scrollList);
  
  JPanel panel = new JPanel();
  panel_1.add(panel, BorderLayout.SOUTH);
  
  JLabel lblNewLabel = new JLabel("노래삭제");
  panel.add(lblNewLabel);
  
  textField_1 = new JTextField();
  panel.add(textField_1);
  textField_1.setColumns(10);
  
  JButton Del_button = new JButton("?");
  Del_button.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		try {
			dao.delete(textField.getText());
			JOptionPane.showMessageDialog(wrapper_panel,"삭제완료");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

  	}
  });
  panel.add(Del_button);
  
  JPanel panel_2 = new JPanel();
  tabbedPane.addTab("추천목록", null, panel_2, null);

  JPanel panel_3 = new JPanel();
  tabbedPane.addTab("인기노래", null, panel_3, null);

  JPanel panel_4 = new JPanel();
  pay = new Pay();
  panel_4.add(pay);
  tabbedPane.addTab("바로결재", null, panel_4 , null);
  panel_4.setVisible(false);

  JPanel panel_5 = new JPanel();
  my2 = new MyPage2();
  panel_5.add(my2);
  tabbedPane.addTab("마이페이지", null, panel_5, null);
  panel_5.setVisible(false);
  
  JPanel panel_6 = new JPanel();
  tabbedPane.addTab("자유게시판", null, panel_6, null);
  
  JPanel panel_7 = new JPanel();
  tabbedPane.addTab("차트분석", null, panel_7, null);
  
  if(dto.sessionId != null) {
	  panel_5.setVisible(true);
  }
  button = new JButton("로그인");
  button.addActionListener(new ActionListener() { //로그인버튼
		@Override
		public void actionPerformed(ActionEvent e) {
			Login log= new Login();
			panel_4.setVisible(true);
			dispose();
		}
	  });
  button.setBounds(746, 48, 208, 67);
  getContentPane().add(button);
  
  button_1 = new JButton("로그아웃");
  button_1.addActionListener(new ActionListener() { //로그아웃버튼
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(getContentPane(), "로그아웃되었습니다");
			panel_4.setVisible(false);
			panel_5.setVisible(false);
			button.setVisible(true);
			button_1.setVisible(false);
			button_2.setVisible(false);
			button_3.setVisible(false);
		
		}
	  });
  button_1.setBounds(857, 48, 97, 34);
  getContentPane().add(button_1);
  
  button_2 = new JButton("마이페이지");
  button_2.addActionListener(new ActionListener() { //마이페이지버튼
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				MyPage my = new MyPage();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	  });
  button_2.setBounds(746, 92, 97, 23);
  getContentPane().add(button_2);
  
  button_3 = new JButton("플레이어");
  button_3.addActionListener(new ActionListener() { //플에이어버튼
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	  });
  button_3.setBounds(857, 92, 97, 23);
  getContentPane().add(button_3);
  
  JLabel lblNewLabel_1 = new JLabel("아이디:");
  lblNewLabel_1.setBounds(746, 58, 51, 15);
  getContentPane().add(lblNewLabel_1);
  
  JLabel lblNewLabel_2 = new JLabel(dto.sessionId);
  lblNewLabel_2.setBounds(809, 58, 58, 15);
  getContentPane().add(lblNewLabel_2);
 
  setVisible(true);
 }


 @Override
 public void actionPerformed(ActionEvent e) {
	 
 }
 
}