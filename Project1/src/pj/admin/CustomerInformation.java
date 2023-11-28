package pj.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import database.JdbcConnection;

// DB에 저장된 회원정보 불러 오기
// 회원들이 주문한 내역도 볼 수 있게 하기

public class CustomerInformation extends JFrame {

	private JTextArea textArea;
	private JButton showDataButton;

	public CustomerInformation() {
		setTitle("BR31 Infomation");
		
		textArea = new JTextArea();
		showDataButton = new JButton("조회");
		
		showDataButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showCustomerData();
				
			}
			
		});
		
		JPanel mainPanel = new JPanel();
		mainPanel.add(textArea);
		mainPanel.add(showDataButton);
		
		add(mainPanel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(555, 960);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void showCustomerData() {

		String sql = "SELECT * FROM membership mb LEFT JOIN receip r ON mb.membership_id = r.membership_id";
		// 1> * 대신에 들어갈 것 2> while()문 수정
		// 멤버십 정보 : membership_id, tel, point
		// 레시피 정보 : receipt_id, menu_name, menu_price, total_price, receipt_date

		try (Connection conn = JdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			
			while(rs.next()) {
				  String membershipInfo = "Membership : " ;

                  String receiptInfo = "Receipt : " ;

                  textArea.append(membershipInfo + "\n" + receiptInfo + "\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {

		new CustomerInformation();
	}

}
