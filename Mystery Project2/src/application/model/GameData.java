package application.model;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.HashSet;

/**
 * The GameData class creates instances of GameData
 * to share between scenes, keeping track of clues and
 * dialogue the player has already looked at, which will
 * then unlock additional information. It also
 * loads in the character data to the
 * game character array list.
 * 
 * @author Clowey Adams
 * @author David Chenevert
 * @author Erik Hernandez
 * @author Miguel Rodriguez
 *
 */

public class GameData {
	
	//creates and sets instance of GameData to share between scenes
	private static final GameData instance  = new GameData();
	
	private ArrayList<Characters> gameCharacters = new ArrayList<Characters>();
	private String characterCSVFilePath;
	private String gameDialogueFilePath;
	private ArrayList<String> gameDialogue = new ArrayList<String>();
	private boolean audioStarted = false;

	
	//Clues that will unlock additional dialogue
    public int bloodClueFound = 0;
    public int noteClueFound = 0;
    public int gunClueFound = 0;
    public boolean judyNoteDialogue = false;
    public boolean junieNoteDialogue = false;
    public boolean williamNoteDialogue = false;
    public boolean samsonNoteDialogue = false;
    public boolean jasonNoteDialogue = false;
	
	
	public GameData() {
		try {
			loadCharacterData("CharacterData/Character1.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static GameData getInstance() {
		return instance;
	}
	
	public ArrayList<Characters> getGameCharacters() {
		return gameCharacters;
	}

	public void setGameCharacters(ArrayList<Characters> gameCharacters) {
		this.gameCharacters = gameCharacters;
	}

	public String getCharacterCSVFilePath() {
		return characterCSVFilePath;
	}

	public void setCharacterCSVFilePath(String characterCSVFilePath) {
		this.characterCSVFilePath = characterCSVFilePath;
	}

	public String getGameDialogueFilePath() {
		return gameDialogueFilePath;
	}

	public void setGameDialogueFilePath(String gameDialogueCSVFilePath) {
		this.gameDialogueFilePath = gameDialogueCSVFilePath;
	}

	public ArrayList<String> getGameDialogue() {
		return gameDialogue;
	}

	public void setGameDialogue(ArrayList<String> gameDialogue) {
		this.gameDialogue = gameDialogue;
	}
	
	public boolean getAudioStarted() {
		return audioStarted;
	}
	
	public void setAudioStarted(boolean audioStarted) {
		this.audioStarted = audioStarted;
	}
	
	public int getCluesFound(){
		
		return bloodClueFound + noteClueFound + gunClueFound;
		
	}

	//Loads in characters to the gameCharacter ArrayList with a file given by the user
	public void loadCharacterData(String fileName) throws IOException{
		File file = new File(fileName);
		Scanner fileScanner = new Scanner(file);
		boolean guilt;
		

		BufferedReader br = new BufferedReader(new FileReader(file));
		String buffer = "";
		
		while((buffer = br.readLine()) != null) {
				String[] data = buffer.split(",");
				if(data[1] == "guilty")
					guilt = true;
				else 
					guilt = false;
				
				Characters c = new Characters(data[0], guilt);
				
				gameCharacters.add(c);
		}
		
		br.close();	
		fileScanner.close();
		
	}
	public void loadGameDialogue(String file) throws IOException {
		this.gameDialogueFilePath = file;
		String line;
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((line = br.readLine()) != null){
			gameDialogue.add(line);
		}
		br.close();
	}
	

	@Override
	public String toString() {
		return "GameData [gameCharacters=" + gameCharacters + ", characterCSVFilePath=" + characterCSVFilePath
				+ ", gameDialogueFilePath=" + gameDialogueFilePath + ", gameSceneFilePath="
				+ ", gameDialogue=" + gameDialogue + ", gameScene=" ;
	}

	
}





