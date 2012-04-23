import java.util.ArrayList;
import java.util.Iterator;


public class Caretaker  {
	
	
	private ArrayList<Memento> arrayStates = new  ArrayList<Memento>();
	private int status=0;
	
	public void addState(Memento o)
	{	
		if (status+1==arrayStates.size())
		{
			arrayStates.add(  o );
		}
		else
		{
			if(arrayStates.size()>1)
			{
				arrayStates.add(status+1, o);	//bug
			}
		}		
		status=index(o);
	}
	
	public Object getState( int i){		
	return arrayStates.get(i);
	}
	
	public int index(Object t){
	int i=0;
   	Iterator<Memento> itr = this.arrayStates.iterator();
   	 	while (itr.hasNext()) {    	
   	 		if(itr.next().equals(t))       	    		
   	 			return i;				//
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
		if(tmp<arrayStates.size() && tmp>=0){ //3+1<4
			status=tmp;
			return arrayStates.get(tmp);		
		}
		else{
			status=arrayStates.size()-1;
			return arrayStates.get(status);
		}
	}

	

	
}
