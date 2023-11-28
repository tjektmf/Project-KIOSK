package pj.choice;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pj.jks.PointButton;
import pj.main.CategoryHome;

public class ChoiceFramePrice extends JPanel {

	private static final ChoiceFramePrice instance = new ChoiceFramePrice();

	public static ChoiceFramePrice getInstance() {
		return instance;
	}

	public int SAVED_PRICE() {
		return SAVED_PRICE;
	}

	ChoiceFrame mainFrame;
	CategoryHome categoryHome;
	int SAVED_PRICE;
	int[] thisPrice = new int[9];

	public int thisPrice(int i) {
		return thisPrice[i];
	}

	public int thisPriceDel(int i) {
		return thisPrice[i] = 0;
	}

	// = new CategoryHome(mainFrame, pointButton);

	JButton but0 = new JButton();

	JTextField tf = new JTextField("price");

	boolean a = true; // 메서드 테스트용

	public void hideButton() {
		System.out.println("hideButton 굴데굴데");

		// but0.setVisible(true);
		// tf.setVisible(true);
		// 불리언포함 if문은 테스트용 이후 삭제하면서 윗줄 살리고 내용추가
		// 메서드 바로위에있는 인스턴스까지 삭제해야함
		if (a) {
			but0.setVisible(true);
			tf.setVisible(true);
			a = false;
		} else {
			// but0.setVisible(false);
			// tf.setVisible(false);
			a = true;
		}

//		repaint();
	}

	public void showPrice(int price) {
		int i;
		System.out.println("showPrice 데굴데굴");
		if (tf.getText().equals("price")) {
			tf.setText(Integer.toString(price));
			for (i = 0; i < 9; i++) {
				if (thisPrice[i] == 0) {
					thisPrice[i] = price;
					System.out.println("처음 : " + thisPrice[i]);
					break;
				}
			}

		} else {
			tf.setText(Integer.toString(price + Integer.parseInt(tf.getText())));
			for (i = 0; i < 9; i++) {
				if (thisPrice[i] == 0) {
					thisPrice[i] = price;
					System.out.println("나중 : " + Integer.toString(thisPrice[i]));
					break;
				}
			}
		}
		System.out.println("추가된 장바구니 가격 배열 : " + Arrays.toString(thisPrice));
		SAVED_PRICE = Integer.parseInt(tf.getText());
		System.out.println("결제창으로 보낼 값 : " + SAVED_PRICE);
	}

	CardLayout priceCard = new CardLayout(10, 0);

	public ChoiceFramePrice() {
		System.out.println("ChoiceFramePrice : " + this);
		JLabel test = new JLabel();
		test.setIcon(new ImageIcon("img/daseul/show.png"));
		test.setHorizontalAlignment(JLabel.CENTER);
		setLayout(priceCard);
		setBackground(Color.white);

		// 팬1 팬2가 카드레이아웃에 붙일 메인 패널
		// 팬12 13은 위치 적당히 잡으려고 만든 투명패널
		// 13은 지금 안쓰는중 나중에 버튼0없애고 그자리에 넣으면됨
		JPanel pan1 = new JPanel();
		GridLayout grid = new GridLayout(1, 3);
		grid.setHgap(10);
		pan1.setLayout(grid);
		but0.setVisible(false);
		but0.setIcon(new ImageIcon("img/daseul/buy.png"));
		tf.setHorizontalAlignment(JTextField.CENTER);

		but0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("결제 ㄱㄱ");
				new PointButton();
			}
		});

		add(pan1);
		pan1.add(test);
		pan1.add(tf);
		pan1.add(but0);

	}
}
