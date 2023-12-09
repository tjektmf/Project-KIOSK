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
import javax.swing.JOptionPane;
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

	public int SAVED_PRICE_minus(int cancel) {
		return SAVED_PRICE = SAVED_PRICE - cancel;

	}

	public void SAVED_PRICE_change(int change) {
		SAVED_PRICE = change;
		tf.setText(Integer.toString(SAVED_PRICE));
	}

	public void SAVED_PRICE_out() {
		tf.setText("price");
		tf.repaint();
	}

	ChoiceFrame mainFrame;
	CategoryHome categoryHome;
	ChoiceFrameBuyList choiceFrameBuyList;
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
		if (tf.getText().equals("price")) {
			tf.setText(Integer.toString(price));
			for (i = 0; i < 9; i++) {
				if (thisPrice[i] == 0) {
					thisPrice[i] = price;
					break;
				}
			}

		} else {
			tf.setText(Integer.toString(price + Integer.parseInt(tf.getText())));
			for (i = 0; i < 9; i++) {
				if (thisPrice[i] == 0) {
					thisPrice[i] = price;
					break;
				}
			}
		}
		System.out.println("추가된 장바구니 가격 배열 : " + Arrays.toString(thisPrice));
		SAVED_PRICE = Integer.parseInt(tf.getText());

	}

	CardLayout priceCard = new CardLayout(10, 0);

	public ChoiceFramePrice() {

		categoryHome = CategoryHome.getInstance();
		choiceFrameBuyList = ChoiceFrameBuyList.getInstance();

		System.out.println("ChoiceFramePrice : " + this);
		setLayout(priceCard);
		setBackground(new Color(244, 228, 225));

		// 팬1 팬2가 카드레이아웃에 붙일 메인 패널
		// 팬12 13은 위치 적당히 잡으려고 만든 투명패널
		// 13은 지금 안쓰는중 나중에 버튼0없애고 그자리에 넣으면됨
		JPanel pan1 = new JPanel();
		GridLayout grid = new GridLayout(1, 2);
		grid.setHgap(20);
		pan1.setLayout(grid);
		pan1.setBackground(new Color(244, 228, 225));
//		but0.setVisible(false);
		but0.setIcon(new ImageIcon("img/daseul/buy.png"));
		tf.setHorizontalAlignment(JTextField.CENTER);

		but0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				choiceFrameBuyList = ChoiceFrameBuyList.getInstance();
				boolean empty = false;
				for (int i = 0; i < 9; i++) {
					if (!choiceFrameBuyList.SAVED_BUYLIST1(i).getText().equals("")) {
						empty = false;
						break;
					} else {
						empty = true;
					}
				}
				if (empty) {
					JOptionPane.showMessageDialog(null, "장바구니가 텅~ 비었어요");
				} else {
					but0.getParent().getParent().getParent().setVisible(false);
					new PointButton();
					empty = false;
				}

			}

		});

		add(pan1);
		pan1.add(tf);
		pan1.add(but0);

	}
}
