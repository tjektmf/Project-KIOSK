package pj_yr.coneAndCup;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConeAndCup_01options extends JFrame {
	
	public ConeAndCup_01options() {
		setSize(540, 200);
		JLabel label1 = new JLabel("옵션");
		label1.setBounds(0, 200, 270, 200);
		label1.setFont(new Font("굴림", Font.BOLD, 30));


		JLabel label2 = new JLabel("플레이버");
		label2.setBounds(270, 200, 0, 200);
		label2.setFont(new Font("굴림", Font.BOLD, 30));

		add(label1);
		add(label2);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(270, 200, 270, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new ConeAndCup_01options();
		
		
	}

	
}