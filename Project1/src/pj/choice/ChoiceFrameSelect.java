package pj.choice;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameSelect extends JPanel {
	
	ChoiceSelectMenu choiceSelectMenu;
	JButton choiceSelectPrevBtn;
	JButton choiceSelectNextBtn;
	
	public ChoiceFrameSelect(ChoiceFrame mainFrame) {
		BorderLayout border = new BorderLayout(40,40);
		setLayout(border);
		
		choiceSelectPrevBtn = new ChoiceSelectPrevBtn(this);
		choiceSelectNextBtn = new ChoiceSelectNextBtn(this);
		
		choiceSelectPrevBtn.addActionListener(new ChoiceSelectPrevBtnAction(this));
		choiceSelectNextBtn.addActionListener(new ChoiceSelectNextBtnAction(this));
		
		
		choiceSelectMenu = new ChoiceSelectMenu(this);
		
		add(choiceSelectMenu, BorderLayout.CENTER);
		add(choiceSelectPrevBtn, BorderLayout.WEST);
		add(choiceSelectNextBtn, BorderLayout.EAST);

	}
}
