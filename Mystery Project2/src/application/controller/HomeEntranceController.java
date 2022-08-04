package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;

public class HomeEntranceController extends AbstractSceneSwitchController{
	
	public void switchToKitchen(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/Kitchen.fxml");
	}
	public void switchToBathroom(ActionEvent event) throws IOException{
		super.sceneSwitcher(event, "/application/view/Bathroom.fxml");
	}
	public void switchToBedroom1(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/Bedroom1.fxml");
	}
	public void switchToBedroom2(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/Bedroom2.fxml");
	}
}
