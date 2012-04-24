import java.util.ArrayList;



public class Buffer implements Isujet,Ibuffer, Imemento{

	private Clipboard pressP=new Clipboard();
	private Selection selection=new Selection();
	private Caretaker care=new Caretaker();
	private ArrayList<Iobserver> arr_Obs =new ArrayList<Iobserver>();
	private String str=new String();
	private  int cut_flag=0;
	private  int undo_flag=0;
	private String addchar=new String("");

	
	
	
	public Clipboard getPressP() {
		return pressP;
	}
	public void setPressP(Clipboard pressP) {
		this.pressP = pressP;
	}
	public Selection getSelection() {
		return selection;
	}
	public void setSelection(Selection selectin) {
		selection = selectin;
	}
	public Caretaker getCare() {
		return care;
	}
	public void setCare(Caretaker care) {
		this.care = care;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	public Object rec2memento(){
		return new Memento(this.str);		
	}
	
	public void restoreState(Object r){
		if(r instanceof Memento){			
			this.str=((Memento) r).getSaavedState();			
		}				
	}
	
	
	@Override
	public void add(Iobserver o) {
		arr_Obs.add(o);		
	}
	@Override
	public void del(Iobserver o) {
		arr_Obs.remove(o);
	}
	
	
	public  void copy() {
		cut_flag=2;	
		undo_flag=0;
		
		pressP.setClip(new String(str.substring(selection.getDebut(),selection.getFin())));	
		care.addState(new Memento(str));
		this.notify_Obs();		
	}
public  void cut() {
		cut_flag=1;
		undo_flag=0;
		//copy();
		//delete();
	
		pressP.setClip(str.substring(selection.getDebut(),selection.getFin()));	
		care.addState(new Memento(str));
		str=str.substring (0, selection.getDebut()) + str.substring (selection.getFin());
		this.notify_Obs();		
	}
	
	public void coller() {
		
		care.addState(new Memento(str));
		String tmp1=new String(str.substring(0, selection.getDebut()).toString());		
		String tmp2=new String(pressP.getClip().toString());
		undo_flag=0;		
		
		if(cut_flag==1){	
			//Coller si cut 
			String tmp3=new String(str.substring(selection.getDebut()));
			//str=tmp1 + tmp2 + tmp3; 
			str=new StringBuilder().append(tmp1).append(tmp2).append(tmp3).toString();		
			pressP.setClip("");
			cut_flag=0;
		}
		else if(cut_flag==2){
			//coller normal
			String tmp3=new String(str.substring(selection.getFin()));	
			str=new StringBuilder().append(tmp1).append(tmp2).append(tmp3).toString();	
			//str=str.substring(0, selection.getDebut()) +  pressP.getClip() + str.substring(selection.getFin() );
		}
		else{
			pressP.setClip("");				
		}
		this.notify_Obs();
	}
	
	public void delete() {
		undo_flag=0;
		care.addState(new Memento(str));
		if(selection.getFin()!= selection.getDebut()){
		str=str.substring(0, selection.getDebut()) + str.substring(selection.getFin() );
		selection.setFin(selection.getDebut());	//maj curseur
		}
		else{
			if(selection.getDebut()!=0){			//remove bug delete on start
			str=str.substring(0, selection.getDebut()-1) + str.substring(selection.getDebut() );
			selection.setDebut(selection.getDebut()-1);
			selection.setFin(selection.getDebut());		//maj curseur
		}
		}
	
		this.notify_Obs();
	}
	public void redo() {
		
		try{
			restoreState(care.next());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			this.notify_Obs();
	}
	public void undo() {
		
		try{
			if (undo_flag==0){
				care.addState(new Memento(str));
				undo_flag=1;
			}
		restoreState(care.previous());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.notify_Obs();
	}
	
	@Override
	public void insert() {
		undo_flag=0;
		care.addState(new Memento(str));
		str=str.substring (0, selection.getDebut())+ pressP.toString() + str.substring (selection.getFin());		
		this.notify_Obs();
	}
	
	public void notify_Obs() {
   	 for (int i =0; i < arr_Obs.size(); i++)
   	 	{
   		 arr_Obs.get(i).update(this);
   	 	}
	}

	@Override
	public void refresh() {		
			
		//care.addState(new Memento(str));
		this.notify_Obs();
	}
	
	public void addchar() {		
		undo_flag=0;
		care.addState(new Memento(str));			
		String tmp1=str.substring (0, selection.getDebut());
		String tmp2=str.substring (selection.getFin());
		str= tmp1+ addchar +tmp2 ;	
		selection.setDebut(selection.getDebut()+1);
		selection.setFin(selection.getDebut());
		this.notify_Obs();
	}
	
	public void setaddchar(String g) {		
		addchar=g;	
	}
	
	public  void setSelection(int a,int b)  {
		selection.setDebut(a);
		selection.setFin(b);
	}
	
	@Override
	public void restoreFromMomento(Memento pMemento) {
		this.str=pMemento.getSaavedState();		
	}
	
	@Override
	public void saveInMemento() {
		Memento a = new Memento(str);
		this.care.addState(a);
	}


}
