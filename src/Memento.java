
public class Memento {

	private String str_buffer_state="";
	
	public Memento(String state2Save){
		
		str_buffer_state=state2Save;
	}
	
	public String getSaavedState(){
		return str_buffer_state;
	}
	
	
}
