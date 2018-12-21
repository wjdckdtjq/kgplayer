package application;

import kgplayer.audio.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class Player extends JFrame{

	//Other
	DefaultListModel<String> songList = new DefaultListModel<String>();
	ScheduledExecutorService timersExec = Executors.newSingleThreadScheduledExecutor();	
	ScheduledExecutorService titleExec = Executors.newSingleThreadScheduledExecutor();
	float currentAudioDurationSec = 0; 
	//AudioPlayer
	AudioPlayer player = AudioPlayer.getInstance();
	//Components
	JPanel container = new JPanel();
	JButton btnPlay = new JButton();
	JButton btnAdd = new JButton();
	JButton btnNext = new JButton();
	JButton btnPrev = new JButton();
	JButton btnDel = new JButton();
	JButton btnDelAll = new JButton();
	JMenuBar topMenu = new JMenuBar();
	JList<String> jSongList = new JList<String>(songList);
	JLabel lblplaying = new JLabel();
	JLabel lblst = new JLabel();
	JLabel lblet = new JLabel();
	SeekBar seekbar = new SeekBar();
	JFileChooser fc = new JFileChooser();
	MemberDTO dto;
	MemberDAO dao;
	String value;
	int index;
	String songArray;
	//Frames
	WaveformParallelFrame wff = null;
//	FFTParallelFrame fdf = null;
//	public static StatusFrame stf = new StatusFrame();
	//Icons
	ImageIcon frameIcon = new ImageIcon(getClass().getResource("/res/frameicon.png"));
	ImageIcon playIcon = new ImageIcon(getClass().getResource("/res/playicon.png"));
	ImageIcon pauseIcon = new ImageIcon(getClass().getResource("/res/pauseicon.png"));
	
	/**
	 * Class/Frame constructor
	 */
	public Player()
	{
		init();
		initMenu();
		uiBehaviour();
		memberSongList();
	}
	
	/**
	 * Holds and init menu functionality
	 */
	private void initMenu()
	{
		
	}
	
	/**
	 * Init Swing graphics UI 
	 */
	private void init()
	{
		//MainView
//		setIconImage(frameIcon.getImage());
		setTitle("kgplayer");
		int _H = 300;
		int _W = 330;
		setSize(330,442);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//Container
		container.setLayout(null);
		getContentPane().add(container);
		//Buttons
		
		JPanel contBtns = new JPanel();
		contBtns.setBounds(0, 80, 180, 35);
		btnPrev.setText("<<");
		btnPrev.setBounds(0, 0, 50, 35);
		//btnPlay.setText(">");
		btnPlay.setIcon(playIcon);
		btnPlay.setMnemonic(KeyEvent.VK_SPACE);
		btnPlay.setBounds(0, 0, 50, 35);
		btnNext.setText(">>");
		btnNext.setBounds(0, 0, 50, 35);
		btnAdd.setText("노래추가");
		btnAdd.setBounds(_W-80,80,70,35);
		contBtns.add(btnPrev);
		contBtns.add(btnPlay);
		contBtns.add(btnNext);
		container.add(contBtns);
		container.add(btnAdd);
		//Now Playing Panel
		JPanel panelNP = new JPanel();
		panelNP.setLayout(new BoxLayout(panelNP, BoxLayout.PAGE_AXIS));
		panelNP.setToolTipText("Now Playing");
		panelNP.setBorder(BorderFactory.createMatteBorder(1, 0, 2, 0, Color.gray));
		panelNP.setBounds(5, 80-25, _W-15, 20);
		//JLabel lblnp = new JLabel("Now Playing:");
		lblplaying.setText("Now Playing: ");
		lblplaying.setBounds(5, 0, 100, 40);
		//panelNP.add(lblnp);
		panelNP.add(lblplaying);
		container.add(panelNP);
		//SongList
		//jSongList.setBounds(0, line1+50, _W, h_list);
		JScrollPane listScroller = new JScrollPane(jSongList);
		listScroller.setPreferredSize(new Dimension(_W-10,100));
		listScroller.setBounds(0, 130, 320, 273);
		container.add(listScroller);
		//DelBtns
		btnDel.setBounds(193, 85, 45, 30);
		btnDel.setText("X");
		container.add(btnDel);
		//SeekBar
		seekbar.setBounds(5, 10, _W-15, 10);
		container.add(seekbar);
		//Labels song time
		JPanel contSlbl = new JPanel();
		contSlbl.setBounds(10, 15, _W-20, 20);
		contSlbl.add(lblst);
		contSlbl.add(lblet);
		lblst.setText("00:00");
		lblst.setBorder(new EmptyBorder(0, 0, 0, 200));
		lblet.setText("00:00");
		container.add(contSlbl);
	}
	public void memberSongList() {
		File files = new File("C:\\Users\\user\\Desktop\\"+dto.sessionId);
		File[] paths = files.listFiles();
		for (File f : paths) {
			player.addSong(f.getAbsolutePath());
			songList.addElement(f.getName());
			
		}
	}
	
	private void uiBehaviour()
	{
		//File chooser
		fc.setMultiSelectionEnabled(true);
		fc.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "only supported audio files (mp3, wav)";
			}
			
			@Override
			public boolean accept(File f) {
				if(f.isDirectory())
					return true;
				if(f.getName().endsWith(".mp3"))
					return true;
				if(f.getName().endsWith(".wav"))
					return true;
				return false;
			}
			
		});
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(btnAdd);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File[] files = fc.getSelectedFiles();
					for(File f : files){
						player.addSong(f.getAbsolutePath());
						songList.addElement(f.getName());
						log("Added file " + f.getName() + " to playlist");
					}
				}
				else{
					log("파일을찾을수없습니다");
				}
			}
		});
		//노래리스트
		jSongList.setModel(songList);
		jSongList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jSongList.setLayoutOrientation(JList.VERTICAL);
		jSongList.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent evt){
				JList list = (JList)evt.getSource();
				if(evt.getClickCount() == 2){
					log("Double click detected, moving to selected item.");
					index = list.locationToIndex(evt.getPoint());
					player.setIndexSong(index);
					try {
						player.play();
					} catch (BasicPlayerException ev) {
						ev.printStackTrace();
					}
					
					value = jSongList.getSelectedValue();
					
				}else if (evt.getClickCount() == 1) {
					value = jSongList.getSelectedValue();
					
				}
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Executed Outside UI Thread
				
				BackgroundExecutor.get().execute(new Runnable() {
					
					@Override
					public void run() {
						int receipt = JOptionPane.showConfirmDialog(getContentPane(), "정말로 노래를삭제할까요 ", null,
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
						
						if (receipt == 0) {
							File file = new File("C:\\Users\\user\\Desktop\\"+dto.sessionId);
							String value = jSongList.getSelectedValue();
							System.out.println(value);
							
							File[] list = file.listFiles();
							for (File fi : list) {
								if(fi.getName().equals(value)) {
									File deleteF = new File("C:\\Users\\user\\Desktop\\"+dto.sessionId+"\\"+value);
									System.out.println(deleteF);
									if(deleteF.exists()) {
//										deleteF.deleteOnExit();	
										deleteF.delete();
									}
								}
							}
							
							 dto = new MemberDTO();
							 dao = new MemberDAO();
							 MemberSongList songlist = new MemberSongList();
							 songlist.setId(dto.sessionId);
							 
							 try {
								 songlist = dao.selectSongList(songlist);
							 } catch (Exception e2) {
								 // TODO Auto-generated catch block
								 e2.printStackTrace();
							 }
							 
							 String a = songlist.getFileName();
							 String[] b = a.split("[,]");
							 ArrayList<String> array = new ArrayList<String>();
							 Collections.addAll(array, b);
							 if(array.contains(value)) {
								 array.remove(value);
								 songlist.setId(dto.sessionId);
								 
								 for (int i = 0; i < 1; i++) {
								 		songArray = array.get(i).join(",", array);
								 	}
								 System.out.println(songArray);
								 songlist.setFileName(songArray);
								 try {
									 dao.updateAllSongList(songlist);
								 } catch (Exception e1) {
									 // TODO Auto-generated catch block
									 e1.printStackTrace();
								 }
								 JOptionPane.showMessageDialog(getContentPane(), "삭제완료");
							 }else {
								 
							 }
							
							int[] indexes = jSongList.getSelectedIndices();
							
							int removed = 0;
							for(int i : indexes)
							{
								log("Removed Song ("+(i-removed)+")" + songList.get(i-removed));
								player.removeSong(i-removed);
								songList.remove(i-removed);
								
								
								removed++;
							}
						}
					
					}//
				});
			}
		});

		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tooglePlay();
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					player.nextSong();
					//seekbar.resetLastSeek();
				} catch (BasicPlayerException e) {
					log("Error calling the next song");
					e.printStackTrace();
				}
			}
		});
		
		btnPrev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					player.prvSong();
					//seekbar.resetLastSeek();
				} catch (BasicPlayerException e) {
					log("Error calling the previous song");
					e.printStackTrace();
				}
			}
		});

		player.addBasicPlayerListener(new BasicPlayerListener() {
			
			@Override
			public void stateUpdated(BasicPlayerEvent event) {
				if(event.getCode() == BasicPlayerEvent.EOM)
				{
					//seekbar.resetLastSeek();
					try {
						player.nextSong();
					} catch (BasicPlayerException e) {
						e.printStackTrace();
					}
					log("EOM event catched, calling next song.");
				}
				if(event.getCode() == BasicPlayerEvent.PAUSED){
					//btnPlay.setText(">");
					btnPlay.setIcon(playIcon);
				}
				if(event.getCode() == BasicPlayerEvent.RESUMED){
					//btnPlay.setText("||");
					btnPlay.setIcon(pauseIcon);
				}
			}
			
			@Override
			public void setController(BasicController arg0) {}
			
			@Override
			public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {
			}
			@Override
			public void opened(Object arg0, Map arg1) {
				//btnPlay.setText("||");
				btnPlay.setIcon(pauseIcon);
				if (player.getIndexSong() == 0 ) {
					jSongList.setSelectedIndex(player.getIndexSong());
					
				}else if(player.getIndexSong() > 0) {
				}
//				File f = new File(songList.get(index));
				
				lblplaying.setText("Now Playing: " + value);
				
				currentAudioDurationSec = player.getAudioDurationSeconds();
			}
		});
		
		timersExec.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				updateTimers();
				//updatePlayingText();
			}
		}, 0, 1, TimeUnit.SECONDS);
		
		
		titleExec.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				updatePlayingText();
			}
		}, 0, 1, TimeUnit.SECONDS);
		
	}

	private void tooglePlay() throws BasicPlayerException
	{
		if(songList.size() == 0)
			return;
		if(!player.isPaused()){
			player.pause();
			//btnPlay.setText(">");
			btnPlay.setIcon(playIcon);
			}
		else{player.play();}
	}
	
	private void updateTimers(){
		if(!player.isPaused()){
			long lms = player.getProgressMicroseconds();
			String timer0 = Utils.getMinutesRapp(player.getProgressMicroseconds());
			String timer1 = Utils.getMinutesRapp((long)(currentAudioDurationSec*1000000)-player.getProgressMicroseconds());
			lblst.setText(timer0);
			lblet.setText(timer1);
		}
	}
	
	int dispIndex = 0;
	boolean goback = false;
	final static int MAXLblPChar = 36;
	
	private void updatePlayingText(){
		if(player.isPaused())
			return;
		if(songList == null || (songList.size() == 0))
			return;
		String currentSong = songList.get(player.getIndexSong());
		if(currentSong.length() > MAXLblPChar){
			if((MAXLblPChar + dispIndex) >= currentSong.length())
				goback = true;
			if(dispIndex == 0)
				goback = false;
			String cutStr = currentSong.substring(dispIndex, MAXLblPChar+dispIndex);
			lblplaying.setText("Now Playing: " +cutStr);
			if(!goback)
				dispIndex++;
			else
				dispIndex--;
		}
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run()
			{
				Player p = new Player();
				p.setVisible(true);
			}
		});
	}
	
	private void log(String line)
	{
		System.out.println("UI-Main] " + line);
	}
}
