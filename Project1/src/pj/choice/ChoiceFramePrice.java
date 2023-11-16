package pj.choice;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoiceFramePrice extends JPanel {

	public ChoiceFramePrice(ChoiceFrame mainFrame) {
		
		CardLayout priceCard = new CardLayout(10, 0);

		JLabel test = new JLabel();
		JLabel test2 = new JLabel();
		test.setIcon(new ImageIcon("img/daseul/cat.gif"));
		test2.setIcon(new ImageIcon("img/daseul/cat.gif"));
		test.setHorizontalAlignment(JLabel.CENTER);
		test2.setHorizontalAlignment(JLabel.CENTER);

		setLayout(priceCard);
		setBackground(Color.white);

		// 팬1 팬2가 카드레이아웃에 붙일 메인 패널
		// 팬12 13은 위치 적당히 잡으려고 만든 투명패널
		// 13은 지금 안쓰는중 나중에 버튼0없애고 그자리에 넣으면됨
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan12 = new JPanel();
		JPanel pan13 = new JPanel();
		GridLayout grid = new GridLayout(1, 3);
		grid.setHgap(10);
		pan1.setLayout(grid);
		pan2.setLayout(grid);

		JButton but0 = new JButton("나중에 사라질 버튼");
		JButton but1 = new JButton("제리 그대로 보여줌");
		JButton but2 = new JButton("text로 가격보여줌");
		JButton but3 = new JButton("결제하기");

		but0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				priceCard.next(ChoiceFramePrice.this);
				System.out.println("ddd");
			}
		});

		but1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				priceCard.previous(ChoiceFramePrice.this);
				System.out.println("뒤로");

			}
		});

		but2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				priceCard.previous(ChoiceFramePrice.this);
				System.out.println("삭제하고 텍스트로");

			}
		});

		but3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				priceCard.previous(ChoiceFramePrice.this);
				System.out.println("나중에 결제창으로");

			}
		});

		add(pan1);
		add(pan2);
		pan1.add(test);
		pan1.add(pan12);
		pan1.add(but0);
		pan2.add(test2);
		pan2.add(but2);
		pan2.add(but3);

	}
}