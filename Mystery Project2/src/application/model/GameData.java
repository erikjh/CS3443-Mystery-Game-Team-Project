package application.model;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.HashSet;

public class GameData {
	private ArrayList<Character> gameCharacters = new ArrayList<Character>();
	private String characterCSVFilePath;
	private String gameDialogueFilePath;
	private String gameSceneFilePath;
	private ArrayList<String> gameDialogue = new ArrayList<String>();
	private ArrayList<String> gameScene = new ArrayList<String>();
	
	public GameData() {
		
	}
	
	public ArrayList<Character> getGameCharacters() {
		return gameCharacters;
	}

	public void setGameCharacters(ArrayList<Character> gameCharacters) {
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
	public String getGameSceneFilePath() {
		return gameSceneFilePath;
	}

	public void setGameSceneFilePath(String gameSceneFilePath) {
		this.gameSceneFilePath = gameSceneFilePath;
	}

	public ArrayList<String> getGameDialogue() {
		return gameDialogue;
	}

	public void setGameDialogue(ArrayList<String> gameDialogue) {
		this.gameDialogue = gameDialogue;
	}

	public ArrayList<String> getGameScene() {
		return gameScene;
	}

	public void setGameScene(ArrayList<String> gameScene) {
		this.gameScene = gameScene;
	}

	//Loads in characters to the gameCharacter ArrayList with a file given by the user
	public void loadCharacterData(String file) throws IOException{
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
	public void loadGameScene(String file) throws IOException{
		this.gameSceneFilePath = file;
		String line;
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((line = br.readLine()) != null) {
			gameScene.add(line);
		}
	}

	@Override
	public String toString() {
		return "GameData [gameCharacters=" + gameCharacters + ", characterCSVFilePath=" + characterCSVFilePath
				+ ", gameDialogueFilePath=" + gameDialogueFilePath + ", gameSceneFilePath=" + gameSceneFilePath
				+ ", gameDialogue=" + gameDialogue + ", gameScene=" + gameScene + "]";
	}

	
}





