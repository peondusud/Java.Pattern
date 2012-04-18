


public class UI  implements Iobserver{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Icmd icmd ;


	public void create() {
		// TODO Auto-generated method stub		
			
		}
	
	public void setcmd(Icmd e){
		
		icmd=e;
		
		
	}
	
	
	public void update(Object a) {
		// TODO Auto-generated method stub
		if(a instanceof Ibuffer) 
		{
			Ibuffer b = (Ibuffer) a;
			System.out.println(b.getStr()); 
			System.out.println("Presse Papier : "+ b.getPressP().getClip());
		}
		
	}



	public int getState() {
		return 0;
		// TODO Auto-generated method stub
		
	}

	


	

}
