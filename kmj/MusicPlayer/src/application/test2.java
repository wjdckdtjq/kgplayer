package application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.beans.value.ChangeListener;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

import javax.swing.JTextField;

public class test2 extends JFrame implements ActionListener {
   JLabel intro, img;
   JButton play, stop, pause, f;
   MediaPlayer p;
   private JTextField search;
   File c;
   String[] list;
   Media m;
   int count = 4;

   public test2() {
      JFXPanel fx = new JFXPanel();
      JPanel panel = new JPanel();
      FileChooser find = new FileChooser();
      intro = new JLabel("노래제목 검색하세요.");
      img = new JLabel();
      play = new JButton("재생");
      stop = new JButton("정지");
      pause = new JButton("일시정지");
      f = new JButton("노래검색");
      play.addActionListener(this);
      stop.addActionListener(this);
      pause.addActionListener(this);
      f.addActionListener(this);
      setTitle("KG플레이어");
      setSize(200, 200);
      panel.add(intro);

      search = new JTextField(); // 노래검색란
      panel.add(search);
      search.setColumns(10); // 10글자

      panel.add(f);
      panel.add(play);
      panel.add(pause);
      getContentPane().add(panel);

      setVisible(true);
      c = new File("/c:/temp/aaa");
      list = c.list();
      m = new Media("file:/c:/temp/aaa/" + list[count]);
      p = new MediaPlayer(m);
      
   }

   public static void main(String[] args) {
      test2 mp3 = new test2();
   }
   
   
   public void auto() {
      p.play();
      p.setOnEndOfMedia(new Runnable() { //노래 종료시 시작
         public void run() {
            count--;
            m = new Media("file:/c:/temp/aaa/" +list[count]);
            p = new MediaPlayer(m);
            auto();
         }
      });
   }

   @Override
   public void actionPerformed(ActionEvent e) {

      if (e.getSource() == play) {
         this.auto();
         //   p.play();

      }

      if (e.getSource() == stop)

      {
         p.stop();
      }
      if (e.getSource() == pause) {
         p.pause();
      }
      if (e.getSource() == f) {
         JOptionPane.showInputDialog(null, "검색할 노래 입력");
      }
   }
}