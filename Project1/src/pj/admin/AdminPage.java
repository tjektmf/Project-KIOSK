package pj.admin;

import java.awt.GridLayout;
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

public class AdminPage extends JFrame {

	public AdminPage() {
		// 화면구성
		setLayout(new GridLayout(2, 2));
		
		// 1. 기간 별 주문내역 (일간, 주간, 월간, 년간)
		// 2. 회원별 포인트 사용내역 (기간별)
		// 3. 카테고리별 랭킹
		// 4. 팀원들 이름 넣기, 만든사람들 => 크레딧느낌으로다가 두목 과 졸개 말고 임원진이었으면 
		// 배라이미지를 모든 버튼에 추가

        // Button names
        String[] buttonNames = {"OrderPage", "CustomerPage", "RanksPage", "MadeBy"};

        for (int i = 0; i < buttonNames.length; ++i) {
            try {
                BufferedImage originalImage = ImageIO.read(new File("img/hyemi/BRlogo.png"));

                // Adjust the size of the image to fit the button dimensions
                Image scaledImage = originalImage.getScaledInstance(150, 200, Image.SCALE_SMOOTH);

                JButton button = new JButton(new ImageIcon(scaledImage));
                button.setText(buttonNames[i]);
                
                button.addActionListener(new ButtonListener(buttonNames[i]));
                add(button);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

     
      
		setSize(555, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
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
			} else if("RanksPage".equals(pageName)) {
				new OrdersRanks();
			} else if ("MadeBy".equals(pageName)) {
				new ProjectMadeBy3();
			}

		}

	}

	public static void main(String[] args) {
		new AdminPage();

	}

}