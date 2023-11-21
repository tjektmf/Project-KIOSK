package pj.choice;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pj.jks.PointButton;
import pj.menu.CategoryHome;

public class ChoiceFramePrice extends JPanel {

	private static final ChoiceFramePrice instance = new ChoiceFramePrice();

	public static ChoiceFramePrice getInstance() {
		return instance;
	}

	ChoiceFrame mainFrame;
	PointButton pointButton;
	CategoryHome categoryHome;
	// = new CategoryHome(mainFrame, pointButton);

	JButton but0 = new JButton("결제하기");
	JTextField tf = new JTextField("price");


	boolean a = true; // 메서드 테스트용

	public void hideButton() {
		System.out.println(but0.getSize() + " hideButton 굴러감");

		// but0.setVisible(true);
		// tf.setVisible(true);
		// 불리언포함 if문은 테스트용 이후 삭제하면서 윗줄 살리고 내용추가
		// 메서드 바로위에있는 인스턴스까지 삭제해야함
		if (a) {
			but0.setVisible(true);
			tf.setVisible(true);
			a = false;
		} else {
			but0.setVisible(false);
			tf.setVisible(false);
			a = true;
		}

//		repaint();
	}

	public void showPrice(int price) {
		System.out.println("showPrice 데굴데굴");
		tf.setText(Integer.toString(price));
	}

	public void priceCard() {
		priceCard.next(this);
	}

	CardLayout priceCard = new CardLayout(10, 0);

	public ChoiceFramePrice() {
		System.out.println("ChoiceFramePrice : " + this);

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

		but0.setVisible(false);

		JButton but1 = new JButton("제리 그대로 보여줌");
		JButton but2 = new JButton("text로 가격보여줌");
		JButton but3 = new JButton("결제하기"); //

		tf.setHorizontalAlignment(JTextField.CENTER);

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
				// categoryHome.showCard("price");
				System.out.println("나중에 결제창으로");

			}
		});

		add(pan1);
		add(pan2);
		pan1.add(test);
		pan1.add(tf);
		pan1.add(but0);
		pan2.add(test2);
		// pan2.add(tf);
		pan2.add(but3);

	}
}
