package pj.Coffee;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Coffee_Select1_1 extends JPanel {
	
	public Coffee_Select1_1() {
		
		CardLayout cardLayout = new CardLayout();
		JFrame Coffee1 = new JFrame();
		JPanel mainPanel = new JPanel();
		
		JLabel imageLabel1 = new JLabel();
		JLabel imageLabel2 = new JLabel();
		
		imageLabel1.setIcon(new ImageIcon("C:/pj/배경.png"));
//		imageLabel2.setIcon(new ImageIcon("C:/pj/배라로고.png"));
		
		Coffee1.setBounds(100, 100, 540, 960);
		
		JButton HomeBtn = new JButton(new ImageIcon("C:/pj/배라로고.png"));
		HomeBtn.setBorderPainted(false); // 버튼 테두리 투명화 작업
		HomeBtn.setOpaque(false); // 버튼 테두리 투명화 작업
		HomeBtn.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton ReturnBtn = new JButton(new ImageIcon("C:/pj/X아이콘.png"));
		ReturnBtn.setBorderPainted(false); // 버튼 테두리 투명화 작업
		ReturnBtn.setOpaque(false); // 버튼 테두리 투명화 작업
		ReturnBtn.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
		JButton CoffeeBeansBtn = new JButton("원두선택");
		JButton IceBtn = new JButton("아이스");
		JButton HotBtn = new JButton("핫");
		JButton S_RegularBtn = new JButton("레귤러");
		JButton PrevBtn = new JButton("이전");
		JButton OptionsBtn = new JButton("상품옵션선택");
		
		// 버튼들 위치 정하는 작업
		HomeBtn.setBounds(10, 10, 50, 50);
		ReturnBtn.setBounds(468, 10, 50, 50);
		CoffeeBeansBtn.setBounds(180, 200, 100, 150);
		IceBtn.setBounds(180, 400, 100, 90);
		HotBtn.setBounds(290, 400, 100, 90);
		S_RegularBtn.setBounds(180, 530, 100, 90);
		PrevBtn.setBounds(20, 630, 140, 90);
		OptionsBtn.setBounds(180, 630, 330, 90);
		
		// 메인 페널에 버튼 추가
		mainPanel.setLayout(null);
		mainPanel.add(HomeBtn);
		mainPanel.add(ReturnBtn);
		mainPanel.add(CoffeeBeansBtn);
		mainPanel.add(IceBtn);
		mainPanel.add(HotBtn);
		mainPanel.add(S_RegularBtn);
		mainPanel.add(PrevBtn);
		mainPanel.add(OptionsBtn);
//		mainPanel.add(imageLabel1);
		
		mainPanel.setBounds(0,0,540,960); // 메인 페널 생성
		mainPanel.setOpaque(false); // 메인 페널 투명화
		
		// 프레임에 이미지 레이블 추가 후  이미지 레이블에 메인 페널 올리기
		Coffee1.add(imageLabel1);
		Coffee1.setLayout(new GridLayout());
		Coffee1.add(mainPanel);
		imageLabel1.add(mainPanel);
		OptionsBtn.setLayout(cardLayout);
		OptionsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == OptionsBtn) {
					new Coffee_Select2();
					
				}
			}
		});
		
		Coffee1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Coffee1.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Coffee_Select1_1();
	}
}
