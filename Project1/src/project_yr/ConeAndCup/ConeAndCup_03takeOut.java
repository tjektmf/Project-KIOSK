package project_yr.ConeAndCup;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConeAndCup_03takeOut extends JFrame {

	public ConeAndCup_03takeOut() {
		
		setSize(540, 80);
        
        JLabel label1 = new JLabel("★ 포장 불가 품목으로 쇼핑백/뚜껑이 제공되지 않습니다 ★");
        label1.setHorizontalAlignment(JLabel.CENTER); 
        label1.setForeground(Color.RED);
		label1.setFont(new Font("맑은 고딕", Font.BOLD, 15));

        add(label1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //     setVisible(true);


	}

	public static void main(String[] args) {
		new ConeAndCup_03takeOut();
	}
}
