package pj.choice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameSelect4 extends JPanel {

	ChoiceSelectBeverage choiceSelectBeverage;
	JButton choiceSelectNextBtn;
	JButton choiceSelectPrevBtn;

	public ChoiceFrameSelect4(ChoiceSelectAll mainFrame) {
		BorderLayout border = new BorderLayout();
		setLayout(border);

		choiceSelectNextBtn = new JButton();
		choiceSelectNextBtn.setIcon(new ImageIcon("img/daseul/longright.png"));
		choiceSelectNextBtn.setBorderPainted(false);
		choiceSelectNextBtn.setBackground(new Color(255,255,255));
		choiceSelectNextBtn.setMargin(new Insets(0, -10, 0, -10));
		
		choiceSelectPrevBtn = new JButton();
		choiceSelectPrevBtn.setIcon(new ImageIcon("img/daseul/longleft.png"));
		choiceSelectPrevBtn.setBorderPainted(false);	
		choiceSelectPrevBtn.setBackground(new Color(255,255,255));
		choiceSelectPrevBtn.setMargin(new Insets(0, -10, 0, -10));
		
		choiceSelectBeverage = new ChoiceSelectBeverage(this);

		add(choiceSelectNextBtn, BorderLayout.EAST);
		add(choiceSelectPrevBtn, BorderLayout.WEST);
		add(choiceSelectBeverage, BorderLayout.CENTER);
	}

}
