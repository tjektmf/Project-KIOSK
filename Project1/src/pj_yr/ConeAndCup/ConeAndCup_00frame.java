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

import pj.main.CategoryHome;

public class ConeAndCup_00frame extends JFrame {

	ConeAndCup_03takeOut noticeTakeOut = new ConeAndCup_03takeOut();
//    private int selectedButtonIndex = -1;
	Color beskinColor = new Color(236, 108, 165);

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

		// 행4 : 컵~콘~와플콘 사진이 있어야
		JPanel row4 = new JPanel();
		row4.setPreferredSize(new Dimension(540, 210));

		// 라벨1 : 컵
		JLabel btn4a = new JLabel();
		// new ConeAndCup_04choicImg(btn4a,"img_menu/img_Container/"+ 1 + ".png");
		btn4a.setPreferredSize(new Dimension(160, 200));
		row4.add(btn4a);

		// 라벨2 : 콘
		JLabel btn4b = new JLabel();
		// new ConeAndCup_04choicImg(btn4b,"img_menu/img_Container/"+ 2 + ".png");
		btn4b.setPreferredSize(new Dimension(160, 200));
		row4.add(btn4b);

		// 라벨3 : 와플콘
		JLabel btn4c = new JLabel();
		// new ConeAndCup_04choicImg(btn4c,"img_menu/img_Container/"+ 3 + ".png");
		btn4c.setPreferredSize(new Dimension(160, 200));
		row4.add(btn4c);

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

		// 행7 : 이전, 담기 버튼
		JPanel row7 = new JPanel();
		row7.setPreferredSize(new Dimension(540, 80));
		JButton button7a = new JButton("확인");
		button7a.setBackground(Color.white);
		button7a.setForeground(beskinColor);
		button7a.setPreferredSize(new Dimension(300, 30));
		button7a.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		button7a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

//        JButton button7b = new JButton("담기");
//        button7b.setBackground(beskinColor);
//        button7b.setForeground(Color.white);
//        button7b.setPreferredSize(new Dimension(350, 30));
//        button7b.setFont(new Font("맑은 고딕", Font.BOLD, 15));
//
		row7.add(button7a);
//        row7.add(button7b);
		jp.add(row7);

		// 다섯 번째 행

		row5.setPreferredSize(new Dimension(540, 180));
		// TODO: 여기에 필요한 컴포넌트 추가
		jp.add(row5);

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
