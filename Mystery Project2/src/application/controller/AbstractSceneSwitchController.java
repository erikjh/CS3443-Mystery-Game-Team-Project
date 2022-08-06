package application.controller;

import java.io.IOException;
import java.nio.file.Paths;

import application.model.GameData;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;


public abstract class AbstractSceneSwitchController {
	

	private Stage stage;
	private Scene scene;
	private Parent root;

	public void sceneSwitcher(ActionEvent event, String file) throws IOException {
		root = FXMLLoader.load(getClass().getResource(file));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void sceneSound(String sound) {
		//footsteps sound effect
		if(sound.equals("footsteps")) {
			String musicFile = "Audio/footsteps.mp3";
			Media media = new Media(Paths.get(musicFile).toUri().toString());
			AudioClip footstepsKitchen = new AudioClip(media.getSource());
			footstepsKitchen.play();
		//door sound effect
		}else if(sound.equals("door")) {
			String musicFile = "Audio/dooropen.mp3";
			Media media = new Media(Paths.get(musicFile).toUri().toString());
			AudioClip doorOpen = new AudioClip(media.getSource());
			doorOpen.play();
			
		}
	}
}
