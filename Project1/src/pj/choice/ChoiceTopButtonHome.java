package pj.choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceTopButtonHome extends JButton {

	JButton choiceTopButtonHome;

	public ChoiceTopButtonHome(ChoiceFrameTop mainFrame) {
		

		ImageIcon home = new ImageIcon("img/daseul/home.png");
		setIcon(home);
	//	setText("Home");
		
		mainFrame.choiceTopButtonHome = choiceTopButtonHome;

	}
}