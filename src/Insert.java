
public class Insert implements Icmd{

	Ibuffer ibuff ;
	//UI ihm ;
	
	public Insert(Ibuffer ibu){
		ibuff=ibu;
	//ihm=ihm2;
			}
	
	@Override
	public void execute() {
		ibuff.insert();
		
	}


}
