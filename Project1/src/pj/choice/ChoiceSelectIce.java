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

public class ChoiceSelectIce extends JPanel {

	// 카드레이아웃도 주변패널과의 행열간격은 줄수있음 CardLayout(x,y)
	CardLayout card = new CardLayout();

	JButton choiceSelectPrevBtn;
	JButton choiceSelectNextBtn;

	public ChoiceSelectIce(ChoiceFrameSelect mainFrame) {
		choiceSelectPrevBtn = mainFrame.choiceSelectPrevBtn;
		choiceSelectNextBtn = mainFrame.choiceSelectNextBtn;

		// 마지막 패널에 열부터 차는건 어떻게 해결?? 그냥 버튼 개수맞춰서 마지막 패널만 수정?
		JPanel pan1 = new JPanel(new GridLayout(4, 4));
		JPanel pan2 = new JPanel(new GridLayout(4, 4));
		JPanel pan3 = new JPanel(new GridLayout(3, 4));
		
		// 이거 버튼마다 이미지 넣으려면 이미지 번호가 1씩 증가하게 저장하면 될거같음
		// 액션리스너는 어케주지?
		for (int i = 1; i < 49; i++) {
			if (i < 17) {
				pan1.add(new JButton("ice " + i));
			} else if (i < 33) {
				pan2.add(new JButton("ice " + i));
			} else {
				pan3.add(new JButton("ice " + i));
			}
		}

		choiceSelectNextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceSelectIce.this);

			}
		});
		choiceSelectPrevBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(ChoiceSelectIce.this);

			}
		});

		add(pan1);
		add(pan2);
		add(pan3);
		setLayout(card);
		setVisible(true);

	}

}
