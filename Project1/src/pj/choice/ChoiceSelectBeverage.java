package pj.choice;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceSelectBeverage extends JPanel {

	CardLayout card = new CardLayout();
	JButton choiceSelectPrevBtn;
	JButton choiceSelectNextBtn;

	public ChoiceSelectBeverage(ChoiceFrameSelect4 mainFrame) {

		choiceSelectPrevBtn = mainFrame.choiceSelectPrevBtn;
		choiceSelectNextBtn = mainFrame.choiceSelectNextBtn;

		JPanel pan1 = new JPanel(new GridLayout(4, 4));
		JPanel pan2 = new JPanel(new GridLayout(4, 4));
		JPanel pan3 = new JPanel(new GridLayout(4, 4));

		for (int i = 1; i < 49; i++) {
			if (i < 17) {
				pan1.add(new JButton("beverage " + i));
			} else if (i < 33) {
				pan2.add(new JButton("beverage " + i));
			} else {
				pan3.add(new JButton("beverage " + i));
			}
		}

		choiceSelectNextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceSelectBeverage.this);

			}
		});
		choiceSelectPrevBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(ChoiceSelectBeverage.this);

			}
		});

		add(pan1);
		add(pan2);
		add(pan3);
		setLayout(card);
		setVisible(true);

	}

}
