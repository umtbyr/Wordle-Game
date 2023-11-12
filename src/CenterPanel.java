import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterPanel extends JPanel  {
	// initiate the current row and column 
	int currentRow = 0;
	int currentColumn = -1;
	JLabel title;
	int x = 60;
	int y = 60;
	//Create 2D array that is going to contain box objects which are JLabel
	Box[][] Boxes;
	JLabel notinthelist;
	public CenterPanel() {
		// set the title's features
		title = new JLabel("WORDLE");
		title.setBounds(140, 15, 100, 20);
		title.setForeground(new Color(252, 181, 3));
		title.setFont(new Font("Serif",Font.BOLD,20));
		// add the title to the CenterPanel
		add(title);
		// set the notinthelist label's features
		notinthelist = new JLabel("Word is not in the list!");
		notinthelist.setBounds(110, 280, 200, 20);
		notinthelist.setFont(new Font("Serif",Font.BOLD,15));
		notinthelist.setVisible(false);
		// ad it to the CenterPanel
		add(notinthelist);
		setLayout(null);
		
		
		setBackground(Color.white);
		Boxes = new Box[6][5];
		// To create and add the boxes to the CenterPanel and set boxes coordinates
		for (int i = 0; i < 6; i++) {
			
			
			for (int j = 0; j <5; j++) {
				x+=35;
				Boxes[i][j] = new Box();
				Boxes[i][j].setBounds(x, y, 30, 30);
				add(Boxes[i][j]);
			}	
			x=60;
			y+=35;
			
		}
		
	}
	// to return all 5 letters to the mainFrame this function returns an array
	public Box[] getRowBox() {
		
		return Boxes[currentRow];			
		
		
	}
	// to return the further box to the mainFrame
	public Box getBox() {
		// if currenColumn is 4 that means its and of the line so we add 1 to the row and make the Column 0
		if(currentColumn==4) {
			currentRow++;
			currentColumn=0;
			
		}
		else {
			currentColumn++;
		}
		System.out.println(currentColumn);
		
		return Boxes[currentRow][currentColumn];
	}

}

