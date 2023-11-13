package pj.choice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameSelect extends JPanel {

	ChoiceSelectMenu choiceSelectMenu;
	JButton choiceSelectPrevBtn;
	JButton choiceSelectNextBtn;
	JButton but1;
	JButton but2;
	

	public ChoiceFrameSelect(ChoiceFrame mainFrame) {

		BorderLayout border = new BorderLayout(40, 40);
		setLayout(border);

		but1 = new JButton(">>");
		but2 = new JButton("<<");
		choiceSelectPrevBtn = new ChoiceSelectPrevBtn(this);
		choiceSelectNextBtn = new ChoiceSelectNextBtn(this);

	

		choiceSelectMenu = new ChoiceSelectMenu(this);
		
		add(but1,BorderLayout.EAST);
		add(but2,BorderLayout.WEST);
		add(choiceSelectMenu, BorderLayout.CENTER);
	
	}
}
