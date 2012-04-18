import java.util.*;


public class Appz {

	
	public static void main(String[] args) {
		
		Buffer buff = new Buffer();
		UI gui = new UI();	
		buff.add(gui);
		gui.create();			
		Icmd copy = new Copy(buff,gui);//		
		Icmd coller = new Coller(buff,gui);//
		Icmd delete = new Del(buff,gui);//
		Icmd undo = new Undo(buff,gui);//
		Icmd redo = new Refaire(buff,gui);//
		Icmd insert = new Insert(buff,gui);//
		
		buff.setStr("toto est la, tata est la!");
		buff.selection.select(10, 15); 	
		copy.execute();		
		buff.selection.select(2,4);//
		copy.execute();//
		buff.selection.select(2,2);//
		coller.execute();
		 
		 Scanner in = new Scanner(System.in);
		 String name;
		  while (in.hasNext()) {
	            name = in.nextLine();
	            
	            
	           if( name.startsWith("select(") && name.endsWith(")") ){ 	//select(***)
	            	
	        	   if( name.matches("^[select(]{7}[0-9]*[,][0-9]*[)]") ){  //regex select(digit,digit)
	        		   
	        		  String temp= name.substring("select(".length());
	        		  StringTokenizer tokenizer = new StringTokenizer(temp,",");
	        		  int debu = Integer.valueOf(tokenizer.nextToken());
	        		  String fin = tokenizer.nextToken();
	        		  buff.selection.select(debu, Integer.valueOf(fin.substring(0,fin.length()-1))); 	        		        		   
	        	   }
	        	   
	        	   if( name.matches("^[select(]{7}[0-9]*[)]") ){  //regex select(digit)
	        		   
	        		   String debu= name.substring("select(".length());		 
	        		   buff.selection.select( Integer.valueOf(debu.substring(0,debu.length()-1))); 	        		  		   
		        	   }
	        	   
	        	   
	            }
	           else if( name.startsWith("copy(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[copy(]{5}[)]") ){
	        	   
	        		   copy.execute();
	        	   }	           
	           }
	           
	           else if( name.startsWith("coller(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[coller(]{7}[)]") ){
	        	   
	        		   coller.execute();
	        	   }	           
	           }
	           else if( name.startsWith("del(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[del(]{4}[)]") ){
	        		   
	        		   delete.execute();
	        	   }	           
	           }
	           else if( name.startsWith("undo(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[undo(]{5}[)]") ){
	        	   
	        		   undo.execute();
	        	   }	           
	           }
	           else if( name.startsWith("redo(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[redo(]{5}[)]") ){
	        	   
	        		   redo.execute();
	        	   }	           
	           }
	           else if( name.startsWith("insert(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[insert(]{7}[)]") ){
	        		   
	        		   insert.execute();
	        	   }	           
	           }
	           
	           
	           
	            else
	            {
	            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	            String newline = System.getProperty("line.separator");
	             buff.setStr(buff.getStr()+newline+name);
	             gui.update(buff);
	            }
	        }
	        in.close(); 
		
	//	while(true) {}
	}
	
	
}
