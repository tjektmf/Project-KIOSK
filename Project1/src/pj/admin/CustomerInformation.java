package pj.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import database.JdbcConnection;

// DB에 저장된 회원정보 불러 오기
// 회원들이 주문한 내역도 볼 수 있게 하기

public class CustomerInformation extends JFrame {

	private JTextArea textArea;
	private JTextField membershipNumberField;
	private JButton showDataButton;
	private JButton showAllButton;

	public CustomerInformation() {
		setTitle("BR31 Infomation");

		textArea = new JTextArea(30, 30);
		textArea.setFont(new Font("맑은고딕", Font.BOLD, 20));
		textArea.setEditable(false);

		showDataButton = new JButton("조회");

		showAllButton = new JButton("전체 회원 확인");
		membershipNumberField = new JTextField(20); // 멤버십 번호 입력 최대 20자리
		showDataButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showCustomerData();
			}

		});
		showAllButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAllCustomerData();
			}
		});
		
		JButton adminPageBtn = new JButton("관리자화면");
		adminPageBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminPage();	
			}
			
		});

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(236, 108, 165));
		mainPanel.add(new JLabel("멤버십번호 : "), BorderLayout.NORTH);
		mainPanel.add(membershipNumberField, BorderLayout.NORTH);
		mainPanel.add(showDataButton, BorderLayout.NORTH);
		mainPanel.add(textArea, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(textArea);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JPanel bottomPanel = new JPanel();
		//bottomPanel.setBackground(new Color(236, 108, 165));
		bottomPanel.add(showAllButton, BorderLayout.SOUTH);
		bottomPanel.add(adminPageBtn, BorderLayout.PAGE_END);

		add(mainPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH); 

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(555, 960);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void showAllCustomerData() {

		textArea.setText("");
		String sql = "SELECT * FROM membership";

		try (Connection conn = JdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				String memberInfo = "아이디: " + rs.getInt("membership_id") + ", 번호: " + rs.getString("membership_tel")
						+ ", 포인트: " + rs.getInt("membership_point") + "\n";

				textArea.append(memberInfo + "\n");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void showCustomerData() {
		String membershipNumber = membershipNumberField.getText();
		String sql = "SELECT r.receipt_id, r.total_price, r.receipt_date, "
				+ "mb.membership_id, mb.membership_tel, mb.membership_point "
				+ "FROM membership mb LEFT JOIN receipt r ON mb.membership_tel = r.membership_tel "
				+ "WHERE mb.membership_id = ?";

		// 1> * 대신에 들어갈 것 2> while()문 수정
		// 멤버십 정보 : membership_id, tel, point
		// 레시피 정보 : receipt_id, menu_name, menu_price, total_price, receipt_date
		// 멤버십id -> 전화번호 뒤4자리. 같은 번호가 있다면 번호 확인해서 클릭하게 하기 

		try (Connection conn = JdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, membershipNumber);

			try (ResultSet rs = pstmt.executeQuery();) {
				textArea.setText("");

				if (rs.next()) {
					String membershipInfo = "\n" + "Membership :" + "ID/번호/포인트내역\n" + rs.getInt("membership_id") + "/"
							+ rs.getString("membership_tel") + "/" + rs.getInt("membership_point");

					String receiptInfo = "\n" + "Receipt :" + "주문번호/총가격/주문날짜\n" + rs.getInt("receipt_id") + "/"
							+ rs.getInt("total_price") + "/" + rs.getDate("receipt_date");

					textArea.append(membershipInfo + "\n" + receiptInfo + "\n");
				} else {
					// 결과가 없을 때 메시지 표시
					textArea.setText("멤버십 번호 " + membershipNumber + "은(는) 존재하지 않습니다.");
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new CustomerInformation();
	}

}
