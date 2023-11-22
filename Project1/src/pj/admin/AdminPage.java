package pj.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.JdbcConnection;

public class AdminPage extends JFrame {

	// adminPassword() 에서 비밀번호 입력 후 들어오는 창
	// 예정 항목 : 매출 관리 (손님 주문내역 확인)
	
	// 현재 아무것도 안나오는데, 오류가 있는건지 아니면 주문내역이 안만들어져서 안나오는건지 모르겠음.
	
	
	public static List<String> getOrderData() {
		List<String> orderDataList = new ArrayList<>();

		try (Connection conn = JdbcConnection.getConnection()) {

			String sql = "SELECT menu_name, menu_price, category5_name "
					+ "FROM menu m JOIN choice c ON m.menu_id = c.icecream_id";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet resultSet = pstmt.executeQuery()) {

				while (resultSet.next()) {
					String menuName = resultSet.getString("menu_name");
					int menuPrice = resultSet.getInt("menu_price");
					String categoryName = resultSet.getString("category5_name");

					String orderData = 
							"Menu: " + menuName + ", Price: " + menuPrice + 
							", Category: " + categoryName;
					orderDataList.add(orderData);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		   return orderDataList;

	}

	public AdminPage() {
		super("IceCreamShop admin");

		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

		JPanel row = new JPanel(new GridLayout());

		 List<String> orderDataList = getOrderData();
		 // 주문 데이터 for문 돌리면서 패널에 추가
		 for(String orderData : orderDataList) {
			 JLabel order = new JLabel(orderData);
			 customizeLabel(order);
			 row.add(order);
		 }

		main.add(row);
		add(main);

		setSize(540, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.gray);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void customizeLabel(JLabel label) {
		label.setPreferredSize(new Dimension(300, 50));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBackground(new Color(236, 108, 165));
		label.setOpaque(true);
	}

	public static void main(String[] args) {
		new AdminPage();
	}

}
