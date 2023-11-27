
package pj_yr.ChoiceFlavor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class ChoiceFlavor_04showFlavorSelections extends JPanel {
    private static final int MAX_BUTTONS = 6;
    private JButton[] flavorButtons;
    private Map<Integer, String> flavorIdMap;
    private ImageIcon selectedIcon; 
    private int[] selectedImagesIndex = new int[30];
    private int addCount = 0;

    

    
    public ChoiceFlavor_04showFlavorSelections() {
        setLayout(new GridLayout(1, MAX_BUTTONS));
        initializeButtons();
    }

    private class ButtonClickListener implements ActionListener {
        private int buttonIndex;

        public ButtonClickListener(int buttonIndex) {
            this.buttonIndex = buttonIndex;
        }

        @Override
        //만약 buttonIndex를 안다면 몇번째의 addFlavor 된건지 알수있을거고 
        public void actionPerformed(ActionEvent e) {
            ImageIcon removedIcon = (ImageIcon) flavorButtons[buttonIndex].getIcon();
            flavorButtons[buttonIndex].setIcon(null);
            flavorButtons[buttonIndex].setEnabled(false);
            flavorButtons[buttonIndex].setBackground(getBackground());
            
            for(int i = 0; i < selectedImagesIndex.length; i++) {
                if (buttonIndex == selectedImagesIndex[i]%6) {
                	ChoiceFlavor_02row2.getSelectedFlavorNames().remove(flavorIdMap.get(i));
                }

            }
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
    
    
    public void addFlavor(ImageIcon imageIcon, int flavorName) {
        for (int i = 0; i<selectedImagesIndex.length; i++) {
        	selectedImagesIndex[i] = -1;
        }
        
        for (JButton button : flavorButtons) {
            if (!button.isEnabled()) {
                button.setIcon(imageIcon);
                button.setBackground(Color.WHITE);
                button.setEnabled(true);
                addCount++;
                selectedImagesIndex[flavorName] = addCount;
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
    
    
 }
