
public class Del implements Icmd{

	Ibuffer ibuff ;
	//UI ihm ;
	
	public Del(Ibuffer ibu){
		ibuff=ibu;
	//ihm=ihm2;
		
	}
	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ibuff.delete();
	}
	

}
