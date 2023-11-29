package pj.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import pj.admin.AdminPassword;
import pj.choice.ChoiceFrame;
import pj.jks.PointButton;

public class IceCreamShopCover extends JFrame {
	// img
	String[] imagePaths = { "img/hyemi/ad0.png", "img/hyemi/ad1.png", "img/hyemi/ad2.png", "img/hyemi/ad3.png",
			"img/hyemi/ad4.png" };

	int currentImgIndex = 0;

	ChoiceFrame choiceFrame = new ChoiceFrame();
	CategoryHome categoryHome = new CategoryHome(choiceFrame);
	AdminPassword adminPassword = new AdminPassword();

	public void showFrame(boolean show) {
		setVisible(show);
	}

	public IceCreamShopCover() {
		setTitle("BR31");

		// 이미지 표시
		JLabel mainLabel = new JLabel();
		mainLabel.setIcon(null);

		// 투명한 패널 위에 글씨 표시
//		JLabel textLabel = new JLabel("화면을 클릭하세요");
//		textLabel.setFont(new Font("맑은고딕", Font.BOLD, 40));

		// 우측하단 관리자 페이지로 넘어갈 버튼
		JButton keyBtn = new JButton();
		keyBtn.setSize(70, 70);
		keyBtn.setLocation(455, 855);
		keyBtn.setBackground(new Color(0, 0, 0, 0));
		keyBtn.setBorderPainted(false);

		// Key 이미지
		ImageIcon addImage = new ImageIcon("img/hyemi/key.png");

		keyBtn.setIcon(addImage);

		keyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//		    	JLabel key = new JLabel();
//		    	key.setIcon(new ImageIcon("img/hyemi/key.png"));
//		    	new adminPassword();

				// adminPassword 클래스의 메서드를 호출하여 기존 프레임의 내용을 변경
				setVisible(false);
				updateFrameContent();
				adminPassword.apear();
			}

		});

		// 투명한 패널을 만들어 글씨를 포함시키고 위치 설정
		JPanel textPanel = new JPanel();
		textPanel.setBounds(120, 280, 400, 400);

		textPanel.setBackground(new Color(0, 0, 0, 0)); // 투명 설정
		add(textPanel);
//		textPanel.add(textLabel);

		// 전체를 감싸는 패널
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setLayout(null); // (mainPanel)의 레이아웃 null로 설정후 수동으로 위치조절
		mainLabel.setSize(540, 960);
		mainPanel.add(mainLabel);// , BorderLayout.CENTER 뺌
		mainPanel.add(keyBtn);// , BorderLayout.SOUTH 뺌

		Timer changeImg = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentImgIndex == 0) {
					currentImgIndex++;
				}
				String imagePath = imagePaths[currentImgIndex];
				updateImg(mainLabel);
				mainLabel.add(textPanel);
				mainLabel.add(keyBtn);
				currentImgIndex = (currentImgIndex + 1) % imagePaths.length;
			}
		});
		changeImg.start();

		try {
			BufferedImage image = ImageIO.read(new File(imagePaths[currentImgIndex]));
			Image scaledImage = image.getScaledInstance(555, 960, Image.SCALE_SMOOTH);
			mainLabel.setIcon(new ImageIcon(scaledImage));

		} catch (IOException e) {
			System.out.println("이미지오류");
			e.printStackTrace();
		}

		// 전체 패널에 마우스 클릭 리스너 추가
		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 화면 클릭 시 카테고리 페이지를 표시
				// ChoiceFrame choiceFrame = new ChoiceFrame();
				// new CategoryHome(choiceFrame);
				categoryHome.f.setVisible(true);

				dispose();
			}
		});

		add(mainPanel, BorderLayout.CENTER);

		// 프레임 표시 설정
		pack();
		setSize(555, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void updateImg(JLabel label) {
		try {
			BufferedImage image = ImageIO.read(new File(imagePaths[currentImgIndex]));
			Image scaledImage = image.getScaledInstance(540, 960, Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(scaledImage));

		} catch (IOException e) {
			System.out.println("이미지오류");
			e.printStackTrace();
		}
	}

	private void updateFrameContent() {
		new AdminPassword();
	}

	public static void main(String[] args) {
		new IceCreamShopCover();
		//SwingUtilities.invokeLater(() -> 이벤트 디스패치 스레드(Event Dispatch Thread, EDT)에서 코드를 실행하기 위한 유틸리티 메서드
		// IceCreamShopCover() 클래스의 인스턴스를 생성하고, 이를 EDT에서 실행하도록 스케줄링
	}
}
