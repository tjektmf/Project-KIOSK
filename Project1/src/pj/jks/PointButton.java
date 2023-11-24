package pj.jks;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PointButton extends JFrame {

	String membership_tel;
	String membership_point= "";
	
	JTextField panel4currenttf = new JTextField(30);
	JTextField panel1tf = new JTextField(30);
	JTextField panel1tf2 = new JTextField(30);
	JTextField panel5tf = new JTextField(30);
	JTextField panel5tf2 = new JTextField(30);
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
		JPanel panel7 = new JPanel(null);

		panel1.setBackground(color.white);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.white);
		panel6.setBackground(Color.white);
		panel7.setBackground(Color.white);

		// panel 1부분
		JLabel label1 = new JLabel("결제하기");
		JLabel label2 = new JLabel("회원이신가요?");
		JLabel label3 = new JLabel("최종 결제금액");
		JLabel label4 = new JLabel("*적립하기: 결제완료 후 포인트가 자동 적립 됩니다.");
		JLabel label5 = new JLabel("*사용하기: 포인트 보유시 사용가능합니다 (자동 적립).");
		JLabel label6 = new JLabel("적립하기");
		JLabel label7 = new JLabel("사용하기");

		label1.setBounds(30, 1, 300, 100);
		label1.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		label2.setBounds(30, 190, 500, 100);
		label2.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		label3.setBounds(30, 490, 300, 100);
		label3.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		label4.setBounds(30, 380, 400, 100);
		label4.setFont(new Font("맑음고딕체", Font.BOLD, 15));
		label5.setBounds(30, 420, 420, 100);
		label5.setFont(new Font("맑음고딕체", Font.BOLD, 15));
		label6.setBounds(58, 320, 420, 100);
		label7.setBounds(190, 320, 420, 100);

		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel1.add(label7);

//	            }

		// tf 밑에 tf2 옆에
		panel1tf.setLocation(10, 610);
		panel1tf.setSize(500, 100);
		panel1tf2.setLocation(280, 520);
		panel1tf2.setSize(200, 40);
		panel1.add(panel1tf);
		panel1.add(panel1tf2);

		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.120:1521:XE", "project", "1234");
			String sql = "SELECT * FROM membership";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				panel1tf.setText("총 주문금액    " + Integer.toString(rs.getInt("membership_point"))+ "                 -                " 
						+ "사용할 적립포인트     "  + membership_point);
				panel1tf2.setText(Integer.toString(rs.getInt("membership_point")));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// 처음에는 0
		// tf 에는 주문금액 - (포인트사용금액) = 최종결제금액
		// tf2 최종결제금액

		JLabel pointLabel = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/happy.png"));

			Image scaledImage = bufferedImage.getScaledInstance(105, 60, Image.SCALE_SMOOTH);

			pointLabel.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pointLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel pointLabel2 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/happy.png"));

			Image scaledImage = bufferedImage.getScaledInstance(105, 60, Image.SCALE_SMOOTH);

			pointLabel2.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pointLabel2.setHorizontalAlignment(JLabel.CENTER);

		JButton btn1 = new JButton("회원포인트");
		btn1.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		btn1.setForeground(Color.pink);
		btn1.setBackground(new Color(0, 0, 0, 0));
		btn1.setBounds(30, 90, 145, 90);
		JButton btn2 = new JButton("결제");
		btn2.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		btn2.setBackground(new Color(0, 0, 0, 0));
		btn2.setBounds(270, 90, 145, 90);
		JButton btn3 = new JButton();
		btn3.add(pointLabel);
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setBounds(30, 270, 105, 120);
		JButton btn4 = new JButton();
		btn4.add(pointLabel2);
		btn4.setBackground(new Color(0, 0, 0, 0));
		btn4.setBounds(160, 270, 105, 120);
		JButton btn5 = new JButton("< 이전");
		btn5.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		btn5.setBounds(30, 800, 100, 90);
		btn5.setForeground(Color.pink);
		btn5.setBackground(Color.white);
		JButton btn6 = new JButton("다음단계(결제하기)");
		btn6.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		btn6.setBounds(165, 800, 350, 90);
		btn6.setForeground(Color.white);
		btn6.setBackground(Color.pink);

		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
		panel1.add(btn4);
		panel1.add(btn5);
		panel1.add(btn6);

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn3.setBackground(Color.pink);
				card.show(f.getContentPane(), "2");

			}
		});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn4.setBackground(Color.pink);
				card.show(f.getContentPane(), "2");
			}
		});

		btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				card.show(f.getContentPane(), "5");
			}
		});

		// panel2 부분

		JTextField tf = new JTextField(30);
		tf.setLocation(100, 700);
		tf.setSize(330, 50);
		panel2.add(tf);
		JLabel panel2label1 = new JLabel("회원번호 입력해주세요");
		panel2label1.setBounds(30, 50, 300, 100);
		panel2label1.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		panel2.add(panel2label1);

		JLabel numLabel1 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/1.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			numLabel1.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel1.setHorizontalAlignment(JLabel.CENTER);

		JLabel numLabel2 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/2.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			numLabel2.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel2.setHorizontalAlignment(JLabel.CENTER);

		JLabel numLabel3 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/3.png"));

			Image scaledImage = bufferedImage.getScaledInstance(80, 90, Image.SCALE_SMOOTH);

			numLabel3.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel2.setHorizontalAlignment(JLabel.CENTER);
		JLabel numLabel4 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/4.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			numLabel4.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel4.setHorizontalAlignment(JLabel.CENTER);

		JLabel numLabel5 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/5.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			numLabel5.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel5.setHorizontalAlignment(JLabel.CENTER);

		JLabel numLabel6 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/6.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			numLabel6.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel6.setHorizontalAlignment(JLabel.CENTER);
		JLabel numLabel7 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/7.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			numLabel7.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel7.setHorizontalAlignment(JLabel.CENTER);
		JLabel numLabel8 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/8.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			numLabel8.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel8.setHorizontalAlignment(JLabel.CENTER);
		JLabel numLabel9 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/9.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			numLabel9.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel9.setHorizontalAlignment(JLabel.CENTER);

		JLabel numLabel0 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/0.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			numLabel0.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		numLabel0.setHorizontalAlignment(JLabel.CENTER);

		JLabel backLabel = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/취소.png"));

			Image scaledImage = bufferedImage.getScaledInstance(60, 90, Image.SCALE_SMOOTH);

			backLabel.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		backLabel.setHorizontalAlignment(JLabel.CENTER);

		JLabel cleLabel = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/reset.jpg"));

			Image scaledImage = bufferedImage.getScaledInstance(60, 90, Image.SCALE_SMOOTH);

			cleLabel.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cleLabel.setHorizontalAlignment(JLabel.CENTER);

		JButton panel2btn0 = new JButton();
		JButton panel2btn1 = new JButton();
		JButton panel2btn2 = new JButton();
		JButton panel2btn3 = new JButton();
		JButton panel2btn4 = new JButton();
		JButton panel2btn5 = new JButton();
		JButton panel2btn6 = new JButton();
		JButton panel2btn7 = new JButton();
		JButton panel2btn8 = new JButton();
		JButton panel2btn9 = new JButton();
		JButton panel2btn10 = new JButton();
		JButton panel2btn11 = new JButton();

		panel2btn1.add(numLabel1);
		panel2btn2.add(numLabel2);
		panel2btn3.add(numLabel3);
		panel2btn4.add(numLabel4);
		panel2btn5.add(numLabel5);
		panel2btn6.add(numLabel6);
		panel2btn7.add(numLabel7);
		panel2btn8.add(numLabel8);
		panel2btn9.add(numLabel9);
		panel2btn0.add(numLabel0);
		panel2btn10.add(cleLabel);
		panel2btn11.add(backLabel);

		panel2btn0.setBounds(200, 500, 100, 90);
		panel2btn0.setBackground(new Color(255, 255, 255));
		panel2btn1.setBounds(80, 200, 100, 90);
		panel2btn1.setBackground(new Color(255, 255, 255));
		panel2btn2.setBounds(200, 200, 100, 90);
		panel2btn2.setBackground(new Color(255, 255, 255));
		panel2btn3.setBounds(320, 200, 100, 90);
		panel2btn3.setBackground(new Color(255, 255, 255));
		panel2btn4.setBounds(80, 300, 100, 90);
		panel2btn4.setBackground(new Color(255, 255, 255));
		panel2btn5.setBounds(200, 300, 100, 90);
		panel2btn5.setBackground(new Color(255, 255, 255));
		panel2btn6.setBounds(320, 300, 100, 90);
		panel2btn6.setBackground(new Color(255, 255, 255));
		panel2btn7.setBounds(80, 400, 100, 90);
		panel2btn7.setBackground(new Color(255, 255, 255));
		panel2btn8.setBounds(200, 400, 100, 90);
		panel2btn8.setBackground(new Color(255, 255, 255));
		panel2btn9.setBounds(320, 400, 100, 90);
		panel2btn9.setBackground(new Color(255, 255, 255));
		panel2btn10.setBounds(80, 500, 100, 90);
		panel2btn10.setBackground(new Color(255, 255, 255));
		panel2btn11.setBounds(320, 500, 100, 90);
		panel2btn11.setBackground(new Color(255, 255, 255));

		panel2btn0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "0");
			}
		});

		panel2btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "1");
			}
		});

		panel2btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "2");
			}
		});
		panel2btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "3");
			}
		});
		panel2btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "4");
			}
		});
		panel2btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "5");
			}
		});
		panel2btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "6");
			}
		});

		panel2btn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "7");
			}
		});
		panel2btn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "8");
			}
		});

		panel2btn9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText(tf.getText() + "9");
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
				tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
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
				tf.setText("");

				btn3.setBackground(Color.white);
				btn4.setBackground(Color.white);
			}
		});

		JButton panel2btn13 = new JButton("입력 완료");
		panel2btn13.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel2btn13.setBounds(155, 800, 350, 90);
		panel2btn13.setForeground(Color.white);
		panel2btn13.setBackground(Color.pink);
		panel2btn13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!tf.getText().equals("")) {
					membership_tel = tf.getText().substring(1, tf.getText().length());

				}
				System.out.println("입력완료버튼 : " + membership_tel);
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				try {
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.120:1521:XE", "project",
							"1234");
					String sql = "SELECT * FROM membership";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();

					while (rs.next()) {
						if (rs.getString("membership_tel").equals(membership_tel)) {
							card.show(f.getContentPane(), "4");
//							System.out.println("ㅇ : " + rs.getString("membership_tel"));
							panel4currenttf.setText(Integer.toString(rs.getInt("membership_point")));
							break;
						} else {
							card.show(f.getContentPane(), "3");
						}
//						panel4currenttf.setText("ddddddd22d");
//						System.out.println("널널" + membership_tel);
//						if (rs.getString("membership_tel").equals(membership_tel)) {
//							System.out.println("ddd");
////							if(membership_point> Integer.toString(rs.getInt("membership_point"))) {
////								System.out.println("사용하고자하는 포인트가 현재 적립금보다 많습니다");
////							}
//							break;
//						}
//						System.out.printf(" %s \n", rs.getString("membership_tel"));
					}
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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

		// panel3 부분
		JLabel panel3label1 = new JLabel("유효하지 않습니다 다시 눌러주세요!");
		panel3label1.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 20));
		panel3label1.setForeground(color.pink);

		panel3label1.setBounds(90, 120, 400, 200);

		JButton panel3btn1 = new JButton("확인");
		panel3btn1.setBounds(60, 700, 400, 150);
		panel3btn1.setForeground(color.white);
		panel3btn1.setBackground(color.pink);
		panel3btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				card.show(f.getContentPane(), "2");
			}
		});
		panel3.add(panel3btn1);
		panel3.add(panel3label1);

		// panel4 부분
		JLabel p4numLabel1 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/1.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			p4numLabel1.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel1.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4numLabel2 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/2.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			p4numLabel2.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel2.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4numLabel3 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/3.png"));

			Image scaledImage = bufferedImage.getScaledInstance(80, 90, Image.SCALE_SMOOTH);

			p4numLabel3.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel3.setHorizontalAlignment(JLabel.CENTER);
		JLabel p4numLabel4 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/4.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			p4numLabel4.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel4.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4numLabel5 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/5.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			p4numLabel5.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel5.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4numLabel6 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/6.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			p4numLabel6.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel6.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4numLabel7 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/7.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			p4numLabel7.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel7.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4numLabel8 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/8.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			p4numLabel8.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel8.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4numLabel9 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/9.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			p4numLabel9.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel9.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4numLabel0 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/0.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			p4numLabel0.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4numLabel0.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4backLabel = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/취소.png"));

			Image scaledImage = bufferedImage.getScaledInstance(60, 90, Image.SCALE_SMOOTH);

			p4backLabel.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4backLabel.setHorizontalAlignment(JLabel.CENTER);

		JLabel p4cleLabel = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/reset.jpg"));

			Image scaledImage = bufferedImage.getScaledInstance(60, 90, Image.SCALE_SMOOTH);

			p4cleLabel.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p4cleLabel.setHorizontalAlignment(JLabel.CENTER);

		JTextField panel4pointtf = new JTextField(30);

		panel4pointtf.setLocation(80, 600);
		panel4pointtf.setSize(330, 50);
		panel4currenttf.setLocation(120, 700);
		panel4currenttf.setSize(330, 50);
		panel4.add(panel4pointtf);
		panel4.add(panel4currenttf);

		JLabel panel4label1 = new JLabel("적립포인트");
		JLabel panel4label2 = new JLabel("포인트를 사용하시려면 확인버튼을 눌러주세요");
		JLabel panel4label3 = new JLabel("현재 적립금");

		panel4label1.setBounds(200, 20, 300, 100);
		panel4label1.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel4label2.setBounds(80, 130, 400, 100);
		panel4label2.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 14));
		panel4label3.setBounds(30, 680, 300, 100);
		panel4label3.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 15));

		panel4.add(panel4label1);
		panel4.add(panel4label2);
		panel4.add(panel4label3);

		JButton panel4btn0 = new JButton();
		JButton panel4btn1 = new JButton();
		JButton panel4btn2 = new JButton();
		JButton panel4btn3 = new JButton();
		JButton panel4btn4 = new JButton();
		JButton panel4btn5 = new JButton();
		JButton panel4btn6 = new JButton();
		JButton panel4btn7 = new JButton();
		JButton panel4btn8 = new JButton();
		JButton panel4btn9 = new JButton();
		JButton panel4btn10 = new JButton();
		JButton panel4btn11 = new JButton();

		panel4btn1.add(p4numLabel1);
		panel4btn2.add(p4numLabel2);
		panel4btn3.add(p4numLabel3);
		panel4btn4.add(p4numLabel4);
		panel4btn5.add(p4numLabel5);
		panel4btn6.add(p4numLabel6);
		panel4btn7.add(p4numLabel7);
		panel4btn8.add(p4numLabel8);
		panel4btn9.add(p4numLabel9);
		panel4btn0.add(p4numLabel0);
		panel4btn10.add(p4cleLabel);
		panel4btn11.add(p4backLabel);

		panel4btn0.setBounds(200, 500, 100, 90);
		panel4btn0.setBackground(new Color(255, 255, 255));
		panel4btn1.setBounds(80, 200, 100, 90);
		panel4btn1.setBackground(new Color(255, 255, 255));
		panel4btn2.setBounds(200, 200, 100, 90);
		panel4btn2.setBackground(new Color(255, 255, 255));
		panel4btn3.setBounds(320, 200, 100, 90);
		panel4btn3.setBackground(new Color(255, 255, 255));
		panel4btn4.setBounds(80, 300, 100, 90);
		panel4btn4.setBackground(new Color(255, 255, 255));
		panel4btn5.setBounds(200, 300, 100, 90);
		panel4btn5.setBackground(new Color(255, 255, 255));
		panel4btn6.setBounds(320, 300, 100, 90);
		panel4btn6.setBackground(new Color(255, 255, 255));
		panel4btn7.setBounds(80, 400, 100, 90);
		panel4btn7.setBackground(new Color(255, 255, 255));
		panel4btn8.setBounds(200, 400, 100, 90);
		panel4btn8.setBackground(new Color(255, 255, 255));
		panel4btn9.setBounds(320, 400, 100, 90);
		panel4btn9.setBackground(new Color(255, 255, 255));
		panel4btn10.setBounds(80, 500, 100, 90);
		panel4btn10.setBackground(new Color(255, 255, 255));
		panel4btn11.setBounds(320, 500, 100, 90);
		panel4btn11.setBackground(new Color(255, 255, 255));

		panel4btn0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "0");
			}
		});

		panel4btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "1");
			}
		});

		panel4btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "2");
			}
		});
		panel4btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "3");
			}
		});
		panel4btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "4");
			}
		});
		panel4btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "5");
			}
		});
		panel4btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "6");
			}
		});

		panel4btn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "7");
			}
		});
		panel4btn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "8");
			}
		});

		panel4btn9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText() + "9");
			}
		});

		panel4btn10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText("");
			}
		});

		panel4btn11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4pointtf.setText(panel4pointtf.getText().substring(0, panel4pointtf.getText().length() - 1));
			}
		});

		JButton panel4btn12 = new JButton("취소");
		panel4btn12.setBounds(30, 800, 100, 90);
		panel4btn12.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel4btn12.setForeground(Color.pink);
		panel4btn12.setBackground(Color.white);
		panel4btn12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText("");
				card.show(f.getContentPane(), "1");
				btn4.setBackground(Color.white);
			}
		});

		JButton panel4btn13 = new JButton("확인");
		panel4btn13.setBounds(155, 800, 350, 90);
		panel4btn13.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel4btn13.setForeground(Color.white);
		panel4btn13.setBackground(Color.pink);
		panel4btn13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				membership_point = panel4pointtf.getText();
//				if (!panel4pointtf.getText().equals("")) {
//					membership_point =panel4pointtf.setText();;

//				}
				
				try {
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.120:1521:XE", "project", "1234");
					String sql = "SELECT * FROM membership";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
//						 int currentMembershipPoint = rs.getInt("membership_point");
//						 int userMembershipPoint = Integer.parseInt(membership_point);
//						if(userMembershipPoint > currentMembershipPoint) {
//						System.out.println("사용하고자하는 포인트가 현재 적립금보다 많습니다");
//						break;
//						}
						panel1tf.setText("총 주문금액    " + Integer.toString(rs.getInt("membership_point"))+ "                 -                " 
								+ "사용할 적립포인트     "  + membership_point);
						panel5tf.setText("총 주문금액    " + Integer.toString(rs.getInt("membership_point"))+ "                 -                " 
								+ "사용할 적립포인트     "  + membership_point);
//						panel1tf2.setText(Integer.toString(rs.getInt("membership_point"))- Integer.parseInt(membership_point));
						
					}
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				

				card.show(f.getContentPane(), "1");
			}
		});

		panel4.add(panel4btn0);
		panel4.add(panel4btn1);
		panel4.add(panel4btn2);
		panel4.add(panel4btn3);
		panel4.add(panel4btn4);
		panel4.add(panel4btn5);
		panel4.add(panel4btn6);
		panel4.add(panel4btn7);
		panel4.add(panel4btn8);
		panel4.add(panel4btn9);
		panel4.add(panel4btn10);
		panel4.add(panel4btn11);
		panel4.add(panel4btn12);
		panel4.add(panel4btn13);
		panel4.add(panel4btn12);
		panel4.add(panel4btn13);

		// panel5 부분
		JLabel panel5label1 = new JLabel("결제하기");
		JLabel panel5label2 = new JLabel("최종결제금액");
		panel5label1.setBounds(30, 1, 300, 100);
		panel5label1.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		panel5label2.setBounds(30, 490, 300, 100);
		panel5label2.setFont(new Font("맑음고딕체", Font.BOLD, 23));
		panel5.add(panel5label1);
		panel5.add(panel5label2);

	

		panel5tf.setLocation(10, 610);
		panel5tf.setSize(500, 100);

		panel5tf2.setLocation(280, 520);
		panel5tf2.setSize(200, 40);

		panel5.add(panel5tf);
		panel5.add(panel5tf2);

		JButton panel5btn1 = new JButton("회원포인트");
		panel5btn1.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel5btn1.setBackground(new Color(0, 0, 0, 0));
		panel5btn1.setBounds(30, 90, 145, 90);
		JButton panel5btn2 = new JButton("결제");
		panel5btn2.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel5btn2.setForeground(Color.pink);
		panel5btn2.setBackground(new Color(0, 0, 0, 0));
		panel5btn2.setBounds(270, 90, 145, 90);

		JLabel cashLabel = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/카드결제.png"));

			Image scaledImage = bufferedImage.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

			cashLabel.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cashLabel.setHorizontalAlignment(JLabel.CENTER);

		JLabel cashLabel2 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/naverpay.png"));

			Image scaledImage = bufferedImage.getScaledInstance(110, 66, Image.SCALE_SMOOTH);

			cashLabel2.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cashLabel2.setHorizontalAlignment(JLabel.CENTER);

		JLabel cashLabel3 = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/jks/카카오페이.png"));

			Image scaledImage = bufferedImage.getScaledInstance(110, 90, Image.SCALE_SMOOTH);

			cashLabel3.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cashLabel3.setHorizontalAlignment(JLabel.CENTER);

		JButton panel5btn3 = new JButton();
		JButton panel5btn4 = new JButton();
		JButton panel5btn5 = new JButton();

		panel5btn3.setBounds(30, 240, 100, 90);
		panel5btn4.setBounds(200, 240, 100, 90);
		panel5btn5.setBounds(370, 240, 100, 90);

		panel5btn3.add(cashLabel);
		panel5btn3.setBackground(new Color(255, 255, 255));
		panel5btn4.add(cashLabel2);
		panel5btn4.setBackground(new Color(255, 255, 255));
		panel5btn5.add(cashLabel3);
		panel5btn5.setBackground(new Color(255, 255, 255));

		panel5btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				card.show(f.getContentPane(), "6");
			}
		});

		panel5btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				card.show(f.getContentPane(), "6");
			}
		});

		panel5btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				card.show(f.getContentPane(), "6");
			}
		});

		JButton panel5btn6 = new JButton("이전");
		panel5btn6.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel5btn6.setBounds(30, 800, 100, 90);
		panel5btn6.setForeground(Color.pink);
		panel5btn6.setBackground(Color.white);
		panel5btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				card.show(f.getContentPane(), "1");
			}
		});

		JButton panel5btn7 = new JButton("결제취소");
		panel5btn7.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel5btn7.setBounds(155, 800, 350, 90);
		panel5btn7.setForeground(Color.white);
		panel5btn7.setBackground(Color.pink);
		add(panel5btn7);
		panel5btn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				card.show(f.getContentPane(), "1");
			}
		});

		panel5.add(panel5btn1);
		panel5.add(panel5btn2);
		panel5.add(panel5btn3);
		panel5.add(panel5btn4);
		panel5.add(panel5btn5);
		panel5.add(panel5btn6);
		panel5.add(panel5btn7);

		// panel6부분
		JLabel panel6label1 = new JLabel("결제대기중");
		panel6label1.setBounds(180, 20, 300, 100);
		panel6label1.setForeground(color.pink);
		panel6label1.setFont(new Font("맑음고딕체", Font.BOLD, 23));

		JLabel panel6label2 = new JLabel("결제준비가 완료 되었다면 결제 확인버튼을 눌러주세요");
		panel6label2.setFont(new Font("맑음고딕체", Font.BOLD, 18));
		panel6label2.setBounds(30, 30, 700, 200);

		JLabel test = new JLabel();
		test.setIcon(new ImageIcon("img/jks/loading.gif"));
		test.setHorizontalAlignment(JLabel.CENTER);
		test.setBounds(30, 230, 440, 400);
		panel6.add(test);

		JButton panel6btn1 = new JButton("결제확인");
		panel6btn1.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel6btn1.setForeground(Color.white);
		panel6btn1.setBackground(Color.pink);
		panel6btn1.setBounds(155, 800, 350, 90);
		add(panel6btn1);
		panel6btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				card.show(f.getContentPane(), "7");
			}
		});
		JButton panel6btn2 = new JButton("이전");
		panel6btn2.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel6btn2.setBounds(30, 800, 100, 90);
		panel6btn2.setForeground(Color.pink);
		panel6btn2.setBackground(Color.white);
		panel6btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				card.show(f.getContentPane(), "5");
			}
		});

		panel6.add(panel6label1);
		panel6.add(panel6label2);
		panel6.add(panel6btn1);
		panel6.add(panel6btn2);

		// panel17부분

		JLabel panel7label = new JLabel("결제가 완료되었습니다");
		panel7label.setForeground(color.pink);
		panel7label.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel7label.setBounds(120, 30, 300, 100);
		JLabel panel7label2 = new JLabel("결제 내역을 확인하시고 카드를 꼭 회수해주세요 ");
		panel7label2.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 15));
		panel7label2.setBounds(70, 80, 400, 100);
		JLabel panel7label3 = new JLabel("주문 번호 ");
		panel7label3.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel7label3.setBounds(180, 140, 300, 100);
		JLabel panel7label4 = new JLabel("결제내역");
		panel7label4.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel7label4.setBounds(50, 370, 300, 100);
		panel7.add(panel7label);
		panel7.add(panel7label2);
		panel7.add(panel7label3);
		panel7.add(panel7label4);

		JTextField panel7waittf = new JTextField(30);
		JTextField panel7ordertf = new JTextField(30);
		panel7waittf.setLocation(10, 440);
		panel7waittf.setSize(500, 300);
		panel7ordertf.setLocation(135, 215);
		panel7ordertf.setSize(180, 60);
		panel7.add(panel7waittf);
		panel7.add(panel7ordertf);

		// waittf에 대기번호 출력 ordertf에 주문 내역 적립금 내역 출력

		JButton panel7btn1 = new JButton("확인");
		panel7btn1.setFont(new Font("맑음고딕체", Font.CENTER_BASELINE, 18));
		panel7btn1.setBounds(155, 800, 350, 90);
		panel7btn1.setForeground(Color.white);
		panel7btn1.setBackground(Color.pink);
		add(panel7btn1);

		panel7.add(panel7btn1);
		f.add("1", panel1);
		f.add("2", panel2);
		f.add("3", panel3);
		f.add("4", panel4);
		f.add("5", panel5);
		f.add("6", panel6);
		f.add("7", panel7);

		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 540, 960);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new PointButton();
	}

}
