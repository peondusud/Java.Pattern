import java.util.ArrayList;
import java.util.Iterator;




public class Buffer implements Isujet,Ibuffer{

	public Clipboard pressP;
	public Selection selection;
	public Caretaker care;
	
	public ArrayList<Iobserver> arr_Obs =new ArrayList<Iobserver>();

	public String str;
	public Buffer() {
		str=new String();
		pressP=new Clipboard();
		selection=new Selection();
		care=new Caretaker();
		
	}
	
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
		if(r instanceof String){
			
			this.str=(String)r;			
		}
				
	}
	
	
	@Override
	public void add(Iobserver o) {
		arr_Obs.add(o);		
	}
	@Override
	public void del(Iobserver o) {
		// TODO Auto-generated method stub
		
	}
	
	
	public  void copy() {
		
		pressP.setClip(str.substring(selection.getDebut(),selection.getFin()));	
		this.notify_Obs();		
	}
public  void cut() {
		
		pressP.setClip(str.substring(selection.getDebut(),selection.getFin()));	
		str=str.substring (0, selection.getDebut()) + str.substring (selection.getFin());
		this.notify_Obs();		
	}
	
	public void coller() {
	
		care.addState(new String(str));
		str=str.substring(0, selection.getDebut()) + pressP.getClip() + str.substring(selection.getFin(), str.length());
	
		this.notify_Obs();
	}
	public void delete() {
		
		care.addState(new String(str));
		str=str.substring(0, selection.getDebut())+str.substring(selection.getFin(), str.length());
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
		care.addState(new String(str));
		restoreState(care.previous());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.notify_Obs();
	}
	
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
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
		
		care.addState(new String(str));
		this.notify_Obs();
	}

	

}
