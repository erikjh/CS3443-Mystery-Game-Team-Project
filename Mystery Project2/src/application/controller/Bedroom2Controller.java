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

public class Bedroom2Controller extends AbstractSceneSwitchController{
	 	@FXML
	    private Button realWillButton;

	    @FXML
	    private Button grayCatButton;

	    @FXML
	    private Button catMemeButton;

	    @FXML
	    private Button williamButton;
	    
	    @FXML
	    private Button junieButton;
	    
	    @FXML
	    private Text clueTextDisplay;
	    private String clueFile = "GameDialogue/Bedroom2Clues.txt";
	    private int willDialogueNum = 1;
	    private int junieDialogueNum = 1;
	    private boolean catClue = false;


	
	//Get instance of GameData to share between scenes
	private GameData gameData = GameData.getInstance();
	
	public void switchToEntrance(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
		super.sceneSound("door");
	}
	
	public void clueClick(ActionEvent event) throws IOException{
		super.clueClick(clueFile, event, "M", catMemeButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "W", realWillButton, gameData, clueTextDisplay);
	}

	public void junieClick(ActionEvent event) throws IOException{
		boolean majorCluesFound = false;
		
		if(gameData.getCluesFound() == 3)
			majorCluesFound = true;
		
		//Will only occur after all major clues found and will cycle only once	
		if(majorCluesFound == true && gameData.junieNoteDialogue == false) {
			switch(junieDialogueNum) {
				case 1: super.clueClick(clueFile, event, "J3", junieButton, gameData, clueTextDisplay);
						junieDialogueNum++;
						break;
						
				case 2: super.clueClick(clueFile, event, "J4", junieButton, gameData, clueTextDisplay);
						junieDialogueNum++;
						break;
						
				case 3: super.clueClick(clueFile, event, "J5", junieButton, gameData, clueTextDisplay);
						junieDialogueNum++;
						break;
						
				case 4:	super.clueClick(clueFile, event, "J6", junieButton, gameData, clueTextDisplay);
						junieDialogueNum = 1;
						gameData.junieNoteDialogue = true;
						break;
				
				default: junieDialogueNum = 1;
						 break;
			}
		} 		  
		else if(catClue == true) {
			 super.clueClick(clueFile, event, "J2", junieButton, gameData, clueTextDisplay);
			 catClue = false;
		 }
		 else if(catClue == false)  {
			super.clueClick(clueFile, event, "J1", junieButton, gameData, clueTextDisplay);
		 }

	}
	public void williamClick(ActionEvent event) throws IOException{
		
		boolean majorCluesFound = false;
		
		if(gameData.getCluesFound() == 3)
			majorCluesFound = true;
		
		//Will only occur after all major clues found and will cycle only once	
		if(majorCluesFound == true && gameData.williamNoteDialogue == false) {
			switch(willDialogueNum) {
				case 1: super.clueClick(clueFile, event, "B2", williamButton, gameData, clueTextDisplay);
					willDialogueNum++;
						break;
						
				case 2: super.clueClick(clueFile, event, "B3", williamButton, gameData, clueTextDisplay);
					willDialogueNum++;
						break;
						
				case 3: super.clueClick(clueFile, event, "B4", williamButton, gameData, clueTextDisplay);
					willDialogueNum++;
						break;
						
				case 4:	super.clueClick(clueFile, event, "B5", williamButton, gameData, clueTextDisplay);
					willDialogueNum++;
						break;
						
				case 5:	super.clueClick(clueFile, event, "B6", williamButton, gameData, clueTextDisplay);
					willDialogueNum = 1;
						gameData.williamNoteDialogue = true;
						break;
				
				default: willDialogueNum = 1;
						 break;
			}
		} 		  
		else{
			super.clueClick(clueFile, event, "B1", williamButton, gameData, clueTextDisplay);
		}
	}

	public void grayCatClick(ActionEvent event) throws IOException{
		catClue = true;
		super.clueClick(clueFile, event, "G", grayCatButton, gameData, clueTextDisplay);
	}

}
