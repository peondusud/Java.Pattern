
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.StringTokenizer;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


public class UIconsole extends JFrame implements Iobserver, KeyListener,IuI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private Icmd copyCMD;	
	private Icmd collerCMD;
	private Icmd deleteCMD;
	private Icmd undoCMD;
	private Icmd redoCMD;
	@SuppressWarnings("unused")
	private Icmd insertCMD ;
	private Icmd refreshCMD ;
	private Icmd cutCMD ;
	private Icmd addCharCMD ;
	private Buffer buf;
	private int a=0;
	private int b=0;
	private Frame f = new Frame("Frame"); 
	//private JPanel container = new JPanel();
	private TextArea textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
	private JTextField textAction =new JTextField("");

	 
	public void create() {
		
		 this.setSize(800,600);
		 this.setTitle("Java Notepad Consl");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setLocationRelativeTo(null);
	     this.setVisible(false);
	     f.setForeground(Color.BLACK);
	     Font police = new Font("Century Gothic", Font.BOLD, 14); 	
		 //container.setBackground(Color.white);
	     f.setBackground(Color.BLACK);
		 textArea.setFont(police);
		 textArea.setEditable(false);
		 textArea.setBackground(Color.BLACK);
		 textArea.setForeground(Color.WHITE);	
		 textArea.setPreferredSize(new Dimension(150, 525));
		 textAction.setBackground(Color.BLACK);
		 textAction.setForeground(Color.BLUE);
		 textAction.setFont(police);
		 textAction.setPreferredSize(new Dimension(150, 30));
		 textAction.addKeyListener(this);		
		 this.getContentPane().setLayout(new BorderLayout()); 
		 this.getContentPane().add(textArea,BorderLayout.NORTH);
		 this.getContentPane().add(textAction,BorderLayout.SOUTH);
		 this.setVisible(true);
		}
	

	
	
	public void update(Object a) {
		
		if(a instanceof Ibuffer) 
		{
			Ibuffer b = (Ibuffer) a;
			textArea.setText("");
			textArea.setText(b.getStr());
			System.out.println(b.getStr()); 
			System.out.println("     Presse Papier : **# "+ b.getPressP().getClip()+" #**");
			
		}
		
	}

	

	@Override
	public void keyPressed(KeyEvent arg0) {
		 if ( arg0.getKeyCode() == KeyEvent.VK_ENTER){
			 String name =textAction.getText();
			  if( name.startsWith("select(") && name.endsWith(")") ){ 	//select(***)
	            	
	        	   if( name.matches("^[select(]{7}[0-9]*[,][0-9]*[)]") ){  //regex select(digit,digit)
	        		   
	        		  String temp= name.substring("select(".length());				
	        		  StringTokenizer tokenizer = new StringTokenizer(temp,",");		//cut string @ ","
	        		  int debu = Integer.valueOf(tokenizer.nextToken());
	        		  String fin = tokenizer.nextToken();
	        		  //buff.selection.select(debu, Integer.valueOf(fin.substring(0,fin.length()-1))); 	 
	        		  buf.setSelection(debu, Integer.valueOf(fin.substring(0,fin.length()-1)));
	        	   }
	        	   
	        	   if( name.matches("^[select(]{7}[0-9]*[)]") ){  //regex select(digit)
	        		   
	        		   String debu= name.substring("select(".length());	
	        		   int a=Integer.valueOf(debu.substring(0,debu.length()-1));
	        		   //buff.selection.select( Integer.valueOf(debu.substring(0,debu.length()-1))); 	
	        		   buf.setSelection(a,a);
		        	   }
	        	   
	        	   
	            }
	           else if( name.startsWith("copy(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[copy(]{5}[)]") ){
	        	   
	        		   copyCMD.execute();
	        	   }	           
	           }
	           
	           else if( name.startsWith("coller(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[coller(]{7}[)]") ){
	        	   
	        		   collerCMD.execute();
	        	   }	           
	           }
	           else if( name.startsWith("del(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[del(]{4}[)]") ){
	        		   
	        		   deleteCMD.execute();
	        	   }	           
	           }
	           else if( name.startsWith("undo(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[undo(]{5}[)]") ){
	        	   
	        		   undoCMD.execute();
	        	   }	           
	           }
	           else if( name.startsWith("redo(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[redo(]{5}[)]") ){
	        	   
	        		   redoCMD.execute();
	        	   }	           
	           }
	           else if( name.startsWith("insert(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[insert(]{7}[)]") ){
	        		   
	        		   insertCMD.execute();
	        	   }	           
	           }
	           else if( name.startsWith("cut(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[cut(]{4}[)]") ){
	        		   
	        		   cutCMD.execute();
	        	   }	           
	           }
	           else if( name.startsWith("enter(") && name.endsWith(")") ) {
	        	   
	        	   if( name.matches("^[enter(]{6}[)]") ){
	        		   String newline = System.getProperty("line.separator");
	  	             buf.setStr(buf.getStr()+newline);
	        		   
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
	             //buf.setStr(buf.getStr()+name);	        
	             buf.setaddchar(textAction.getText());
			    	textAction.setText("");
					 addCharCMD.execute();
	            
	            }
			  textAction.setText("");
	        }
			 
		    	
		    }
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		buf.notify_Obs();
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}


	public void setcopyCMD(Icmd e){		
		copyCMD=e;		
	}
	public void setcollerCMD(Icmd e){		
		collerCMD=e;		
	}
	public void setcutCMD(Icmd e){		
		cutCMD=e;		
	}
	
	public void setdeleteCMD(Icmd e){		
		deleteCMD=e;		
	}
	public void setundoCMD(Icmd e){		
		undoCMD=e;		
	}
	public void setredoCMD(Icmd e){		
		redoCMD=e;		
	}
	public void setinsertCMD(Icmd e){		
		insertCMD=e;		
	}
	public void setrefreshCMD(Icmd e){		
		refreshCMD=e;		
	}

	public void setaddCharCMD(Icmd e){		
		addCharCMD=e;		
	}
	public void setBuffer(Ibuffer ib){
		buf=(Buffer)ib;
	}

	public static void help(){
		 JFrame parent = new JFrame();
		 Object complexMsg[]={"Selection(digit,digit) = Selection" ,"copy() = copy","coller() = coller","cut() = cut","insert() = insert","redo() = redo","undo() = undo","enter() = retour ligne","del() = delete"};
		    JOptionPane optionPane = new JOptionPane(complexMsg, JOptionPane.INFORMATION_MESSAGE);
		    JDialog dialog = optionPane.createDialog(parent, "HELP");
		    dialog.setVisible(true);
	/*	System.out.println("Selection(digit,digit) = Selection");
	   System.out.println("copy() = copy");
	   System.out.println("coller() = coller");
	   System.out.println("cut() = cut");
	   System.out.println("insert() = insert");
	   System.out.println("redo() = redo");
	   System.out.println("undo() = undo");
	   System.out.println("enter() = retour ligne");
	   System.out.println("del() = delete");		*/
}
	

}
