package pj.choice;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameSelect4 extends JPanel {

	ChoiceSelectBeverage choiceSelectBeverage;
	JButton choiceSelectNextBtn;
	JButton choiceSelectPrevBtn;

	public ChoiceFrameSelect4(ChoiceSelectAll mainFrame) {
		BorderLayout border = new BorderLayout(40, 40);
		setLayout(border);

		choiceSelectNextBtn = new JButton(">>");
		choiceSelectPrevBtn = new JButton("<<");
		choiceSelectBeverage = new ChoiceSelectBeverage(this);

		add(choiceSelectNextBtn, BorderLayout.EAST);
		add(choiceSelectPrevBtn, BorderLayout.WEST);
		add(choiceSelectBeverage, BorderLayout.CENTER);
	}

}
