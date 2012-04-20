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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UI extends JFrame implements ActionListener,Iobserver, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Icmd icmd ;	
	private Frame f = new Frame("Frame"); 
	private JPanel container = new JPanel();
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
	
	public void setcmd(Icmd e){
		
		icmd=e;		
	}
	
	
	public void update(Object a) {
		
		if(a instanceof Ibuffer) 
		{
			Ibuffer b = (Ibuffer) a;
			System.out.println(b.getStr()); 
			System.out.println("     Presse Papier : **# "+ b.getPressP().getClip()+" #**");
		}
		
	}

	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		 if ( arg0.getKeyCode() == KeyEvent.VK_ENTER){
		    	textArea.setText(textAction.getText());
		    	textAction.setText("");
		    }
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
