import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RestartMenu extends JFrame implements ActionListener{
	//to initiate restart button
	JButton jbRestart;
	// to show some message we initiate a label
	JLabel p;
	// to understand the user win the game or not
	boolean iswin;
	// to get the answer from the mainFrame
	String Answer;
	// to indicate how many try that takes to users win
	int shotCount;
	public RestartMenu(boolean iswin,String Answer,int shotCount) {
		super("Wordle");
		this.iswin = iswin;
		this.Answer = Answer;
		this.shotCount = shotCount;
		// set the main frame features
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(null);
		// set the buttons features
		jbRestart = new JButton("ReStart");
		jbRestart.setBounds(100, 100, 150, 150);
		jbRestart.addActionListener(this);
		add(jbRestart);
		showMessage(iswin);
	}
	// to show a message tý the user
	public void showMessage(boolean a) {
		if(a) {
			p = new JLabel("YOU WON " + "AT THE "+ shotCount + "."+" TRY"+ " THE ANSWER IS " + Answer.toUpperCase());
			p.setBounds(40,60,300,20);
			p.setForeground(new Color(207, 42, 27));
			p.setFont(new Font("Serif",Font.BOLD,12));
			add(p);
		}
		else {
			p = new JLabel("YOU LOSE  THE ANSWER IS " + Answer.toUpperCase());
			p.setBounds(80,60,300,20);
			p.setForeground(new Color(207, 42, 27));
			p.setFont(new Font("Serif",Font.BOLD,12));
			add(p);
			
		}
	}
	

	@Override
	// if the user clicks the restart we create new mainFrame object
	public void actionPerformed(ActionEvent e) {
		MainFrame mf = new MainFrame();
		setVisible(false);
		
		
		
	}
}
