package pj.choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceCategoryIceBtn extends JButton{
	
	JButton choiceCategoryIceBtn;
	
	public ChoiceCategoryIceBtn(ChoiceFrameCategory mainFrame) {
		
		ImageIcon ice = new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/apple100.jpg");
		setIcon(ice);
		mainFrame.choiceCategoryIceBtn = choiceCategoryIceBtn;	
	}
}
