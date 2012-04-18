
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class GUI extends JFrame implements Iobserver,ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Icmd icmd ;
	Frame f = new Frame("Frame"); 
    MenuBar menuBar= new MenuBar(); 
    Menu file = new Menu();
    TextArea textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
    MenuItem openFile = new MenuItem(); 
    MenuItem saveFile = new MenuItem(); 
  	MenuItem close = new MenuItem();

	public void create() {
		// TODO Auto-generated method stub		
			
		 this.setSize(500, 300);
		 this.setTitle("Java Notepad 1");
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12)); 		
		 this.getContentPane().setLayout(new BorderLayout()); 
		 this.getContentPane().add(textArea); 		
		 this.setMenuBar(this.menuBar);
		 this.menuBar.add(this.file); 		     
		 this.openFile.setLabel("Open");
		 this.openFile.addActionListener(this); 
		 this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));
		 this.file.add(this.openFile);		  
		  this.saveFile.setLabel("Save");
		  this.saveFile.addActionListener(this);
		  this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
		  this.file.add(this.saveFile);		  
		  this.close.setLabel("Close");
		  this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
		  this.close.addActionListener(this);
		  this.file.add(this.close);
		  this.setVisible(true);
		}
	
	
	public void update(Buffer b) {
		// TODO Auto-generated method stub
		
		
		
	}

	public void update() {
		// TODO Auto-generated method stub
	//	System.out.println(getStr()); 
	}

	@Override
	public int getState() {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setState(int a) {
		// TODO Auto-generated method stub
		
	}

	public void execute() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        // if the source of the event was our "close" option
	    if (e.getSource() == this.close)
	           this.dispose(); // dispose all resources and close the application
		       
	     // if the source was the "open" option
	     else if (e.getSource() == this.openFile) {
	          JFileChooser open = new JFileChooser(); // open up a file chooser (a dialog for the user to browse files to open)
	          int option = open.showOpenDialog(this); // get the option that the user selected (approve or cancel)
	            // NOTE: because we are OPENing a file, we call showOpenDialog~
	           // if the user clicked OK, we have "APPROVE_OPTION"
		            // so we want to open the file
		            if (option == JFileChooser.APPROVE_OPTION) {
			                this.textArea.setText(""); // clear the TextArea before applying the file contents
		                try {
	                    // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
	                    Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
			                    while (scan.hasNext()) // while there's still something to read
		                        this.textArea.append(scan.nextLine() + "\n"); // append the line to the TextArea
		                } catch (Exception ex) { // catch any exceptions, and...
			                    // ...write to the debug console
			                    System.out.println(ex.getMessage());
		                }
			            }
		        }
			         
		
		        else if (e.getSource() == this.saveFile) {
	            JFileChooser save = new JFileChooser(); 
	            int option = save.showSaveDialog(this);
		
		            if (option == JFileChooser.APPROVE_OPTION) {
			                try {		                 
		                    BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
		                    out.write(this.textArea.getText()); 
	                  out.close(); 
	                } catch (Exception ex) { 
	                   
	                    System.out.println(ex.getMessage());
	                }
		           }
	        }
		 
		
	}


	@Override
	public void update(Object b) {
		// TODO Auto-generated method stub
		
	}




}
