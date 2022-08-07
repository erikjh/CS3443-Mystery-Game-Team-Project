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
		
		boolean majorCluesFound = false;
		
		if(gameData.getCluesFound() == 3)
			majorCluesFound = true;
		
		//Will only occur after all major clues found and will cycle only once
		if(majorCluesFound == true && gameData.judyNoteDialogue == false) {
			switch(dialogueNum) {
				case 1: super.clueClick(clueFile, event, "J4", judyButton, gameData, clueTextDisplay);
						dialogueNum++;
						break;
						
				case 2: super.clueClick(clueFile, event, "J5", judyButton, gameData, clueTextDisplay);
						dialogueNum++;
						break;
						
				case 3: super.clueClick(clueFile, event, "J6", judyButton, gameData, clueTextDisplay);
						dialogueNum++;
						break;
						
				case 4:	super.clueClick(clueFile, event, "J7", judyButton, gameData, clueTextDisplay);
						dialogueNum++;
						break;
						
				case 5:	super.clueClick(clueFile, event, "J8", judyButton, gameData, clueTextDisplay);
						dialogueNum = 1;
						gameData.judyNoteDialogue = true;
						break;
				
				default: dialogueNum = 1;
						 break;
			}
		} 
		else if(catClue == true) {
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
