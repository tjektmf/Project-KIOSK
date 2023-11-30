package pj_yr.ConeAndCup;

import javax.imageio.ImageIO;
import javax.swing.*;

import pj_yr.ChoiceFlavor.ChoiceFlavor_00frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConeAndCup_00frame extends JFrame {
    ConeAndCup_03takeOut noticeTakeOut = new ConeAndCup_03takeOut();
//    private int selectedButtonIndex = -1;
    
    public ConeAndCup_00frame() {
        setTitle("ConeAndCup Frame");
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

        // 행2 : 맛에대한 설명
        JPanel row2 = new JPanel();
        row2.setPreferredSize(new Dimension(540, 150));
        row2.setBackground(Color.gray);
        jp.add(row2);

        // 행3 : 포장 하는지 안내문구
        JPanel row3 = new JPanel();
        row3.setPreferredSize(new Dimension(540, 50));
        row3.add(noticeTakeOut.getContentPane());
        jp.add(row3);

        // 행4 : 컵~콘~와플콘 사진이 있어야
        JPanel row4 = new JPanel();
        row4.setPreferredSize(new Dimension(540, 210));
        
        // 라벨1 : 컵
        JLabel btn4a = new JLabel();
        new ConeAndCup_04choicImg(btn4a,"img_menu/img_ConeAndCup/"+ 1 + ".png");
        btn4a.setPreferredSize(new Dimension(160, 200)); 
        row4.add(btn4a);

        // 라벨2 : 콘
        JLabel btn4b = new JLabel();
        new ConeAndCup_04choicImg(btn4b,"img_menu/img_ConeAndCup/"+ 2 + ".png");
        btn4b.setPreferredSize(new Dimension(160, 200)); 
        row4.add(btn4b);

        // 라벨3 : 와플콘
        JLabel btn4c = new JLabel();
        new ConeAndCup_04choicImg(btn4c,"img_menu/img_ConeAndCup/"+ 3 + ".png");
        btn4c.setPreferredSize(new Dimension(160, 200)); 
        row4.add(btn4c);
        

        jp.add(row4);
        
        // 행5 : 버튼
        JPanel row5 = new JPanel();
        row5.setPreferredSize(new Dimension(540, 40));

        // 패널 1 : 컵 버튼
        JPanel panel5a = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
        panel5a.setBackground(beskinColor);
        panel5a.setPreferredSize(new Dimension(160, 40));

        new ConeAndCup_05counting(panel5a, 1);

        row5.add(panel5a);

        // 패널 2 : 콘 버튼
        JPanel panel5b = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
        panel5b.setBackground(beskinColor);
        panel5b.setPreferredSize(new Dimension(160, 40));

        new ConeAndCup_05counting(panel5b, 2);
        row5.add(panel5b);

        // 패널 3 : 와플 버튼
        JPanel panel5c = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
        panel5c.setBackground(beskinColor);
        panel5c.setPreferredSize(new Dimension(160, 40));

        new ConeAndCup_05counting(panel5c, 3);
        row5.add(panel5c);
           
        jp.add(row5);

        // 행6 : 빈공간
        JPanel row6 = new JPanel();
        row6.setPreferredSize(new Dimension(540, 180));
        // TODO: 여기에 필요한 컴포넌트 추가
        jp.add(row6);

        // 행7 : 이전, 담기 버튼
        JPanel row7 = new JPanel();
        row7.setPreferredSize(new Dimension(540, 80));
        JButton button7a = new JButton("확인");
        button7a.setBackground(Color.white);
        button7a.setForeground(beskinColor);
        button7a.setPreferredSize(new Dimension(100, 30));
        button7a.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        button7a.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);			
			}
		});
        
        JButton button7b = new JButton("담기");
        button7b.setBackground(beskinColor);
        button7b.setForeground(Color.white);
        button7b.setPreferredSize(new Dimension(350, 30));
        button7b.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        button7b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	            // ConeAndCup_00frame 열기
				ChoiceFlavor_00frame choiceFlavorFrame = new ChoiceFlavor_00frame();
				choiceFlavorFrame.setVisible(true);
			}
		});

        row7.add(button7a);
        row7.add(button7b);
        jp.add(row7);

        // 행8 : 뭔가,, 광고 같은게,,
        JPanel row8 = new JPanel();
        JLabel AD_one = new JLabel();
        try {
			BufferedImage image = ImageIO.read(new File("img/daseul/hotel.png"));
			Image scaledImage = image.getScaledInstance(540, 170, Image.SCALE_SMOOTH);
			AD_one.setIcon(new ImageIcon(scaledImage));

		} catch (IOException e) {
			System.out.println("이미지오류");
			e.printStackTrace();
		}
        row8.add(AD_one);
        row8.setPreferredSize(new Dimension(540, 170));
        
        // 앞으로 쓸곳8
        row8.setBackground(Color.gray);
        jp.add(row8);

        add(jp);
    }

    public static void main(String[] args) {
    	new ConeAndCup_00frame().setVisible(true);
    }
}

 