
package pj_yr.ChoiceFlavor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ChoiceFlavor_04showFlavorSelections extends JPanel {
    private static final int MAX_BUTTONS = 6;
    private JButton[] flavorButtons;
    private Map<Integer, String> flavorIdMap;
    private ImageIcon selectedIcon; 
    
    public ChoiceFlavor_04showFlavorSelections() {
        setLayout(new GridLayout(1, MAX_BUTTONS));
        initializeButtons();
        flavorIdMap = buildFlavorHashMap();
    }

    private class ButtonClickListener implements ActionListener {
        private int buttonIndex;

        public ButtonClickListener(int buttonIndex) {
            this.buttonIndex = buttonIndex;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            flavorButtons[buttonIndex].setIcon(null);
            flavorButtons[buttonIndex].setEnabled(false);
        }
    }

    
    private void initializeButtons() {
        flavorButtons = new JButton[MAX_BUTTONS];
        for (int i = 0; i < MAX_BUTTONS; i++) {
            flavorButtons[i] = new JButton("메뉴" + (i+1));
            flavorButtons[i].setPreferredSize(new Dimension(90, 110));
            flavorButtons[i].setEnabled(false);            
            flavorButtons[i].addActionListener(new ButtonClickListener(i));

            add(flavorButtons[i]);        }
    }


// 깃 자꾸 충돌 하
    
    public static Map<Integer, String> buildFlavorHashMap() {
        Map<Integer, String> flavorIdMap = new HashMap<>();

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

        return flavorIdMap;
    }


    public void updateFlavorButtons(ImageIcon[] selectedImages) {
        for (int i = 0; i < MAX_BUTTONS; i++) {
            if (i < selectedImages.length) {
                flavorButtons[i].setIcon(selectedImages[i]);
                flavorButtons[i].setEnabled(true);
            } else {
                flavorButtons[i].setIcon(null);
                flavorButtons[i].setEnabled(false);
            }
        }
    }

    public void addFlavor(ImageIcon imageIcon) {
        for (JButton button : flavorButtons) {
            if (!button.isEnabled()) {
                button.setIcon(imageIcon);
                button.setEnabled(true);
                break;
            }
        }
    }

    public void clearFlavorButtons() {
        for (JButton button : flavorButtons) {
            button.setIcon(null);
            button.setEnabled(false);
        }
    }
    
    public String getFlavorNameByImage(ImageIcon imageIcon) {
        for (int i = 0; i < flavorButtons.length; i++) {
            if (flavorButtons[i].getIcon() != null && flavorButtons[i].getIcon().equals(imageIcon)) {
                return getFlavorNameById(i + 1);
            }
        }
        return null; 
    }

    // flavorName
    public String getFlavorNameById(int flavorId) {
        return flavorIdMap.get(flavorId);
    }

    // flavorId
    public int getFlavorIdByButtonIndex(int buttonIndex) {
        for (Map.Entry<Integer, String> entry : flavorIdMap.entrySet()) {
            if (flavorButtons[entry.getKey()].isEnabled()) {
                if (buttonIndex == 0) {
                    return entry.getKey();
                }
                buttonIndex--;
            }
        }
        return -1; 
    }


    public String getSelectedImageIcon() {
        for (Map.Entry<Integer, String> entry : flavorIdMap.entrySet()) {
            int buttonIndex = entry.getKey();
            if (buttonIndex >= 0 && buttonIndex < flavorButtons.length &&
                flavorButtons[buttonIndex].getIcon() == selectedIcon) {
                return entry.getValue();
            } 
        }
        return null;
    }

    
 }
