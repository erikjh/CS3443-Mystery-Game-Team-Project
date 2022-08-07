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
		  
		 if(catClue == true) {
			 super.clueClick(clueFile, event, "S2", samsonButton, gameData, clueTextDisplay);
			 catClue = false;
		 }
		 else{
			super.clueClick(clueFile, event, "S1", samsonButton, gameData, clueTextDisplay);
		 }
	}
	
	public void jasonClick(ActionEvent event) throws IOException{
		  
		 if(catClue == true) {
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
