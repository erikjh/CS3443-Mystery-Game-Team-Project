package application.controller;

import java.io.IOException;
import java.nio.file.Paths;

import application.model.GameData;
import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class Bedroom1Controller extends AbstractSceneSwitchController {
	
	//Get instance of GameData to share between scenes
	private GameData gameData = GameData.getInstance();
	
	public void switchToEntrance(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
		
		// open door sound effect
		String musicFile = "Audio/dooropen.mp3";
		Media media = new Media(Paths.get(musicFile).toUri().toString());
		AudioClip doorOpen = new AudioClip(media.getSource());
		doorOpen.play();
	}
	

}
