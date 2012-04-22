import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class UI extends JFrame implements Iobserver, KeyListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
			
	private Icmd copyCMD;	
	private Icmd collerCMD;//
	private Icmd deleteCMD;//
	private Icmd undoCMD;//
	private Icmd redoCMD;//
	@SuppressWarnings("unused")
	private Icmd insertCMD ;//
	private Icmd refreshCMD ;//
	private Icmd cutCMD ;//	
	private int a=0;
	private int b=0;
	private Frame f = new Frame("Frame"); 
	private JPanel container = new JPanel();
	private JButton copy= new JButton("Copy");
	private JButton coller= new JButton("Coller");
	private JButton cut= new JButton("Cut");
	private JButton undo= new JButton("UNdo");
	private JButton redo= new JButton("REdo");
	private TextArea textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_BOTH);


	 
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
		 textArea.setEditable(true);	
		 textArea.setBackground(Color.BLACK);
		 textArea.setForeground(Color.WHITE);	
		 textArea.setPreferredSize(new Dimension(150, 520));
		 textArea.addMouseListener(this);
		 textArea.addKeyListener(this);
		 container.setPreferredSize(new Dimension(150,45));
		 container.setLayout(new GridLayout(1,5));
		 container.add(copy);
		 container.add(coller);
		 container.add(cut);
		 container.add(undo);
		 container.add(redo);
		 copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
							
				copyCMD.execute();
			}
		});
		coller.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				collerCMD.execute();
			}
		});
		cut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				cutCMD.execute();
			}
		});
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				undoCMD.execute();
			}
		});
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				redoCMD.execute();
			}
		});
		 this.getContentPane().setLayout(new BorderLayout()); 	
		 this.getContentPane().add(container,BorderLayout.NORTH);
		 this.getContentPane().add(textArea,BorderLayout.SOUTH);
		 this.setVisible(true);
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

	
	public void update(Object a) {
		
		if(a instanceof Ibuffer) 
		{
			Ibuffer b = (Ibuffer) a;
			textArea.setText(b.getStr());
			textArea.setSelectionStart(b.getSelection().getDebut());		//maj SELECTEDselection
			textArea.setSelectionEnd(b.getSelection().getFin());			//maj SELECTEDselection
			System.out.println(b.getStr()); 
			System.out.println("     Presse Papier : **# "+ b.getPressP().getClip()+" #**");
				
		}
		
	}

	

	@Override
	public void keyPressed(KeyEvent arg0) {

		 if ( arg0.getKeyCode() == KeyEvent.VK_ENTER){
					    	
		    	Buffer.str=textArea.getText().substring(0,textArea.getSelectionStart())+System.getProperty("line.separator")+textArea.getText().substring(textArea.getSelectionEnd());
		    	a=textArea.getSelectionStart();
		   	 	b=textArea.getSelectionEnd();
		   		Buffer.setSelection(a,b);		    	
		    	
		    	refreshCMD.execute();//add caretaker
		    }
		 else if ( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			 Buffer.str=textArea.getText();
		    	deleteCMD.execute();
		    }
		 
		 else{
			 a=textArea.getSelectionStart();
			 b=textArea.getSelectionEnd();
			 
			 Buffer.str=textArea.getText();
			 Buffer.setSelection(a,b);		    	
		    	
		    	refreshCMD.execute();
		 }
		 
		 
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		refreshCMD.execute();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	 a=textArea.getSelectionStart();
	 b=textArea.getSelectionEnd();
	
		Buffer.setSelection(a,b);
	
		
	}



	

}
