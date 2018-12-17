package kgplayer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JFrame;
import javafx.scene.media.*;

public class MvTest extends JFrame{
	
	private File Mvfile;
	private Player mediaPlayer;
	
	public MvTest() { 
     
	Mvfile = new File("HarmlessAgonizingCatbird.webm");
	
	setSize(600, 300);
    setLayout(new BorderLayout()); 
     
     URL mediaURL = null;
	try {
		mediaURL = Mvfile.toURI().toURL();
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
     try {
		mediaPlayer = Manager.createRealizedPlayer(mediaURL);
	} catch (NoPlayerException e) {
		e.printStackTrace();
	} catch (CannotRealizeException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} 
     Component video = mediaPlayer.getVisualComponent(); 
     Component controls = mediaPlayer.getControlPanelComponent(); 
     add(video,BorderLayout.CENTER); 
     add(controls,BorderLayout.SOUTH); 
     
     setVisible(true);
     
     
    } 
 

	public static void main(String[] args) {
		
		new MvTest();
		
	}
	
	
}
