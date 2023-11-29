
package pj.admin;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ProjectMadeBy3 extends JFrame {

	private CardLayout card;
	private JComboBox<String> list;
	private String selected;
	private JPanel cardPanel;
	private Map<String, Color> nameColors = new HashMap<>();
	private JPanel calendarPanel;
	
	final private String[] developers = { "서다슬(리더)", "방혜미", "장호동", "정기상", "황예린" };
	private Color brColor = new Color(236, 108, 165);
	public ProjectMadeBy3() {
		super("Project3");

		card = new CardLayout();
		cardPanel = new JPanel(card);

		String[] lists = { " ", "프로젝트 팀원", "만든기간", "수고하셨습니다", "관리자페이지" };
		list = new JComboBox<>(lists);

		JButton searchBtn = new JButton("검색");
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected = (String) list.getSelectedItem();
				card.show(cardPanel, selected);
				 if ("관리자페이지".equals(selected)) {
	                    new AdminPage();
	                }
			}
		});

		JPanel controlPanel = new JPanel();
		controlPanel.add(list);
		controlPanel.add(searchBtn);

		// 첫페이지 빈 화면
		JPanel empty = new JPanel();
		cardPanel.add(empty);
		
		// 팀원목록
		JPanel projectTeamPanel = new JPanel(new BorderLayout());
		projectTeamPanel.setBackground(brColor);

		JLabel title = new JLabel("3팀 프로젝트 팀원");
		title.setFont(new Font("맑은고딕", Font.BOLD, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		

		JTextArea madeByPro = new JTextArea();
		madeByPro.setEditable(false);
		madeByPro.setFont(new Font("맑은고딕", Font.BOLD, 30));
		madeByPro.setBorder(BorderFactory.createEmptyBorder(120 , 100 , 0 , 0));

		Arrays.sort(developers);
		for (String developer : developers) {
			Color nameColor = new Color(236, 108, 165);
			madeByPro.append(developer + "\n");
			nameColors.put(developer, nameColor);
		}
		projectTeamPanel.add(title, BorderLayout.NORTH);
		projectTeamPanel.add(madeByPro);

		cardPanel.add(projectTeamPanel, "프로젝트 팀원");
		card.show(cardPanel, " ");

		// 기간
		JPanel periodPanel = new JPanel(new BorderLayout());
		calendarPanel = new JPanel(new GridLayout(0,7));
		periodPanel.add(calendarPanel, BorderLayout.CENTER);
		
		cardPanel.add(periodPanel, "만든기간");
		displayCalendar(2023,11);

		// 뭐 해야할지 모르겠음~
		JPanel thanks = new JPanel(new BorderLayout());
	
		ImageIcon imageIcon = new ImageIcon("img/hyemi/Simpsons.gif");
		JLabel imageLabel = new JLabel(imageIcon);
		
		JLabel thanksLabel = new JLabel("수고하셨습니다!!");
		thanksLabel.setFont(new Font("맑은고딕", Font.BOLD, 25));
		thanksLabel.setForeground(brColor);
		thanksLabel.setBorder(BorderFactory.createEmptyBorder(120 , 180 , 0 , 0));
		//createEmptyBorder 안에 들어가는 값이 각각 위, 왼쪽, 아래, 오른쪽 안쪽 여백
		thanksLabel.setOpaque(false);
		
		
		thanks.add(imageLabel, BorderLayout.CENTER);
		thanks.add(thanksLabel, BorderLayout.NORTH);

		cardPanel.add(thanks, "수고하셨습니다");

		setLayout(new BorderLayout());
		add(controlPanel, BorderLayout.NORTH);
		add(cardPanel, BorderLayout.CENTER);

		setSize(555, 960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ProjectMadeBy3();

	}

	private void displayCalendar(int year, int month) {
		calendarPanel.removeAll();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month -1, 1);
		
		int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		String[] dayOfWeek = {"일", "월", "화", "수", "목", "금", "토"};
		for(String day : dayOfWeek) {
			JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
			dayLabel.setOpaque(true);
			dayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));	
			dayLabel.setFont(new Font("맑은고딕", Font.BOLD, 20));
			calendarPanel.add(dayLabel);
		}
		
		for(int i = 1; i <firstDayOfWeek; i++) {
			calendarPanel.add(new JLabel());
		}
		
		for(int i = 1; i<= lastDayOfMonth; i++) {
			JLabel dayLabel = new JLabel(String.valueOf(i), SwingConstants.CENTER);
			dayLabel.setOpaque(true);
			dayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			if(i >=8 && i <=30) {
				dayLabel.setBackground(brColor);
			}
			calendarPanel.add(dayLabel);
		}
	}
}


/*
	// 기간
		JPanel periodPanel = new JPanel(new BorderLayout());
		
		JTextArea calendarArea = new JTextArea();
		calendarArea.setEditable(false);
		calendarArea.setFont(new Font("맑은고딕", Font.PLAIN, 16));
		calendarArea.setBorder(new LineBorder(Color.BLACK));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Calendar calendar = Calendar.getInstance();
		
		try {
			Date startDate = sdf.parse("2023.11.08");
			Date endDate = sdf.parse("2023.11.30");
			
			calendar.setTime(startDate);
			while(!calendar.getTime().after(endDate)) {
				calendarArea.append(sdf.format(calendar.getTime()) + "\n");
				calendar.add(Calendar.DATE, 1);
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		periodPanel.add(new JScrollPane(calendarArea), BorderLayout.CENTER);

		cardPanel.add(periodPanel, "만든기간");
*/
