package pj.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminPage extends JFrame {

	//  adminPassword() 에서 비밀번호 입력 후 들어오는 창
	// 예정 항목 : 매출 관리 (손님 주문내역 확인)
	
	
		
	public AdminPage() {
	    super("IceCreamShop admin");

	    JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 100));
	    
	    JLabel order = new JLabel("주문 내역"); 
	    customizeLabel(order);
	    	    
	
	    
	    row.add(order);  
	       
        main.add(row);
        
        add(main);

	    setSize(540, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.gray);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void customizeLabel(JLabel label) {
        label.setPreferredSize(new Dimension(250, 250));
        label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        label.setBackground(new Color(236, 108, 165));
        label.setOpaque(true);
    }
	
	public static void main(String[] args) {
	    new AdminPage();
	}
	
}
