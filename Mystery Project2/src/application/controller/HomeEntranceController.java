package application.controller;

import application.model.GameData;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;


public class HomeEntranceController extends AbstractSceneSwitchController implements Initializable {
	//Clue variables
	@FXML
	private Button michelleButton;
	@FXML
    private Button bloodButton;
    @FXML
    private Button noteButton;
    @FXML
    private Button gunButton;
    @FXML
    private Text clueTextDisplay;
    private String clueFile = "GameDialogue/HomeEntranceClues.txt";
    private int dialogueNum = 1;
    private int noteNum = 1;
    
	// music variables
	private String musicFile;
	private Media media;
	private AudioClip startGameMedia;
	
	//Get instance of GameData to share between scenes
	private GameData gameData = GameData.getInstance();

	
	public void switchToKitchen(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/Kitchen.fxml");
		super.sceneSound("footsteps");
	}
	public void switchToBathroom(ActionEvent event) throws IOException{
		super.sceneSwitcher(event, "/application/view/Bathroom.fxml");
		super.sceneSound("door");
	}
	public void switchToBedroom1(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/Bedroom1.fxml");
		super.sceneSound("door");
	}
	public void switchToBedroom2(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/Bedroom2.fxml");
		super.sceneSound("door");
	}
	
	
	
	// This method is called upon fxml load
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			musicFile = "Audio/startGame(3mins).mp3";
		    media = new Media(Paths.get(musicFile).toUri().toString());
		    startGameMedia = new AudioClip(media.getSource());
		    startGameMedia.setCycleCount(999); // cycle the media 999 times
		    startGameMedia.setVolume(0.2);  // volume can be set 0 - 1
			playEntranceMusic();
	
		
	}
	
	// This method plays the main menu background music.
	public void playEntranceMusic() {
		if(gameData.getAudioStarted() == false) {
			gameData.setAudioStarted(true);
	    	startGameMedia.play();
		}
    }
	
	//Game's clue methods
	public void clueClick(ActionEvent event) throws IOException{
		super.clueClick(clueFile, event, "B", bloodButton, gameData, clueTextDisplay);
		super.clueClick(clueFile, event, "G", gunButton, gameData, clueTextDisplay);
		//super.clueClick(clueFile, event, "N", noteButton, gameData, clueTextDisplay);
		
	}
	//note probs need to make a noteClick like michelleClick
	public void noteClick(ActionEvent event) throws IOException{
		if(noteNum == 1)
			super.clueClick(clueFile, event, "N1", noteButton, gameData, clueTextDisplay);
		else if(noteNum == 2)
			super.clueClick(clueFile, event, "N2", noteButton, gameData, clueTextDisplay);
		else if(noteNum == 3)
			super.clueClick(clueFile, event, "N3", noteButton, gameData, clueTextDisplay);
		else {
			super.clueClick(clueFile, event, "N4", noteButton, gameData, clueTextDisplay);
			noteNum = 0;
		}
		noteNum++;
	}

	
	public void michelleClick(ActionEvent event) throws IOException{
			if(dialogueNum == 1)
				super.clueClick(clueFile, event, "M1", michelleButton, gameData, clueTextDisplay);
			else if(dialogueNum == 2)
				super.clueClick(clueFile, event, "M2", michelleButton, gameData, clueTextDisplay);
			else if(dialogueNum == 3)
				super.clueClick(clueFile, event, "M3", michelleButton, gameData, clueTextDisplay);
			else {
				super.clueClick(clueFile, event, "M4", michelleButton, gameData, clueTextDisplay);
				dialogueNum = 0;
			}
			dialogueNum++;
	}
}
