package pj.admin;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class adminPage extends JFrame {

	//  adminPassword() 에서 비밀번호 입력후 들어오는 창
	// 예정 항목 : 매출 관리 (손님 주문내역 확인), 상품 관리 (등록,취소,할인,본사에주문,품절관리 등)
	// 가라페이지
	
	public adminPage() {
		super("IceCreamShop admin");
		
		JFrame f = new JFrame();
		CardLayout card = new CardLayout();
		f.setLayout(card);
		
		JPanel panel1 = new JPanel(new BorderLayout());
		JPanel panel2 = new JPanel(new GridLayout(3,3));
		JPanel panel3 = new JPanel(null);

		
		f.add("1번", panel1);
		f.add("2번", panel2);
		f.add("3번", panel3);
			
		setSize(540, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new adminPage();
	}

}
