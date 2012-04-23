
public class Undo implements Icmd {

	Ibuffer ibuff ;

	
	public Undo(Ibuffer ibu){
		
		ibuff=ibu;	
	}
		
	
	@Override
	public void execute() {
		ibuff.undo();
	}

}
