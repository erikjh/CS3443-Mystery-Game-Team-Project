package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;

import application.model.GameData;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/HomeEntrance.fxml"));
			Scene scene = new Scene(root,800,800);
			primaryStage.setResizable(false);
			primaryStage.setTitle("The Murder Mystery Game!");
			Image icon = new Image(new File("Images/bloodyroadrunner.png").toURI().toString());
			primaryStage.getIcons().add(icon);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		launch(args);
		GameData gameData = new GameData();
		gameData.loadCharacterData("CharacterData/Character1.csv");		}
	
}
 