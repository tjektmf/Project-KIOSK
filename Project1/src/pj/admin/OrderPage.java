package pj.admin;

import java.awt.BorderLayout;
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
import javax.swing.SwingUtilities;

import database.JdbcConnection;

public class OrderPage extends JFrame {
	// 기간 별 주문내역 (일간, 주간, 월간, 년간)

	private List<String> orderDataList;
	private int currentPage; // 현재 표시 중인 페이지
	private JTextArea orderTextArea;
	private JComboBox<String> searchPeriods;
	private String selectedPeriod;

	public OrderPage() {
		super("IceCreamShop Orders");

		String[] searchPeriod = { "일간", "주간", "월간", "연간" };
		searchPeriods = new JComboBox<>(searchPeriod);

		// private JComboBox searchPeriods = new JComboBox(searchPeriod);
		// String period = (String) searchPeriods.getSelectedItem();

		orderDataList = getOrderData();
		currentPage = 0;

		orderTextArea = new JTextArea(40, 60); // 40 텍스트영역 행의수 / 60 텍스트영역 열의 수 -> 추후 db들어오는 것 보고 수정이 필요함
		orderTextArea.setEnabled(false);

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

		JPanel PanelBtn = new JPanel();
		PanelBtn.add(prevPageBtn);
		PanelBtn.add(nextPageBtn);
		PanelBtn.add(searchButton);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(new JScrollPane(orderTextArea), BorderLayout.CENTER);
		mainPanel.add(PanelBtn, BorderLayout.SOUTH);

		add(mainPanel);

		setSize(555, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

//	orderDataList에 있는 데이터를 가져와서 텍스트 영역에 업데이트
//	private void updateOrderText() {
//		StringBuilder orderText = new StringBuilder();
//		for(String order : orderDataList) {
//			orderText.append(order).append("\n");
//		}
//		orderTextArea.setText(orderText.toString());
//	}

	private void showNextPage() {
		int ordersPerPage = 5; // 한 페이지에 표시할 주문 수
		int startIndex = currentPage * ordersPerPage;
		int endIndex = Math.min((currentPage + 1) * ordersPerPage, orderDataList.size());

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
		return orderDataList;
		// 선택된 기간에 따라 데이터를 가져오는 메서드
		// 고민중
	}

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

			String sql = "SELECT r.receipt_id, r.menu_name, r.menu_price, r.total_price, r.receipt_date, "
					+ "m.menu_id, m.choice1, m.choice2, m.choice3, m.choice4, m.choice5, "
					+ "mb.membership_tel, mb.membership_point " + "FROM receipt r "
					+ "JOIN menu m ON r.menu_id = m.menu_id "
					+ "LEFT JOIN membership mb ON r.membership_id = mb.membership_id";

			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet resultSet = pstmt.executeQuery()) {

				while (resultSet.next()) {
//				        String menuName = resultSet.getString("menu_name");
//				        int menuPrice = resultSet.getInt("menu_price");
//				        String totalPrice = resultSet.getString(" total_price");

					String orderData = "메뉴: "; // + menuName + ", 가격: " + menuPrice + "\n 총 가격: " + totalPrice;

					orderDataList.add(orderData);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error : " + e.getMessage());
		}
		return orderDataList;

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new OrderPage());
	}

}
