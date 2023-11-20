package pj.choice;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PointButton extends JFrame {
	public PointButton() {
		JFrame f = new JFrame("CardLayout Sample");
		CardLayout card = new CardLayout();
		f.setLayout(card);
		Color color = new Color(236, 108, 165);
		
		JPanel panel1 = new JPanel(null);
		JPanel panel2 = new JPanel(null);
		JPanel panel3 = new JPanel(null);
		JPanel panel4 = new JPanel(null);
		JPanel panel5 = new JPanel(null);
		JPanel panel6 = new JPanel(null);

	
		panel1.setBackground(color);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.white);
		
		//panel 1부분
		JLabel label1 = new JLabel("결제하기");
		JLabel label2 = new JLabel("회원이신가요?");
		JLabel label3 = new JLabel("최종 결제금액");
	
		label1.setBounds(30, 1, 300, 100);
		label1.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		label2.setBounds(30, 190, 500, 100);
		label2.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		label3.setBounds(30, 490, 300, 100);
		label3.setFont(new Font("맑음고딕체", Font.BOLD, 23));
	
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
	
		JButton btn1 = new JButton("회원포인트");
		btn1.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		btn1.setForeground(Color.pink);
		btn1.setBackground(new Color(0,0,0,0)); 
		btn1.setBounds(30, 90, 145, 90);
		JButton btn2 = new JButton("결제");
		btn2.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		btn2.setBackground(new Color(0,0,0,0)); 
		btn2.setBounds(270, 90, 145, 90);
		JButton btn3 = new JButton("yes");
		btn3.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 50));
		btn3.setBounds(30, 270, 405, 90);
		JButton btn4 = new JButton("< 이전");
		btn4.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		btn4.setBounds(30, 800, 100, 90);
		btn4.setForeground(Color.pink);
		btn4.setBackground(Color.white);
		JButton btn5 = new JButton("다음단계(결제하기)");
		btn5.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		btn5.setBounds(165, 800, 350, 90);
		btn5.setForeground(Color.white);
		btn5.setBackground(Color.pink);
		
	
		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
		panel1.add(btn4);
		panel1.add(btn5);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn3.setBackground(Color.pink);
				card.show(f.getContentPane(), "2");
			}
		});
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				card.show(f.getContentPane(), "4");
			}
		});
		
		
		// panel2 부분
		JTextField tf = new JTextField(30);
		tf.setLocation(100,700);
		tf.setSize(330, 50);
		panel2.add(tf);
		JLabel panel2label1 = new JLabel("회원번호 입력해주세요");
		panel2label1.setBounds(30, 50, 300, 100);
		panel2label1.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		panel2.add(panel2label1);
		
		JButton panel2btn0 = new JButton("0");
		JButton panel2btn1 = new JButton("1");
		JButton panel2btn2 = new JButton("2");
		JButton panel2btn3 = new JButton("3");
		JButton panel2btn4 = new JButton("4");
		JButton panel2btn5 = new JButton("5");
		JButton panel2btn6 = new JButton("6");
		JButton panel2btn7 = new JButton("7");
		JButton panel2btn8 = new JButton("8");
		JButton panel2btn9 = new JButton("9");
		JButton panel2btn10 = new JButton("전체 지우기");
		JButton panel2btn11 = new JButton("<");
		
		panel2btn0.setBounds(200, 500, 100, 90);
		panel2btn1.setBounds(80, 200, 100, 90);
		panel2btn2.setBounds(200, 200, 100, 90);
		panel2btn3.setBounds(320, 200, 100, 90);
		panel2btn4.setBounds(80, 300, 100, 90);
		panel2btn5.setBounds(200, 300, 100, 90);
		panel2btn6.setBounds(320, 300, 100, 90);
		panel2btn7.setBounds(80, 400, 100, 90);
		panel2btn8.setBounds(200, 400, 100, 90);
		panel2btn9.setBounds(320, 400, 100, 90);
		panel2btn10.setBounds(80, 500, 100, 90);
		panel2btn11.setBounds(320, 500, 100, 90);
		
		panel2btn0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "0");
			}
		});
		
		panel2btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "1");
			}
		});
		
		panel2btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "2");
			}
		});
		panel2btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "3");
			}
		});
		panel2btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "4");
			}
		});
		panel2btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "5");
			}
		});
		panel2btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "6");
			}
		});
		
		panel2btn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "7");
			}
		});
		panel2btn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "8");
			}
		});
		
		panel2btn9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText()+ "9");
			}
		});
		
		
		panel2btn10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText("");
			}
		});
		
		panel2btn11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 tf.setText(tf.getText().substring(0, tf.getText().length()-1));
			}
		});
		
		JButton panel2btn12 = new JButton("이전");
		panel2btn12.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel2btn12.setBounds(30, 800, 100, 90);
		panel2btn12.setForeground(Color.pink);
		panel2btn12.setBackground(Color.white);
		panel2btn12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				card.show(f.getContentPane(), "1");
				btn3.setBackground(Color.white);
			}
		});
		
		
		
		JButton panel2btn13 = new JButton("입력 완료");
		panel2btn13.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel2btn13.setBounds(155, 800, 350, 90);
		panel2btn13.setForeground(Color.white);
		panel2btn13.setBackground(Color.pink);
		add(panel2btn7);
		panel2btn13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(f.getContentPane(), "3");
			}
		});
		
		
		panel2.add(panel2btn0);
		panel2.add(panel2btn1);
		panel2.add(panel2btn2);
		panel2.add(panel2btn3);
		panel2.add(panel2btn4);
		panel2.add(panel2btn5);
		panel2.add(panel2btn6);
		panel2.add(panel2btn7);
		panel2.add(panel2btn8);
		panel2.add(panel2btn9);
		panel2.add(panel2btn10);
		panel2.add(panel2btn11);
		panel2.add(panel2btn12);
		panel2.add(panel2btn13);
		
		//panel3 부분
		JLabel panel3label1 = new JLabel("인증되었습니다");
		JLabel panel3label2 = new JLabel("현재 적립금");
		
		panel3label1.setBounds(180, 140, 300, 100);
		panel3label2.setBounds(180, 400, 300, 100);
		JTextField tf1 = new JTextField(30);
		tf1.setLocation(100,500);
		tf1.setSize(330, 50);
		JButton panel3btn1 = new JButton("확인");
		panel3btn1.setBounds(155, 800, 350, 90);
		panel3btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(f.getContentPane(), "1");
			}
		});
		panel3.add(panel3btn1);
		panel3.add(panel3label1);
		panel3.add(panel3label2);
		panel3.add(tf1);
		
		// panel4 부분
		JLabel panel4label1 = new JLabel("결제하기");
		JLabel panel4label2 = new JLabel("최종결제금액");
		

		panel4label1.setBounds(30, 1, 300, 100);
		panel4label1.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		panel4label2.setBounds(30, 490, 300, 100);
		panel4label2.setFont(new Font("맑음고딕체", Font.BOLD, 23));
	
		panel4.add(panel4label1);
		panel4.add(panel4label2);
		
		
		JButton panel4btn1 = new JButton("회원포인트");
		JButton panel4btn2 = new JButton("신용카드");
		JButton panel4btn3 = new JButton("카카오페이");
		panel4btn1.setBounds(30, 140, 100, 90);
		panel4btn2.setBounds(200, 140, 100, 90);
		panel4btn3.setBounds(370, 140, 100, 90);
		
		panel4btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				card.show(f.getContentPane(), "5");
			}
		});
		
		panel4btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				card.show(f.getContentPane(), "5");
			}
		});
		
		panel4btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				card.show(f.getContentPane(), "5");
			}
		});
		
		
		JButton panel4btn6 = new JButton("이전");
		panel4btn6.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel4btn6.setBounds(30, 800, 100, 90);
		panel4btn6.setForeground(Color.pink);
		panel4btn6.setBackground(Color.white);
		panel4btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				card.show(f.getContentPane(), "1");
			}
		});
		
		JButton panel4btn7 = new JButton("결제취소");
		panel4btn7.setBounds(155, 800, 350, 90);
		panel4btn7.setForeground(Color.white);
		panel4btn7.setBackground(Color.pink);
		add(panel4btn7);
		panel4btn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				card.show(f.getContentPane(), "1");
			}
		});
		
		panel4.add(panel4btn1);
		panel4.add(panel4btn2);
		panel4.add(panel4btn3);
		panel4.add(panel4btn6);
		panel4.add(panel4btn7);
		
		
		
		// panel5부분
		JLabel panel5label1 = new JLabel("결제하시겠습니까???");
		panel5label1.setBounds(120, 300, 300, 100);
		
		JButton panel5btn1 = new JButton("결제확인");
		panel5btn1.setBounds(155, 800, 350, 90);
		add(panel5btn1);
		panel5btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				card.show(f.getContentPane(), "6");
			}
		});
		JButton panel5btn2 = new JButton("이전");
		panel5btn2.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel5btn2.setBounds(30, 800, 100, 90);
		panel5btn2.setForeground(Color.pink);
		panel5btn2.setBackground(Color.white);
		panel5btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				card.show(f.getContentPane(), "4");
			}
		});
		
		panel5.add(panel5label1);
		panel5.add(panel5btn1);
		panel5.add(panel5btn2);

		
		// panel16부분
		
		JLabel panel6label1 = new JLabel("결제완료되었습니다");
		panel6label1.setBounds(70, 100, 300, 100);
		JLabel panel6label2 = new JLabel("주문내역");
		panel6label2.setBounds(70, 500, 300, 100);
		panel6.add(panel6label1);
		panel6.add(panel6label2);
		
		JButton panel6btn1 = new JButton("확인");
		panel6btn1.setBounds(155, 800, 350, 90);
		add(panel6btn1);
//		panel6btn1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				card.show(f.getContentPane(), "1");
//			}
//		});
		
		panel6.add(panel6btn1);
		
		
		
		
		
		
		
		
		f.add("1", panel1);
		f.add("2", panel2);
		f.add("3", panel3);
		f.add("4", panel4);
		f.add("5", panel5);
		f.add("6", panel6);
		
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 540, 960);
		f.setVisible(true);
		}

	public static void main(String[] args) {
		new PointButton();
	}

}
