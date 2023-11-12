import java.awt.Color;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Box extends JLabel {

	
	public Box() {
		//set the boxes features box is extends from JLabel
		setOpaque(true);
		setBackground(Color.LIGHT_GRAY);
		setText("");
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
	}
	
	
	
	
}
