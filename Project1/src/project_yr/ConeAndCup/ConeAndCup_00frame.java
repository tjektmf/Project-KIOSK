package project_yr.ConeAndCup;

import javax.swing.*;
import java.awt.*;

public class ConeAndCup_00frame extends JFrame {
    ConeAndCup_03takeOut noticeTakeOut = new ConeAndCup_03takeOut();

    public ConeAndCup_00frame() {
        setTitle("Custom Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 960);

        Color beskinColor = new Color(236, 108, 165);

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

        // 첫 번째 행
        JPanel row1 = new JPanel(new BorderLayout());

        JLabel label1a = new JLabel("옵션", SwingConstants.CENTER);
        label1a.setPreferredSize(new Dimension(270, 80));
        label1a.setForeground(beskinColor);
        label1a.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        JLabel label1b = new JLabel("플레이버", SwingConstants.CENTER);
        label1b.setPreferredSize(new Dimension(270, 80));
        label1b.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        row1.add(label1a, BorderLayout.WEST);
        row1.add(label1b, BorderLayout.EAST);
        jp.add(row1);

        // 두 번째 행
        JPanel row2 = new JPanel();
        row2.setPreferredSize(new Dimension(540, 150));
        row2.setBackground(Color.gray);
        jp.add(row2);

        // 세 번째 행
        JPanel row3 = new JPanel();
        row3.setPreferredSize(new Dimension(540, 50));
        row3.add(noticeTakeOut.getContentPane());
        jp.add(row3);

        // 네 번째 행
        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        row4.setPreferredSize(new Dimension(540, 280));

        // 패널 1
        JPanel panel4a = new JPanel();
        panel4a.setBackground(beskinColor);
        panel4a.setPreferredSize(new Dimension(160, 230));
        JButton button4a1 = new JButton("+");
        button4a1.setPreferredSize(new Dimension(20, 20));
        JButton button4a2 = new JButton("-");
        button4a2.setPreferredSize(new Dimension(20, 20));

        // TODO: 버튼 리스너 및 초기값 설정
        panel4a.add(button4a1, button4a2);
        panel4a.add(button4a1, button4a2);

        row4.add(panel4a);

        // 패널 2
        JPanel panel4b = new JPanel();
        panel4b.setBackground(beskinColor);
        panel4b.setPreferredSize(new Dimension(160, 230));
        JButton button4b1 = new JButton("+");
        button4b1.setPreferredSize(new Dimension(20, 20));
        JButton button4b2 = new JButton("-");
        button4b2.setPreferredSize(new Dimension(20, 20));
        // TODO: 버튼 리스너 및 초기값 설정
        panel4b.add(button4b1, button4b2);
        row4.add(panel4b);

        // 패널 3
        JPanel panel4c = new JPanel();
        panel4c.setBackground(beskinColor);
        panel4c.setPreferredSize(new Dimension(160, 230));
        JButton button4c1 = new JButton("+");
        button4c1.setPreferredSize(new Dimension(20, 20));
        JButton button4c2 = new JButton("-");
        button4c2.setPreferredSize(new Dimension(20, 20));
        // TODO: 버튼 리스너 및 초기값 설정
        panel4c.add(button4c1, button4c2);
        row4.add(panel4c);

        jp.add(row4);

        // 다섯 번째 행
        JPanel row5 = new JPanel();
        row5.setPreferredSize(new Dimension(540, 180));
        // TODO: 여기에 필요한 컴포넌트 추가
        jp.add(row5);

        // 여섯 번째 행
        JPanel row6 = new JPanel();
        row6.setPreferredSize(new Dimension(540, 80));
        JButton button6a = new JButton("이전");
        button6a.setBackground(Color.white);
        button6a.setForeground(beskinColor);
        button6a.setPreferredSize(new Dimension(100, 30));
        button6a.setFont(new Font("맑은 고딕", Font.BOLD, 15));

        JButton button6b = new JButton("담기");
        button6b.setBackground(beskinColor);
        button6b.setForeground(Color.white);
        button6b.setPreferredSize(new Dimension(350, 30));
        button6b.setFont(new Font("맑은 고딕", Font.BOLD, 15));

        row6.add(button6a);
        row6.add(button6b);
        jp.add(row6);

        // 일곱 번째 행
        JPanel row7 = new JPanel();
        row7.setPreferredSize(new Dimension(540, 170));
        // 앞으로 쓸곳
        row7.setBackground(Color.gray);
        jp.add(row7);

        add(jp);
    }

    public static void main(String[] args) {
    	new ConeAndCup_00frame().setVisible(true);
    }
}