package pj.choice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class dd extends JFrame {

	JButton icecreamBtn = new JButton("아이스크림");
	JButton icecakeBtn = new JButton("케이크");
	JButton coffeeBtn = new JButton("커피");
	JButton beverageBtn = new JButton("음료");
	JButton dessertBtn = new JButton("디저트");

	public dd() {
		setTitle("카테고리");

		// 메인 프레임에 GridLayout을 사용
//		setLayout(new GridLayout(1, 2));

		// 첫 번째 패널에 버튼을 추가
		JPanel panel1 = new JPanel();

		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		// panel1.setLayout(null);
		panel1.add(icecreamBtn);
		panel1.add(icecakeBtn);
		panel1.add(coffeeBtn);
		panel1.add(beverageBtn);
		panel1.add(dessertBtn);

		icecreamBtn.setPreferredSize(new Dimension(200, 200));
		// icecreamBtn.setBounds(80, 150, 100, 50);
		icecakeBtn.setBounds(200, 150, 100, 50);
		coffeeBtn.setBounds(310, 150, 100, 50);
		beverageBtn.setBounds(130, 300, 100, 50);
		dessertBtn.setBounds(260, 300, 100, 50);

		icecreamBtn.addActionListener(new MenuButtonListener("아이스크림"));
		icecakeBtn.addActionListener(new MenuButtonListener("케이크"));
		coffeeBtn.addActionListener(new MenuButtonListener("커피"));
		beverageBtn.addActionListener(new MenuButtonListener("음료"));
		dessertBtn.addActionListener(new MenuButtonListener("디저트"));

		// 메인 프레임에 패널 추가
		add(panel1);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		setVisible(true);
	}

	// 메뉴 버튼에 대한 액션 리스너
	private class MenuButtonListener implements ActionListener {
		private String itemName;

		public MenuButtonListener(String itemName) {
			this.itemName = itemName;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// 선택된 메뉴 정보 처리
			System.out.println(itemName + " 선택됨");
		}
	}

	public static void main(String[] args) {
		new dd();
	}
}