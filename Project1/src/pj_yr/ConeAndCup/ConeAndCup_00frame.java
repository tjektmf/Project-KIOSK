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

		setSize(555, 960);
		setLocationRelativeTo(null);
	//	setVisible(true);

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

		row1.add(label1a, BorderLayout.WEST);
		row1.add(label1b, BorderLayout.EAST);
		jp.add(row1);

		// 두 번째 행
		JPanel row2 = new JPanel();
		row2.setPreferredSize(new Dimension(540, 150));
		row2.setBackground(Color.gray);
		jp.add(row2);

		// 세 번째 행
		JPanel row3 = new JPanel();
		row3.setPreferredSize(new Dimension(540, 50));
		row3.add(noticeTakeOut.getContentPane());
		jp.add(row3);

		// 네 번째 행
		JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		row4.setPreferredSize(new Dimension(540, 280));

		// 패널 1
		JPanel panel4a = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
		panel4a.setBackground(beskinColor);
		panel4a.setPreferredSize(new Dimension(160, 40));

		JButton minusButton1 = new JButton("-");
		JTextField numberField1 = new JTextField("0", 3); // 초기값은 0
		numberField1.setEditable(false);
		JButton plusButton1 = new JButton("+");

		// 버튼에 대한 액션 리스너 추가
		minusButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentValue = Integer.parseInt(numberField1.getText());
				if (currentValue > 0) {
					numberField1.setText(Integer.toString(currentValue - 1));
				}
			}
		});

		plusButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentValue = Integer.parseInt(numberField1.getText());
				if (currentValue < 100) {
					numberField1.setText(Integer.toString(currentValue + 1));
				}
			}
		});

		panel4a.add(minusButton1);
		panel4a.add(numberField1);
		panel4a.add(plusButton1);

		row4.add(panel4a);

		// 패널 2
		JPanel panel4b = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
		panel4b.setBackground(beskinColor);
		panel4b.setPreferredSize(new Dimension(160, 40));

		JButton minusButton2 = new JButton("-");
		JTextField numberField2 = new JTextField("0", 3); // 초기값은 0
		numberField2.setEditable(false);
		JButton plusButton2 = new JButton("+");

		// 버튼에 대한 액션 리스너 추가
		minusButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentValue = Integer.parseInt(numberField2.getText());
				if (currentValue > 0) {
					numberField2.setText(Integer.toString(currentValue - 1));
				}
			}
		});

		plusButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentValue = Integer.parseInt(numberField2.getText());
				if (currentValue < 100) {
					numberField2.setText(Integer.toString(currentValue + 1));
				}
			}
		});

		panel4b.add(minusButton2);
		panel4b.add(numberField2);
		panel4b.add(plusButton2);

		row4.add(panel4b);

		// 패널 3
		JPanel panel4c = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
		panel4c.setBackground(beskinColor);
		panel4c.setPreferredSize(new Dimension(160, 40));

		JButton minusButton3 = new JButton("-");
		JTextField numberField3 = new JTextField("0", 3); // 초기값은 0
		numberField3.setEditable(false);
		JButton plusButton3 = new JButton("+");

		// 버튼에 대한 액션 리스너 추가
		minusButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentValue = Integer.parseInt(numberField3.getText());
				if (currentValue > 0) {
					numberField3.setText(Integer.toString(currentValue - 1));
				}
			}
		});

		plusButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentValue = Integer.parseInt(numberField3.getText());
				if (currentValue < 100) {
					numberField3.setText(Integer.toString(currentValue + 1));
				}
			}
		});

		panel4c.add(minusButton3);
		panel4c.add(numberField3);
		panel4c.add(plusButton3);

		row4.add(panel4c);

		jp.add(row4);

		// 다섯 번째 행
		JPanel row5 = new JPanel();
		row5.setPreferredSize(new Dimension(540, 180));
		// TODO: 여기에 필요한 컴포넌트 추가
		jp.add(row5);

		// 여섯 번째 행
		JPanel row6 = new JPanel();
		row6.setPreferredSize(new Dimension(540, 80));
		JButton button6a = new JButton("이전");
		button6a.setBackground(Color.white);
		button6a.setForeground(beskinColor);
		button6a.setPreferredSize(new Dimension(100, 30));
		button6a.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		JButton button6b = new JButton("담기");
		button6b.setBackground(beskinColor);
		button6b.setForeground(Color.white);
		button6b.setPreferredSize(new Dimension(350, 30));
		button6b.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		row6.add(button6a);
		row6.add(button6b);
		jp.add(row6);

		// 일곱 번째 행
		JPanel row7 = new JPanel();
		row7.setPreferredSize(new Dimension(540, 170));
		// 앞으로 쓸곳8
		row7.setBackground(Color.gray);
		jp.add(row7);

		add(jp);
	}

	public static void main(String[] args) {
		new ConeAndCup_00frame();
	}
}
