
public class Refaire implements Icmd {

	Ibuffer ibuff ;
	//UI ihm ;
	
	public Refaire(Ibuffer ibu,UI ihm2){
		ibuff=ibu;
	//ihm=ihm2;
	}
		
	@Override
	public void execute() {
		ibuff.redo();
		
	}


	

}
