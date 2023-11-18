package pj.choice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoiceSelectIce extends JPanel {

	// 카드레이아웃도 주변패널과의 행열간격은 줄수있음 CardLayout(x,y)
	CardLayout card = new CardLayout();

	JButton choiceSelectPrevBtn;
	JButton choiceSelectNextBtn;
	ImageIcon apple;
	ChoiceFramePrice choiceFramePrice;

	int count;
	int num;

	public ChoiceSelectIce(ChoiceFrameSelect mainFrame) {
		choiceSelectPrevBtn = mainFrame.choiceSelectPrevBtn;
		choiceSelectNextBtn = mainFrame.choiceSelectNextBtn;

		// 마지막 패널에 열부터 차는건 어떻게 해결?? 그냥 버튼 개수맞춰서 마지막 패널만 수정?

		// 대충 크기나 이미지는 나중에 조정하면 될듯 크기맞추는게 좀 귀찮을거같은데

		// 패널 3개를 gridlayout으로 설정하기 위해 3개를 만듬
		// 행렬 설정 자체는 굳이 따로 만들지 않아도 되지만 setvgap sethgap을 수정하기 위해 만듬
		GridLayout grid1 = new GridLayout(3, 3);
		GridLayout grid2 = new GridLayout();
		GridLayout grid3 = new GridLayout();
		grid1.setHgap(10);
		grid1.setVgap(10);
		grid2.setHgap(10);
		grid2.setVgap(10);
		grid3.setHgap(10);
		grid3.setVgap(10);

		JPanel pan1 = new JPanel(grid1);
		JPanel pan2 = new JPanel(grid2);
		JPanel pan3 = new JPanel(grid3);

		// 나중에 페이지 나타내는 이미지활용 지금은 무시해도됨
		JLabel page1 = new JLabel();
		page1.setIcon(new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/pagetest.png"));
		JLabel page2 = new JLabel();
		JLabel page22 = new JLabel();
		page2.setIcon(new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/pagetest.png"));
		page22.setIcon(new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/pagetest.png"));

		JLabel page3 = new JLabel();
		JLabel page32 = new JLabel();
		JLabel page33 = new JLabel();
		page3.setIcon(new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/pagetest.png"));
		page32.setIcon(new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/pagetest.png"));
		page33.setIcon(new ImageIcon("C:/ds/JavaStudy/myfiles/images/fruits/pagetest.png"));

		// 이거 버튼마다 이미지 넣으려면 이미지 번호가 1씩 증가하게 저장하면 될거같음
		// 액션리스너는 어케주지? 이거도 포문안에 넣을수있나?

		
		
		JButton[] actions = new JButton[48];
		BorderLayout[] borderArr = new BorderLayout[48];
		JLabel[] nameArr = new JLabel[48];
		JLabel[] picArr = new JLabel[48];
		for (int i = 1; i < 8; i++) {
			apple = new ImageIcon("img/img_baskin/baskin_container/0" + i + ".png");
			if (i < 8) {
				pan1.add(actions[i - 1] = new JButton());
				borderArr[i - 1] = new BorderLayout(0, -10);
				nameArr[i - 1] = new JLabel("<html>파인트<br>9800원<html>");
				picArr[i - 1] = new JLabel(apple);
				actions[i - 1].setLayout(borderArr[i - 1]);
				actions[i - 1].add(picArr[i - 1], BorderLayout.CENTER);
				actions[i - 1].add(nameArr[i - 1], BorderLayout.SOUTH);
				nameArr[i - 1].setHorizontalAlignment(JLabel.CENTER);
				picArr[i - 1].setHorizontalAlignment(JLabel.CENTER);
			} else if (i < 33) {
				pan2.add(actions[i - 1] = new JButton(apple));
			} else {
				pan3.add(actions[i - 1] = new JButton(apple));
			}
		}

		// test.setIcon(new ImageIcon("img/daseul/cat.gif"));
		// e.getSource().toString().contains("img/daseul/1.png");
		// check = Integer.parseInt(e.getSource().toString().substring(11,
		// e.getSource().toString().length() - 3));

		// 각 메뉴 선택시 이동하는 화면이 다르고 가격도 다름
		// switch 문으로 여러개 묶을수는 있을거같은데

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

		pan1.add(page1);
		pan2.add(page2);
		pan2.add(page22);
		pan3.add(page3);
		pan3.add(page32);
		pan3.add(page33);

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
		add(pan2);
		add(pan3);
		setLayout(card);
		setVisible(true);

	}

}
