package pj.menu;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuFrame extends JFrame {

	ImageIcon ok = new ImageIcon("pj/icecream.jpg");

	JButton icecreamBtn = new JButton(ok);
	JButton icecakeBtn = new JButton("icecake");
	JButton coffeeBtn = new JButton("coffee");
	JButton beverageBtn = new JButton("beverage");
	JButton dessertBtn = new JButton("dessert");
	public MenuFrame() {
		setLayout(null);
		// 1080 x 1920

		icecreamBtn.setBounds(240, 400, 200, 62);
		icecakeBtn.setBounds(510, 400, 100, 100);
		coffeeBtn.setBounds(780, 400, 100, 100);
		beverageBtn.setBounds(240, 600, 100, 100);
		dessertBtn.setBounds(510, 600, 100, 100);

		add(icecreamBtn);
		add(icecakeBtn);
		add(coffeeBtn);
		add(beverageBtn);
		add(dessertBtn);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 1920);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MenuFrame();
	}

}
