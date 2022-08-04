package application.controller;

import java.io.IOException;

import application.model.GameData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage; 

public class SceneController {
		private GameData gameData = new GameData();

		private Stage stage;
		private Scene scene;
		private Parent root;
		//Main Menu Variables
		
		@FXML
	    private Button nextButton;
	    @FXML
	    
	    private Text instructionText;
	    @FXML
	    private Button beginGameButton;
	    private int count = 0;
	    private int i = 0;
	    
	    //End of Main Menu Variables
		
	    //Main Menu instruction loading method
	    public void loadInstructions() throws IOException{
	    	gameData.loadGameDialogue("GameDialogue/OpeningScene.txt");
	    }
	    
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
	    	
		
		public void switchToEntrance(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("/application/view/HomeEntrance.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		public void switchToBathroom(ActionEvent event) throws IOException {
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
		}
		
}
