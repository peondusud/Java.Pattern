public class Cut implements Icmd{

	Ibuffer ibuff ;
	
	public Cut(Ibuffer ibu){
		ibuff=ibu;
		
	}
	
	@Override
	public void execute() {
		
		ibuff.cut();		
	}
	
}
