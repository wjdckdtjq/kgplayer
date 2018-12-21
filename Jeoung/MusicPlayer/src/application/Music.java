package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Music extends Application {
	Media m;
	MediaPlayer p;
	File file;
	Button btn2,btn3,btn4;
	String path;
	FileChooser fc;
	Slider timeSlider;
	private int count = 3;
	MusicDAO dao = new MusicDAO();
	ArrayList<MusicDTO> list = new ArrayList<>();
	MusicDTO dto = new MusicDTO();
	
	@Override
	public void start(Stage st) throws Exception{

			Slider sl = new Slider();
			HBox root = new HBox();
			Scene scene = new Scene(root,400,300);
			Slider vs = new Slider(0.0, 1.0, 0.0);
			BorderPane vp = new BorderPane();
			Button btn = new Button("노래선택");
			st.setTitle("KG플레이어");
			
			btn.setOnAction(e -> {
				
				fc = new FileChooser();
				file = fc.showOpenDialog(st);
				//fc.getExtensionFilters().addAll(new ExtensionFilter("mp3 File(*.mp3), *mp3"));
				System.out.println(file);
				m = new Media(file.toURI().toString());
				p = new MediaPlayer(m);
				st.setTitle("" + file.getName());
				System.out.println(file.getName());
				list.add(dto);
				
			});
			
			btn2 = new Button("노래재생");
			btn2.setTranslateX(100);
			btn2.setOnMousePressed((event) ->
			{	
				p.play();
				//---------------------------------------------------------카운트 증가
				try {
					int idx = file.getName().lastIndexOf(".");
					dao.countUp(file.getName().substring(0, idx), count-3);
					System.out.println();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}); 
			
			btn3 = new Button("일시정지");
			btn3.setTranslateX(100);
			btn3.setOnMousePressed((event) ->
			{
				p.pause();
			}); 

			btn4 = new Button("노래정지");
			btn4.setTranslateX(100);
			btn4.setOnMousePressed((event) ->
			{
				p.stop();
			}); 

			root.getChildren().add(btn);
			root.getChildren().add(btn2);
			root.getChildren().add(btn3);
			root.getChildren().add(btn4);
			st.setScene(scene);
			
			st.show();
		}

	public static void main(String[] args) {
		//		launch(args);
		Music.launch(Music.class,args);

	}

}

