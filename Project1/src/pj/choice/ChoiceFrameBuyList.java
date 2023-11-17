package pj.choice;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoiceFrameBuyList extends JPanel {

	public ChoiceFrameBuyList(ChoiceFrame mainFrame) {

		CardLayout card = new CardLayout(10, 10);

		JLabel test = new JLabel();
		test.setIcon(new ImageIcon("img/daseul/cat.gif"));
		

		setLayout(card);
	//	add(test);

		GridLayout grid = new GridLayout(1,3);
		grid.setVgap(20);
		grid.setHgap(20);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel(new GridLayout(1,2));
		JButton but1 = new JButton("x");
		JButton but2 = new JButton("x");
		JButton but3 = new JButton("prev");
		JButton but4 = new JButton("next");
		
		but4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceFrameBuyList.this);
				
			}
		});
		
		but3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.previous(ChoiceFrameBuyList.this);
			}
		});
		
		pan1.setLayout(grid);
		
		add(pan2);
		add(pan1);
		pan2.add(test);
		pan2.add(but4);
		pan1.add(but1);
		pan1.add(but2);
		pan1.add(but3);
		

	}
}
