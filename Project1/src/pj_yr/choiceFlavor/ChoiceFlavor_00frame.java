package pj_yr.choiceFlavor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChoiceFlavor_00frame extends JFrame {
    private JPanel centerPanel;
    private int currentPanel = 1;
    private ChoiceFlavor_02row2 row2Panel;


    public ChoiceFlavor_00frame() {
        setTitle("choiceFlavor Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 960);

        Color beskinColor = new Color(236, 108, 165);

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

        // 행1 옵션 / 맛선택
        JPanel row1 = new JPanel(new BorderLayout());
        JLabel label1a = new JLabel("옵션");
        label1a.setPreferredSize(new Dimension(270, 80));
        label1a.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        JLabel label1b = new JLabel("플레이버");
        label1b.setPreferredSize(new Dimension(270, 80));
        label1b.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        label1b.setForeground(beskinColor);

        row1.add(label1a, BorderLayout.WEST);
        row1.add(label1b, BorderLayout.EAST);
        jp.add(row1, BorderLayout.NORTH);

        // 행2 보더레이아웃 양쪽에 넘기기 버튼 가운데에 아이스크림
        row2Panel = new ChoiceFlavor_02row2(this);
        row2Panel.setPreferredSize(new Dimension(540, 460));
        jp.add(row2Panel, BorderLayout.CENTER);

        add(jp);

        // 행3 이전 담기
        
        JPanel row3 = new JPanel();
        row3.setPreferredSize(new Dimension(540, 80));
        JButton button3a = new JButton("이전");
        button3a.setBackground(Color.white);
        button3a.setForeground(beskinColor);
        button3a.setPreferredSize(new Dimension(100, 30));
        button3a.setFont(new Font("맑은 고딕", Font.BOLD, 15));

        JButton button3b = new JButton("담기");
        button3b.setBackground(beskinColor);
        button3b.setForeground(Color.white);
        button3b.setPreferredSize(new Dimension(350, 30));
        button3b.setFont(new Font("맑은 고딕", Font.BOLD, 15));

        row3.add(button3a);
        row3.add(button3b);
        jp.add(row3);

        // 행4 추가된 맛들 보이기
        JPanel row4 = new JPanel();
        row4.setPreferredSize(new Dimension(540, 180));
		GridLayout g1 = new GridLayout(1, 6);
		row4.setLayout(g1);
		
		for (int i = 0; i < 6; i++) {
			row4.add(new JButton("메뉴" + i));
		}

		row4.setBackground(Color.gray);
        jp.add(row4);

    }

    public int getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(int panel) {
        this.currentPanel = panel;
        row2Panel.updateCenterPanel();
    }


	public static void main(String[] args) {
		new ChoiceFlavor_00frame().setVisible(true);
	}
}
