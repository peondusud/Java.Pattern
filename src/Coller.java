
public class Coller implements Icmd{

	Ibuffer ibuff ;

	public Coller(Ibuffer ibu){
		ibuff=ibu;
		
	}
	
	public void execute() {
		
		ibuff.coller();		
	}


}
