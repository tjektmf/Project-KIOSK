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
        setSize(540, 960);

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
        
        // 버튼1 : 컵
        JButton btn4a = new JButton();
        new ConeAndCup_04choicImg(btn4a,"img_yr/"+ 1 + ".png");
        btn4a.setPreferredSize(new Dimension(160, 200)); 
        row4.add(btn4a);
        btn4a.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoiceManager.setUserChoice("컵");
				System.out.println(ChoiceManager.getUserChoice());				

			}
		});

        // 버튼2 : 콘
        JButton btn4b = new JButton();
        new ConeAndCup_04choicImg(btn4b,"img_yr/"+ 2 + ".png");
        btn4b.setPreferredSize(new Dimension(160, 200)); 
        row4.add(btn4b);
        btn4b.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoiceManager.setUserChoice("콘");
				System.out.println(ChoiceManager.getUserChoice());				

			}
		});

        // 버튼3 : 와플콘
        JButton btn4c = new JButton();
        new ConeAndCup_04choicImg(btn4c,"img_yr/"+ 3 + ".png");
        btn4c.setPreferredSize(new Dimension(160, 200)); 
        row4.add(btn4c);
        btn4c.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoiceManager.setUserChoice("와플콘");
				System.out.println(ChoiceManager.getUserChoice());				
			}
		});
                

        jp.add(row4);
        

        
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
        row8.setPreferredSize(new Dimension(540, 200));
        JLabel label8 = new JLabel();
        
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File("img_yr/5.png"));
			Image scaledImage = bufferedImage.getScaledInstance(540, 200, Image.SCALE_SMOOTH);
			label8.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		label8.setPreferredSize(new Dimension(540, 200));
        row8.add(label8);

        // 앞으로 쓸곳8
        //row8.setBackground(Color.gray);
        jp.add(row8);

        add(jp);
    }

    public class ChoiceManager {
        private static String userChoice;

        public static void setUserChoice(String choice) {
            userChoice = choice;
        }

        public static String getUserChoice() {
            return userChoice;
        }
    }

    public static void main(String[] args) throws IOException {
    	new ConeAndCup_00frame().setVisible(true);
    }
}

 
