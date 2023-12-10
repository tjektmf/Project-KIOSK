package pj.choice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceCategoryIceBtn extends JButton{
	
	JButton choiceCategoryIceBtn;
	
	public ChoiceCategoryIceBtn(ChoiceFrameCategory mainFrame) {
		
		ImageIcon ice = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(ice);
		setText("Icecream");
		setBorder(null);
		setBackground(new Color(255,255,255));
		mainFrame.choiceCategoryIceBtn = choiceCategoryIceBtn;	
	}
}
