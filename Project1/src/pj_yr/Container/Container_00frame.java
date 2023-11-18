package pj_yr.Container;

import javax.swing.*;
import java.awt.*;

public class Container_00frame extends JFrame {
    Container_03takeOut noticeTakeOut = new Container_03takeOut();

    public Container_00frame() {
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
        row4.setPreferredSize(new Dimension(540, 290));

        // 패널 1
        JPanel panel4a = new JPanel();
        panel4a.setBackground(beskinColor);
        panel4a.setPreferredSize(new Dimension(160, 120));
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
        panel4b.setPreferredSize(new Dimension(160, 120));
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
        panel4c.setPreferredSize(new Dimension(160, 120));
        JButton button4c1 = new JButton("+");
        button4c1.setPreferredSize(new Dimension(20, 20));
        JButton button4c2 = new JButton("-");
        button4c2.setPreferredSize(new Dimension(20, 20));
        // TODO: 버튼 리스너 및 초기값 설정
        panel4c.add(button4c1, button4c2);
        row4.add(panel4c);

        jp.add(row4);

        
        // 다섯 번째 행
        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        row5.setPreferredSize(new Dimension(540, 290));

        // 패널 1
        JPanel panel5a = new JPanel();
        panel5a.setBackground(beskinColor);
        panel5a.setPreferredSize(new Dimension(160, 120));
        JButton button5a1 = new JButton("+");
        button5a1.setPreferredSize(new Dimension(20, 20));
        JButton button5a2 = new JButton("-");
        button5a2.setPreferredSize(new Dimension(20, 20));

        // TODO: 버튼 리스너 및 초기값 설정
        panel5a.add(button5a1, button5a2);
        panel5a.add(button5a1, button5a2);

        row5.add(panel5a);

        // 패널 2
        JPanel panel5b = new JPanel();
        panel5b.setBackground(beskinColor);
        panel5b.setPreferredSize(new Dimension(160, 120));
        JButton button5b1 = new JButton("+");
        button5b1.setPreferredSize(new Dimension(20, 20));
        JButton button5b2 = new JButton("-");
        button5b2.setPreferredSize(new Dimension(20, 20));
        // TODO: 버튼 리스너 및 초기값 설정
        panel5b.add(button5b1, button5b2);
        row5.add(panel5b);

        // 패널 3
        JPanel panel5c = new JPanel();
        panel5c.setBackground(beskinColor);
        panel5c.setPreferredSize(new Dimension(160, 120));
        JButton button5c1 = new JButton("+");
        button5c1.setPreferredSize(new Dimension(20, 20));
        JButton button5c2 = new JButton("-");
        button5c2.setPreferredSize(new Dimension(20, 20));
        // TODO: 버튼 리스너 및 초기값 설정
        panel5c.add(button5c1, button5c2);
        row5.add(panel5c);

        jp.add(row5);
        
        
        // 여섯 번째 행
        JPanel row6 = new JPanel();
        row6.setPreferredSize(new Dimension(540, 130));
        // TODO: 여기에 필요한 컴포넌트 추가
        jp.add(row6);

        // 일곱 번째 행
        JPanel row7 = new JPanel();
        row7.setPreferredSize(new Dimension(540, 80));
        JButton button7a = new JButton("이전");
        button7a.setBackground(Color.white);
        button7a.setForeground(beskinColor);
        button7a.setPreferredSize(new Dimension(100, 30));
        button7a.setFont(new Font("맑은 고딕", Font.BOLD, 15));

        JButton button7b = new JButton("담기");
        button7b.setBackground(beskinColor);
        button7b.setForeground(Color.white);
        button7b.setPreferredSize(new Dimension(350, 30));
        button7b.setFont(new Font("맑은 고딕", Font.BOLD, 15));

        row7.add(button7a);
        row7.add(button7b);
        jp.add(row7);

        // 여덟 번째 행
        JPanel row8 = new JPanel();
        row8.setPreferredSize(new Dimension(540, 170));
        // 앞으로 쓸곳8
        row8.setBackground(Color.gray);
        jp.add(row8);

        add(jp);
    }

    public static void main(String[] args) {
    	new Container_00frame().setVisible(true);
    }
}