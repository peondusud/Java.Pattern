
public class Coller implements Icmd{


	Ibuffer ibuff ;
	//UI ihm ;
	
	public Coller(Ibuffer ibu){
		ibuff=ibu;
	//ihm=ihm2;
		
		
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		ibuff.coller();
		
	}



}
