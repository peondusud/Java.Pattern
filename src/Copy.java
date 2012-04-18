
public class Copy implements Icmd{

	
	Ibuffer ibuff ;
	//UI ihm ;
	
	public Copy(Ibuffer ibu,UI ihm2){
		ibuff=ibu;
	//	ihm=ihm2;
		
		
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ibuff.copy();
		//ihm.update(ibuff);
		
	}

	
}
