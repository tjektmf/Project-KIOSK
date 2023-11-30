package pj_yr.container;

import javax.swing.*;

import pj_yr.ChoiceFlavor.ChoiceFlavor_00frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Container_00frame extends JFrame {
    Container_03takeOut noticeTakeOut = new Container_03takeOut();
    // 이미지의 좌표
    private static final int IMAGE_X = 160;
    private static final int IMAGE_Y_START = 200;  // 시작 위치
    private static final int IMAGE_Y_OFFSET = 80;  // 간격
    
    public Container_00frame() {
        setTitle("Container Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(555, 960);
        setLocationRelativeTo(null);

        Color beskinColor = new Color(236, 108, 165);

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

        // 행1 : 옵션, 플레이버
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

        // 행2 : 여기에서 - 0 + 버튼도 구현해야함 -> 가격도 변하는, 맛에대한 설명도 나와야함 아마 쪼개야할거같음 
        JPanel row2 = new JPanel();
        row2.setPreferredSize(new Dimension(540, 150));
        row2.setBackground(Color.gray);
        jp.add(row2);

        // 행3 : 뭔가 정보가 나와야할듯,,
        JPanel row3 = new JPanel();
        row3.setPreferredSize(new Dimension(540, 50));
        row3.add(noticeTakeOut.getContentPane());
        jp.add(row3);

        // 행4 : 스푼이랑 이미지
        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        row4.setPreferredSize(new Dimension(540, 70));

        jp.add(row4);
        
        // 패널0 : 스푼
        JLabel spoon = new JLabel("스푼");
        spoon.setPreferredSize(new Dimension(50, 70));
        row4.add(spoon);
        
        // 패널 1 : 필요없음
        JLabel label4a = new JLabel();
        label4a.setPreferredSize(new Dimension(110, 70));
        new Container_04imageSpoon(label4a, "img_menu/img_Container/" + 1 + ".png");

        row4.add(label4a);

        // 패널 2 : 스푼(최대 4개)
        JLabel label4b = new JLabel();
        label4b.setPreferredSize(new Dimension(110, 70));
        new Container_04imageSpoon(label4b, "img_menu/img_Container/" + 2 + ".png");

        row4.add(label4b);

        // 패널 3 : 포장스푼추가(+50)
        JLabel label4c = new JLabel();
        label4c.setPreferredSize(new Dimension(110, 70));
        new Container_04imageSpoon(label4c, "img_menu/img_Container/" + 3 + ".png");

        row4.add(label4c);

        jp.add(row4);

        
        // 행5 
        // 스푼의 버튼 -> 3번째, 4번째만 있으면됨
        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        row5.setPreferredSize(new Dimension(540, 40));

        //스푼 밑에
        JPanel panel5i = new JPanel();
        //panel5a.setBackground(beskinColor);
        panel5i.setPreferredSize(new Dimension(110, 30));
        row5.add(panel5i);

        //패널 1
        JPanel panel5a = new JPanel();
        //panel5a.setBackground(beskinColor);
        panel5a.setPreferredSize(new Dimension(110, 30));

        //new Container_05counting(panel5a, 1);
        row5.add(panel5a);

        // 패널 2
        JPanel panel5b = new JPanel();
        //panel5b.setBackground(beskinColor);
        panel5b.setPreferredSize(new Dimension(110, 30));

        new Container_05counting(panel5b, 1);
        row5.add(panel5b);

        // 패널 3
        JPanel panel5c = new JPanel();
        //panel5c.setBackground(beskinColor);
        panel5c.setPreferredSize(new Dimension(110, 30));
        																												
        new Container_05counting(panel5c, 1);
        row5.add(panel5c);
        jp.add(row5);
        
        
        // 행6
        // 포장 이미지
        JPanel row6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        row6.setPreferredSize(new Dimension(540, 50));

        // 패널0 : 포장
        JLabel togo = new JLabel("포장");
        togo.setPreferredSize(new Dimension(50, 70));
        row6.add(togo);
        
        // 패널 1
        JLabel label6a = new JLabel();
        label6a.setPreferredSize(new Dimension(110, 70));
        new Container_04imageSpoon(label6a, "img_menu/img_Container/" + 4 + ".png");

        row6.add(label6a);

        // 패널 2
        JLabel label6b = new JLabel();
        label6b.setPreferredSize(new Dimension(110, 70));
        new Container_04imageSpoon(label6b, "img_menu/img_Container/" + 5 + ".png");

        row6.add(label6b);

        // 패널 3
        JLabel label6c = new JLabel();
        label6c.setPreferredSize(new Dimension(110, 70));
        new Container_04imageSpoon(label6c, "img_menu/img_Container/" + 6 + ".png");

        row6.add(label6c);

        jp.add(row6);

        
        // 행7 
        // 포장 버튼
        JPanel row7 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        row7.setPreferredSize(new Dimension(540, 40));

        // 포장밑에
        JPanel panel7i = new JPanel();
        //panel5a.setBackground(beskinColor);
        panel7i.setPreferredSize(new Dimension(110, 30));
        row7.add(panel7i);

        // 패널 1
        JPanel panel7a = new JPanel();
        //panel7a.setBackground(beskinColor);
        panel7a.setPreferredSize(new Dimension(110, 30));

        new Container_05counting(panel7a, 1);
        row7.add(panel7a);

        // 패널 2
        JPanel panel7b = new JPanel();
        //panel7b.setBackground(beskinColor);
        panel7b.setPreferredSize(new Dimension(110, 30));

        new Container_05counting(panel7b, 1);
        row7.add(panel7b);

        // 패널 3
        JPanel panel7c = new JPanel();
        //panel7c.setBackground(beskinColor);
        panel7c.setPreferredSize(new Dimension(110, 30));

        new Container_05counting(panel5c, 1);
        row7.add(panel7c);
        jp.add(row7);
        

        // 행8
        JPanel row8 = new JPanel();
        row8.setPreferredSize(new Dimension(540, 80));
        JButton button8a = new JButton("이전");
        button8a.setBackground(Color.white);
        button8a.setForeground(beskinColor);
        button8a.setPreferredSize(new Dimension(100, 30));
        button8a.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        button8a.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

        JButton button8b = new JButton("담기");
        button8b.setBackground(beskinColor);
        button8b.setForeground(Color.white);
        button8b.setPreferredSize(new Dimension(350, 30));
        button8b.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        button8b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				ChoiceFlavor_00frame choiceFlavorFrame = new ChoiceFlavor_00frame();
				choiceFlavorFrame.setVisible(true);
				

			}
		});

        row8.add(button8a);
        row8.add(button8b);
        jp.add(row8);

        // 행9
        JPanel row9 = new JPanel();
        row9.setPreferredSize(new Dimension(540, 170));
        // 앞으로 쓸곳8
        row9.setBackground(Color.gray);
        jp.add(row9);

        add(jp);
    }

    public static void main(String[] args) {
       new Container_00frame().setVisible(true);
    }
}