package pj.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminPage extends JFrame {
	
	// 1. 기간 별 주문내역 (일간, 주간, 월간, 년간)
	// 2. 회원별 포인트 사용내역 (기간별)
	// 3. 카테고리별 랭킹
	// 4. 팀원들 이름 넣기, 만든사람들 => 크레딧느낌으로다가
	// 배라이미지를 모든 버튼에 추가

	public AdminPage() {
		// 화면구성
		 setLayout(new GridLayout(6,1));
		JPanel empty = new JPanel();
		empty.setBackground(Color.black);
		JLabel adminLabel = new JLabel();
		//adminLabel.setText("관리자페이지");
		//adminLabel.setFont(new Font("맑은 고딕",Font.BOLD,40));
		adminLabel.setIcon(new ImageIcon("img/hyemi/adminpage.png"));
		adminLabel.setBorder(BorderFactory.createEmptyBorder(-30 , 0, 0 , 0));	
		//adminLabel.setPreferredSize(new Dimension(550, 150));
		empty.add(adminLabel);
		add(empty);
		JPanel empty0 = new JPanel();
		empty0.setBackground(Color.black);
		//empty0.setPreferredSize(new Dimension(550, 100));
		add(empty0);
		
        // Button names
        String[] buttonNames = {"OrderPage", "CustomerPage", "MadeBy"};
        String[] imgPath = {"img/hyemi/orderpage.png","img/hyemi/customerpage.png","img/hyemi/madeby.png"};
//        JPanel panel1 = new JPanel();
//        panel1.setSize(150,200);
//        add(panel1);

        for (int i = 0; i < buttonNames.length; ++i) {
            try {
                BufferedImage originalImage = ImageIO.read(new File(imgPath[i]));

                Image scaledImage = originalImage.getScaledInstance(550, 150, Image.SCALE_SMOOTH);
                JButton button = new JButton(new ImageIcon(scaledImage));
                //JButton button = new JButton(new ImageIcon(originalImage));
                //button.setText(buttonNames[i]);
                button.addActionListener(new ButtonListener(buttonNames[i]));
                button.setBorderPainted(false);
                add(button);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JPanel empty1 = new JPanel();
        empty1.setBackground(Color.black);
        add(empty1);
		setSize(555, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	// 버튼눌러서 각 페이지 이동할 액션리스너
	private class ButtonListener implements ActionListener {
		private String pageName;

		public ButtonListener(String pageName) {
			this.pageName = pageName;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if("OrderPage".equals(pageName)) {
				new OrderPage();
			} else if("CustomerPage".equals(pageName)) {
				new CustomerInformation();
			} else if ("MadeBy".equals(pageName)) {
				new ProjectMadeBy3();
			}

		}

	}

	public static void main(String[] args) {
		new AdminPage();

	}

}
