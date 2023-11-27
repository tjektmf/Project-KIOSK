
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
        public void actionPerformed(ActionEvent e) {
            ImageIcon removedIcon = (ImageIcon) flavorButtons[buttonIndex].getIcon();
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
                button.setBackground(Color.WHITE);
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
    
    
 }
