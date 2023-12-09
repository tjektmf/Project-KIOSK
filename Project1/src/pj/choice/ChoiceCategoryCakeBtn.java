package pj.choice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceCategoryCakeBtn extends JButton {
	JButton choiceCategoryCakeBtn;
	ChoiceSelectAll choiceSelectAll;

	public ChoiceCategoryCakeBtn(ChoiceFrameCategory mainFrame) {
		ImageIcon cake = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(cake);
		setText("Cake");
		setBorder(null);
		setBackground(new Color(255,255,255));
		mainFrame.choiceCategoryCakeBtn = choiceCategoryCakeBtn;

	}
}
