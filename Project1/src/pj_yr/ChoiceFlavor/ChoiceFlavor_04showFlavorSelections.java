
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
	private FlavorButton[] flavorButtons;
	private Map<Integer, String> flavorIdMap;
	private ImageIcon selectedIcon;
	private int[] selectedImagesIndex = new int[29];
	private int addCount = 0;

	public ChoiceFlavor_04showFlavorSelections() {
		setLayout(new GridLayout(1, MAX_BUTTONS));
		initializeButtons();
	}

	private class ButtonClickListener implements ActionListener {
        private int addCount;
        private int flavorName;

        public ButtonClickListener(int addCount, int flavorName) {
            this.addCount = addCount;
            this.flavorName = flavorName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            ImageIcon removedIcon = (ImageIcon) clickedButton.getIcon();

            clickedButton.setIcon(null);
            clickedButton.setEnabled(false);
            clickedButton.setBackground(getBackground());

            System.out.println("Clicked Flavor Name: " + flavorName);
            System.out.println("Clicked Add Count: " + addCount);

            int[] selectedImagesIndex = ChoiceFlavor_04showFlavorSelections.this.selectedImagesIndex;

            List<String> selectedFlavorName = ChoiceFlavor_02row2.getSelectedFlavorNames();
            ChoiceFlavor_02row2.removeSelectedFlavor(flavorName);

        }
	}

	private void initializeButtons() {
	    flavorButtons = new FlavorButton[MAX_BUTTONS];

	    for (int i = 0; i < MAX_BUTTONS; i++) {
	        flavorButtons[i] = new FlavorButton("메뉴" + (i + 1), i);
	        flavorButtons[i].setPreferredSize(new Dimension(90, 110));
	        flavorButtons[i].setEnabled(false);

	        // Set the client property with the flavorName
	        flavorButtons[i].putClientProperty("flavorName", i);

	        flavorButtons[i].addActionListener(new ButtonClickListener(i, 0));
	        add(flavorButtons[i]);
	    }
	}

// 깃 자꾸 충돌 하

	// 여기서 처음에 addButton할때 button에 해당하는 flavorName을 넣고 다른 메서드에서 꺼낼수 있도록 하는 어떤 방법이 있을까?

	public void addFlavor(ImageIcon imageIcon, int flavorName) {
		for (int i = 0; i < selectedImagesIndex.length; i++) {
			selectedImagesIndex[i] = -1;
		}

		for (JButton button : flavorButtons) {
			if (!button.isEnabled()) {
				button.setIcon(imageIcon);
				button.setBackground(Color.WHITE);
				button.setEnabled(true);
				
	            // Flavor 이름 저장
	            
				addCount++;
				selectedImagesIndex[flavorName] = addCount;
				System.out.print("addButton : " + selectedImagesIndex[flavorName]);
				System.out.println(", flavorName : " + flavorName);

	            // ActionListener에 flavorName 전달
	            button.addActionListener(new ButtonClickListener(addCount, flavorName));

				break;
			}
		}
	}

	public void clearFlavorButtons() {
		for (JButton button : flavorButtons) {
			button.setIcon(null);
			button.setEnabled(false);
			button.setBackground(getBackground());
		}
	}

}


