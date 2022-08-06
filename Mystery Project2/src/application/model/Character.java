package application.model;

public class Character {
	private String name;
	//private int age;
	//private String relation;
	private boolean guilty;
	
	public Character(String name, int age, String relation, boolean guilty) {
		this.name = name;
		//this.age = age;
		//this.relation = relation;
		this.guilty = guilty;
	}
	public Character() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
*/
	public boolean isGuilty() {
		return guilty;
	}

	public void setGuilty(boolean guilty) {
		this.guilty = guilty;
	}
/*	
	@Override
	public String toString() {
		return getRelation();
	}
*/	

}
