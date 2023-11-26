package pj.choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceTopButtonBack extends JButton{

	JButton choiceTopButtonBack;

	public ChoiceTopButtonBack(ChoiceFrameTop mainFrame) {
		ImageIcon back = new ImageIcon("img/daseul/cat.gif");
		
		setIcon(back);
		setVisible(false);
		mainFrame.choiceTopButtonBack = choiceTopButtonBack;
	}
}