package pj.choice;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameSelect2 extends JPanel{
	ChoiceSelectCake choiceSelectCake;
	JButton choiceSelectNextBtn;
	JButton choiceSelectPrevBtn;
	
	public ChoiceFrameSelect2(ChoiceSelectAll mainFrame) {
		
		BorderLayout border = new BorderLayout(20, 20);
		setLayout(border);
		

		choiceSelectNextBtn = new JButton(">>");
		choiceSelectPrevBtn = new JButton("<<");
		choiceSelectCake = new ChoiceSelectCake(this);
	
		
		add(choiceSelectNextBtn, BorderLayout.EAST);
		add(choiceSelectPrevBtn, BorderLayout.WEST);
		add(choiceSelectCake, BorderLayout.CENTER);
	
	}

}
