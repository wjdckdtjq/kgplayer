package application;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class KgplayerTab {
   

   public JPanel songList() {
      JPanel songList = new JPanel();
      songList.setLayout(null);
      JScrollBar scrollBar1 = new JScrollBar();
      scrollBar1.setBounds(799, 10, 17, 502);
      songList.add(scrollBar1);
      
      JLabel lblSongTitle = new JLabel("  song Title");
      lblSongTitle.setHorizontalAlignment(SwingConstants.LEFT);
      lblSongTitle.setBounds(44, 167, 709, 41);
      songList.add(lblSongTitle);
      
      
      JButton b1 = new JButton();
      
      return songList;
   }
   
   public JPanel recommend() {

      //5개씩 묶기
      JPanel recommend = new JPanel();
      recommend.setLayout(null);
      JScrollBar scrollBar2 = new JScrollBar();
      scrollBar2.setBounds(799, 10, 17, 502);
      recommend.add(scrollBar2);
            
      return recommend;
   }
    
   
   public JPanel populor() {
        //차트, 노래 포함된 패널
      JPanel populor = new JPanel();
      populor.setLayout(null);
      JScrollBar scrollBar3 = new JScrollBar();
      scrollBar3.setBounds(799, 10, 17, 502);
      populor.add(scrollBar3);
      
      return populor;
   }
   
   public JPanel payment() {
        //마이페이지, 노래 둘다 연동
      JPanel payment = new JPanel();
      payment.setLayout(null);
      JScrollBar scrollBar4 = new JScrollBar();
      scrollBar4.setBounds(799, 10, 17, 502);
      payment.add(scrollBar4);
      
      return payment;
   }
   
   public JPanel bbs() {
        
      //게시판
      JPanel bbs = new JPanel();
      bbs.setLayout(null);
      JScrollBar scrollBar5 = new JScrollBar();
      scrollBar5.setBounds(799, 10, 17, 502);
      bbs.add(scrollBar5);
      
      return bbs;
   }
   
   public JPanel mypage() {

      //마이페이지 연결
      JPanel mypage = new JPanel();
      mypage.setLayout(null);
      JScrollBar scrollBar6 = new JScrollBar();
      scrollBar6.setBounds(799, 10, 17, 502);
      mypage.add(scrollBar6);
      
      return mypage;
   }
   
   /**
    * @throws Exception 
    * @wbp.parser.entryPoint
    */
   public JPanel chart() throws Exception {
      
      //통계페이지
      JPanel chart = new JPanel();
      chart.setLayout(null);
      JScrollBar scrollBar6 = new JScrollBar();
      scrollBar6.setBounds(799, 10, 17, 502);
      chart.add(scrollBar6);
      
      JPanel panel = new JPanel();
      panel.setBounds(31, 20, 741, 383);
      panel.setLayout(new FlowLayout());
      panel.add(new SongChart("").chartPanel);
      chart.add(panel);
      
       
      return chart;
   }
   
}

