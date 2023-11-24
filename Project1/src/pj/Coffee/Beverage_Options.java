package pj.Coffee;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Beverage_Options extends JPanel {
	 private BufferedImage[] images;

	 private static BufferedImage[] loadImages() {
	        BufferedImage[] images = new BufferedImage[18]; // 이미지 개수에 맞게 배열 크기 조절

	        // 이미지 파일 경로
	        String[] imagePaths = {
	        		"img/hodong/음료1.png",
	        		"img/hodong/음료2.png",
	        		"img/hodong/음료3.png",
	        		"img/hodong/음료4.png",
	        		"img/hodong/음료5.png",
	        		"img/hodong/음료6.png",
	        		"img/hodong/음료7.png",
	        		"img/hodong/음료8.png",
	        		"img/hodong/음료9.png",
	        		"img/hodong/음료10.png",
	        		"img/hodong/음료11.png",
	        		"img/hodong/음료12.png",
	        		"img/hodong/음료13.png",
	        		"img/hodong/음료14.png",
	        		"img/hodong/음료15.png",
	        		"img/hodong/음료16.png",
	        		"img/hodong/음료17.png",
	        		"img/hodong/음료18.png"	
	        };
	        // 이미지를 배열에 로드
	        for (int i = 0; i < images.length; i++) {
	            try {
	                images[i] = ImageIO.read(new File(imagePaths[i]));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	        return images;
	    }
	
	public Beverage_Options() {
		CardLayout cardLayout = new CardLayout();
		
		JFrame Beverage = new JFrame();
		JPanel mainPanel = new JPanel();
		JLabel imageLabel = new JLabel(new ImageIcon(loadImages()[0]));// loadImages()[] []안에 숫자가 바뀌면 배경이미지가 바뀐다 ㅎㅎ
		Beverage.setBounds(100, 100, 550, 960);

		JButton CupForBurial = new JButton(new ImageIcon("img/hodong/B매장용컵P.png"));
		CupForBurial.setBorderPainted(false); // 버튼 테두리 투명화 작업
		CupForBurial.setOpaque(false); // 버튼 테두리 투명화 작업
		CupForBurial.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton DisposableCup = new JButton(new ImageIcon("img/hodong/B일회용컵G.png"));
		DisposableCup.setBorderPainted(false); // 버튼 테두리 투명화 작업
		DisposableCup.setOpaque(false); // 버튼 테두리 투명화 작업
		DisposableCup.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton PrevBtn = new JButton(new ImageIcon("img/hodong/이전.png"));
		PrevBtn.setBorderPainted(false); // 버튼 테두리 투명화 작업
		PrevBtn.setOpaque(false); // 버튼 테두리 투명화 작업
		PrevBtn.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton OptionsBtn = new JButton(new ImageIcon("img/hodong/결제하기.png"));
		OptionsBtn.setBorderPainted(false); // 버튼 테두리 투명화 작업
		OptionsBtn.setOpaque(false); // 버튼 테두리 투명화 작업
		OptionsBtn.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업

		// 버튼들 위치 정하는 작업

		CupForBurial.setBounds(160, 300, 160, 230);
		DisposableCup.setBounds(330, 300, 160, 230);
		PrevBtn.setBounds(20, 600, 140, 90);
		OptionsBtn.setBounds(180, 600, 330, 90);

		// 메인 페널에 버튼 추가
		mainPanel.setLayout(null);
		mainPanel.add(CupForBurial);
		mainPanel.add(DisposableCup);
		mainPanel.add(PrevBtn);
		mainPanel.add(OptionsBtn);
		mainPanel.add(imageLabel);
		mainPanel.setBounds(0, 0, 540, 960); // 메인 페널 생성
		mainPanel.setOpaque(false); // 메인 페널 투명화

		// 프레임에 이미지 레이블 추가 후 이미지 레이블에 메인 페널 올리기
		Beverage.add(imageLabel);
		Beverage.setLayout(new GridLayout());
		Beverage.add(mainPanel);
		Beverage.setLocationRelativeTo(null);
		imageLabel.add(mainPanel);

		PrevBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Beverage.setVisible(false);

			}
		});

		Beverage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Beverage.setVisible(true);
	}

	public static void main(String[] args) {
		new Beverage_Options();
	}
}
