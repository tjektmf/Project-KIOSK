package pj_yr.Container;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Container_03takeOut extends JFrame {

	public Container_03takeOut() {
		
		setSize(540, 80);
        
        JLabel label1 = new JLabel("★ 알레르기 유발 식품에 대한 정보는 매장 내 비치되었습니다 ★");
        label1.setHorizontalAlignment(JLabel.CENTER); 
        label1.setForeground(Color.RED);
		label1.setFont(new Font("맑은 고딕", Font.BOLD, 15));

        add(label1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //     setVisible(true);


	}

	public static void main(String[] args) {
		new Container_03takeOut();
	}
}