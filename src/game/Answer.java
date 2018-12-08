package game;

public enum Answer {
	YES("Y"), NO("N"), SOMETIMES("S"), UNKNOWN("U");
	
	private final String character;
	
	Answer(String character) {
		this.character = character;
	
		
	}
	
	public String getChar() {
		return this.character;
	}
}
