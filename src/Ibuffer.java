
public interface Ibuffer {
	
	
	public Clipboard getPressP() ;
	public void setPressP(Clipboard pressP);
	public Selection getSelection();
	public void setSelection(Selection selection) ;
	public Caretaker getCare();
	public void setCare(Caretaker care);
	public String getStr();
	public void setStr(String str);
	
	
	public void add(Iobserver o);
	public void del(Iobserver o);
	public void insert();
	public void copy();
	public void cut();
	public void coller();
	public void delete();
	public void undo() ;
	public void redo();
	public void refresh();
	

}
