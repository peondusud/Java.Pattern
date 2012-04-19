
public class Refresh implements Icmd{

	Ibuffer ibuff ;
	//UI ihm ;
	
	public Refresh(Ibuffer ibu,UI ihm2){
		ibuff=ibu;
	//ihm=ihm2;
		
	}
	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ibuff.refresh();
	}
	

}