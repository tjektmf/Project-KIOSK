package pj.choice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceCategoryBeverageBtn extends JButton {
	
	JButton choiceCategoryBeverageBtn;
	public ChoiceCategoryBeverageBtn(ChoiceFrameCategory mainFrame) {
		
		ImageIcon beverage = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(beverage);
		setText("Beverage");
		setBorder(null);
		setBackground(new Color(255,255,255));
		mainFrame.choiceCategoryBeverageBtn = choiceCategoryBeverageBtn;
	}
	
}
