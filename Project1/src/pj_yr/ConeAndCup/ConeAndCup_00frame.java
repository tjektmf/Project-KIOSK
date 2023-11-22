package pj_yr.ConeAndCup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pj.menu.CategoryHome;

public class ConeAndCup_00frame extends JFrame {

	ConeAndCup_03takeOut noticeTakeOut = new ConeAndCup_03takeOut();
	CategoryHome categoryHome;

	public ConeAndCup_00frame() {

		setSize(560, 960);
		setLocationRelativeTo(null);
		// setVisible(true);

		Color beskinColor = new Color(236, 108, 165);

		JPanel jp = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

		// 첫 번째 행
		JPanel row1 = new JPanel(new BorderLayout());

		JLabel label1a = new JLabel("옵션", SwingConstants.CENTER);
		label1a.setPreferredSize(new Dimension(270, 80));
		label1a.setForeground(beskinColor);
		label1a.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JLabel label1b = new JLabel("플레이버", SwingConstants.CENTER);
		label1b.setPreferredSize(new Dimension(270, 80));
		label1b.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		// 행2 : 맛에대한 설명
		JPanel row2 = new JPanel();
		row2.setPreferredSize(new Dimension(540, 150));
		row2.setBackground(Color.gray);
		jp.add(row2);

		// 행3 : 포장 하는지 안내문구
		JPanel row3 = new JPanel();
		row3.setPreferredSize(new Dimension(540, 50));
		row3.add(noticeTakeOut.getContentPane());
		jp.add(row3);

		// 행4 : 컵~콘~와플콘 사진이 있어야
		JPanel row4 = new JPanel();
		row4.setPreferredSize(new Dimension(540, 210));

		// 라벨1 : 컵
		JLabel btn4a = new JLabel();
		new ConeAndCup_04choicImg(btn4a);
		btn4a.setPreferredSize(new Dimension(160, 200));
		row4.add(btn4a);

		// 라벨2 : 콘
		JLabel btn4b = new JLabel();
		new ConeAndCup_04choicImg(btn4b);
		btn4b.setPreferredSize(new Dimension(160, 200));
		row4.add(btn4b);

		// 라벨3 : 와플콘
		JLabel btn4c = new JLabel();
		new ConeAndCup_04choicImg(btn4c);
		btn4c.setPreferredSize(new Dimension(160, 200));
		row4.add(btn4c);

//        btn4a.addActionListener(createButtonActionListener(0));
//        btn4b.addActionListener(createButtonActionListener(1));
//        btn4c.addActionListener(createButtonActionListener(2));

		jp.add(row4);

		// 행5 : 버튼
		JPanel row5 = new JPanel();
		row5.setPreferredSize(new Dimension(540, 40));

		// 패널 1 : 컵 버튼
		JPanel panel5a = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
		panel5a.setBackground(beskinColor);
		panel5a.setPreferredSize(new Dimension(160, 40));

		new ConeAndCup_05counting(panel5a, 1);

		row5.add(panel5a);

		// 패널 2 : 콘 버튼
		JPanel panel5b = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
		panel5b.setBackground(beskinColor);
		panel5b.setPreferredSize(new Dimension(160, 40));

		new ConeAndCup_05counting(panel5b, 2);
		row5.add(panel5b);

		// 패널 3 : 와플 버튼
		JPanel panel5c = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
		panel5c.setBackground(beskinColor);
		panel5c.setPreferredSize(new Dimension(160, 40));

		new ConeAndCup_05counting(panel5c, 3);
		row5.add(panel5c);

		jp.add(row5);

		// 행6 : 빈공간
		JPanel row6 = new JPanel();
		row6.setPreferredSize(new Dimension(540, 180));
		// TODO: 여기에 필요한 컴포넌트 추가
		jp.add(row6);

		// 행7 : 이전, 담기 버튼
		JPanel row7 = new JPanel();
		row7.setPreferredSize(new Dimension(540, 80));
		JButton button6a = new JButton("이전");
		button6a.setBackground(Color.white);
		button6a.setForeground(beskinColor);
		button6a.setPreferredSize(new Dimension(100, 30));
		button6a.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		// 다섯 번째 행

		row5.setPreferredSize(new Dimension(540, 180));
		// TODO: 여기에 필요한 컴포넌트 추가
		jp.add(row5);

		row7.add(button6a);
	
		jp.add(row7);

		// 행8 : 뭔가,, 광고 같은게,,
		JPanel row8 = new JPanel();
		row8.setPreferredSize(new Dimension(540, 170));
		// 앞으로 쓸곳8
		row8.setBackground(Color.gray);
		jp.add(row8);

		add(jp);
	}

	public static void main(String[] args) {
		new ConeAndCup_00frame().setVisible(true);
	}

}
