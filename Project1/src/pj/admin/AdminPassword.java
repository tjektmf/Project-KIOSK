package pj.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import pj.main.IceCreamShopCover;

public class AdminPassword extends JFrame {

	// 1. IceCreamShopCover() 우측하단 키 누르면 -> adminPassword()
	// 2. adminPassword() 에서 비밀번호 입력(비밀번호 ~~~)
	// (맞으면 adminPage() 틀리면 IceCreamShopCover())

	private String passWord = "123456";
	
	

	public void apear() {
		this.setVisible(true);
	}

	public AdminPassword() {
		super("관리자 페이지");

		// 배경이미지
		JLabel pageLabel = new JLabel();
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("img/hyemi/image.png"));
			Image scaledImage = bufferedImage.getScaledInstance(540, 960, Image.SCALE_SMOOTH);
			pageLabel.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pageLabel.setLayout(null);

		JLabel label = new JLabel("관리자 비밀번호: ");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(40, 300, 120, 30);
		label.setBackground(new Color(0, 0, 0, 0));
		JPasswordField pw = new JPasswordField(50);
		pw.setBounds(180, 300, 200, 30);

		pw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pw.getPassword().equals(passWord)) {
					new OrderPage();
					setVisible(false);
				} else {
					new IceCreamShopCover();
					setVisible(false); // 비밀번호 틀리면 화면 넘어가면서 기존화면 꺼짐
				}

			}
		});

		pageLabel.add(label);
		pageLabel.add(pw);

		add(pageLabel);
//		add(label);
//		add(pw);

		JButton click = new JButton("로그인");
		click.setBounds(400, 300, 100, 30);
		click.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// if (passWord.equals(new String(pw.getPassword()))) {
				if (new String(pw.getPassword()).equals(passWord)) {
					new AdminPage();
					setVisible(false);
				} else {
					new IceCreamShopCover();
					setVisible(false);
				}
			}

		});

		pageLabel.add(click);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(555, 960);
		setLocationRelativeTo(null);
//		setVisible(true);

	}

	public static void main(String[] args) {
		new AdminPassword();
	}

}
