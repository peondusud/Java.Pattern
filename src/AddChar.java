
public class AddChar implements Icmd{

	Ibuffer ibuff ;
	
	
	public AddChar(Ibuffer ibu){
		ibuff=ibu;		
	}
	
	public void execute() {
		
		ibuff.addchar();
		
	}


}
