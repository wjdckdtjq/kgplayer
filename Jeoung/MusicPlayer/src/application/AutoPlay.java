package application;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AutoPlay {
	private MediaPlayer p;
	private File c;
	private String[] list;
	private Media m;
	private int count = 1;

	public void auto() {

		c= new File("C:/Temp/music");
		list = c.list();
		m = new Media("file:/C:/Temp/music/" + list[count]);
		p = new MediaPlayer(m);

		p.play();
		p.setOnEndOfMedia(new Runnable() {
			public void run() {
				count--;
				m = new Media("C:/Temp/music" + list[count]);
				p = new MediaPlayer(m);
				auto();
			}
		});
	}
}


