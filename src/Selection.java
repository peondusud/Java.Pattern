
public class Selection {
	
	int debut;
	int fin;
	
	
	public  void select(int a, int b)
	{
		this.debut=a;
		this.fin=b;
		
	}
	public  void select(int a)
	{
		this.debut=a;
		this.fin=a;
		
	}


	public int getDebut() {
		return debut;
	}


	public void setDebut(int debut) {
		this.debut = debut;
	}


	public int getFin() {
		return fin;
	}


	public void setFin(int fin) {
		this.fin = fin;
	}	

}
