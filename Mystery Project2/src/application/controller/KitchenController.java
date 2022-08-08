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
 * Kitchen controller that handles changing scenes from the 
 * kitchen as well as all the clues contained in
 * the kitchen.
 * 
 * @author Clowey Adams
 * @author David Chenevert
 * @author Erik Hernandez
 * @author Miguel Rodriguez
 *
 */

public class KitchenController extends AbstractSceneSwitchController {
	@FXML
	private Button jasonButton;
	
	@FXML
	private Button samsonButton;
	
	@FXML
    private Button freezerButton;

    @FXML
    private Button blackCatButton;

    @FXML
    private Text clueTextDisplay;

    @FXML
    private Button warmStoveButton;
    
    private String clueFile = "GameDialogue/KitchenClues.txt";
    private int samDialogueNum = 1;
    private int jasonDialogueNum = 1;
    private boolean catClue = false;

	
	//Get instance of GameData to share between scenes
	private GameData gameData = GameData.getInstance();
	
	public void switchToEntrance(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
		super.sceneSound("footsteps");
	}
	public void clueClick(ActionEvent event) throws IOException{
		super.clueClick(clueFile, event, "F", freezerButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "W", warmStoveButton, gameData, clueTextDisplay);
	}

	public void samsonClick(ActionEvent event) throws IOException{
		
		boolean majorCluesFound = false;
		
		if(gameData.getCluesFound() == 3)
			majorCluesFound = true;
		
		//Will only occur after all major clues found and will cycle only once
		if(majorCluesFound == true && gameData.samsonNoteDialogue == false) {
			switch(samDialogueNum) {
				case 1: super.clueClick(clueFile, event, "S3", samsonButton, gameData, clueTextDisplay);
						samDialogueNum++;
						break;
						
				case 2: super.clueClick(clueFile, event, "S4", samsonButton, gameData, clueTextDisplay);
						samDialogueNum++;
						break;
						
				case 3:	super.clueClick(clueFile, event, "S5", samsonButton, gameData, clueTextDisplay);
						samDialogueNum = 1;
						gameData.samsonNoteDialogue = true;
						break;
				
				default: samDialogueNum = 1;
						 break;
			}
		} 		  
		else if(catClue == true) {
			 super.clueClick(clueFile, event, "S2", samsonButton, gameData, clueTextDisplay);
			 catClue = false;
		 }
		 else{
			super.clueClick(clueFile, event, "S1", samsonButton, gameData, clueTextDisplay);
		 }
	}
	
	public void jasonClick(ActionEvent event) throws IOException{
		boolean majorCluesFound = false;
		
		if(gameData.getCluesFound() == 3)
			majorCluesFound = true;
		
		//Will only occur after all major clues found and will cycle only once
		if(majorCluesFound == true && gameData.jasonNoteDialogue == false) {
			switch(jasonDialogueNum) {
				case 1: super.clueClick(clueFile, event, "J3", jasonButton, gameData, clueTextDisplay);
						jasonDialogueNum++;
						break;
						
				case 2: super.clueClick(clueFile, event, "J4", jasonButton, gameData, clueTextDisplay);
						jasonDialogueNum++;
						break;
						
				case 3:	super.clueClick(clueFile, event, "J5", jasonButton, gameData, clueTextDisplay);
						jasonDialogueNum = 1;
						gameData.jasonNoteDialogue = true;
						break;
				
				default: jasonDialogueNum = 1;
						 break;
			}
		} 		  
		else if(catClue == true) {
			 super.clueClick(clueFile, event, "J2", jasonButton, gameData, clueTextDisplay);
			 catClue = false;
		 }
		 else if(catClue == false)  {
			super.clueClick(clueFile, event, "J1", jasonButton, gameData, clueTextDisplay);
		 }

	}
	
	
	public void blackCatClick(ActionEvent event) throws IOException{
		catClue = true;
		super.clueClick(clueFile, event, "B", blackCatButton, gameData, clueTextDisplay);
	}
	
	
}
