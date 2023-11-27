package pj.choice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceTopButtonBack extends JButton{

	JButton choiceTopButtonBack;

	public ChoiceTopButtonBack(ChoiceFrameTop mainFrame) {
	//	ImageIcon back = new ImageIcon("img/daseul/cat.gif");
		
		setBackground(new Color(255,255,255));
		setBorderPainted(false);
	//	setVisible(false);
		mainFrame.choiceTopButtonBack = choiceTopButtonBack;
	}
}