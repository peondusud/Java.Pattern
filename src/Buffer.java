import java.util.ArrayList;



public class Buffer implements Isujet,Ibuffer{

	public Clipboard pressP;
	public static Selection selection;
	private Caretaker care;	
	public ArrayList<Iobserver> arr_Obs =new ArrayList<Iobserver>();
	public String str;
	private static int cut_flag=0;
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
		arr_Obs.remove(o);
	}
	
	
	public  void copy() {
		cut_flag=2;
		care.addState(new String(str));
		pressP.setClip(str.substring(selection.getDebut(),selection.getFin()));	
		this.notify_Obs();		
	}
public  void cut() {
		cut_flag=1;
		//copy();
		//delete();
		care.addState(new String(str));
		pressP.setClip(str.substring(selection.getDebut(),selection.getFin()));	
		str=str.substring (0, selection.getDebut()) + str.substring (selection.getFin());
		this.notify_Obs();		
	}
	
	public void coller() {
		
		care.addState(new String(str));
		String tmp1=str.substring(0, selection.getDebut()).toString();		
		String tmp2=pressP.getClip().toString();
		String tmp3=str.substring(selection.getFin()).toString();
		
		if(cut_flag==1){	
			//str="";
			
			str=new StringBuilder().append(tmp1).append(tmp2).append(tmp3).toString();		//str=tmp1 + tmp2 + tmp3; //kelmerde
			pressP.setClip("");
		cut_flag=0;
		}
		else if(cut_flag==2){
			//str=str.substring(0, selection.getDebut()) +  pressP.getClip() + str.substring(selection.getFin() );
			//str="";
			str=new StringBuilder().append(tmp1).append(tmp2).append(tmp3).toString();	
		}
		else{
			pressP.setClip("");
				
		}
		this.notify_Obs();
	}
	public void delete() {
		
		care.addState(new String(str));
		str=str.substring(0, selection.getDebut()) + str.substring(selection.getFin(), str.length() );
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
		
		str=str.substring (0, selection.getDebut())+ pressP.toString() + str.substring (selection.getFin());
		care.addState(new String(str));
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
	
	public static void setSelection(int a,int b)  {
		selection.debut=  a;
		selection.fin=b;
		
		
	}


}
