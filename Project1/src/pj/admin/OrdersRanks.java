package pj.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import database.JdbcConnection;

public class OrdersRanks extends JFrame {
	// 주문 많이 들어온 순서대로 정렬 (카테고리별로 나누지 않고 통틀어서)
	// 그날 영업정리할때 랭킹 확인 버튼 누르면 db에 저장되어있던 당일 영수증들을 통해 내역을 확인하여 주문랭킹 갱신

	private Map<String, Integer> orderRanks;
	// 1> 랭킹확인버튼 누르기전에 현재 랭크대로 정리되어있는 페이지 보여져야하고
	// 2> 상단 패널에 있는 랭킹확인 버튼 클릭하면 해당 날짜로 업데이트해서 보여져야한다
	

	public OrdersRanks() {
		setTitle("BR31 Ranks");
		setSize(555, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		orderRanks = new HashMap<>();

		// 데이터베이스 연결
		try (Connection connection = JdbcConnection.getConnection();) {
			System.out.println("DB연결성공!");
			String sql = ""; // 주문내역에서 메뉴명으로 중복찾아서 갯수세기 (count에 저장)

			try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
				// 결과 출력
				while (rs.next()) {
					String menuName = rs.getString("menu_name");
					int quantity = rs.getInt("quantity");
					// 메뉴 당 주문된 내역 확인 할 방법이 현 디비에 있는가..?
					// 각 영수증에서 하나씩 꺼내와서 ?

					System.out.println("Menu Name: " + menuName + " Quantity: " + quantity + "Count: " + count);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	

	public static void main(String[] args) {
		new OrdersRanks();
	}
}