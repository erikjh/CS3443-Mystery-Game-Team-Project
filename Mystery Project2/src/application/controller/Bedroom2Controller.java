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
	    private Button junieButton;

	    @FXML
	    private Button grayCatButton;

	    @FXML
	    private Button catMemeButton;

	    @FXML
	    private Button williamButton;
	    
	    @FXML
	    private Text clueTextDisplay;
	    private String clueFile = "GameDialogue/Bedroom2Clues.txt";
	
	//Get instance of GameData to share between scenes
	private GameData gameData = GameData.getInstance();
	
	public void switchToEntrance(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
		super.sceneSound("door");
	}
	
	public void clueClick(ActionEvent event) throws IOException{
		super.clueClick(clueFile, event, "G", grayCatButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "M", catMemeButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "W", realWillButton, gameData, clueTextDisplay);
	}
	public void CharacterClick(ActionEvent event) throws IOException{
		
	}



}
