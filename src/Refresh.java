
public class Refresh implements Icmd{

	Ibuffer ibuff ;
	
	public Refresh(Ibuffer ibu){
		
		ibuff=ibu;
	}

	public void execute() {
		
		ibuff.refresh();
	}



}