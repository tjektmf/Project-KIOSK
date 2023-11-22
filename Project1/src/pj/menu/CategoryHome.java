package pj.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pj.admin.AdminPassword;
import pj.choice.ChoiceFrame;
import pj.choice.ChoiceFrameCategory;
import pj.choice.ChoiceSelectAll;
import pj.jks.PointButton;
import pj_yr.ConeAndCup.ConeAndCup_00frame;


public class CategoryHome extends JPanel {

	private Color beskinColor = new Color(236,108,165);

	private JButton icecreamBtn = new JButton("Icecream");
	private JButton icecakeBtn = new JButton("Cake");
	private JButton coffeeBtn = new JButton("Coffee");
	private JButton beverageBtn = new JButton("Beverage");
	private JButton dessertBtn = new JButton("Dessert");
	private JButton prevBtn = new JButton("이전");

	ChoiceSelectAll choiceSelectAll;
	ChoiceFrame choiceFrame;
	ChoiceFrameCategory choiceFrameCategory;
	ConeAndCup_00frame coneAndCup_00frame = new ConeAndCup_00frame();
	
			

	public JFrame f = new JFrame();
	

	public void mainFrame(JFrame frame) {
		this.f = frame;

	}

	public void showFrame(boolean show) {
		f.setVisible(show);
	}

	public void mainCard(CardLayout mainCard) {
		
		this.card = mainCard;
		card.next(f);
	}

	CardLayout card = new CardLayout();

	public CategoryHome(ChoiceFrame mainFrame) {
		choiceSelectAll = mainFrame.choiceSelectAll;
		System.out.println("CategoryHome : " + this);
		
		f.setLayout(card);
		f.setTitle("BR31");
		
		setLayout(new GridLayout(3, 1));
		
	
		JPanel panel2 = new JPanel(null);
		panel2.setLayout(null);
	
		add(panel2);

		f.add(panel2);
		f.add(mainFrame);
	
		// 카테고리 버튼 추가
		panel2.add(icecreamBtn);
		panel2.add(icecakeBtn);
		panel2.add(coffeeBtn);
		panel2.add(beverageBtn);
		panel2.add(dessertBtn);
		panel2.add(prevBtn);

		icecreamBtn.setForeground(beskinColor);
		icecakeBtn.setForeground(beskinColor);
		coffeeBtn.setForeground(beskinColor);
		beverageBtn.setForeground(beskinColor);
		dessertBtn.setForeground(beskinColor);
	
		icecreamBtn.setBounds(80, 300, 120, 60);
		icecakeBtn.setBounds(230, 300, 100, 60);
		coffeeBtn.setBounds(360, 300, 100, 60);
		beverageBtn.setBounds(140, 450, 120, 60);
		dessertBtn.setBounds(290, 450, 100, 60);
		prevBtn.setBounds(460, 850, 60, 60);
		
		prevBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new IceCreamShopCover();

			}
		});
		// .setPreferredSize(new Dimension(width,height));
		//icecreamBtn.setPreferredSize(new Dimension(100, 60));
		//icecakeBtn.setPreferredSize(new Dimension(80, 60));
		//coffeeBtn.setPreferredSize(new Dimension(80, 60));
		//beverageBtn.setPreferredSize(new Dimension(100, 60));
		//dessertBtn.setPreferredSize(new Dimension(80, 60));

		// add("CENTER",newPanel);
		icecreamBtn.addActionListener(new MenuButtonListener("iceBtn"));
		icecakeBtn.addActionListener(new MenuButtonListener("cakeBtn"));
		coffeeBtn.addActionListener(new MenuButtonListener("coffeeBtn"));
		beverageBtn.addActionListener(new MenuButtonListener("beverageBtn"));
		dessertBtn.addActionListener(new MenuButtonListener("dessertBtn"));

		ActionListener btnActionListener = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("작동");

		        if (e.getSource() == icecreamBtn) {
		            card.next(f.getContentPane());
		            choiceSelectAll.showCard("ice");
		        } else if (e.getSource() == icecakeBtn) {
		            card.next(f.getContentPane());
		            choiceSelectAll.showCard("cake");
		        } else if (e.getSource() == coffeeBtn) {
		        	card.next(f.getContentPane());
					choiceSelectAll.showCard("coffee");
		        } else if (e.getSource() == beverageBtn) {
		        	card.next(f.getContentPane());
		        	choiceSelectAll.showCard("beverage");
		        } else if(e.getSource() == dessertBtn) {
		        	card.next(f.getContentPane());
					choiceSelectAll.showCard("dessert");
		        }
		    }
		};

		icecreamBtn.addActionListener(btnActionListener);
		icecakeBtn.addActionListener(btnActionListener);
		coffeeBtn.addActionListener(btnActionListener);
		beverageBtn.addActionListener(btnActionListener);
		dessertBtn.addActionListener(btnActionListener);

		// f.setDefaultCloseOperation(ABORT);
		f.setSize(540, 960);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			// System.out.println(itemName.substring(0, itemName.length() - 3));
		}
	}

	public static void main(String[] args) {
		ChoiceFrame choiceFrame = new ChoiceFrame();
	      new CategoryHome(choiceFrame);
	}

}