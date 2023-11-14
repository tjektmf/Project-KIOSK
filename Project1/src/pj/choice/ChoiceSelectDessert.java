package pj.choice;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceSelectDessert extends JPanel {

	CardLayout card = new CardLayout();
	JButton choiceSelectPrevBtn;
	JButton choiceSelectNextBtn;

	public ChoiceSelectDessert(ChoiceFrameSelect5 mainFrame) {

		choiceSelectPrevBtn = mainFrame.choiceSelectPrevBtn;
		choiceSelectNextBtn = mainFrame.choiceSelectNextBtn;

		JPanel pan1 = new JPanel(new GridLayout(4, 4));
		JPanel pan2 = new JPanel(new GridLayout(4, 4));
		JPanel pan3 = new JPanel(new GridLayout(4, 4));

		for (int i = 1; i < 49; i++) {
			if (i < 17) {
				pan1.add(new JButton("dessert " + i));
			} else if (i < 33) {
				pan2.add(new JButton("dessert " + i));
			} else {
				pan3.add(new JButton("dessert " + i));
			}
		}

		choiceSelectNextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceSelectDessert.this);

			}
		});
		choiceSelectPrevBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(ChoiceSelectDessert.this);

			}
		});

		add(pan1);
		add(pan2);
		add(pan3);
		setLayout(card);
		setVisible(true);

	}
}
