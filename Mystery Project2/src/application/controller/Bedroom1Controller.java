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

public class Bedroom1Controller extends AbstractSceneSwitchController {
    
    	@FXML
    	private Button judyButton;
	
		@FXML
	    private Button paintingButton;

	    @FXML
	    private Button fakeWillButton;

	    @FXML
	    private Button orangeCatButton;

	    
	    @FXML
	    private Text clueTextDisplay;
	    private String clueFile = "GameDialogue/Bedroom1Clues.txt";
	    private int dialogueNum = 1;
	    private boolean catClue = false;
	
	//Get instance of GameData to share between scenes
	private GameData gameData = GameData.getInstance();
	
	public void switchToEntrance(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
		super.sceneSound("door");
	}
	public void clueClick(ActionEvent event) throws IOException{
		super.clueClick(clueFile, event, "P", paintingButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "F", fakeWillButton, gameData, clueTextDisplay);
	}
	
	public void judyClick(ActionEvent event) throws IOException{
		  
		 if(catClue == true) {
			 super.clueClick(clueFile, event, "J3", judyButton, gameData, clueTextDisplay);
			 catClue = false;
		 }
		 else if(dialogueNum == 1) {
			super.clueClick(clueFile, event, "J1", judyButton, gameData, clueTextDisplay);
			dialogueNum = 2;
		  }
		  else {
			super.clueClick(clueFile, event, "J2", judyButton, gameData, clueTextDisplay);
			dialogueNum = 1;
		  }
	}
	public void catClick(ActionEvent event) throws IOException{
		catClue = true;
		super.clueClick(clueFile, event, "O", orangeCatButton, gameData, clueTextDisplay);
	}
}
