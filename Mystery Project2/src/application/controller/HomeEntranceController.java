package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class HomeEntranceController extends AbstractSceneSwitchController implements Initializable {
	
	private String musicFile;
	private Media media;
	private AudioClip startGameMedia;
	
	public void switchToKitchen(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/Kitchen.fxml");
	}
	public void switchToBathroom(ActionEvent event) throws IOException{
		super.sceneSwitcher(event, "/application/view/Bathroom.fxml");
	}
	public void switchToBedroom1(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/Bedroom1.fxml");
	}
	public void switchToBedroom2(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/Bedroom2.fxml");
	}
	
	// This method is called upon fxml load
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		musicFile = "Audio/startGame.mp4";
	    media = new Media(Paths.get(musicFile).toUri().toString());
	    startGameMedia = new AudioClip(media.getSource());
	    startGameMedia.setCycleCount(999); // cycle the media 999 times
	    startGameMedia.setVolume(0.2);  // volume can be set 0 - 1
		
		playEntranceMusic();
		
	}
	
	// This method plays the main menu background music.
	public void playEntranceMusic() {
    	
	    startGameMedia.play();
    }
}
