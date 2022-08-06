package application.controller;

import java.io.IOException;
import java.nio.file.Paths;

import application.model.GameData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.text.Text;

public class BathroomController extends AbstractSceneSwitchController {
		@FXML
	    private Text clueTextDisplay;
		@FXML
	    private Button pictureButton;

	    @FXML
	    private Button manuscriptButton;

	    @FXML
	    private Button fingerPrintButton;
	    
	    private String clueFile = "GameDialogue/BathroomClues.txt";

	
	//Get instance of GameData to share between scenes
	private GameData gameData = GameData.getInstance();
	
	public void switchToEntrance(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
		super.sceneSound("door");
	}
	/*public void clueClick(ActionEvent event) throws IOException {
		gameData.loadGameDialogue("GameDialogue/BathroomClues.txt");
		
		if(event.getSource() == manuscriptButton) {
			for(String index : gameData.getGameDialogue()) {
				if (index.startsWith("M", 0)) {
					String[] tempString = index.split(",");
					clueTextDisplay.setText(tempString[1]);
				}
			}
		}else if(event.getSource() == pictureButton) {
			for(String index : gameData.getGameDialogue()) {
				if (index.startsWith("P", 0)) {
					String[] tempString = index.split(",");
					clueTextDisplay.setText(tempString[1]);
				}
			}
		}else if(event.getSource() == fingerPrintButton) {
			for(String index : gameData.getGameDialogue()) {
				if (index.startsWith("F", 0)) {
					String[] tempString = index.split(",");
					clueTextDisplay.setText(tempString[1]);
				}
			}
		}
	}*/
	public void clueClick(ActionEvent event) throws IOException{
		super.clueClick(clueFile, event, "M", manuscriptButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "P", pictureButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "F", fingerPrintButton, gameData, clueTextDisplay);
	}
}
