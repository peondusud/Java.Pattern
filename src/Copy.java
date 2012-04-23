
public class Copy implements Icmd{

	
	Ibuffer ibuff ;
	
	public Copy(Ibuffer ibu){
		ibuff=ibu;
		
	}
	
	
	public void execute() {
		ibuff.copy();

	}

	
}
