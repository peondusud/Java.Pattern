import java.util.ArrayList;
import java.util.Iterator;


public class Caretaker {
	
	
	@SuppressWarnings("rawtypes")
	private ArrayList arrayStates = new  ArrayList();
	private int status=0;
	
	@SuppressWarnings("unchecked")
	public void addState(Object o){	
		
		arrayStates.add( o );
		status=index(o);
		//reecrecrire par dessus
		
	}
	
	public Object getState( int i){		
	return arrayStates.get(i);
	}
	
	@SuppressWarnings("unchecked")
	public int index(Object t){
	int i=0;
   	Iterator<Object> itr = this.arrayStates.iterator();
   	 	while (itr.hasNext()) {
    	
   	 		if(itr.next().equals(t)){        	    		
   	 			return i;				//ca match indice array -1
   	 		} 
   	 		i++;
   	 	}
	return -1;
	}
	
	public Object previous() throws Exception {
		
		if(status>=0){		//status positif
			status=status-1;
		return arrayStates.get(status+1);
		
		}
		
		throw new Exception();
		}
	
	public Object  next() throws Exception{		
		
	
		if(status+1<arrayStates.size()){
			status=status+1;
		return arrayStates.get(status);
		
		}
		
		throw new Exception();
		
		}
	
	
}
