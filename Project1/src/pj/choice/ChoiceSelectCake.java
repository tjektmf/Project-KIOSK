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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.JdbcConnection;
import pj_yr.ConeAndCup.ConeAndCup_00frame;

public class ChoiceSelectCake extends JPanel {

	CardLayout card = new CardLayout();
	JButton choiceSelectPrevBtn;
	JButton choiceSelectNextBtn;
	ImageIcon menuImage;

	ChoiceFrame choiceFrame;
	ChoiceFramePrice choiceFramePrice;
	ConeAndCup_00frame move = new ConeAndCup_00frame();
	ChoiceFrameBuyList choiceFrameBuyList;
	ArrayList<Integer> priceSet = new ArrayList<Integer>();

	final int theNumberOfMenu = 14;
	int buttonNum;

	public ChoiceSelectCake(ChoiceFrameSelect2 mainFrame) {
		choiceFrameBuyList = ChoiceFrameBuyList.getInstance();
		choiceFramePrice = ChoiceFramePrice.getInstance();

		choiceSelectPrevBtn = mainFrame.choiceSelectPrevBtn;
		choiceSelectNextBtn = mainFrame.choiceSelectNextBtn;

		GridLayout grid1 = new GridLayout(3, 3);
		GridLayout grid2 = new GridLayout(3, 3);
		grid1.setHgap(10);
		grid1.setVgap(10);
		grid2.setHgap(10);
		grid2.setVgap(10);

		JPanel pan1 = new JPanel(grid1);
		JPanel pan2 = new JPanel(grid2);
		pan1.setBackground(new Color(244, 228, 225));
		pan2.setBackground(new Color(244, 228, 225));
		JPanel pan3 = new JPanel(new GridLayout(3, 3));

		JButton[] actions = new JButton[48];
		BorderLayout[] borderArr = new BorderLayout[48];
		JLabel[] nameArr = new JLabel[48];
		JLabel[] picArr = new JLabel[48];

		for (int i = 1; i <= 18; i++) {
			try {

				if (i <= theNumberOfMenu) {
					BufferedImage image = ImageIO.read(new File("img/img_baskin/baskin_cake/" + i + ".png"));
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

			} else if (i < 19) {
				pan2.add(actions[i - 1] = new JButton(menuImage));
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
			String sql = "select cake_name, cake_price from cake";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			int i = 0;
			while (rs.next()) { // 넥스트값이 없으면 false를 반환, while문 정지
				nameArr[i].setText("<html><body style='text-align:center;'>" + rs.getString("cake_name") + "<br>"
						+ rs.getInt("cake_price") + "<html>");
				i++;

				priceSet.add(rs.getInt("cake_price"));
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
											String sql = "select cake_name, cake_price from cake";

											PreparedStatement pstmt = conn.prepareStatement(sql);
											ResultSet rs = pstmt.executeQuery();

											while (rs.next()) { // 넥스트값이 없으면 false를 반환, while문 정지
												if (nameArr[i].getText().contains(rs.getString("cake_name"))) {
													choiceFrameBuyList.SAVED_BUYLIST1[k]
															.setText(rs.getString("cake_name"));
													choiceFrameBuyList.SAVED_BUYLIST2[k].setText(" ");
													choiceFrameBuyList.SAVED_BUYLIST7[k]
															.setText(Integer.toString(rs.getInt("cake_price")));
												}

											}

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
						choiceFrameBuyList.showImg();
						choiceFramePrice.hideButton();
						boolean fullCheck = false;
						for (int p = 0; p < 9; p++) {
							if (choiceFrameBuyList.SAVED_BUYLIST2(p).getText() == "") {
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

		choiceSelectNextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceSelectCake.this);

			}
		});
		choiceSelectPrevBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(ChoiceSelectCake.this);

			}
		});

		add(pan1);
		add(pan2);
//		add(pan3);
		setLayout(card);
		setVisible(true);

	}
}
