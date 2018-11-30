package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class Main extends JFrame implements ActionListener{
	JLabel intro, img;
	JButton play, stop, pause,auto;
	MediaPlayer p;
	private JTextField search;
	private JButton button_1;
	
	
	
	int count = 1; //전체 곡 수 
	
	public Main() {
		JFXPanel fx = new JFXPanel();
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 184, 161);
		FileChooser find = new FileChooser();
		
		intro = new JLabel("노래제목 검색하세요.");
		img = new JLabel();
		play = new JButton("재생");
		stop = new JButton("정지");
		pause = new JButton("일시정지");
		auto = new JButton("전체듣기");
		
		play.addActionListener(this);
		stop.addActionListener(this);
		pause.addActionListener(this);
		auto.addActionListener(this);
		
		setTitle("KG플레이어");
		setSize(200, 800);
		getContentPane().setLayout(null);
		panel.add(intro);
		
		search = new JTextField(); //노래검색란
		panel.add(search);
		search.setColumns(10); //10글자
		
		panel.add(play);
		panel.add(stop);
		panel.add(pause);
		panel.add(auto);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("IU-마음");
		lblNewLabel.setBounds(10, 171, 57, 15);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setForeground(Color.RED);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("빅뱅-뱅뱅뱅");
		label.setBounds(0, 207, 87, 15);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setBackground(Color.BLUE);
		getContentPane().add(label);
		
		JButton btnNewButton = new JButton("실행");
		btnNewButton.setBounds(79, 167, 70, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Music maum = new Music();
				maum.maum();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("실행");
		button.setBounds(79, 203, 70, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Music bangbangbang = new Music();
				bangbangbang.bangbangbang();
			}
		});
		getContentPane().add(button);
		
		setVisible(true);
		
		Media m = new Media("file:/c:/temp/1.mp3");
		p = new MediaPlayer(m);
	}
	
	
	
	public static void main(String[] args) {
		Main mp3 = new Main();
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == play) {
			p.play();
		}
		if(e.getSource() == stop) {
			p.stop();
		}
		if(e.getSource() == pause) {
			p.pause();
		}
		if(e.getSource() == auto) {
			AutoPlay au = new AutoPlay();
			au.auto();
		}
		
	}
}
