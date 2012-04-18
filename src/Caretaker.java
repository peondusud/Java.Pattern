import java.util.ArrayList;
import java.util.Iterator;


public class Caretaker {
	
	
	@SuppressWarnings("rawtypes")
	private ArrayList arrayStates = new  ArrayList();
	private int status=0;
	
	@SuppressWarnings("unchecked")
	public void addState(Object o){	
		
		arrayStates.add( o );
		status=index(o)-1;			
		arrayStates.size();
	}
	
	public Object getState( int i){		
	return arrayStates.get(i);
	}
	
	@SuppressWarnings("unchecked")
	public int index(Object t){
		int i=0;
   	 Iterator<Object> itr = this.arrayStates.iterator();
   	while (itr.hasNext()) {
    	i++;
    	if(itr.next().equals(t)){        	    		
    		return i;				//ca match indice array -1
    	}        	    	
    }
	return -1;
	}
	
	public Object previous() throws Exception {
		
		if(status-1>=-1){
			status=status-1;
		return getState(status+1);
		
		}
		
		throw new Exception();
		}
	
	public Object  next(){		
		
	/*	if(status+1<arrayStates.size()){
			restoreState(care.getState(care.status+1));
			care.status=care.status+1;
			this.notify_Obs();
		}
		*/
		
		
		return arrayStates;}
	
	
}
