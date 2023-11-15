package pj.choice;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChoiceFrame extends JFrame {

	ChoiceFrameTop choiceFrameTop;
	ChoiceFrameCategory choiceFrameCategory;
	ChoiceSelectAll choiceSelectAll;
	ChoiceFramePrice choiceFramePrice;
	ChoiceFrameBuyList choiceFrameBuyList;

	public ChoiceFrame() {

		setLayout(null);
		choiceFrameTop = new ChoiceFrameTop(this);
		choiceFrameCategory = new ChoiceFrameCategory(this);
		choiceSelectAll = new ChoiceSelectAll(this);
		choiceFramePrice = new ChoiceFramePrice(this);
		choiceFrameBuyList = new ChoiceFrameBuyList(this);

		
		// 크기조절
		choiceFrameTop.setBounds(0, 0, 540, 50);
		choiceFrameCategory.setBounds(0, 60, 540, 60);
		choiceSelectAll.setBounds(0, 130, 540, 400);
		choiceFramePrice.setBounds(0, 530, 540, 60);
		choiceFrameBuyList.setBounds(0, 780, 540, 200);

		add(choiceFrameTop);
		add(choiceFrameCategory);
		add(choiceSelectAll);
		add(choiceFramePrice);
		add(choiceFrameBuyList);

		setBounds(100, 100, 540, 960);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChoiceFrame();
	}
}