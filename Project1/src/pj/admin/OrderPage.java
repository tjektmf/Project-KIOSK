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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import database.JdbcConnection;

public class OrderPage extends JFrame {
	// 기간 별 주문내역 (일간, 주간, 월간, 년간)

	private List<String> orderDataList;
	private int currentPage;
	private JTextArea orderTextArea;
	private JComboBox<String> searchPeriods;
	private String selectedPeriod;

	public OrderPage() {
		super("BR31 Orders");

		String[] searchPeriod = { "일간", "주간", "월간", "연간" };
		searchPeriods = new JComboBox<>(searchPeriod);
		
		// 기간을 직접 검색하게 하는게 나을 것 같음.

		// private JComboBox searchPeriods = new JComboBox(searchPeriod);
		// String period = (String) searchPeriods.getSelectedItem();

		orderDataList = getOrderData();
		currentPage = 0;

		orderTextArea = new JTextArea(30, 30); // 행의수 / 열의 수 -> 추후 db들어오는 것 보고 수정이 필요함
		orderTextArea.setFont(new Font("맑은고딕", Font.BOLD, 18));
		orderTextArea.setEditable(false);

		JButton adminPageBtn = new JButton("관리자화면");
		adminPageBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminPage();	
			}
			
		});
		
		JButton searchButton = new JButton("검색");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedPeriod = (String) searchPeriods.getSelectedItem();
				showOrdersByPeriod();
			}
		});

		JButton nextPageBtn = new JButton(">>");
		nextPageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showNextPage();

			}
		});

		JButton prevPageBtn = new JButton("<<");
		prevPageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showPrevPage();

			}
		});

		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(new Color(236, 108, 165));
		panelBtn.add(prevPageBtn);
		panelBtn.add(nextPageBtn);
		panelBtn.add(adminPageBtn, BorderLayout.PAGE_END);

		JPanel mainPanel = new JPanel(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(orderTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
		mainPanel.add(scrollPane);
		mainPanel.add(panelBtn, BorderLayout.SOUTH);

		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(236, 108, 165));
		searchPanel.add(searchPeriods);
		searchPanel.add(searchButton);
		mainPanel.add(searchPanel, BorderLayout.NORTH);

		add(mainPanel);

		setSize(555, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void showNextPage() {
		int ordersPerPage = 5; // 한 페이지에 표시할 주문 수
		int startIndex = currentPage * ordersPerPage;
		int endIndex = Math.min((currentPage + 1) * ordersPerPage, orderDataList.size()); // 둘 중 작은 수

		StringBuilder pageText = new StringBuilder();
		for (int i = startIndex; i < endIndex; i++) {
			pageText.append(orderDataList.get(i)).append("\n");
		}

		orderTextArea.setText(pageText.toString());
		currentPage++;

		if (currentPage * ordersPerPage >= orderDataList.size()) {
			currentPage = 0;
		}
	}

	private void showPrevPage() {
		int ordersPerPage = 5; // 한 페이지에 표시할 주문 수

		currentPage--;

		if (currentPage < 0) {
			// 현재 페이지가 0보다 작아지면 가장 마지막 페이지로 이동
			int totalPages = (int) Math.ceil((double) orderDataList.size() / ordersPerPage);
			currentPage = totalPages - 1;
		}

		int startIndex = currentPage * ordersPerPage;
		int endIndex = Math.min((currentPage + 1) * ordersPerPage, orderDataList.size());

		StringBuilder pageText = new StringBuilder();
		for (int i = startIndex; i < endIndex; i++) {
			pageText.append(orderDataList.get(i)).append("\n");
		}

		orderTextArea.setText(pageText.toString());
	}
	
	private void showOrdersByPeriod() {
	    orderDataList = getOrderDataByPeriod(selectedPeriod);
	    currentPage = 0;
	    showNextPage();
	}

	private List<String> getOrderDataByPeriod(String period) {
		// 선택된 기간에 따라
		List<String> orderDataList = new ArrayList<>();

		try (Connection conn = JdbcConnection.getConnection()) {
			if (conn == null) {
				System.err.println("데이터베이스와의 연결을 확인하세요");
				return orderDataList;
			}

			String sql;
			switch (period) {
			case "일간":
				sql = "SELECT * FROM receipt WHERE receipt_date BETWEEN CURRENT_DATE AND CURRENT_DATE + INTERVAL '1' DAY";
				break;
			case "주간":
				sql = "SELECT * FROM receipt WHERE receipt_date >= CURRENT_DATE - INTERVAL '7' DAY";
				break;
			case "월간":
				sql = "SELECT * FROM receipt WHERE EXTRACT(MONTH FROM receipt_date) = EXTRACT(MONTH FROM CURRENT_DATE)";
				break;
			case "연간":
				sql = "SELECT * FROM receipt WHERE EXTRACT(YEAR FROM receipt_date) = EXTRACT(YEAR FROM CURRENT_DATE)";
				break;
			default:
				sql = "SELECT * FROM receipt";
				break;
			}

			try (PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet resultSet = pstmt.executeQuery()) {

				while (resultSet.next()) {
	                String orderData = "\n" + "주문 번호: " + resultSet.getInt("receipt_id") +
	                        "\n 회원 번호 : " + resultSet.getString("membership_tel") +
	                        "\n 메뉴1 : " + resultSet.getString("receipt_menu1") +
	                        "\n 메뉴2 : " + resultSet.getString("receipt_menu2") +
	                        "\n 메뉴3 : " + resultSet.getString("receipt_menu3") +
	                        "\n 메뉴4 : " + resultSet.getString("receipt_menu4") +
	                        "\n 메뉴5 : " + resultSet.getString("receipt_menu5") +
	                        "\n 메뉴6 : " + resultSet.getString("receipt_menu6") +
	                        "\n 메뉴7 : " + resultSet.getString("receipt_menu7") +
	                        "\n 메뉴8 : " + resultSet.getString("receipt_menu8") +
	                        "\n 메뉴9 : " + resultSet.getString("receipt_menu9") +
	                        "\n 총 가격 : " + resultSet.getInt("total_price") +
	                        "\n 주문 일자 : " + resultSet.getDate("receipt_date") + "\n";

	                orderDataList.add("========================");
	                orderDataList.add(orderData);
	                orderDataList.add("\n");
				}
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		
		return orderDataList;

	}

	// 초기 주문 데이터
	public List<String> getOrderData() {
		List<String> orderDataList = new ArrayList<>();

		try (Connection conn = JdbcConnection.getConnection()) {
			if (conn == null) {
				System.err.println("데이터베이스와의 연결을 확인하세요");
				return orderDataList;
			}

//			 String sql = "SELECT r.menu_name, r.menu_price, m.category5_id "
//					    + "FROM receipt r "
//					    + "JOIN menu m ON r.menu_id = m.menu_id";

			String sql = "SELECT r.receipt_id, r.receipt_menu1, r.receipt_price1, r.receipt_menu2, r.receipt_price2, r.receipt_menu3, "
					+ "r.receipt_price3, r.receipt_menu4, r.receipt_price4, r.receipt_menu5, r.receipt_price5, r.receipt_menu6, r.receipt_price6, "
					+ "r.receipt_menu7, r.receipt_price7, r.receipt_menu8, r.receipt_price8, r.receipt_menu9, r.receipt_price9, r.total_price, r.receipt_date, "
					+ "mb.membership_tel, mb.membership_point "
					+ "FROM receipt r "
					+ "INNER JOIN membership mb ON r.membership_tel = mb.membership_tel";

			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet resultSet = pstmt.executeQuery()) {

				while (resultSet.next()) {
//				        String menuName = resultSet.getString("menu_name");
//				        int menuPrice = resultSet.getInt("menu_price");
//				        String totalPrice = resultSet.getString(" total_price");

//					String orderData = "메뉴: " + menuName + ", 가격: " + menuPrice + "\n 총 가격: " + totalPrice;
					
					
				     String orderData = "주문 번호: " + resultSet.getInt("receipt_id") +
				    		  "\n 멤버십 번호: " + resultSet.getString("membership_tel") +
	                            "\n 메뉴1: " + resultSet.getString("receipt_menu1") +
	                            "\n 메뉴2: " + resultSet.getString("receipt_menu2") +
	                            "\n 메뉴3: " + resultSet.getString("receipt_menu3") +
	                            "\n 메뉴4: " + resultSet.getString("receipt_menu4") +
	                            "\n 메뉴5: " + resultSet.getString("receipt_menu5") +
	                            "\n 메뉴6: " + resultSet.getString("receipt_menu6") +
	                            "\n 메뉴7: " + resultSet.getString("receipt_menu7") +
	                            "\n 메뉴8: " + resultSet.getString("receipt_menu8") +
	                            "\n 메뉴9: " + resultSet.getString("receipt_menu9") +
	                            "\n 총 가격: " + resultSet.getInt("total_price") +
	                            "\n 주문 일자: " + resultSet.getDate("receipt_date") + "\n";
				     
					orderDataList.add(orderData);
				}
			}

		} catch (SQLException e) {
		    System.err.println("에러: " + e.getMessage());
		    e.printStackTrace();
		}

	
		return orderDataList;

	}

	public static void main(String[] args) {
		new OrderPage();
	}

}

/*
void setVerticalScrollBarPolicy(int), int getVerticalScrollBarPolicy()
수직 방향의 정책을 설정하거나 읽어온다. 

VERTICAL_SCROLLBAR_AS_NEEDED : 필요할 때만 스크롤 바가 보이도록 함
VERTICAL_SCROLLBAR_ALWAYS : 항상 스크롤바가 보이도록 함
VERTICAL_SCROLLBAR_NEVER : 스크롤바가 보이지 않게 함


void setHorizontalScrollBarPolicy(int), int getHorizontalScrollBarPolicy()
수평 방향의 정책을 설정하거나 읽어온다.

HORIZONTAL_SCROLLBAR_AS_NEEDED : 필요할 때만 스크롤 바가 보이도록 함
HORIZONTAL_SCROLLBAR_ALWAYS : 항상 스크롤바가 보이도록 함
HORIZONTAL_SCROLLBAR_NEVER : 스크롤바가 보이지 않게 함

https://blog.naver.com/sks6624/150165616213

*/
