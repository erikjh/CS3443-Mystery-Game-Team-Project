package application.model;

/**
 * The characters class that sets the attributes
 * to the characters in the game.
 * 
 * @author Clowey Adams
 * @author David Chenevert
 * @author Erik Hernandez
 * @author Miguel Rodriguez
 *
 */

public class Characters {
	private String name;
	private boolean guilty;
	
	public Characters(String name, boolean guilty) {
		this.name = name;
		this.guilty = guilty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGuilty() {
		return guilty;
	}

	public void setGuilty(boolean guilty) {
		this.guilty = guilty;
	}

}
