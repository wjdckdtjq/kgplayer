package application;

import java.io.File;
import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
	int maum = 0;
	int bangbangbang = 0;
	MediaPlayer p;
	
//	public void maum() {
//		
//		Media m = new Media("file:/c:/temp/1.mp3");
//		p = new MediaPlayer(m);
//		p.play();
//	}
	
public void bangbangbang() {
		
		Media m2 = new Media("file:/c:/temp/2.mp3");
		p = new MediaPlayer(m2);
		p.play();
	}

public void maum(){
    String bip = "file:/c:/temp/1.mp3";
    Media hit = new Media(Paths.get(bip).toUri().toString());
    p = new MediaPlayer(hit);
    p.play();
}
}

