import java.util.ArrayList;
import java.util.Iterator;


public class Caretaker {
	
	
	@SuppressWarnings("rawtypes")
	private ArrayList arrayStates = new  ArrayList();
	private int status=0;
	
	@SuppressWarnings("unchecked")
	public void addState(Object o){	
		if (status+1==arrayStates.size()){
		arrayStates.add( o );
		}
		else{
			//arrayStates.add(status+1,o);			//bug
		}		
		status=index(o);
	}
	
	public Object getState( int i){		
	return arrayStates.get(i);
	}
	
	@SuppressWarnings("unchecked")
	public int index(Object t){
	int i=0;
   	Iterator<Object> itr = this.arrayStates.iterator();
   	 	while (itr.hasNext()) {    	
   	 		if(itr.next().equals(t))       	    		
   	 			return i;				//ca match indice array -1
   	 		i++;
   	 	}
	return -1;
	}
	
	public Object previous() throws Exception {		
		int tmp =status-1;	
		if(status>0){		//status positif
			status=tmp;
			return arrayStates.get(status);		
		}		
		else{
			status=0;
			return arrayStates.get(status);
		}
	}
	
	public Object  next() throws Exception{			
		int tmp =status+1;	
		if(tmp<arrayStates.size() && tmp>=0){
			status=tmp;
			return arrayStates.get(tmp);		
		}
		else{
			status=arrayStates.size()-1;
			return arrayStates.get(tmp);
		}
	}
	
	
}
