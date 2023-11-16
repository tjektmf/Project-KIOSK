package pj.choice;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChoiceFrame extends JFrame {

	ChoiceFrameTop choiceFrameTop;
	ChoiceFrameCategory choiceFrameCategory;
	ChoiceSelectAll choiceSelectAll;

	public ChoiceFrame() {
		GridLayout grid = new GridLayout(4, 1);
		setLayout(grid);
		grid.setVgap(40);
		choiceFrameTop = new ChoiceFrameTop(this);
		choiceFrameCategory = new ChoiceFrameCategory(this);

		choiceSelectAll = new ChoiceSelectAll(this);

		// 붙이는 순서 중요
		add(choiceFrameTop);
		add(choiceFrameCategory);
		add(choiceSelectAll);

		setBounds(100, 100, 1080, 1920);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChoiceFrame();
	}
}