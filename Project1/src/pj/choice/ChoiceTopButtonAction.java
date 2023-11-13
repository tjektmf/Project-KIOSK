package pj.choice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChoiceTopButtonAction implements ActionListener {

	JButton choiceTopButtonHome;
	JButton choiceTopButtonBack;

	public ChoiceTopButtonAction(ChoiceFrameTop mainFrame) {
		mainFrame.choiceTopButtonHome = choiceTopButtonHome;
		mainFrame.choiceTopButtonBack = choiceTopButtonBack;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ddd");

	}

}