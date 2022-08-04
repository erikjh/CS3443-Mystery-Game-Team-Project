package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;

public class Bedroom1Controller extends AbstractSceneSwitchController {
	public void switchToEntrance(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/HomeEntrance.fxml");
	}
	

}
