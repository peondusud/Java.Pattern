
public class Undo implements Icmd {

	Ibuffer ibuff ;
	//UI ihm ;
	
	public Undo(Ibuffer ibu,UI ihm2){
		ibuff=ibu;
	//ihm=ihm2;
	}
		
	
	@Override
	public void execute() {
		ibuff.undo();
	}


}
