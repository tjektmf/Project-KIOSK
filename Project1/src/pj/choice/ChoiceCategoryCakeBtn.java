package pj.choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceCategoryCakeBtn extends JButton {
	JButton choiceCategoryCakeBtn;
	public ChoiceCategoryCakeBtn(ChoiceFrameCategory mainFrame) {
		ImageIcon cake = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(cake);
		mainFrame.choiceCategoryCakeBtn = choiceCategoryCakeBtn;
	}
}
