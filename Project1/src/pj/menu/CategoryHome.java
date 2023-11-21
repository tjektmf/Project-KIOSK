package pj.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import pj_yr.ConeAndCup.ConeAndCup_00frame;

public class CategoryHome extends JPanel {

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
	

	public void mainFrame(JFrame frame) {
		this.f = frame;
	}

	public void showFrame(boolean show) {
		f.setVisible(show);
	}

	public void mainCard(CardLayout mainCard) {
		
		this.card = mainCard;
		card.next(f);
	}

	CardLayout card = new CardLayout();

	public CategoryHome(ChoiceFrame mainFrame) {

		choiceSelectAll = mainFrame.choiceSelectAll;
	//	choiceSelectAll = new ChoiceSelectAll(mainFrame);
		System.out.println("CategoryHome : " + this);
		
		f.setLayout(card);

		f.setTitle("category");
		setLayout(new GridLayout(3, 1));

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));

		add(panel);
		add(panel2);

		f.add(panel2);
		f.add(mainFrame);
		f.add(panel);

		// 카테고리 버튼 추가
		panel2.add(icecreamBtn);
		panel2.add(icecakeBtn);
		panel2.add(coffeeBtn);
		panel2.add(beverageBtn);
		panel2.add(dessertBtn);

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
		new CategoryHome(choiceFrame);
	}

}