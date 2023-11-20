package pj.hm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CategoryHome extends JFrame {

	JButton icecreamBtn = new JButton("아이스크림");
	JButton icecakeBtn = new JButton("케이크");
	JButton coffeeBtn = new JButton("커피");
	JButton beverageBtn = new JButton("음료");
	JButton dessertBtn = new JButton("디저트");

	public CategoryHome() {
		setTitle("category");
		setLayout(new GridLayout(3, 1));

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));

		add(panel);
		add(panel2);
		
		// 카테고리 버튼 추가
		panel2.add(icecreamBtn);
		panel2.add(icecakeBtn);
		panel2.add(coffeeBtn);
		panel2.add(beverageBtn);
		panel2.add(dessertBtn);
		
		//.setPreferredSize(new Dimension(width,height));
		icecreamBtn.setPreferredSize(new Dimension(100,60));
		icecakeBtn.setPreferredSize(new Dimension(80,60));
		coffeeBtn.setPreferredSize(new Dimension(80,60));
		beverageBtn.setPreferredSize(new Dimension(80,60));
		dessertBtn.setPreferredSize(new Dimension(80,60));
		
		// add("CENTER",newPanel);
		icecreamBtn.addActionListener(new MenuButtonListener("아이스크림"));
		icecakeBtn.addActionListener(new MenuButtonListener("케이크"));
		coffeeBtn.addActionListener(new MenuButtonListener("커피"));
		beverageBtn.addActionListener(new MenuButtonListener("음료"));
		dessertBtn.addActionListener(new MenuButtonListener("디저트"));


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 540, 960);
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
		new CategoryHome();
	}

}