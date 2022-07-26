package application.controller;

import java.io.IOException;
import java.nio.file.Paths;
import application.model.GameData;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Abstract controller for switching scenes.
 * Also contains methods for triggering the sound
 * effects when switching scenes.
 * 
 * @author Clowey Adams
 * @author David Chenevert
 * @author Erik Hernandez
 * @author Miguel Rodriguez
 *
 */

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
			footstepsKitchen.setVolume(0.4);
			footstepsKitchen.play();
		//door sound effect
		}else if(sound.equals("door")) {
			String musicFile = "Audio/dooropen.mp3";
			Media media = new Media(Paths.get(musicFile).toUri().toString());
			AudioClip doorOpen = new AudioClip(media.getSource());
			doorOpen.setVolume(0.2);
			doorOpen.play();
			
		}
	}
	public void clueClick(String file, ActionEvent event, String inputString, Button click, GameData gameData, Text text) throws IOException {
		gameData.loadGameDialogue(file);
		if(event.getSource() == click) {
			for(String index : gameData.getGameDialogue()) {
				if (index.startsWith(inputString, 0)) {
					String[] tempString = index.split(";");
					text.setText(tempString[1]);
				}
			}
		}
	}
	
	public void majorClueClick(String file, ActionEvent event, String inputString, Button click, GameData gameData, Text text, int majorClueCount) throws IOException {
		gameData.loadGameDialogue(file);
		if(event.getSource() == click) {
			for(String index : gameData.getGameDialogue()) {
				if (index.startsWith(inputString, 0)) {
					String[] tempString = index.split(";");
					text.setText(tempString[1] + "\n- Major Clue Found: " + majorClueCount + "/3 -");
				}
			}
		}
	}
}
