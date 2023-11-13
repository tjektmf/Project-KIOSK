package pj.choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceTopButtonBack extends JButton{

	JButton choiceTopButtonBack;

	public ChoiceTopButtonBack(ChoiceFrameTop mainFrame) {
		ImageIcon back = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(back);
		setText("Back");
		mainFrame.choiceTopButtonBack = choiceTopButtonBack;
	}
}