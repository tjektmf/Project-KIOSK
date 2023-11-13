package pj.choice;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameCategory extends JPanel {

	
	JButton choiceCategoryIceBtn;
	JButton choiceCategoryCakeBtn;
	JButton choiceCategoryCoffeeBtn;
	JButton choiceCategoryBeverageBtn;
	JButton choiceCategoryDessertBtn;

	public ChoiceFrameCategory(ChoiceFrame mainFrame) {
		
		GridLayout grid = new GridLayout(1,5);
		setLayout(grid);
		grid.setHgap(50);
		grid.setVgap(50);
		choiceCategoryIceBtn = new ChoiceCategoryIceBtn(this);
		choiceCategoryCakeBtn = new ChoiceCategoryCakeBtn(this);
		choiceCategoryCoffeeBtn = new ChoiceCategoryCoffeeBtn(this);
		choiceCategoryBeverageBtn = new ChoiceCategoryBeverageBtn(this);
		choiceCategoryDessertBtn = new ChoiceCategoryDessertBtn(this);
		add(choiceCategoryIceBtn);
		add(choiceCategoryCakeBtn);
		add(choiceCategoryCoffeeBtn);
		add(choiceCategoryBeverageBtn);
		add(choiceCategoryDessertBtn);	
	}
}