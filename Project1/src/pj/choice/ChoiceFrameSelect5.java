package pj.choice;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameSelect5 extends JPanel {

	ChoiceSelectDessert choiceSelectdessert;
	JButton choiceSelectNextBtn;
	JButton choiceSelectPrevBtn;

	public ChoiceFrameSelect5(ChoiceSelectAll mainFrame) {
		BorderLayout border = new BorderLayout(40, 40);
		setLayout(border);

		choiceSelectNextBtn = new JButton(">>");
		choiceSelectPrevBtn = new JButton("<<");
		choiceSelectdessert = new ChoiceSelectDessert(this);

		add(choiceSelectNextBtn, BorderLayout.EAST);
		add(choiceSelectPrevBtn, BorderLayout.WEST);
		add(choiceSelectdessert, BorderLayout.CENTER);
	}
}
