package pj_yr.ChoiceFlavor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ChoiceFlavor_04showFlavorSelections extends JPanel {
    private static final int MAX_BUTTONS = 6;
    private JButton[] flavorButtons;

    public ChoiceFlavor_04showFlavorSelections() {
        setLayout(new GridLayout(1, MAX_BUTTONS));
        initializeButtons();
    }

    private void initializeButtons() {
        flavorButtons = new JButton[MAX_BUTTONS];
        for (int i = 0; i < MAX_BUTTONS; i++) {
            flavorButtons[i] = new JButton("메뉴" + (i+1));
            flavorButtons[i].setPreferredSize(new Dimension(90, 110));
            flavorButtons[i].setEnabled(false);
            add(flavorButtons[i]);
        }
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
		// TODO Auto-generated method stub
		
	}
    
    
 }
