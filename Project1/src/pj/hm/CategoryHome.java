package pj.hm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pj.choice.ChoiceFrameSelect;
import pj.choice.ChoiceSelectAll;

public class CategoryHome extends JFrame {

	JButton icecreamBtn = new JButton("Icecream");
	JButton icecakeBtn = new JButton("Cake");
	JButton coffeeBtn = new JButton("Coffee");
	JButton beverageBtn = new JButton("Beverage");
	JButton dessertBtn = new JButton("Dessert");

	public CategoryHome() {
		setTitle("category");
		setLayout(new GridLayout(3, 1));

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));
	
		add(panel);
		add(panel2);
		
		// 카테고리 버튼 추가
		panel2.add(icecreamBtn);
		panel2.add(icecakeBtn);
		panel2.add(coffeeBtn);
		panel2.add(beverageBtn);
		panel2.add(dessertBtn);
		
		//.setPreferredSize(new Dimension(width,height));
		icecreamBtn.setPreferredSize(new Dimension(100,60));
		icecakeBtn.setPreferredSize(new Dimension(80,60));
		coffeeBtn.setPreferredSize(new Dimension(80,60));
		beverageBtn.setPreferredSize(new Dimension(100,60));
		dessertBtn.setPreferredSize(new Dimension(80,60));
		
		// add("CENTER",newPanel);
		icecreamBtn.addActionListener(new MenuButtonListener("Icecream")); // ChoiceFrameSelect();
		 icecreamBtn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	//new ChoiceFrameSelect(ChoiceSelectAll mainFrame, "Icecream");
	        	 //new ChoiceFrameSelect(ChoiceSelectAll.);
	        	 
	        	 // 

	         }
	      });
		icecakeBtn.addActionListener(new MenuButtonListener("Cake")); // ChoiceFrameSelect2();
		coffeeBtn.addActionListener(new MenuButtonListener("Coffee")); // ChoiceFrameSelect3();
		beverageBtn.addActionListener(new MenuButtonListener("Beverage")); // ChoiceFrameSelect4();
		dessertBtn.addActionListener(new MenuButtonListener("Dessert")); // ChoiceFrameSelect5();
		
		
/*
	choiceCategoryBeverageBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mainFrame.choiceSelectAll.menuCard.show(mainFrame.choiceSelectAll, "beverage");

         }
      });
*/

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setBounds(300, 300, 540, 960);
		setVisible(true);

	}

	// 메뉴 버튼에 대한 액션 리스너
	private class MenuButtonListener implements ActionListener {
		private String itemName;
		
		

		public MenuButtonListener(String itemName) {
			this.itemName = itemName;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// 선택된 메뉴 정보 처리
			System.out.println(itemName + " 선택됨");
		}
	}
	

	public static void main(String[] args) {
		new CategoryHome();
	}

	// 베스킨 핑크색 rgb번호 rgb(236, 108, 165)
	
	
	
	
	 
	 
	 
}