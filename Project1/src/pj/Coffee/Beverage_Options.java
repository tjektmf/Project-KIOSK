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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pj.choice.ChoiceFrameBuyList;
import pj.choice.ChoiceFrameSelect4;
import pj.choice.ChoiceSelectAll;
import pj.choice.ChoiceSelectBeverage;

public class Beverage_Options extends JPanel {

	ChoiceFrameBuyList choiceFrameBuyList;
	ChoiceSelectAll choiceSelectAll;
	ChoiceFrameSelect4 mainFrame = new ChoiceFrameSelect4(choiceSelectAll);
	ChoiceSelectBeverage choiceSelectBeverage = new ChoiceSelectBeverage(mainFrame);

	private static final Beverage_Options instance = new Beverage_Options();

	public static Beverage_Options getInstance() {
		return instance;
	}

	public void showFrame(boolean check) {
		Beverage.setVisible(check);
	}

	private BufferedImage[] images;
	boolean BEVERAGE_CUP = false;

	public String BEVERAGE_CUP() {
		if (BEVERAGE_CUP) {
			return "일회용컵";
		} else {
			return "매장용컵";
		}
	}

	JLabel imageLabel = new JLabel();

	public void loadImages(int index) {

		BufferedImage[] images = new BufferedImage[18]; // 이미지 개수에 맞게 배열 크기 조절

		// 이미지 파일 경로
		String[] imagePaths = { "img/hodong/음료1.png", "img/hodong/음료2.png", "img/hodong/음료3.png", "img/hodong/음료4.png",
				"img/hodong/음료5.png", "img/hodong/음료6.png", "img/hodong/음료7.png", "img/hodong/음료8.png",
				"img/hodong/음료9.png", "img/hodong/음료10.png", "img/hodong/음료11.png", "img/hodong/음료12.png",
				"img/hodong/음료13.png", "img/hodong/음료14.png", "img/hodong/음료15.png", "img/hodong/음료16.png",
				"img/hodong/음료17.png", "img/hodong/음료18.png" };
		// 이미지를 배열에 로드
		for (int i = 0; i < images.length; i++) {
			try {
				images[i] = ImageIO.read(new File(imagePaths[i]));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		imageLabel.setIcon(new ImageIcon(images[index]));
	}

	JFrame Beverage = new JFrame();

	private Beverage_Options() {

		choiceFrameBuyList = ChoiceFrameBuyList.getInstance();
		CardLayout cardLayout = new CardLayout();

		JPanel mainPanel = new JPanel();
		Beverage.setBounds(100, 100, 555, 960);
		loadImages(0);
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
		JButton OptionsBtn = new JButton(new ImageIcon("img/hodong/장바구니.png"));
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
		mainPanel.setBounds(0, 0, 555, 960); // 메인 페널 생성
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
				BEVERAGE_CUP = false;
				Beverage.setVisible(false);

			}
		});
		OptionsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CupForBurial.setIcon(new ImageIcon("img/hodong/B매장용컵P.png"));
				DisposableCup.setIcon(new ImageIcon("img/hodong/B일회용컵G.png"));
				Beverage.setVisible(false);
				for (int i = 0; i < 9; i++) {

					if (choiceFrameBuyList.SAVED_BUYLIST2(i).getText() == "") {
						choiceFrameBuyList.SAVED_BUYLIST2(i).setText(BEVERAGE_CUP());
						BEVERAGE_CUP = false;
						break;
					}
				}
			}
		});

		DisposableCup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DisposableCup.setIcon(new ImageIcon("img/hodong/B일회용컵P.png"));
				CupForBurial.setIcon(new ImageIcon("img/hodong/B매장용컵G.png"));
				BEVERAGE_CUP = true;

				System.out.println("포장 : " + BEVERAGE_CUP);
			}
		});

		CupForBurial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CupForBurial.setIcon(new ImageIcon("img/hodong/B매장용컵P.png"));
				DisposableCup.setIcon(new ImageIcon("img/hodong/B일회용컵G.png"));
				BEVERAGE_CUP = false;
			}
		});

		Beverage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Beverage.setVisible(true);
	}

	public static void main(String[] args) {
		// new Beverage_Options();
	}
}
