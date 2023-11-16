package pj.choice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameCategory extends JPanel {

	JButton choiceCategoryIceBtn;
	JButton choiceCategoryCakeBtn;
	JButton choiceCategoryCoffeeBtn;
	JButton choiceCategoryBeverageBtn;
	JButton choiceCategoryDessertBtn;
	ChoiceSelectAll choiceSelectAll;

	public ChoiceFrameCategory(ChoiceFrame mainFrame) {

		choiceSelectAll = mainFrame.choiceSelectAll;
		GridLayout grid = new GridLayout(1, 5);
		setLayout(grid);
		grid.setHgap(50);
		grid.setVgap(50);

		choiceCategoryIceBtn = new ChoiceCategoryIceBtn(this);
		choiceCategoryCakeBtn = new ChoiceCategoryCakeBtn(this);
		choiceCategoryCoffeeBtn = new ChoiceCategoryCoffeeBtn(this);
		choiceCategoryBeverageBtn = new ChoiceCategoryBeverageBtn(this);
		choiceCategoryDessertBtn = new ChoiceCategoryDessertBtn(this);

		choiceCategoryIceBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.choiceSelectAll.menuCard.show(mainFrame.choiceSelectAll, "ice");

			}
		});

		choiceCategoryCakeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.choiceSelectAll.menuCard.show(mainFrame.choiceSelectAll, "cake");
			}
		});

		choiceCategoryCoffeeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.choiceSelectAll.menuCard.show(mainFrame.choiceSelectAll, "coffee");

			}
		});

		choiceCategoryBeverageBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.choiceSelectAll.menuCard.show(mainFrame.choiceSelectAll, "beverage");

			}
		});

		choiceCategoryDessertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.choiceSelectAll.menuCard.show(mainFrame.choiceSelectAll, "dessert");

			}
		});

		add(choiceCategoryIceBtn);
		add(choiceCategoryCakeBtn);
		add(choiceCategoryCoffeeBtn);
		add(choiceCategoryBeverageBtn);
		add(choiceCategoryDessertBtn);
	}
}