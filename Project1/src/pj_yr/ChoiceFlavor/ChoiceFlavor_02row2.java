package pj_yr.ChoiceFlavor;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFlavor_02row2 extends JPanel {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private ChoiceFlavor_00frame frame;
    private ChoiceFlavor_04showFlavorSelections showFlavorSelections;
    private ChoiceFlavor_03prevOrNext row3; // row3 추가
    private static List<String> selectedFlavorName = new ArrayList<>();
    public Map<Integer, String> flavorIdMap = new HashMap<>();


    public ChoiceFlavor_02row2(ChoiceFlavor_00frame frame, ChoiceFlavor_04showFlavorSelections showFlavorSelections) {
        this.frame = frame;
        this.showFlavorSelections = showFlavorSelections;
        setLayout(new BorderLayout());

        flavorIdMap.put(1, "도라에몽의 팥붕!슈붕!");
        flavorIdMap.put(2, "너는 참 달고나");
        flavorIdMap.put(3, "초코, 우리 이제 헤이즐넛");
        flavorIdMap.put(4, "나는 딸기치오");
        flavorIdMap.put(5, "엄마는 외계인");
        flavorIdMap.put(6, "아몬드 봉봉");
        flavorIdMap.put(7, "민트 초콜릿 칩");
        flavorIdMap.put(8, "뉴욕 치즈케이크");
        flavorIdMap.put(9, "핑크 베리 하츄핑");
        flavorIdMap.put(10, "레인보우 샤베트");
        flavorIdMap.put(11, "체리쥬빌레");
        flavorIdMap.put(12, "슈팅스타");
        flavorIdMap.put(13, "사랑에 빠진 딸기");
        flavorIdMap.put(14, "오레오 쿠키 앤 크림");
        flavorIdMap.put(15, "베리베리 스트로베리");
        flavorIdMap.put(16, "31요거트");
        flavorIdMap.put(17, "바람과 함께 사라지다");
        flavorIdMap.put(18, "바닐라");
        flavorIdMap.put(19, "초코나무 숲");
        flavorIdMap.put(20, "이상한 나라의 솜사탕");
        flavorIdMap.put(21, "초콜릿 무스");
        flavorIdMap.put(22, "그린티");
        flavorIdMap.put(23, "피스타치오 아몬드");
        flavorIdMap.put(24, "팝핑 스타 라이즈");
        flavorIdMap.put(25, "초콜릿");
        flavorIdMap.put(26, "자모카 아몬드 훠지");
        flavorIdMap.put(27, "알폰소 망고");
        flavorIdMap.put(28, "라이언 망고 마카롱");
        flavorIdMap.put(29, "마법사의 비밀 레시피");

        // 카드 패널 추가 
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 카드 1
        JPanel card1 = createCardPanel(1, 16);
        cardPanel.add(card1, "card1");

        // 카드 2
        JPanel card2 = createCardPanel(17, 29);
        cardPanel.add(card2, "card2");

        // << 
        JButton prevButton = new JButton("<<");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel);
            }
        });
        prevButton.setBackground(Color.white);

        add(prevButton, BorderLayout.WEST);

        // >> 
        JButton nextButton = new JButton(">>");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });
        nextButton.setBackground(Color.white);

        add(nextButton, BorderLayout.EAST);

        // 카드 패널 추가 (센터에)
        add(cardPanel, BorderLayout.CENTER);

        // row3 추가 (남쪽에)
        row3 = new ChoiceFlavor_03prevOrNext(frame, showFlavorSelections);
        add(row3, BorderLayout.SOUTH);
    }

    private JPanel createCardPanel(int startValue, int endValue) {
        JPanel cardPanel = new JPanel(new GridLayout(4, 4));
        for (int i = startValue; i <= endValue; i++) {
            JButton imageButton = new JButton();
            try {
                BufferedImage bufferedImage = ImageIO.read(new File("img_baskin/baskin_flavor/" + i + ".png"));
                Image scaledImage = bufferedImage.getScaledInstance(100, 110, Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(scaledImage);
                int flavorName = i;
                imageButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addFlavorSelection(imageIcon);
                        // 여기서 selectedFlavorName에 flavorName을 받고싶은데
                        selectedFlavorName.add(flavorIdMap.get(flavorName));
                    }
                });
                
                imageButton.setBackground(Color.white);
                imageButton.setIcon(imageIcon);
                cardPanel.add(imageButton);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cardPanel;
    }
    
    

    public void changePanel(int direction) {
        cardLayout.next(cardPanel);
    }

    private void addFlavorSelection(ImageIcon imageIcon) {
        showFlavorSelections.addFlavor(imageIcon);
    }
    
    public static List<String> getSelectedFlavorNames() {
    	return selectedFlavorName;
    }	


}

