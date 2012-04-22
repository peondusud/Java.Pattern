
public class Refaire implements Icmd {

	Ibuffer ibuff ;
	//UI ihm ;
	
	public Refaire(Ibuffer ibu){
		ibuff=ibu;
	//ihm=ihm2;
	}
		
	@Override
	public void execute() {
		ibuff.redo();
		
	}


	

}
