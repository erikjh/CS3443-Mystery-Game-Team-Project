package application.controller;

import java.io.IOException;

import application.model.GameData;
import javafx.event.ActionEvent;

public class Bedroom2Controller extends AbstractSceneSwitchController{
	
	private GameData gameData = GameData.getInstance();
	
	public void switchToEntrance(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
	}


}
