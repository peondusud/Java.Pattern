
public class AddChar implements Icmd{


	Ibuffer ibuff ;
	//UI ihm ;
	
	public AddChar(Ibuffer ibu){
		ibuff=ibu;
	//ihm=ihm2;
		
		
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		ibuff.addchar();
		
	}



}
