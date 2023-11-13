package pj.choice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceSelectMenu extends JPanel {

	CardLayout card = new CardLayout();

	JButton but1;
	JButton but2;

	public ChoiceSelectMenu(ChoiceFrameSelect mainFrame) {
		but1 = mainFrame.but1;
		but2 = mainFrame.but2;

		JPanel pan1 = new JPanel(new GridLayout(1, 1));
		JPanel pan2 = new JPanel(new GridLayout(1, 1));
		JPanel pan3 = new JPanel(new GridLayout(1, 1));

		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		
		but1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceSelectMenu.this);

			}
		});
		but2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(ChoiceSelectMenu.this);

			}
		});

		pan1.add(b1);
		pan2.add(b2);
		pan3.add(b3);
		
		add(pan1);
		add(pan2);
		add(pan3);
		setLayout(card);
		setVisible(true);

	}

}
