
public class Undo implements Icmd {

	Ibuffer ibuff ;
	//UI ihm ;
	
	public Undo(Ibuffer ibu){
		ibuff=ibu;
	//ihm=ihm2;
	}
		
	
	@Override
	public void execute() {
		ibuff.undo();
	}


}
