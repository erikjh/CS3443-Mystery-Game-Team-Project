package application.controller;

import java.io.IOException;
import java.nio.file.Paths;

import application.model.GameData;
import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class KitchenController extends AbstractSceneSwitchController {
	
	//Get instance of GameData to share between scenes
	private GameData gameData = GameData.getInstance();
	
	public void switchToEntrance(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
		
		// footsteps to kitchen sound effect
		String musicFile = "Audio/footsteps.mp3";
		Media media = new Media(Paths.get(musicFile).toUri().toString());
		AudioClip footstepsKitchen = new AudioClip(media.getSource());
		footstepsKitchen.play();
	}

}
