package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Player extends BorderPane{
		
	Media media;
	MediaPlayer mediaplayer;
	
	public Player(String name) {
		media = new Media(name);
		mediaplayer = new MediaPlayer(media);
		
	}
	
}
