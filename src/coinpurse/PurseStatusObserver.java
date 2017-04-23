package coinpurse;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PurseStatusObserver extends JFrame implements Observer{

	private static final int FONT_SIZE = 30;
	private JTextArea textarea;
	private JProgressBar progressBar;
	
	public PurseStatusObserver() {
		this.setTitle("Purse Status");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	public void initComponents() {
		textarea = new JTextArea(2,10);
		textarea.setEditable(false);
		textarea.setFont( new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE) );
		
		this.setLayout(new BorderLayout());
		progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		JScrollPane scrollpane = new JScrollPane( textarea );
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollpane, BorderLayout.NORTH);
		this.add(progressBar, BorderLayout.SOUTH);
		this.pack();
	}

	@Override
	public void update(Observable subject, Object info) {
		if (info != null) textarea.setText(info+"\n");
		
		if (subject instanceof Purse) {
			Purse purse = (Purse)subject;
			progressBar.setMaximum(purse.getCapacity());
			if( purse.isFull() && purse.count() != 0 ){
				textarea.setText("FULL");
			} else if(purse.count() != 0) {
				textarea.setText(purse.count()+"/"+purse.getCapacity());
			} else {
				textarea.setText("EMPTY");
			}
			progressBar.setValue(purse.count());
		}
	}
	
	public void run() {
		this.setVisible(true);
	}

}
