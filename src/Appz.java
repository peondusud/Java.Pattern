import java.util.*;


public class Appz {

	
	public static void main(String[] args) {
		if( args.equals("--guiconsole")){		//gui-console  args[0]
			help();
			Buffer buff = new Buffer();	
			UIconsole gui = new UIconsole();
			buff.add(gui);
			gui.create();			
			Icmd copy = new Copy(buff);//		
			Icmd coller = new Coller(buff);//
			Icmd delete = new Del(buff);//
			Icmd undo = new Undo(buff);//
			Icmd redo = new Refaire(buff);//
			Icmd insert = new Insert(buff);//
			Icmd refresh = new Refresh(buff);//
			Icmd cut = new Cut(buff);//
			Icmd addchar = new AddChar(buff);//
			gui.setcopyCMD(copy);
			gui.setcollerCMD(coller);
			gui.setdeleteCMD(delete);
			gui.setundoCMD(undo);
			gui.setredoCMD(redo);
			gui.setcutCMD(cut);
			gui.setrefreshCMD(refresh);
			gui.setinsertCMD(insert);
			gui.setaddCharCMD(addchar);
			gui.setBuffer(buff);
		}
		else if( args.equals("--console")){		//console
			help();
			Buffer buff = new Buffer();	
			Icmd copy = new Copy(buff);//		
			Icmd coller = new Coller(buff);//
			Icmd delete = new Del(buff);//
			Icmd undo = new Undo(buff);//
			Icmd redo = new Refaire(buff);//
			Icmd insert = new Insert(buff);//
			Icmd refresh = new Refresh(buff);//
			Icmd cut = new Cut(buff);//
			Icmd addchar = new AddChar(buff);//
			 Scanner in = new Scanner(System.in);
			 String name;
			  while (in.hasNext()) {
		            name = in.nextLine();	            
		            
		           if( name.startsWith("select(") && name.endsWith(")") ){ 	//select(***)
		            	
		        	   if( name.matches("^[select(]{7}[0-9]*[,][0-9]*[)]") ){  //regex select(digit,digit)
		        		   
		        		  String temp= name.substring("select(".length());				
		        		  StringTokenizer tokenizer = new StringTokenizer(temp,",");		//cut string @ ","
		        		  int debu = Integer.valueOf(tokenizer.nextToken());
		        		  String fin = tokenizer.nextToken();
		        		  //buff.selection.select(debu, Integer.valueOf(fin.substring(0,fin.length()-1))); 	 
		        		  buff.setSelection(debu, Integer.valueOf(fin.substring(0,fin.length()-1)));
		        	   }
		        	   
		        	   if( name.matches("^[select(]{7}[0-9]*[)]") ){  //regex select(digit)
		        		   
		        		   String debu= name.substring("select(".length());	
		        		   int a=Integer.valueOf(debu.substring(0,debu.length()-1));
		        		   //buff.selection.select( Integer.valueOf(debu.substring(0,debu.length()-1))); 	
		        		   buff.setSelection(a,a);
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
		           else if( name.startsWith("cut(") && name.endsWith(")") ) {
		        	   
		        	   if( name.matches("^[cut(]{4}[)]") ){
		        		   
		        		   cut.execute();
		        	   }	           
		           }
		           else if( name.startsWith("enter(") && name.endsWith(")") ) {
		        	   
		        	   if( name.matches("^[enter(]{6}[)]") ){
		        		   String newline = System.getProperty("line.separator");
		  	             buff.setStr(buff.getStr()+newline);
		        		   
		        	   }	           
		           }
		           else if( name.startsWith("help(") && name.endsWith(")") ) {
		        	   
		        	   if( name.matches("^[help(]{5}[)]") ){
		        		   help();
		        	   }	           
		           }
		           else if( name.startsWith("--help") ) {
		        	   
		        	   if( name.matches("^[--help]{6}") ){
		        		   help();
		        	   }	           
		           }
		       
		            else
		            {
		            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		             buff.setStr(buff.getStr()+name);
		             refresh.execute();
		            
		            }
		        }
		        in.close(); 
		}
		else{
									//GUI
		Buffer buff = new Buffer();	
		UI gui = new UI();							//GUInotepad
		//UIconsole gui = new UIconsole();			//GUIconsole
		buff.add(gui);
		gui.create();			
		Icmd copy = new Copy(buff);//		
		Icmd coller = new Coller(buff);//
		Icmd delete = new Del(buff);//
		Icmd undo = new Undo(buff);//
		Icmd redo = new Refaire(buff);//
		Icmd insert = new Insert(buff);//
		Icmd refresh = new Refresh(buff);//
		Icmd cut = new Cut(buff);//
		Icmd addchar = new AddChar(buff);//
		gui.setcopyCMD(copy);
		gui.setcollerCMD(coller);
		gui.setdeleteCMD(delete);
		gui.setundoCMD(undo);
		gui.setredoCMD(redo);
		gui.setcutCMD(cut);
		gui.setrefreshCMD(refresh);
		gui.setinsertCMD(insert);
		gui.setaddCharCMD(addchar);
		gui.setBuffer(buff);	
		
		}		
		
	}
	
	
	public static void help(){
			System.out.println("Selection(digit,digit) = Selection");
		   System.out.println("copy() = copy");
		   System.out.println("coller() = coller");
		   System.out.println("cut() = cut");
		   System.out.println("insert() = insert");
		   System.out.println("redo() = redo");
		   System.out.println("undo() = undo");
		   System.out.println("enter() = retour ligne");
		   System.out.println("del() = delete");		
	}

	
}
