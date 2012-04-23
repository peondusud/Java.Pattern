
public class Refaire implements Icmd {

	Ibuffer ibuff ;

	
	public Refaire(Ibuffer ibu){
		ibuff=ibu;

	}
		
	@Override
	public void execute() {
		ibuff.redo();
		
	}


	

}
