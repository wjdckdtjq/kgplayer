package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
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
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import application.KgplayerTab;
import application.Login;
import application.MemberDTO;
import application.MyPage;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MultipartDataSource;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class  MemberMain extends JFrame implements ActionListener , MouseListener{
 private JLabel intro, img;
 private JTextField textField;
 private JButton b1;
 private JPanel wrapper_panel;
 private MusicDAO dao = new MusicDAO();
 private KgplayerTab Tabsetting = new KgplayerTab();
 private JTextField textField_1;
 private JLabel lblNewLabel_1;
 private JTable table;
 private JTable table2;
 private JTable table3;
 private JScrollPane scrollPane;
 private ArrayList<MusicDTO> list;
 private JComboBox comboBox;
 private JComboBox comboBox_1;
 private MusicDTO musicDTO;
 private MusicDAO mucisDAO;
 private DefaultTableModel dtm;
 static Stage st = null;
 static String rowCount2;
 JButton button_1;
 JButton button_2;
 JButton button_3;
 JPanel panel;
 JPanel panel_1;
 JPanel panel_2;
 JPanel panel_3;
 JPanel panel_4;
 JPanel panel_5;
 private FileInputStream input = null;
 private FileOutputStream output = null;
 Pay pay;
 MyPage2 my2;
 MemberDTO dto;
 File file;
 FileChooser fc;
 private MediaPlayer p, pmv;
 JButton btnPlay,btnPause,btnStop;
 MediaView mv;
 
 public MemberMain() throws Exception{
  dto = new MemberDTO();
  setTitle("KG Player");
  setSize(1000, 1040);
  getContentPane().setLayout(null);
  
  JLabel mainGifLabel = new JLabel(new ImageIcon("1982736309_YRKGrF69_152774369770630.gif"));
  mainGifLabel.setBounds(37, 125, 733, 337);
  getContentPane().add(mainGifLabel);
  
  textField = new JTextField();
  textField.setFont(new Font("굴림", Font.PLAIN, 30));
  textField.setBounds(49, 40, 569, 75);
  getContentPane().add(textField);
  textField.setColumns(10);
  
  JButton btnNewButton = new JButton(new ImageIcon("picture1.png")); //검색
  btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			table.removeAll();
		         String select = comboBox_1.getSelectedItem().toString();
		         if (select.equals("노래제목")) {
		            ArrayList list2 = new ArrayList();			   
		            for (int i = 0; i < list.size(); i++) {
		            	musicDTO = new MusicDTO();
		            	musicDTO = (MusicDTO) list.get(i);
		               if (musicDTO.getSongName().indexOf(textField.getText()) != -1) {
		                  list2.add(musicDTO);
		               }
		               
		            }
		            
		            String[] col = { "노래제목", "가수", "카운터", "노래순서"};
		            Object[][] row2 = new Object[list2.size()][col.length];
		            
		            for (int i = 0; i < list2.size(); i++) {
		            	musicDTO = new MusicDTO();
		            	musicDTO = (MusicDTO) list2.get(i);
		            	row2[i][0] = musicDTO.getSongName();
		    		    row2[i][1] = musicDTO.getSinger();
		    		    row2[i][2] = musicDTO.getCount();
		    		    row2[i][3] = musicDTO.getNum();
		            }
		            
		            dtm = new DefaultTableModel(row2, col) {
		               public boolean isCellEditable(int a, int column) {
		                  return false;
		               }
		            };
		            table2 = new JTable(dtm);
		            scrollPane = new JScrollPane(table2);
		            scrollPane.setBounds(0, 0, 955, 417);
		            panel_1.add(scrollPane);
		            table2.setDragEnabled(false);
		         }  

		         else if (select.equals("가수")) {
		            ArrayList list2 = new ArrayList();
		            
		            for (int i = 0; i < list.size(); i++) {
		            	musicDTO = new MusicDTO();
		            	musicDTO = (MusicDTO) list.get(i);
		               if (musicDTO.getSinger().indexOf(textField.getText()) != -1) {
		                  list2.add(musicDTO);
		               }
		               
		            }
		            
		            String[] col = { "노래제목", "가수", "카운터", "노래순서"};			            
		            Object[][] row3 = new Object[list2.size()][col.length];
		            for (int i = 0; i < list2.size(); i++) {
		            	musicDTO = new MusicDTO();
		            	musicDTO = (MusicDTO) list2.get(i);
		            	row3[i][0] = musicDTO.getSongName();
		    		    row3[i][1] = musicDTO.getSinger();
		    		    row3[i][2] = musicDTO.getCount();
		    		    row3[i][3] = musicDTO.getNum();
		            }
		            dtm = new DefaultTableModel(row3, col) { 
		               public boolean isCellEditable(int a, int column) {
		                  return false;
		               }
		            };
		            table3 = new JTable(dtm);
		            scrollPane = new JScrollPane(table3);
		            scrollPane.setBounds(0, 0, 955, 417);
		            panel_1.add(scrollPane);
		            table3.setDragEnabled(false);
		         }else if(textField.equals("")) {
		        	 getContentPane().add(table);
		        	
		         }else {
					
					}
		         
		
		}
	});
  btnNewButton.setBounds(630, 23, 94, 92);
  getContentPane().add(btnNewButton);
  
  btnPlay = new JButton("play");
  btnPlay.setBounds(809, 335, 57, 54);
  getContentPane().add(btnPlay);
  
  btnStop = new JButton("stop");
  btnStop.setBounds(878, 335, 69, 23);
  getContentPane().add(btnStop);
  
  btnPause = new JButton("pause");
  btnPause.setBounds(878, 366, 69, 23);
  getContentPane().add(btnPause);
  
  JButton btnNewButton_5 = new JButton("파일 불러오기");
  btnNewButton_5.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  		Music music = new Music();
	  		try {
				music.main(null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  	}
	  });
  btnNewButton_5.setBounds(809, 399, 142, 34);
  getContentPane().add(btnNewButton_5);
  
  JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
  tabbedPane.setBounds(12, 472, 960, 479);
  getContentPane().add(tabbedPane);
  
  

  //음악리스트
  
  panel_1 = new JPanel(); 
  tabbedPane.addTab("노래", null, panel_1, null);
  panel_1.setLayout(null);
  scrollPane = new JScrollPane();
  scrollPane.setBounds(0, 0, 955, 417);
  panel_1.add(scrollPane);
  
	mucisDAO = new MusicDAO();
	list = new ArrayList<MusicDTO>();
	try {
		list = mucisDAO.selectAll();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String[] col = { "노래제목", "가수", "카운터", "노래순서"};
	
	Object[][] row = new Object[list.size()][col.length];
	for (int i = 0; i < list.size(); i++) {
		musicDTO = new MusicDTO();
		musicDTO = (MusicDTO) list.get(i);
		row[i][0] = musicDTO.getSongName();
	    row[i][1] = musicDTO.getSinger();
	    row[i][2] = musicDTO.getCount();
	    row[i][3] = musicDTO.getNum();
	 
	}
	 dtm = new DefaultTableModel(row, col) {
       public boolean isCellEditable(int row, int column) {
          return false;
       }
    };
	
	table = new JTable(dtm);
	scrollPane.setViewportView(table);
  
  //
  panel = new JPanel();
  panel.setBounds(0, 417, 955, 33);
  panel_1.add(panel);
  
  JLabel lblNewLabel = new JLabel("삭제할노래");
  panel.add(lblNewLabel);
  
  textField_1 = new JTextField();
  panel.add(textField_1);
  textField_1.setColumns(10);
  
  JButton Del_button = new JButton("노래삭제");
  Del_button.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		try {
  			mucisDAO.delete(textField.getText());
			JOptionPane.showMessageDialog(wrapper_panel, "삭제완료");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
  		
  	}
  });
  panel.add(Del_button);
  
//  panel_2 = new JPanel();
//  tabbedPane.addTab("추천목록", null, panel_2, null);
//  //
//  panel_3 = new JPanel();
//  tabbedPane.addTab("인기노래", null, panel_3, null);
  //결재
  panel_4 = new JPanel(new BorderLayout());
  pay = new Pay();
  panel_4.add(pay);
  tabbedPane.addTab("바로결재", null, panel_4 , null);
  
  
  //마이페이지
  panel_5 = new JPanel(new BorderLayout());
  my2 = new MyPage2();
  panel_5.add(my2);
  tabbedPane.addTab("마이페이지", null, panel_5, null);
  
  JPanel panel_6 = new JPanel(new BorderLayout());
  KgPlayerListBbs bbs = new KgPlayerListBbs();
  panel_6.add(bbs);
  tabbedPane.addTab("자유게시판", null, panel_6, null);
  
  JPanel panel_7 = new JPanel(new BorderLayout());
  panel_7.add(Tabsetting.chart());
  tabbedPane.addTab("차트분석", null, panel_7, null);
  
  button_1 = new JButton(dto.sessionId+"님 로그아웃");
  button_1.addActionListener(new ActionListener() { //로그아웃버튼
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(getContentPane(), "로그아웃되었습니다");
			
			button_1.setVisible(false);
			button_2.setVisible(false);
			button_3.setVisible(false);
			try {
				Login name = new Login();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
		}
	  });
  button_1.setBounds(746, 23, 208, 34);
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
  button_2.setBounds(746, 67, 97, 48);
  getContentPane().add(button_2);
  
  button_3 = new JButton("플레이어");
  button_3.addActionListener(new ActionListener() { //플레이어버튼
		@Override
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run()
				{
					Player p = new Player();
					p.setVisible(true);
				}
			});
		}
	  });
  button_3.setBounds(857, 67, 97, 48);
  getContentPane().add(button_3);
  
  JLabel lblNewLabel_3 = new JLabel(new ImageIcon(""));
  lblNewLabel_3.setBounds(782, 125, 172, 198);
  getContentPane().add(lblNewLabel_3);
  
  JButton button_4 = new JButton("my리스트 추가");
  button_4.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dto = new MemberDTO();
		MemberSongList list = new MemberSongList();
		MemberDAO dao = new MemberDAO();
		list.setId(dto.sessionId);
		
		try {
			list = dao.selectSongList(list);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 	
		 String a = list.getFileName();
		 String[] b = a.split("[,]");
		 ArrayList<String> array = new ArrayList<String>();
		 Collections.addAll(array, b);
		 if(rowCount2 == null) {
			 JOptionPane.showMessageDialog(getContentPane(), "음악리스트를 골라주세요");
		 }else {
			 
			 if(array.contains(rowCount2+".mp3")) {
				 System.out.println(rowCount2+".mp3");
				 JOptionPane.showMessageDialog(getContentPane(), "이미 my리스트항목에 있습니다");
			 }else {
				 
				 try {
					dto = (MemberDTO) dao.selectId(dto.sessionId);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 System.out.println(dto.getPoint());
				if(dto.getPoint() <= 0) {
					JOptionPane.showMessageDialog(getContentPane(), "포인트충전해주세요");
				}else {
					
					try {
						dao.pointId(dto.sessionId, -3 );
						JOptionPane.showMessageDialog(getContentPane(), "P-3차감(잔여P>"+ (dto.getPoint()-3)+")");
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try{    
						input = new FileInputStream(new File("C:\\Users\\user\\Desktop\\music\\"+rowCount2+".mp3"));
						output = new FileOutputStream(new File("C:\\Users\\user\\Desktop\\"+dto.sessionId+"\\"+rowCount2+".mp3"));            
						int readBuffer;
						byte [] buffer = new byte[512];
						while((readBuffer = input.read(buffer)) != -1) {
							output.write(buffer, 0, readBuffer);
						}
						JOptionPane.showMessageDialog(getContentPane(), "my리스트에 추가되었습니다");
					} catch (IOException e3) {
						System.out.println(e3);
					} finally {
						try{
							input.close();
							output.close();
						} catch(IOException io) {}
					}
					
					list.setId(dto.sessionId);
					String fName = rowCount2+".mp3";
					list.setFileName(fName);
					try {
						dao.updateSongList(list);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			 }
		 }
	}
});
  button_4.setBounds(809, 444, 142, 34);
  getContentPane().add(button_4);
  
  String[] search = {"노래제목", "가수"};
  comboBox_1 = new JComboBox(search);
  comboBox_1.setBounds(49, 9, 81, 21);
  getContentPane().add(comboBox_1);
  
  lblNewLabel_1 = new JLabel("Now Playing: ");
  
  lblNewLabel_1.setBounds(809, 301, 138, 15);
  getContentPane().add(lblNewLabel_1);

  table.addMouseListener(this);
  btnPlay.addActionListener(this);
  btnStop.addActionListener(this);
  btnPause.addActionListener(this);
  
  setVisible(true);
 }
public static void main(String[] args) throws Exception {
	new Main();
}

 @Override
 public void actionPerformed(ActionEvent e) {
	 
	 if(e.getSource() == btnPlay) {

		 lblNewLabel_1.setText("Now Playing: "+ rowCount2+".mp3");
	        p.play();
	        p.setOnEndOfMedia(new Runnable() {
	          
	          @Override
	          public void run() {
	             Media m = new Media("file:/C:/Users/user/Desktop/music/" + URLEncoder.encode(rowCount2).replace("+", "%20") + ".mp3");
	             p = new MediaPlayer(m);
	             
	          }
	       });
	     }
	     if(e.getSource() == btnPause) {
	        p.pause();
	     }
	     if(e.getSource() == btnStop) {
	        p.stop();
	     }

 }
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getClickCount() == 1) {
		int[] selection = table.getSelectedRows();
		   for (int i = 0; i < selection.length; i++) {
		     selection[i] = table.convertRowIndexToModel(selection[i]);
		     rowCount2 = (String) table.getValueAt(selection[i],0);
		}
		   System.out.println(rowCount2);
		  
		   JFXPanel fx = new JFXPanel();
	         if(rowCount2 ==null) {
	              JOptionPane.showMessageDialog(getContentPane(), "음악을골라주세요");
	           }else {
	        	  
	              Media m = new Media("file:/C:/Users/user/Desktop/music/" + URLEncoder.encode(rowCount2).replace("+", "%20") + ".mp3");
	              p = new MediaPlayer(m);
	              
	           }

	}
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

public String rowCount2() {
	return rowCount2;
}
}