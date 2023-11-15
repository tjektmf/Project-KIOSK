package pj.choice;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PointButton extends JFrame {
	public PointButton() {
		JFrame f = new JFrame("CardLayout Sample");

		CardLayout card = new CardLayout();

		f.setLayout(card);
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel label1 = new JLabel("결제하기");
		JLabel label2 = new JLabel("회원이신가요?");

		label1.setBounds(1, 1, 300, 100);
		label1.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		label2.setBounds(1, 190, 300, 100);
		label2.setFont(new Font("맑음고딕체", Font.BOLD, 23));

		add(label1);
		add(label2);

		JButton btn1 = new JButton("포인트/할인");
		btn1.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 50));
		btn1.setForeground(Color.pink);
		btn1.setBackground(Color.white);
		btn1.setBounds(30, 90, 405, 90);
		JButton btn2 = new JButton("결제");
		btn2.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 50));
		btn2.setBackground(Color.white);
		btn2.setBounds(500, 90, 405, 90);
		JButton btn3 = new JButton("yes");
		btn3.setFont(new Font("SanSerif", Font.CENTER_BASELINE, 50));
		btn3.setBounds(30, 270, 405, 90);
		JButton btn4 = new JButton("< 이전");
		btn4.setFont(new Font("SanSerif", Font.CENTER_BASELINE, 50));
		btn4.setBounds(30, 800, 200, 90);
		btn4.setForeground(Color.pink);
		btn4.setBackground(Color.white);
		JButton btn5 = new JButton("다음단계(결제하기)");
		btn5.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 50));
		btn5.setBounds(245, 800, 705, 90);
		btn5.setForeground(Color.white);
		btn5.setBackground(Color.pink);

		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);

//		btn1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				btn1.setBackground(Color.pink);
//				
//			}
//		});

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn3.setBackground(Color.pink);

			}
		});

//		btn5.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				card
//				
//			}
//		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PointButton();
	}

}
