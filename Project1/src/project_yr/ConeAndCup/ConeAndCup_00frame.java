package project_yr.ConeAndCup;

import javax.swing.*;
import java.awt.*;
public class ConeAndCup_00frame extends JFrame {
	ConeAndCup_03takeOut noticeTakeOut = new ConeAndCup_03takeOut();
	
	public ConeAndCup_00frame() {

		setTitle("Custom Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(540, 960);
		
		setLayout(new GridLayout(7, 1));
		
		// 첫 번째 행
		JPanel row1 = new JPanel();
		JLabel label1a = new JLabel("옵션");
		label1a.setPreferredSize(new Dimension(100, 30));
		JLabel label1b = new JLabel("플레이버");
		label1b.setPreferredSize(new Dimension(100, 30));
		row1.add(label1a);
		row1.add(label1b);
		add(row1);
		
		// 두 번째 행
		JPanel row2 = new JPanel();
		row2.setPreferredSize(new Dimension(540, 140));
		// TODO: 여기에 필요한 컴포넌트 추가
		add(row2);
		
		// 세 번째 행
		JPanel row3 = new JPanel();
		row3.setPreferredSize(new Dimension(540, 80));
		row3.add(noticeTakeOut.getContentPane());
		add(row3);
		
		// 네 번째 행
		JPanel row4 = new JPanel();
		row4.setPreferredSize(new Dimension(540, 260));
		
		JButton button4a = new JButton("Button 4a");
		JButton button4b = new JButton("Button 4b");
		JButton button4c = new JButton("Button 4c");
		row4.add(button4a);
		row4.add(button4b);
		row4.add(button4c);
		add(row4);
		
		// 다섯 번째 행
		JPanel row5 = new JPanel();
		row5.setPreferredSize(new Dimension(540, 150));
		// TODO: 여기에 필요한 컴포넌트 추가
		add(row5);
		
		// 여섯 번째 행
		JPanel row6 = new JPanel();
		row6.setPreferredSize(new Dimension(540, 80));
		JButton button6a = new JButton("이전");
		button6a.setPreferredSize(new Dimension(100, 40));
		JButton button6b = new JButton("담기");
		button6b.setPreferredSize(new Dimension(350, 40));
		row6.add(button6a);
		row6.add(button6b);
		add(row6);
		
		// 일곱 번째 행
		JPanel row7 = new JPanel();
		row7.setPreferredSize(new Dimension(540, 150));
		// TODO: 여기에 필요한 컴포넌트 추가
		add(row7);
	}

	
	public static void main(String[] args) {
		ConeAndCup_00frame customFrame = new ConeAndCup_00frame();
        customFrame.setVisible(true);
		
	}
}


