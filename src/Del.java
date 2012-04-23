
public class Del implements Icmd{

	Ibuffer ibuff ;

	public Del(Ibuffer ibu){
		ibuff=ibu;
}
	

	@Override
	public void execute() {
		
		ibuff.delete();
	}
	
}
