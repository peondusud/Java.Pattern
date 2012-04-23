
public class Insert implements Icmd{

	Ibuffer ibuff ;

	public Insert(Ibuffer ibu){
		ibuff=ibu;

			}
	
	@Override
	public void execute() {
		
		ibuff.insert();		
	}


}
