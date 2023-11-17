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

	int count = 0;

	public ChoiceSelectIce(ChoiceFrameSelect mainFrame) {
		choiceSelectPrevBtn = mainFrame.choiceSelectPrevBtn;
		choiceSelectNextBtn = mainFrame.choiceSelectNextBtn;

		// 마지막 패널에 열부터 차는건 어떻게 해결?? 그냥 버튼 개수맞춰서 마지막 패널만 수정?

		// 대충 크기나 이미지는 나중에 조정하면 될듯 크기맞추는게 좀 귀찮을거같은데
		JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 22));
		JPanel pan2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 22));
		JPanel pan3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 22));

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
		// 액션리스너는 어케주지? 이거도 포문안에 넣을수있나? 됨ㅋ

		JButton[] actions = new JButton[48];
		for (int i = 1; i < 49; i++) {
			apple = new ImageIcon("img/daseul/" + i + ".png");
			if (i < 17) {
				pan1.add(actions[i - 1] = new JButton(apple));
			} else if (i < 33) {
				pan2.add(actions[i - 1] = new JButton(apple));
			} else {
				pan3.add(actions[i - 1] = new JButton(apple));
			}
		}
		// test.setIcon(new ImageIcon("img/daseul/cat.gif"));
		
		

		actions[0].addActionListener(new ActionListener() {

			// e.getSource().toString().contains("img/daseul/1.png");

			@Override
			public void actionPerformed(ActionEvent e) {
				int check = 0;
				
		//		check = Integer.parseInt(e.getSource().toString().substring(11, e.getSource().toString().length() - 3));
				switch (check) {
				case 0:
					System.out.println("0");
					break;
				case 1:
					System.out.println("1");
					break;
				case 2:
					System.out.println("2");
					break;
				case 3:
					System.out.println("3");
					break;
				case 4:
					System.out.println("4");
					break;
				case 5:
					System.out.println("5");
					break;
				case 6:
					System.out.println("6");
					break;
				case 7:
					System.out.println("7");
					break;
				case 8:
					System.out.println("8");
					break;
				default:
					System.out.println("0");
					break;
				}
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
