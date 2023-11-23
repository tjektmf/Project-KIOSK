package pj.menu;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pj.choice.ChoiceFrame;
import pj.choice.ChoiceFrameCategory;
import pj.choice.ChoiceSelectAll;
import pj_yr.ConeAndCup.ConeAndCup_00frame;

public class CategoryHome extends JPanel {

	Color beskinColor = new Color(236, 108, 165);

	JButton icecreamBtn = new JButton();
	JButton icecakeBtn = new JButton();
	JButton coffeeBtn = new JButton();
	JButton beverageBtn = new JButton();
	JButton dessertBtn = new JButton();

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
		// choiceSelectAll = new ChoiceSelectAll(mainFrame);
		System.out.println("CategoryHome : " + this);

		f.setLayout(card);
		f.setTitle("category");

		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setLayout(null);
		JLabel mainLabel = new JLabel();

		try {
			BufferedImage image = ImageIO.read(new File("img/img_baskin/baskin_main/show.png"));
			Image scaledImage = image.getScaledInstance(555, 960, Image.SCALE_SMOOTH);
			mainLabel.setIcon(new ImageIcon(scaledImage));

		} catch (IOException e) {
			System.out.println("이미지오류");
			e.printStackTrace();
		}

		// add(panel2);

//		f.add(mainLabel);
//		f.add(panel2);
		f.add(panel2);
		f.add(mainFrame);

		// 카테고리 버튼 추가
		mainLabel.setBounds(0, 0, 555, 960);
		panel2.add(icecreamBtn);
		panel2.add(icecakeBtn);
		panel2.add(coffeeBtn);
		panel2.add(beverageBtn);
		panel2.add(dessertBtn);
		panel2.add(mainLabel);

		icecreamBtn.setBounds(80, 200, 170, 250);
		icecakeBtn.setBounds(300, 200, 170, 250);
		coffeeBtn.setBounds(60, 500, 120, 200);
		beverageBtn.setBounds(220, 500, 120, 200);
		dessertBtn.setBounds(380, 500, 120, 200);


		// 버튼 선 없애기
		icecreamBtn.setBorderPainted(false);
		icecakeBtn.setBorderPainted(false);
		coffeeBtn.setBorderPainted(false);
		beverageBtn.setBorderPainted(false);
		dessertBtn.setBorderPainted(false);

		ImageIcon addIcecreamBtn = new ImageIcon("img/img_baskin/baskin_main/ice.png");
		icecreamBtn.setIcon(addIcecreamBtn);

		ImageIcon addCakeBtn = new ImageIcon("img/img_baskin/baskin_main/cake.png");
		icecakeBtn.setIcon(addCakeBtn);

		ImageIcon addCoffeeBtn = new ImageIcon("img/img_baskin/baskin_main/coffee.png");
		coffeeBtn.setIcon(addCoffeeBtn);

		ImageIcon addBeverageBtn = new ImageIcon("img/img_baskin/baskin_main/beverage.png");
		beverageBtn.setIcon(addBeverageBtn);

		ImageIcon addDessertBtn = new ImageIcon("img/img_baskin/baskin_main/dessert.png");
		dessertBtn.setIcon(addDessertBtn);

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
	//	f.setVisible(true);
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