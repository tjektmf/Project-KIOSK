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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoiceSelectBeverage extends JPanel {

	CardLayout card = new CardLayout();
	JButton choiceSelectPrevBtn;
	JButton choiceSelectNextBtn;
	ImageIcon menuImage;
	int theNumberOfMenu = 18;

	public ChoiceSelectBeverage(ChoiceFrameSelect4 mainFrame) {

		choiceSelectPrevBtn = mainFrame.choiceSelectPrevBtn;
		choiceSelectNextBtn = mainFrame.choiceSelectNextBtn;

		JPanel pan1 = new JPanel(new GridLayout(3, 3));
		JPanel pan2 = new JPanel(new GridLayout(3, 3));
		JPanel pan3 = new JPanel(new GridLayout(3, 3));

		JButton[] actions = new JButton[48];
		BorderLayout[] borderArr = new BorderLayout[48];
		JLabel[] nameArr = new JLabel[48];
		JLabel[] picArr = new JLabel[48];
		
		for (int i = 1; i <= 18; i++) {
			try {
				if (i <= theNumberOfMenu) {
					BufferedImage image = ImageIO.read(new File("img/img_baskin/baskin_beverage/" + i + ".png"));
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
			} else if (i < 19) {
				pan2.add(actions[i - 1] = new JButton(menuImage));
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

		nameArr[0].setText("<html><body style='text-align:center;'>도라에몽의<br>대나무 헬리콥터<br>31000원<html>");
		nameArr[1].setText("<html><body style='text-align:center;'>달토끼맛 쿠기의<br>보름달 소원<br>28000원<html>");
		nameArr[2].setText("<html><body style='text-align:center;'>노티드 스마일<br>크림 버니<br>31000원<html>");
		nameArr[3].setText("<html><body style='text-align:center;'>스페셜 데이<br>27000원<html>");
		nameArr[4].setText("<html><body style='text-align:center;'>핑크 퐁당 라이언<br>28000원<html>");
		nameArr[5].setText("<html><body style='text-align:center;'>핑크 라춘 인 원더랜드<br>31000원<html>");
		nameArr[6].setText("<html><body style='text-align:center;'>라이언의 서핑 타임<br>33000원<html>");
		nameArr[7].setText("<html><body style='text-align:center;'>핑크 하트 드롭<br>31000원<html>");
		nameArr[8].setText("<html><body style='text-align:center;'>우주에서 온<br>엄마는 외계인<br>28000원<html>");
		nameArr[9].setText("<html><body style='text-align:center;'>반짝이는 잔망루피<br>30000원<html>");

		choiceSelectNextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceSelectBeverage.this);

			}
		});
		choiceSelectPrevBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(ChoiceSelectBeverage.this);

			}
		});

		add(pan1);
		add(pan2);
		add(pan3);
		setLayout(card);
		setVisible(true);

	}

}
