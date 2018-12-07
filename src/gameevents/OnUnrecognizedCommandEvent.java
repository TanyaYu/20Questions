package gameevents;

public class OnUnrecognizedCommandEvent extends GameEvent { 
	
	private String command;
	
	public OnUnrecognizedCommandEvent(String command) {
		this.command = command;
	}
}
