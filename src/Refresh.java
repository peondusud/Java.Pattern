
public class Refresh implements Icmd{

	Ibuffer ibuff ;
	//UI ihm ;
	
	public Refresh(Ibuffer ibu){
		ibuff=ibu;
	//ihm=ihm2;
		
	}
	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ibuff.refresh();
	}



}