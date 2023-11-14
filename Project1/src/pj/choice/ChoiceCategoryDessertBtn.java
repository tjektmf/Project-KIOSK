package pj.choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceCategoryDessertBtn extends JButton {

	JButton choiceCategoryDessertBtn;
	

	public ChoiceCategoryDessertBtn(ChoiceFrameCategory mainFrame) {
		
		ImageIcon dessert = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(dessert);
		setText("Dessert");

		mainFrame.choiceCategoryDessertBtn = choiceCategoryDessertBtn;

	}

}