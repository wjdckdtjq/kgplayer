package kgplayer;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class KgplayerMainFrame extends JFrame { //implements ActionListener{
//메인 화면 클래스
   private JTextField searchTextField;
   JButton searchButton;
   
   public KgplayerMainFrame() {
      
      setTitle("KgPlayer");
      setSize(900,900);
      getContentPane().setLayout(null);
      
      JButton button = new JButton("마이페이지");
      button.setBounds(714, 20, 141, 23);
      getContentPane().add(button);
      
      JButton button1 = new JButton("내 음악 리스트");
      button1.setBounds(714, 53, 141, 23);
      getContentPane().add(button1);
      
      JButton button2 = new JButton("포인트 확인");
      button2.setBounds(714, 86, 141, 23);
      getContentPane().add(button2);
      
      searchTextField = new JTextField();
      searchTextField.setBounds(198, 39, 342, 37);
      getContentPane().add(searchTextField);
      searchTextField.setColumns(20);

      //사진 버튼 크기에 맞게 조절
      String img1 = "picture1.png";   //ImageIcon객체를 생성
      ImageIcon originIcon = new ImageIcon(img1);  //ImageIcon에서 Image를 추출
      Image originImg = originIcon.getImage(); 
      Image changedImg= originImg.getScaledInstance(40, 38, Image.SCALE_SMOOTH ); //추출된 Image의 크기를 조절하여 새로운 Image객체 생성
      ImageIcon Icon = new ImageIcon(changedImg);   //새로운 Image로 ImageIcon객체를 생성
      
      searchButton = new JButton(new ImageIcon(changedImg));
      searchButton.setBounds(553, 39, 41, 37);
      getContentPane().add(searchButton);
      
      JPanel panel = new JPanel();
      panel.setBounds(26, 120, 829, 264);
      getContentPane().add(panel);
      panel.setLayout(new FlowLayout());
      panel.add(new SongChart("").chartPanel);
      
//    searchButton.addActionListener(this);
      
      setVisible(true);
      
   }
//
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == searchButton) {
//			ChartData chartData = new ChartData();
//			chartData.setSearchSubject(searchTextField.getText());
//			
//		}
//		
//		
//	}
   
   
      public static void main(String[] args) {
   
         new KgplayerMainFrame();
         

   }


}