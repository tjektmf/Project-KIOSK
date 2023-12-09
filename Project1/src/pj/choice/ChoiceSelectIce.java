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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.JdbcConnection;
import pj.main.CategoryHome;
import pj.main.IceCreamShopCover;
import pj_yr.ConeAndCup.ConeAndCup_00frame;
import pj_yr.Container.Container_00frame;

public class ChoiceSelectIce extends JPanel {

	// 카드레이아웃도 주변패널과의 행열간격은 줄수있음 CardLayout(x,y)
	CardLayout card = new CardLayout();
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
	Container_00frame move2 = new Container_00frame();
	ChoiceFrameBuyList choiceFrameBuyList;
	ChoiceFrameSelect choiceFrameSelect;

//	JLabel[] SAVED_BUYLIST = new JLabel[9];

	// ResultSet priceSet;
	ArrayList<Integer> priceSet = new ArrayList<Integer>();

	// 이미지 없다고 오류떠서 메뉴개수 정해줌
	final int theNumberOfMenu = 9;
	int buttonNum = 1;

	// ChoiceFrameSelect mainFrame
	public ChoiceSelectIce(ChoiceFrameSelect mainFrame) {
		choiceFrameBuyList = ChoiceFrameBuyList.getInstance();
		choiceFramePrice = ChoiceFramePrice.getInstance();

		choiceSelectPrevBtn = mainFrame.choiceSelectPrevBtn;
		choiceSelectNextBtn = mainFrame.choiceSelectNextBtn;

		GridLayout grid1 = new GridLayout(3, 3);

		grid1.setHgap(10);
		grid1.setVgap(10);

		JPanel pan1 = new JPanel(grid1);
		pan1.setBackground(new Color(244, 228, 225));

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
				actions[i - 1].add(nameArr[i - 1], BorderLayout.SOUTH);
				actions[i - 1].add(picArr[i - 1], BorderLayout.CENTER);
				actions[i - 1].setBackground(new Color(255, 255, 255));
				actions[i - 1].setBorder(null);
				nameArr[i - 1].setHorizontalAlignment(JLabel.CENTER);
				picArr[i - 1].setHorizontalAlignment(JLabel.CENTER);
				menuImage = null;
			}
		}

		try {
			Connection conn = JdbcConnection.getConnection();
			String sql = "select icecream_name, icecream_price, icecream_id from icecream";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			int i = 0;
			while (rs.next()) { // 넥스트값이 없으면 false를 반환, while문 정지
				nameArr[i].setText("<html><body style='text-align:center;'>" + rs.getString("icecream_name") + "<br>"
						+ rs.getInt("icecream_price") + "<html>");
				i++;

				priceSet.add(rs.getInt("icecream_price"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (buttonNum = 1; buttonNum <= theNumberOfMenu; buttonNum++) {
			if (picArr[buttonNum - 1] != null) {
				actions[buttonNum - 1].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						boolean full = false;
						for (int i = 0; i < theNumberOfMenu; i++) {
							for (int j = 0; j < 9; j++) {
								if (choiceFramePrice.thisPrice[j] == 0) {
									full = true;

								}
							}
							if (e.getSource() == actions[i] && full) {

								choiceFramePrice.showPrice(priceSet.get(i));
								for (int k = 0; k < 9; k++) {

									if (choiceFrameBuyList.SAVED_BUYLIST1[k].getText() == "") {

										try {
											Connection conn = JdbcConnection.getConnection();
											String sql = "select icecream_name, icecream_price from icecream";

											PreparedStatement pstmt = conn.prepareStatement(sql);
											ResultSet rs = pstmt.executeQuery();

											while (rs.next()) { // 넥스트값이 없으면 false를 반환, while문 정지
												if (nameArr[i].getText().contains(rs.getString("icecream_name"))) {
													choiceFrameBuyList.SAVED_BUYLIST1[k]
															.setText(rs.getString("icecream_name"));
													choiceFrameBuyList.SAVED_BUYLIST7[k]
															.setText(Integer.toString(rs.getInt("icecream_price")));
												}

											}

											rs.close();
											conn.close();

											// choiceFrameBuyList.SAVED_BUYLIST1[k].setText(nameArr[i].getText());
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										break;
									}

								}
							}
						}

		//				System.out.println("아이스크림 크기배열 : " + Arrays.toString(choiceFrameBuyList.ICECREAM_SIZE));
						choiceFrameBuyList.showImg();
						choiceFramePrice.hideButton();

						// if문을 통해 메뉴당 골라서 넣으면 될듯

						if (choiceFrameBuyList.SAVED_BUYLIST1[8].getText().equals("")) {
							for (int i = 0; i < theNumberOfMenu; i++) {
								if (e.getSource() == actions[i]) {
									switch (i) {
									case 0, 1, 2:
										move.setVisible(true);
										break;
									case 3, 4, 5, 6, 7, 8:
										move2.setVisible(true);
										break;

									}
								}
							}
						}
						boolean fullCheck = false;
						for (int p = 0; p < 9; p++) {
							if (choiceFrameBuyList.SAVED_BUYLIST1(p).getText() == "") {
								fullCheck = false;
								break;
							} else {
								fullCheck = true;
							}
						}
						if (fullCheck) {
							JOptionPane.showMessageDialog(null, "장바구니에 빈 자리가 없어요");
							fullCheck = false;
						}
					}
				});
			}
		}

		System.out.println("ChoiceSelectIce : " + this);

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
		setLayout(card);
		setVisible(true);
	}
}
