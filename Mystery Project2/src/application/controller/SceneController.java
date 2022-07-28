package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage; 

public class SceneController {

		private Stage stage;
		private Scene scene;
		private Parent root;
		
		@FXML
		public void switchToMenu(ActionEvent event) throws IOException {
		    root = FXMLLoader.load(getClass().getResource("/application/view/MainMenu.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		@FXML
		public void switchToEntrance(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("/application/view/HomeEntrance.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		@FXML
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
