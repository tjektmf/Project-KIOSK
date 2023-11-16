package pj.choice;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoiceFramePrice extends JPanel {

	public ChoiceFramePrice(ChoiceFrame mainFrame) {

		// JLabel test = new JLabel();
		// test.setIcon(new
		// ImageIcon("C:/ds/JavaStudy/myfiles/images/animals/img2.jpg"));

		// add(test);
		CardLayout priceCard = new CardLayout();
		
		
		setLayout(priceCard);
		setBackground(Color.cyan);
		
		JPanel pan1 = new JPanel(); 
		JPanel pan2 = new JPanel(); 

		JButton but1 = new JButton();
		JButton but2 = new JButton();
		JButton but3 = new JButton();
		
		
		add(pan1);
		add(pan2);
		
		pan2.add(but1);
		pan2.add(but2);
		pan2.add(but3);
		
		

	}
}
