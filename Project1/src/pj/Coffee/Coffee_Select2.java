package pj.Coffee;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Coffee_Select2 extends JPanel {
	
public Coffee_Select2() {
	JLabel imageLabel = new JLabel();
	JFrame Coffee1 = new JFrame();
	JPanel mainPanel = new JPanel();
//	JButton HomeBtn = new JButton();

	imageLabel.setIcon(new ImageIcon("C:/pj/배경2.png"));

	Coffee1.setBounds(100, 100, 540, 960);
//
//	JButton HomeBtn = new JButton("초기화면");
//	JButton ReturnBtn = new JButton("카테고리");
	JButton AddShotN = new JButton("추가안함");
	JButton AddShotY = new JButton("샷추가");
	JButton SyrupN = new JButton("추가안함");
	JButton SyrupY = new JButton("시럽추가");
	JButton CupForBurial = new JButton("매장용컵");
	JButton DisposableCup = new JButton("일회용컵");
	JButton ReusableCup = new JButton("리유저블컵");
	JButton PersonalCup = new JButton("개인용컵");
	JButton PrevBtn = new JButton("이전");
	JButton OptionsBtn = new JButton("상품옵션선택");

	// 버튼들 위치 정하는 작업
//	HomeBtn.setBounds(10, 20, 50, 50);
//	ReturnBtn.setBounds(468, 20, 50, 50);
	AddShotN.setBounds(160, 200, 100, 90);
	AddShotY.setBounds(270, 200, 100, 90);
	SyrupN.setBounds(160, 310, 100, 90);
	SyrupY.setBounds(270, 310, 100, 90);
	CupForBurial.setBounds(160, 420, 100, 90);
	DisposableCup.setBounds(270, 420, 100, 90);
	ReusableCup.setBounds(380, 420, 100, 90);
	PersonalCup.setBounds(160, 520, 100, 90);
	PrevBtn.setBounds(20, 630, 140, 90);
	OptionsBtn.setBounds(180, 630, 330, 90);

	// 메인 페널에 버튼 추가
	mainPanel.setLayout(null);
//	mainPanel.add(HomeBtn);
//	mainPanel.add(ReturnBtn);
	mainPanel.add(AddShotN);
	mainPanel.add(AddShotY);
	mainPanel.add(SyrupN);
	mainPanel.add(SyrupY);
	mainPanel.add(CupForBurial);
	mainPanel.add(DisposableCup);
	mainPanel.add(ReusableCup);
	mainPanel.add(PersonalCup);
	mainPanel.add(PrevBtn);
	mainPanel.add(OptionsBtn);
	mainPanel.add(imageLabel);
	mainPanel.setBounds(0,0,540,960); // 메인 페널 생성
	mainPanel.setOpaque(false); // 메인 페널 투명화
	
	// 프레임에 이미지 레이블 추가 후  이미지 레이블에 메인 페널 올리기
	Coffee1.add(imageLabel);
	Coffee1.setLayout(new GridLayout());
	Coffee1.add(mainPanel);
	imageLabel.add(mainPanel);
	

	Coffee1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Coffee1.setVisible(true);
}
		
	public static void main(String[] args) {
	
	}
}