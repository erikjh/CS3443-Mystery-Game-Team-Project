package application.model;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class GameData {
	
	//creates and sets instance of GameData to share between scenes
	private static final GameData instance  = new GameData();
	
	private ArrayList<Characters> gameCharacters = new ArrayList<Characters>();
	private String characterCSVFilePath;
	private String gameDialogueFilePath;
	private ArrayList<String> gameDialogue = new ArrayList<String>();
	private boolean audioStarted = false;
	
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
		
	/*	
		this.characterCSVFilePath = file;
		String line;
		BufferedReader br = new BufferedReader(new FileReader(file));
		Random rand = new Random();
		HashSet<String> characterHash= new HashSet<String>();
		ArrayList<String> characterList = new ArrayList<String>();
		while((line = br.readLine()) != null){
			characterList.add(line);
			String[] tempString = line.split(",");
			characterHash.add(tempString[2]);
			
		}	
		int i = 0;
		while( i < characterHash.size()) {
		int random = rand.nextInt(characterList.size());
		String[] characterString = characterList.get(random).split(",");
			if(characterHash.contains(characterString[2])) {
				int age = Integer.parseInt(characterString[1]); 
				boolean guilty = false;//initializing all characters to be not guilty
				Character tempCharacterNew = new Character(characterString[0], age, characterString[2], guilty);
				gameCharacters.add(tempCharacterNew);
				characterHash.remove(characterString[2]);
			}
		}
		br.close();
		*/
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





