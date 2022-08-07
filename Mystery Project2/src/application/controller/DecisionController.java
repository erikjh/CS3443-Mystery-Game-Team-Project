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

public class DecisionController extends AbstractSceneSwitchController {

		@FXML
	    private Button samsonButton;
	    @FXML
	    private Button jasonButton;
	    @FXML
	    private Button junieButton;
	    @FXML
	    private Button williamButton;
	    @FXML
	    private Button judyButton;
	    @FXML
	    private Button voidButton;
	
	public void switchToGoodEnding(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/GoodEnding.fxml");
	}
	
	public void switchToBadEnding(ActionEvent event) throws IOException {
		super.sceneSwitcher(event, "/application/view/BadEnding.fxml");
	}


}
