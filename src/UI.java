import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.MenuShortcut;
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
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


public class UI extends JFrame implements Iobserver, KeyListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Icmd icmd ;	
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
				System.out.println("copy"); 
				System.out.println(textArea.getCaretPosition()); 
				System.out.println(textArea.getSelectionStart()); 
				System.out.println(textArea.getSelectionEnd()); 
				copy.execute;
			}
		});
		coller.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("coller"); 
				coller.execute;
			}
		});
		cut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("cut"); 
				cut.execute;
			}
		});
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("undo"); 
				undo.execute;
			}
		});
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("redo"); 
				redo.execute;
			}
		});
		 this.getContentPane().setLayout(new BorderLayout()); 	
		 this.getContentPane().add(container,BorderLayout.NORTH);
		 this.getContentPane().add(textArea,BorderLayout.SOUTH);
		 this.setVisible(true);
		}
	
	public void setcmd(Icmd e){
		
		icmd=e;		
	}
	
	
	public void update(Object a) {
		
		if(a instanceof Ibuffer) 
		{
			Ibuffer b = (Ibuffer) a;
			textArea.setText(b.getStr());
			System.out.println(b.getStr()); 
			System.out.println("     Presse Papier : **# "+ b.getPressP().getClip()+" #**");
			
			
		}
		
	}

	

	@Override
	public void keyPressed(KeyEvent arg0) {

		 if ( arg0.getKeyCode() == KeyEvent.VK_ENTER){
		    	textArea.setText(textArea.getText()+System.getProperty("line.separator"));
		    	//add a caretaker
		    }
		 if ( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE){
		    	textArea.setText(textArea.getText());
		    	//add a caretaker
		    }
		 
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		selection.getdebut(textArea.getSelectionStart());
		selection.getfin(textArea.getSelectionEnd());
		b.getPressP().setClip()( buff.str.substring(   textArea.getSelectionStart(), textArea.getSelectionEnd())  );
		
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
		// TODO Auto-generated method stub
		
	}



	

}
