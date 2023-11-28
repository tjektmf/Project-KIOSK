package pj.choice;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameSelect3 extends JPanel{

	ChoiceSelectCoffee choiceSelectCoffee;
	JButton choiceSelectNextBtn;
	JButton choiceSelectPrevBtn;
	
	public ChoiceFrameSelect3(ChoiceSelectAll mainFrame) {
		BorderLayout border = new BorderLayout(20, 20);
		setLayout(border);
		
		choiceSelectNextBtn = new JButton();
		choiceSelectNextBtn.setIcon(new ImageIcon("img/daseul/longright.png"));
		choiceSelectNextBtn.setBorderPainted(false);
		choiceSelectNextBtn.setBackground(new Color(255,255,255));
	
		choiceSelectPrevBtn = new JButton();
		choiceSelectPrevBtn.setIcon(new ImageIcon("img/daseul/longleft.png"));
		choiceSelectPrevBtn.setBorderPainted(false);	
		choiceSelectPrevBtn.setBackground(new Color(255,255,255));
		
		choiceSelectCoffee = new ChoiceSelectCoffee(this);
	
		
		add(choiceSelectNextBtn, BorderLayout.EAST);
		add(choiceSelectPrevBtn, BorderLayout.WEST);
		add(choiceSelectCoffee, BorderLayout.CENTER);
	}
}
