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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Database.jdbcConnection;

public class OrderPage extends JFrame {
	// adminPassword() 에서 비밀번호 입력 후 들어오는 창

	private List<String> orderDataList;
	private int currentPage; //  현재 표시 중인 페이지
	private JTextArea orderTextArea;
	
	public OrderPage() {
		super("IceCreamShop Orders");
		
		orderDataList = getOrderData();
		currentPage = 0;
		
		orderTextArea = new JTextArea(40,60); // 40 텍스트영역 행의수 / 60 텍스트영역 열의 수  -> 추후 db들어오는 것 보고 수정이 필요함
		orderTextArea.setEnabled(false);
			
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
	
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(new JScrollPane(orderTextArea), BorderLayout.CENTER);
		// 혹시 주문내역이 많아 한 페이지에 안보이면 스크롤 할 수 있게
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
		int ordersPerPage = 3; // 한 페이지에 표시할 주문 수
		int startIndex = currentPage * ordersPerPage; 
		int endIndex = Math.min((currentPage + 1) * ordersPerPage, orderDataList.size());
		// 첫 페이지 -> (0+1)*3 -> 3개의 주문을 보여준다.
		
		StringBuilder pageText = new StringBuilder();
		for(int i = startIndex; i < endIndex; i++) {
			pageText.append(orderDataList.get(i)).append("\n");
		}
		
		orderTextArea.setText(pageText.toString());
		currentPage++;
		
		if(currentPage * ordersPerPage >= orderDataList.size()) {
			currentPage = 0;
		}
	}
	
	private void showPrevPage() {
	    int ordersPerPage = 3; // 한 페이지에 표시할 주문 수
	    
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
	
	
	public List<String> getOrderData() {
		List<String> orderDataList = new ArrayList<>();

		try (Connection conn = jdbcConnection.getConnection()) {
			 if (conn == null) {
	                System.err.println("데이터베이스와의 연결을 확인하세요");
	                return orderDataList;
	            }

			 String sql = "SELECT r.menu_name, r.menu_price, m.category5_id "
					    + "FROM receipt r "
					    + "JOIN menu m ON r.menu_id = m.menu_id";


				try (PreparedStatement pstmt = conn.prepareStatement(sql);
				     ResultSet resultSet = pstmt.executeQuery()) {

				    while (resultSet.next()) {
				        String menuName = resultSet.getString("menu_name");
				        int menuPrice = resultSet.getInt("menu_price");
				        String totalPrice = resultSet.getString(" total_price");

				        String orderData = "메뉴: " + menuName + ", 가격: " + menuPrice + "\n 총 가격: " + totalPrice;

                    orderDataList.add(orderData);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
            System.err.println("Error executing SQL query: " + e.getMessage());
		}
		   return orderDataList;

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new OrderPage()); 
	}

}
