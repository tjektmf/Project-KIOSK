package pj.choice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceCategoryDessertBtn extends JButton {

	JButton choiceCategoryDessertBtn;
	

	public ChoiceCategoryDessertBtn(ChoiceFrameCategory mainFrame) {
		
		ImageIcon dessert = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(dessert);
		setText("Dessert");
		setBorder(null);
		setBackground(new Color(255,255,255));

		mainFrame.choiceCategoryDessertBtn = choiceCategoryDessertBtn;

	}

}