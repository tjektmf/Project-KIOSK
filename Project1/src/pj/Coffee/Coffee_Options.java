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
import pj.choice.ChoiceFrameSelect3;
import pj.choice.ChoiceSelectAll;
import pj.choice.ChoiceSelectCoffee;

public class Coffee_Options extends JPanel {

	ChoiceFrameBuyList choiceFrameBuyList;
	ChoiceSelectAll choiceSelectAll;
	ChoiceFrameSelect3 mainFrame = new ChoiceFrameSelect3(choiceSelectAll);
	ChoiceSelectCoffee choiceSelectCoffee = new ChoiceSelectCoffee(mainFrame);

	private static final Coffee_Options instance = new Coffee_Options();

	public static Coffee_Options getInstance() {
		return instance;
	}

	public void showFrame(boolean check) {
		Coffee1.setVisible(check);
	}

	private BufferedImage[] images;
	boolean COFFEE_SHOT = false;
	boolean COFFEE_SYRUP = false;
	boolean COFFEE_CUP = false;

	public String COFFEE_SHOT() {
		if (COFFEE_SHOT) {
			return "샷추가";
		} else {
			return "샷추가안함";
		}

	}

	public String COFFEE_SYRUP() {
		if (COFFEE_SYRUP) {
			return "시럽추가";
		} else {
			return "시럽추가안함";
		}
	}

	public String COFFEE_CUP() {

		if (COFFEE_CUP) {
			return "일회용컵";
		} else {

			return "매장용컵";
		}
	}

	JLabel imageLabel = new JLabel();

	public void loadImages(int index) {
		choiceFrameBuyList = ChoiceFrameBuyList.getInstance();
		BufferedImage[] images = new BufferedImage[10]; // 이미지 개수에 맞게 배열 크기 조절

		// 이미지 파일 경로
		String[] imagePaths = { "img/hodong/배경1.png", "img/hodong/배경2.png", "img/hodong/배경3.png", "img/hodong/배경4.png",
				"img/hodong/배경5.png", "img/hodong/배경6.png", "img/hodong/배경7.png", "img/hodong/배경8.png",
				"img/hodong/배경9.png", "img/hodong/배경10.png" };
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

	JFrame Coffee1 = new JFrame();

	private Coffee_Options() {
		CardLayout cardLayout = new CardLayout();
		JPanel mainPanel = new JPanel();
		loadImages(0);

		Coffee1.setBounds(100, 100, 555, 960);

		JButton AddShotN = new JButton(new ImageIcon("img/hodong/추가안함P.png"));
		AddShotN.setBorderPainted(false); // 버튼 테두리 투명화 작업
		AddShotN.setOpaque(false); // 버튼 테두리 투명화 작업
		AddShotN.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton AddShotY = new JButton(new ImageIcon("img/hodong/샷추가G.png"));
		AddShotY.setBorderPainted(false); // 버튼 테두리 투명화 작업
		AddShotY.setOpaque(false); // 버튼 테두리 투명화 작업
		AddShotY.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton SyrupN = new JButton(new ImageIcon("img/hodong/추가안함P.png"));
		SyrupN.setBorderPainted(false); // 버튼 테두리 투명화 작업
		SyrupN.setOpaque(false); // 버튼 테두리 투명화 작업
		SyrupN.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton SyrupY = new JButton(new ImageIcon("img/hodong/시럽추가G.png"));
		SyrupY.setBorderPainted(false); // 버튼 테두리 투명화 작업
		SyrupY.setOpaque(false); // 버튼 테두리 투명화 작업
		SyrupY.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton CupForBurial = new JButton(new ImageIcon("img/hodong/매장용컵P.png"));
		CupForBurial.setBorderPainted(false); // 버튼 테두리 투명화 작업
		CupForBurial.setOpaque(false); // 버튼 테두리 투명화 작업
		CupForBurial.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton DisposableCup = new JButton(new ImageIcon("img/hodong/일회용컵G.png"));
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

		AddShotN.setBounds(160, 220, 100, 90);
		AddShotY.setBounds(270, 220, 100, 90);
		SyrupN.setBounds(160, 340, 100, 90);
		SyrupY.setBounds(270, 340, 100, 90);
		CupForBurial.setBounds(160, 450, 100, 90);
		DisposableCup.setBounds(270, 450, 100, 90);
		PrevBtn.setBounds(20, 600, 140, 90);
		OptionsBtn.setBounds(180, 600, 330, 90);

		// 메인 페널에 버튼 추가
		mainPanel.setLayout(null);
		mainPanel.add(AddShotN);
		mainPanel.add(AddShotY);
		mainPanel.add(SyrupN);
		mainPanel.add(SyrupY);
		mainPanel.add(CupForBurial);
		mainPanel.add(DisposableCup);
		mainPanel.add(PrevBtn);
		mainPanel.add(OptionsBtn);
		mainPanel.add(imageLabel);
		mainPanel.setBounds(0, 0, 555, 960); // 메인 페널 생성
		mainPanel.setOpaque(false); // 메인 페널 투명화

		// 프레임에 이미지 레이블 추가 후 이미지 레이블에 메인 페널 올리기
		Coffee1.add(imageLabel);
		Coffee1.setLayout(new GridLayout());
		Coffee1.add(mainPanel);
		Coffee1.setLocationRelativeTo(null);
		imageLabel.add(mainPanel);

		PrevBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				COFFEE_SHOT = false;
				COFFEE_SYRUP = false;
				COFFEE_CUP = false;
				Coffee1.setVisible(false);

			}
		});
		OptionsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coffee1.setVisible(false);
				AddShotN.setIcon(new ImageIcon("img/hodong/추가안함P.png"));
				AddShotY.setIcon(new ImageIcon("img/hodong/샷추가G.png"));
				SyrupN.setIcon(new ImageIcon("img/hodong/추가안함P.png"));
				SyrupY.setIcon(new ImageIcon("img/hodong/시럽추가G.png"));
				CupForBurial.setIcon(new ImageIcon("img/hodong/매장용컵P.png"));
				DisposableCup.setIcon(new ImageIcon("img/hodong/일회용컵G.png"));
				for (int i = 0; i < 9; i++) {

					if (choiceFrameBuyList.SAVED_BUYLIST2(i).getText() == "") {
						choiceFrameBuyList.SAVED_BUYLIST2(i).setText(COFFEE_SHOT());
						choiceFrameBuyList.SAVED_BUYLIST3(i).setText(COFFEE_SYRUP());
						choiceFrameBuyList.SAVED_BUYLIST4(i).setText(COFFEE_CUP());
						COFFEE_SHOT = false;
						COFFEE_SYRUP = false;
						COFFEE_CUP = false;
						break;
					}
				}

			}
		});
		AddShotN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddShotN.setIcon(new ImageIcon("img/hodong/추가안함P.png"));
				AddShotY.setIcon(new ImageIcon("img/hodong/샷추가G.png"));
				COFFEE_SHOT = false;
			}
		});
		AddShotY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddShotN.setIcon(new ImageIcon("img/hodong/추가안함G.png"));
				AddShotY.setIcon(new ImageIcon("img/hodong/샷추가P.png"));
				COFFEE_SHOT = true;
			}
		});
		SyrupN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SyrupN.setIcon(new ImageIcon("img/hodong/추가안함P.png"));
				SyrupY.setIcon(new ImageIcon("img/hodong/시럽추가G.png"));
				COFFEE_SYRUP = false;
			}
		});
		SyrupY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SyrupN.setIcon(new ImageIcon("img/hodong/추가안함G.png"));
				SyrupY.setIcon(new ImageIcon("img/hodong/시럽추가P.png"));
				COFFEE_SYRUP = true;
			}
		});
		CupForBurial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CupForBurial.setIcon(new ImageIcon("img/hodong/매장용컵P.png"));
				DisposableCup.setIcon(new ImageIcon("img/hodong/일회용컵G.png"));
				COFFEE_CUP = false;
			}
		});
		DisposableCup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CupForBurial.setIcon(new ImageIcon("img/hodong/매장용컵G.png"));
				DisposableCup.setIcon(new ImageIcon("img/hodong/일회용컵P.png"));
				COFFEE_CUP = true;
			}
		});

		Coffee1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Coffee1.setVisible(true);
	}

	public static void main(String[] args) {
		// new Coffee_Options();
	}
}