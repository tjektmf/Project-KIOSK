package pj.choice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceSelectAll extends JPanel {

	ChoiceFrameSelect choiceFrameSelect;
	ChoiceFrameSelect2 choiceFrameSelect2;
	ChoiceFrameSelect3 choiceFrameSelect3;
	ChoiceFrameSelect4 choiceFrameSelect4;
	ChoiceFrameSelect5 choiceFrameSelect5;
//	JButton choiceSelectNextBtn;
//	JButton choiceSelectPrevBtn;
	CardLayout menuCard;

	public ChoiceSelectAll(ChoiceFrame mainFrame) {
		menuCard = new CardLayout(20, 20);

		setLayout(menuCard);

//		choiceSelectNextBtn = new JButton(">>");
//		choiceSelectPrevBtn = new JButton("<<");
		choiceFrameSelect = new ChoiceFrameSelect(this);
		choiceFrameSelect2 = new ChoiceFrameSelect2(this);
		choiceFrameSelect3 = new ChoiceFrameSelect3(this);
		choiceFrameSelect4 = new ChoiceFrameSelect4(this);
		choiceFrameSelect5 = new ChoiceFrameSelect5(this);

		// 아이스크림1 케잌2 커피3 음료4 디저트5 클래스 이름길어서 숫자붙임

		// 카테고리 버튼을 통해 이동할 패널의 고유이름 설정
		add("ice", choiceFrameSelect);
		add("cake", choiceFrameSelect2);
		add("coffee", choiceFrameSelect3);
		add("beverage", choiceFrameSelect4);
		add("dessert", choiceFrameSelect5);

//		choiceFrameSelect.add(choiceSelectNextBtn);
//		choiceFrameSelect.add(choiceSelectPrevBtn);

	}

}
