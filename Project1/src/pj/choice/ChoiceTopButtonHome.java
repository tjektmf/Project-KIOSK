package pj.choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceTopButtonHome extends JButton {

	JButton choiceTopButtonHome;

	public ChoiceTopButtonHome(ChoiceFrameTop mainFrame) {
		

		ImageIcon home = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(home);
		setText("Home");
		mainFrame.choiceTopButtonHome = choiceTopButtonHome;

	}
}