package pj.choice;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameSelect3 extends JPanel{

	ChoiceSelectCoffee choiceSelectCoffee;
	JButton choiceSelectNextBtn;
	JButton choiceSelectPrevBtn;

	public ChoiceFrameSelect3(ChoiceSelectAll mainFrame) {
		BorderLayout border = new BorderLayout(40, 40);
		setLayout(border);
		

		choiceSelectNextBtn = new JButton(">>");
		choiceSelectPrevBtn = new JButton("<<");
		choiceSelectCoffee = new ChoiceSelectCoffee(this);
	
		
		add(choiceSelectNextBtn, BorderLayout.EAST);
		add(choiceSelectPrevBtn, BorderLayout.WEST);
		add(choiceSelectCoffee, BorderLayout.CENTER);
	}
}
