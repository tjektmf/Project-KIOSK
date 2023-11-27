package pj.choice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pj.admin.AdminPassword;
import pj.main.CategoryHome;
import pj.main.IceCreamShopCover;

public class ChoiceFrameTop extends JPanel {

	JButton choiceTopButtonHome;
	JButton choiceTopButtonBack;
	CategoryHome categoryHome;
	AdminPassword adminPassword = new AdminPassword();
	IceCreamShopCover iceCreamShopCover;

	public ChoiceFrameTop(ChoiceFrame mainFrame) {
		
		categoryHome = CategoryHome.getInstance();

		GridLayout grid = new GridLayout(1, 2);

		grid.setHgap(200);
		setLayout(grid);

		choiceTopButtonHome = new ChoiceTopButtonHome(this);
		choiceTopButtonBack = new ChoiceTopButtonBack(this);

		choiceTopButtonHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new IceCreamShopCover();
				categoryHome.disapear();

			}
		});

		choiceTopButtonBack.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseReleased(MouseEvent e) {
				// categoryHome.disapear();
				adminPassword.apear();
			}
		});

		add(choiceTopButtonHome, BorderLayout.WEST);
		add(choiceTopButtonBack, BorderLayout.EAST);
		setBorder(null);
		setBackground(new Color(255, 255, 255));
	}
}