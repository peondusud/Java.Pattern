import java.util.ArrayList;


public class Caretaker2 {
	
	
	@SuppressWarnings("rawtypes")
	private ArrayList arrayStates = new  ArrayList();
	private int status=0;
	
	@SuppressWarnings("unchecked")
	public void addState(Object o){		
		arrayStates.add( o );
		//status=arrayStates.size();
	}
	
	public Object getState( int i){		
	return arrayStates.get(i);
	}
	
	
	public Object previous() throws Exception {		
		int tmp ;	
		
			return arrayStates.get(status);		
		
	}
	
	public Object  next() throws Exception{			
		if(status+1==arrayStates.size())		
			return arrayStates.get(status);
		else return arrayStates.get(status+1);
		
	}
	
	
}

