package coinpurse;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * GUI for showing a balance of purse.
 * 
 * @author Patinya Yongyai
 *
 */
public class PurseBalanceObserver extends JFrame implements Observer{
	private static final int FONT_SIZE = 30;
	private JTextArea textarea;
	
	/**
	 * Constructor for initialize GUI
	 */
	public PurseBalanceObserver() {
		this.setTitle("Purse Balance");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	/**
	 * Initial all components in GUI
	 */
	public void initComponents() {
		textarea = new JTextArea(2,10);
		textarea.setEditable(false);
		textarea.setFont( new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE) );
		
		JScrollPane scrollpane = new JScrollPane( textarea );
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollpane);
		this.pack();
	}

	/**
	 * Update UI when balance in a purse was updated.
	 */
	@Override
	public void update(Observable subject, Object info) {
		if (info != null) textarea.setText(info+"\n");
		
		if (subject instanceof Purse) {
			Purse purse = (Purse)subject;
			textarea.setText(purse.getBalance()+" "+"Baht"+"\n");
		}
	}
	
	/**
	 * To enable GUI of this frame.
	 */
	public void run() {
		this.setVisible(true);
	}

}
