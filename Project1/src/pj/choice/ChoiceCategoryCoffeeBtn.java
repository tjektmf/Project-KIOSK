package pj.choice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceCategoryCoffeeBtn extends JButton {

	JButton choiceCategoryCoffeeBtn;

	public ChoiceCategoryCoffeeBtn(ChoiceFrameCategory mainFrame) {
		ImageIcon coffee = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(coffee);
		setText("Coffee");
		setBorder(null);
		setBackground(new Color(255,255,255));
		mainFrame.choiceCategoryCoffeeBtn = choiceCategoryCoffeeBtn;

	}
}
