package pj.choice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameTop extends JPanel {

	JButton choiceTopButtonHome;
	JButton choiceTopButtonBack;
	

	public ChoiceFrameTop(ChoiceFrame mainFrame) {
		
		
		GridLayout grid = new GridLayout(1,2);

		grid.setHgap(200);
		setLayout(grid);

		choiceTopButtonHome = new ChoiceTopButtonHome(this);
		choiceTopButtonBack = new ChoiceTopButtonBack(this);

		add(choiceTopButtonHome, BorderLayout.WEST);
		add(choiceTopButtonBack, BorderLayout.EAST);
		setBorder(null);
		setBackground(new Color(255,255,255));
	}
}