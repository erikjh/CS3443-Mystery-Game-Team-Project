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

/**
 * Bathroom controller that handles changing scenes from the 
 * bathroom as well as all the clues contained in
 * the bathroom.
 * 
 * @author Clowey Adams
 * @author David Chenevert
 * @author Erik Hernandez
 * @author Miguel Rodriguez
 *
 */

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
	
	public void clueClick(ActionEvent event) throws IOException{
		super.clueClick(clueFile, event, "M", manuscriptButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "P", pictureButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "F", fingerPrintButton, gameData, clueTextDisplay);
	}
}
