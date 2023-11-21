package pj.choice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
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

import pj.menu.CategoryHome;
import pj.menu.IceCreamShopCover;
import pj_yr.ConeAndCup.ConeAndCup_00frame;

public class ChoiceSelectIce extends JPanel {

	// 카드레이아웃도 주변패널과의 행열간격은 줄수있음 CardLayout(x,y)
	CardLayout card = new CardLayout();
	CardLayout mainCard;
	ChoiceFrame choiceFrame;
	JButton choiceSelectPrevBtn;
	JButton choiceSelectNextBtn;
	JButton hideButton = new JButton("숨어있는 결제창");
	ImageIcon menuImage;
	CategoryHome categoryHome;
	JFrame f;
	IceCreamShopCover iceCreamShopCover;
	ChoiceFramePrice choiceFramePrice;
	ConeAndCup_00frame move = new ConeAndCup_00frame();
	ChoiceFrameBuyList choiceFrameBuyList;
	ChoiceFrameSelect choiceFrameSelect;

	// 이미지 없다고 오류떠서 메뉴개수 정해줌
	int theNumberOfMenu = 9;
	int buttonNum = 1;

	int count;
	int num;

	// ChoiceFrameSelect mainFrame
	public ChoiceSelectIce(ChoiceFrameSelect mainFrame) {
		choiceFrameBuyList = ChoiceFrameBuyList.getInstance();
		choiceSelectPrevBtn = mainFrame.choiceSelectPrevBtn;
		choiceSelectNextBtn = mainFrame.choiceSelectNextBtn;

		GridLayout grid1 = new GridLayout(3, 3);
		GridLayout grid2 = new GridLayout(3, 3);
		GridLayout grid3 = new GridLayout(3, 3);
		grid1.setHgap(10);
		grid1.setVgap(10);
		grid2.setHgap(10);
		grid2.setVgap(10);
		grid3.setHgap(10);
		grid3.setVgap(10);

		JPanel pan1 = new JPanel(grid1);
		JPanel pan2 = new JPanel(grid2);
		JPanel pan3 = new JPanel(grid3);

		JButton[] actions = new JButton[48];
		BorderLayout[] borderArr = new BorderLayout[48];
		JLabel[] nameArr = new JLabel[48];
		JLabel[] picArr = new JLabel[48];

		for (int i = 1; i <= 18; i++) {
			try {
				if (i <= theNumberOfMenu) {
					BufferedImage image = ImageIO
							.read(new File("img/img_baskin/baskin_container/" + i + "_icecream.png"));
					Image scaledImage = image.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
					menuImage = new ImageIcon(scaledImage);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (i <= 9) {

				pan1.add(actions[i - 1] = new JButton());
				borderArr[i - 1] = new BorderLayout(-10, -10);
				nameArr[i - 1] = new JLabel();
				picArr[i - 1] = new JLabel(menuImage);
				actions[i - 1].setLayout(borderArr[i - 1]);
				actions[i - 1].add(picArr[i - 1], BorderLayout.CENTER);
				actions[i - 1].add(nameArr[i - 1], BorderLayout.SOUTH);
				actions[i - 1].setBackground(new Color(255, 255, 255));
				actions[i - 1].setBorder(null);
				nameArr[i - 1].setHorizontalAlignment(JLabel.CENTER);
				picArr[i - 1].setHorizontalAlignment(JLabel.CENTER);

				menuImage = null;

			}
		}

		for (buttonNum = 1; buttonNum <= theNumberOfMenu; buttonNum++) {
			if (picArr[buttonNum - 1] != null) {
				actions[buttonNum - 1].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("액션리스너 작동함");
						// choiceFramePrice.priceCard();
						// choiceFramePrice.hideButton(ChoiceSelectCake.this);
						choiceFrameBuyList.showImg();
						move.setVisible(true);

					}
				});
			}
		}
		nameArr[0].setText("<html><body style='text-align:center;'>싱글레귤러<br>3900원<html>");
		nameArr[1].setText("<html><body style='text-align:center;'>더블주니어<br>5100원<html>");
		nameArr[2].setText("<html><body style='text-align:center;'>더블레귤러<br>7300원<html>");
		nameArr[3].setText("<html><body style='text-align:center;'>파인트<br>9800원<html>");
		nameArr[4].setText("<html><body style='text-align:center;'>쿼터<br>18500원<html>");
		nameArr[5].setText("<html><body style='text-align:center;'>패밀리<br>26000원<html>");
		nameArr[6].setText("<html><body style='text-align:center;'>하프갤런<br>31500원<html>");
		nameArr[7].setText("<html><body style='text-align:center;'>버라이어티팩<br>23400원<html>");
		nameArr[8].setText("<html><body style='text-align:center;'>핸드팩<br>39200원<html>");

		System.out.println("ChoiceSelectIce : " + this);

		// categoryHome.showFrame(false);
		// categoryHome.mainCard(mainCard);

		// mainFrame.getParent().getParent().getParent().
		// categoryHome.frame(f).dispose();

		actions[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
			}
		});
		actions[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("2");
			}
		});

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
//		add(pan2);
//		add(pan3);
		setLayout(card);
		setVisible(true);
	}
}
