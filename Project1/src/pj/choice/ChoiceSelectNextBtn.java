package pj.choice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChoiceSelectNextBtn extends JButton{
	
	JButton choiceSelectNextBtn = new JButton();
	ChoiceSelectIce card;

	public ChoiceSelectNextBtn(ChoiceFrameSelect mainFrame) {
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.card.next(card);
				
			}
		});
		mainFrame.choiceSelectNextBtn = choiceSelectNextBtn;
		
		
		setText(">>");
	
	}
}
