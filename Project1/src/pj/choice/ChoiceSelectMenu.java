package pj.choice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceSelectMenu extends JPanel {
	
	CardLayout card = new CardLayout();
	
	public ChoiceSelectMenu(ChoiceFrameSelect mainFrame) {
	
		JPanel pan1 = new JPanel(new GridLayout(1,1)); 
		JPanel pan2 = new JPanel(new GridLayout(4,4));
		JPanel pan3 = new JPanel(new GridLayout(1,1));
		
		JButton but1 = new JButton("test");
		JButton but2 = new JButton("테스트");
		
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceSelectMenu.this);
				
				
			}
		});
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceSelectMenu.this);
				
			}
		});
		
		pan1.add(but1);
		pan2.add(but2);
		add(pan1);
		add(pan2);
		add(pan3);
		setLayout(card);
		setVisible(true);

	}

}
