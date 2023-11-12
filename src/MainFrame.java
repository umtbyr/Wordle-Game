import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements KeyListener {
	//to show that game is finish or not
	boolean isRun = true;
	//String that we get from the wordlist
	String Stringfromdatabase;
	//initiate Center panel
	CenterPanel cp;
	//initiate user string 
	String currentString ="";	
	// to read word file
	File db;
		
	
	public MainFrame() {
		// get the string from wordlist
		Stringfromdatabase = ReadRandom().toUpperCase();
		// add keylistener to get input from the user
		addKeyListener(this);
		// create the panel
		cp = new CenterPanel();
		// set the MainFrame's property
		setTitle("Wordle");
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add the main panel to MainFrame which extends from JFrame
		add(cp);
		System.out.println(Stringfromdatabase);
		
	}
	// To select a random word from wordlist
	public String ReadRandom() {
		String randLine = "";
		Random rand = new Random();
		int uperBound = 10000;
		int random = rand.nextInt(uperBound);
		try {
			String line = Files.readAllLines(Paths.get("src/words.txt")).get(random);
			System.out.println(line);
			randLine = line;
			
			
			
		}catch(IOException e){
			System.out.println(e);
		}
		return randLine;
	}

	// This function determine the user string is in the wordlist or not
	public int ComparewithDbReadFile(String s) {
			int rtrn = 0;
		try {
			File db = new File("src/words.txt");
			Scanner reader = new Scanner(db);
			while(reader.hasNext()) {
				String data = reader.nextLine();
				
				if(data.equalsIgnoreCase(s)) {
					System.out.println("BURA ÇALIÞTI");
					rtrn = 1;
				}
				
				
			}
			reader.close();
		}catch (FileNotFoundException e) {
			System.out.println("FileNotFound");
			e.printStackTrace();
		}
		System.out.println(rtrn);
		return rtrn;
		
	}


	//Handlers to handle the user inputs
	@Override
	public void keyPressed(KeyEvent e) {
		// when the currentColumn is 4 in that case we want to user to press enter to compare the string with the answer of the question
		if(cp.currentColumn!=4) {
			if(e.getKeyCode()==KeyEvent.VK_Q ) {
				cp.getBox().setText("Q");
			}
			if(e.getKeyCode()==KeyEvent.VK_W) {
				cp.getBox().setText("W");
			}
			if(e.getKeyCode()==KeyEvent.VK_E) {
				cp.getBox().setText("E");
			}
			if(e.getKeyCode()==KeyEvent.VK_R) {
				cp.getBox().setText("R");
			}
			if(e.getKeyCode()==KeyEvent.VK_T) {
				cp.getBox().setText("T");
			}
			if(e.getKeyCode()==KeyEvent.VK_Y) {
				cp.getBox().setText("Y");
			}
			if(e.getKeyCode()==KeyEvent.VK_U) {
				cp.getBox().setText("U");
			}
			if(e.getKeyCode()==KeyEvent.VK_I) {
				cp.getBox().setText("I");
			}
			if(e.getKeyCode()==KeyEvent.VK_O) {
				cp.getBox().setText("O");
			}
			if(e.getKeyCode()==KeyEvent.VK_P) {
				cp.getBox().setText("P");
			}if(e.getKeyCode()==KeyEvent.VK_A) {
				cp.getBox().setText("A");
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				cp.getBox().setText("S");
			}
			if(e.getKeyCode()==KeyEvent.VK_D) {
				cp.getBox().setText("D");
			}
			if(e.getKeyCode()==KeyEvent.VK_F) {
				cp.getBox().setText("F");
			}
			if(e.getKeyCode()==KeyEvent.VK_G) {
				cp.getBox().setText("G");
			}
			if(e.getKeyCode()==KeyEvent.VK_H) {
				cp.getBox().setText("H");
			}
			if(e.getKeyCode()==KeyEvent.VK_J) {
				cp.getBox().setText("J");
			}
			if(e.getKeyCode()==KeyEvent.VK_K) {
				cp.getBox().setText("K");
			}
			if(e.getKeyCode()==KeyEvent.VK_L) {
				cp.getBox().setText("L");
			}
			if(e.getKeyCode()==KeyEvent.VK_Z) {
				cp.getBox().setText("Z");
			}
			if(e.getKeyCode()==KeyEvent.VK_X) {
				cp.getBox().setText("X");
			}
			if(e.getKeyCode()==KeyEvent.VK_C) {
				cp.getBox().setText("C");
			}
			if(e.getKeyCode()==KeyEvent.VK_V) {
				cp.getBox().setText("V");
			}
			if(e.getKeyCode()==KeyEvent.VK_B) {
				cp.getBox().setText("B");
			}
			if(e.getKeyCode()==KeyEvent.VK_N) {
				cp.getBox().setText("N");
			}
			if(e.getKeyCode()==KeyEvent.VK_M) {
				cp.getBox().setText("M");
			}
			
			
			
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
			if(cp.currentColumn<0) {
				//if currentColumn is 0 we tell the program to do nothing
			}
			else {
				//we take one step back because getBox method gives us the box which is one step further
				cp.currentColumn--;
				//to set the label empty
				cp.getBox().setText("");
				// then other one step back
				cp.currentColumn--;
			}
			
		}
		
		
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			
			
			
			//to get the users words 
			if(cp.currentColumn==4) {
				System.out.println("WORKS");
				for (int i = 0; i < 5; i++) {
					//getBoxRox gives us the all 5 letter of the word  
					currentString+=cp.getRowBox()[i].getText();
					
				
				}
				
				
				// to check the word is on the list or not
				if(!(ComparewithDbReadFile(currentString)== 1)){
					
					System.out.println("Word is not in the list!");
					cp.notinthelist.setVisible(true);
					cp.currentColumn=4;
					
					
					
				}
				else {
					cp.notinthelist.setVisible(false);
					for (int i = 0; i < currentString.length(); i++) {
						// First we check the letter is in the right place if not
						if(currentString.charAt(i)!=Stringfromdatabase.charAt(i)) {
							for (int j = 0; j < currentString.length(); j++) {
								//Then we check the letter is in the answer if so we make the letterbox blue
								if(currentString.charAt(i) == Stringfromdatabase.charAt(j)) {
									cp.Boxes[cp.currentRow][i].setBackground(new Color(92, 155, 242));
								
							
								}	
				
							}
						}
						//We check the letter is in the right place or not if it is we make it green
						if(Stringfromdatabase.charAt(i)==currentString.charAt(i)) {
							cp.Boxes[cp.currentRow][i].setBackground(new Color(70, 209, 46));
							
						}
						
					}
					//Check the answer is equal to user input if it user is win the game
					if(Stringfromdatabase.equalsIgnoreCase(currentString)) {
						System.out.println("YOU WON");
						//running will be false
						isRun = false;
						//we create a restart menu
						RestartMenu rs = new RestartMenu(true,Stringfromdatabase,cp.currentRow+1);
						setVisible(false);
						
					}
					//Check the game is over or not
					if(cp.currentColumn==4 && cp.currentRow==5) {
						System.out.println("YOU LOSE");
						isRun = false;
						//we create a restart menu
						RestartMenu rs = new RestartMenu(false,Stringfromdatabase,6);
						setVisible(false);
						
					}
					//to check the game is running or not
					if(isRun) {
						cp.getBox();
						//get box is give us the further  box because of that we take one step back
						cp.currentColumn--;
						
					}
							
			}
			// we make the currentstring empty to start next try
			currentString = "";
			
			
			
		}
				}
				

	}			

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
