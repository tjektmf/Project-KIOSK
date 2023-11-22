package pj.menu;

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

import pj.choice.ChoiceFrame;
import pj.choice.ChoiceFrameCategory;
import pj.choice.ChoiceSelectAll;
<<<<<<< HEAD
import pj_yr.ConeAndCup.ConeAndCup_00frame;
=======
import pj.jks.PointButton;
>>>>>>> refs/remotes/origin/hyemi

public class CategoryHome extends JPanel {

	Color beskinColor = new Color(236,108,165);

	JButton icecreamBtn = new JButton("Icecream");
	JButton icecakeBtn = new JButton("Cake");
	JButton coffeeBtn = new JButton("Coffee");
	JButton beverageBtn = new JButton("Beverage");
	JButton dessertBtn = new JButton("Dessert");

	ChoiceSelectAll choiceSelectAll;
	ChoiceFrame choiceFrame;
	ChoiceFrameCategory choiceFrameCategory;
	ConeAndCup_00frame coneAndCup_00frame = new ConeAndCup_00frame();
	
			

	JFrame f = new JFrame();
<<<<<<< HEAD
	

	public void mainFrame(JFrame frame) {
		this.f = frame;
=======

	public JFrame frame(JFrame f) {
		return this.f = f;
>>>>>>> refs/remotes/origin/hyemi
	}

<<<<<<< HEAD
	public void showFrame(boolean show) {
		f.setVisible(show);
	}

	public void mainCard(CardLayout mainCard) {
		
		this.card = mainCard;
		card.next(f);
	}

	CardLayout card = new CardLayout();

	public CategoryHome(ChoiceFrame mainFrame) {
=======
	public CategoryHome(ChoiceFrame mainFrame, PointButton pointButton) {
>>>>>>> refs/remotes/origin/hyemi

		choiceSelectAll = mainFrame.choiceSelectAll;
	//	choiceSelectAll = new ChoiceSelectAll(mainFrame);
		System.out.println("CategoryHome : " + this);
		
		f.setLayout(card);
		f.setTitle("category");
		
		setLayout(new GridLayout(3, 1));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));
		
		add(panel);
		add(panel2);

<<<<<<< HEAD
		f.add(panel2);
		f.add(mainFrame);
		f.add(panel);
=======
		f.add(panel2, BorderLayout.NORTH);

		f.add(mainFrame, BorderLayout.CENTER); // 위치 안먹음 @_@
		f.add("price", pointButton);
>>>>>>> refs/remotes/origin/hyemi

		// 카테고리 버튼 추가
		panel2.add(icecreamBtn);
		panel2.add(icecakeBtn);
		panel2.add(coffeeBtn);
		panel2.add(beverageBtn);
		panel2.add(dessertBtn);

		icecreamBtn.setForeground(beskinColor);
		icecakeBtn.setForeground(beskinColor);
		coffeeBtn.setForeground(beskinColor);
		beverageBtn.setForeground(beskinColor);
		dessertBtn.setForeground(beskinColor);

		// .setPreferredSize(new Dimension(width,height));
		icecreamBtn.setPreferredSize(new Dimension(100, 60));
		icecakeBtn.setPreferredSize(new Dimension(80, 60));
		coffeeBtn.setPreferredSize(new Dimension(80, 60));
		beverageBtn.setPreferredSize(new Dimension(100, 60));
		dessertBtn.setPreferredSize(new Dimension(80, 60));

		// add("CENTER",newPanel);
		icecreamBtn.addActionListener(new MenuButtonListener("iceBtn"));
		icecakeBtn.addActionListener(new MenuButtonListener("cakeBtn"));
		coffeeBtn.addActionListener(new MenuButtonListener("coffeeBtn"));
		beverageBtn.addActionListener(new MenuButtonListener("beverageBtn"));
		dessertBtn.addActionListener(new MenuButtonListener("dessertBtn"));

		icecreamBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("작동");
					card.next(f.getContentPane());
					choiceSelectAll.showCard("ice");
				}
			});
			icecakeBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("작동");
					card.next(f.getContentPane());
					choiceSelectAll.showCard("cake");
				}
			});
			coffeeBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("작동");
					card.next(f.getContentPane());
					choiceSelectAll.showCard("coffee");
				}
			});
			beverageBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("작동");
					card.next(f.getContentPane());
					choiceSelectAll.showCard("beverage");
				}
			});
			dessertBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("작동");
					card.next(f.getContentPane());
					choiceSelectAll.showCard("dessert");
				}
			});

		// f.setDefaultCloseOperation(ABORT);
		f.setSize(555, 960);
//		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			// System.out.println(itemName.substring(0, itemName.length() - 3));
		}
	}

	public static void main(String[] args) {
		ChoiceFrame choiceFrame = new ChoiceFrame();
		PointButton pointButton = new PointButton();

		new CategoryHome(choiceFrame, pointButton);
	}

}