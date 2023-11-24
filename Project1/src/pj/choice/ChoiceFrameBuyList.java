package pj.choice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChoiceFrameBuyList extends JPanel {

	// 싱글톤 : 생성자 private 박아버리고 다른데선 객체생성을 못하게하고
	// public 메서드로 만들어논 객체를 불러다 사용하게 설정함 중복으로 객체가 만들어지는걸 막아줌
	private static final ChoiceFrameBuyList instance = new ChoiceFrameBuyList();

	public static ChoiceFrameBuyList getInstance() {
		return instance;
	}

	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel[] SAVED_BUYLIST = new JLabel[9];
	JLabel label3 = new JLabel();
	GridLayout grid1 = new GridLayout(1, 3);
	GridLayout grid2 = new GridLayout(1, 3);
	GridLayout grid3 = new GridLayout(1, 3);
	JPanel gridPan1 = new JPanel(grid1);
	JPanel gridPan2 = new JPanel(grid2);
	JPanel gridPan3 = new JPanel(grid3);
	CardLayout card = new CardLayout(10, 10);

	public JLabel[] SAVED_BUYLIST() {
		return SAVED_BUYLIST();
	}

	private ChoiceFrameBuyList() {

		JLabel test = new JLabel();
		test.setIcon(new ImageIcon("img/daseul/cat.gif"));

		grid1.setVgap(20);
		grid1.setHgap(20);
		grid2.setVgap(20);
		grid2.setHgap(20);
		grid3.setVgap(20);
		grid3.setHgap(20);

		JPanel borderPan1 = new JPanel(new BorderLayout(20, 20));
		JPanel borderPan2 = new JPanel(new BorderLayout(20, 20));
		JPanel borderPan3 = new JPanel(new BorderLayout(20, 0));

		JButton borderPrevBtn1 = new JButton("<<");
		JButton borderNextBtn1 = new JButton(">>");
		JButton borderPrevBtn2 = new JButton("<<");
		JButton borderNextBtn2 = new JButton(">>");
		JButton borderPrevBtn3 = new JButton("<<");
		JButton borderNextBtn3 = new JButton(">>");

		borderNextBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceFrameBuyList.this);

			}
		});
		borderNextBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceFrameBuyList.this);

			}
		});
		borderNextBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(ChoiceFrameBuyList.this);

			}
		});
		borderPrevBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(ChoiceFrameBuyList.this);

			}
		});
		borderPrevBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(ChoiceFrameBuyList.this);

			}
		});
		borderPrevBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(ChoiceFrameBuyList.this);

			}
		});

		setLayout(card);
		add(borderPan1);
		add(borderPan2);
		add(borderPan3);
		borderPan1.add(borderPrevBtn1, BorderLayout.WEST);
		borderPan1.add(borderNextBtn1, BorderLayout.EAST);
		borderPan1.add(gridPan1, BorderLayout.CENTER);
		borderPan2.add(borderPrevBtn2, BorderLayout.WEST);
		borderPan2.add(borderNextBtn2, BorderLayout.EAST);
		borderPan2.add(gridPan2, BorderLayout.CENTER);
		borderPan3.add(borderPrevBtn3, BorderLayout.WEST);
		borderPan3.add(borderNextBtn3, BorderLayout.EAST);
		borderPan3.add(gridPan3, BorderLayout.CENTER);
		gridPan1.setLayout(grid1);
		gridPan2.setLayout(grid2);
		gridPan3.setLayout(grid3);

//		gridPan1.add(label2);
//		gridPan1.add(label3);

		// 팬2는 날릴 생각으로 test랑 같이 붙여놓은거임
		label1.setText("외않되");
		System.out.println("외않되 추가당시 instance: " + this);

		for (int i = 0; i < 9; i++) {
			SAVED_BUYLIST[i] = new JLabel();

			switch (i) {
			case 0, 1, 2:
				gridPan1.add(SAVED_BUYLIST[i]);
				// SAVED_BUYLIST[i].setText("콘컵맛 추가예정 : " + i);
				break;
			case 3, 4, 5:
				gridPan2.add(SAVED_BUYLIST[i]);
				// SAVED_BUYLIST[i].setText("콘컵맛 추가예정 : " + i);
				break;
			case 6, 7, 8:
				gridPan3.add(SAVED_BUYLIST[i]);
				// SAVED_BUYLIST[i].setText("콘컵맛 추가예정 : " + i);
				break;
			}

		}

	}

	public void showImg() {
		System.out.println("showImg 잘굴러가는중");
		int i;
		for (i = 0; i < 10; i++) {
			if (i >= 9) {
				JOptionPane.showMessageDialog(null, "장바구니에 빈 자리가 없어요");
				break;
			}

			if (SAVED_BUYLIST[i].getText() == "") {
				SAVED_BUYLIST[i].setText("콘컵맛 추가예정 : " + i);
				if (i == 3 || i == 6) {
					card.next(ChoiceFrameBuyList.this);
				}

				break;
			}
		}
	}
}
