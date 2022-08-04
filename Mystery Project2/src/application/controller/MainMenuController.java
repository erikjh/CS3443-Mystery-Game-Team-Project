package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import application.model.GameData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage; 

public class MainMenuController extends AbstractSceneSwitchController implements Initializable {
		private GameData gameData = new GameData();
		
		@FXML
	    private Button nextButton;
	    @FXML
	    private Text instructionText;
	    @FXML
	    private Button beginGameButton;
	    private int count = 0;
	    private int i = 0;
	    
	    // music variables
	    private String musicFile;
	    private Media media;
	    private AudioClip menuMedia;
		
	    //Main Menu instruction loading method
	    public void loadInstructions() throws IOException{
	    	gameData.loadGameDialogue("GameDialogue/OpeningScene.txt");
	    }
	    
	    //Loading in instructions for the game
	    public void loadNextInstructions(ActionEvent event) throws IOException{
	    	 if( count == 0) {
	    		loadInstructions();
	    		count ++;
	    	}
	    	if(i < gameData.getGameDialogue().size()) {
	    		instructionText.setText(gameData.getGameDialogue().get(i));
	    		i++;
	    	}else{
	    		 count = 0;
	    		 gameData.getGameDialogue().clear();
	    		 i = 0;
	    		 switchToEntrance(event); //if running instructions forever comment out or delete line
	    	}
	    }
	    
	    //Method for switching to entrance from main menu
	    public void switchToEntrance(ActionEvent event) throws IOException {
			super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
			stopMenuMusic(); // stops main menu music.
		}
	    
	    // This method is called upon fxml load
	    @Override 
		public void initialize(URL arg0, ResourceBundle arg1) {
	    	
	    	musicFile = "Audio/mainMenu(3mins).mp3";
		    media = new Media(Paths.get(musicFile).toUri().toString());
		    menuMedia = new AudioClip(media.getSource()); // I used audioClip instead of MediaPlayer because there was an issue where after a few seconds the music would stop.
		    menuMedia.setCycleCount(999); // cycle the media 999 times
		    menuMedia.setVolume(0.5); // volume can be set 0 - 1
		    
			playMenuMusic();
				
		}
	    
	    // This method plays the main menu background music.
	    public void playMenuMusic() {
	    	
		    menuMedia.play();
		    
	    }
	    
	    // This method stops the main menu music, allowing the main game music to play.
	    public void stopMenuMusic() {
	    	
	    	menuMedia.stop();
	    }
		
		/*public void switchToBathroom(ActionEvent event) throws IOException {
		    root = FXMLLoader.load(getClass().getResource("/application/view/Bathroom.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
		
		
		public void switchToKitchen(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("/application/view/Kitchen.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		public void switchToBedroom1(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("/application/view/Bedroom1.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		public void switchToBedroom2(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("/application/view/Bedroom2.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}*/
		
}
