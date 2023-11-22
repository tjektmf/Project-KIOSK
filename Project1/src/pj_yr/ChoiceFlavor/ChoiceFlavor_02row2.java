package pj_yr.ChoiceFlavor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFlavor_02row2 extends JPanel {
    private JPanel centerPanel;
    private ChoiceFlavor_00frame frame;
    private ChoiceFlavor_04showFlavorSelections showFlavorSelections;
    
    private static final int BUTTONS_NUMS = 16;

    public ChoiceFlavor_02row2(ChoiceFlavor_00frame frame, 
    		ChoiceFlavor_04showFlavorSelections showFlavorSelections) {
        this.frame = frame;
        this.showFlavorSelections = showFlavorSelections;
        setLayout(new BorderLayout());
        
        // 버튼 4x4
        centerPanel = new JPanel(new GridLayout(4, 4)); 
        updateCenterPanel();
        add(centerPanel, BorderLayout.CENTER);

     // << west
        JButton prevButton = new JButton("<<");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.getCurrentPanel() == 2) {
                    frame.setCurrentPanel(1);
                }
            }
        });
        add(prevButton, BorderLayout.WEST);

        // >> east
        JButton nextButton = new JButton(">>");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.getCurrentPanel() == 1) {
                    frame.setCurrentPanel(2);
                }
            }
        });
        add(nextButton, BorderLayout.EAST);
    }
    

    private ImageIcon getImageIcon(String imageUrl) throws IOException {
        try {
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);
            return new ImageIcon(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 이미지버튼
    public void updateCenterPanel() {

        centerPanel.removeAll();

        int startValue = (frame.getCurrentPanel() - 1) * BUTTONS_NUMS + 1;

        for (int i = 0; i < BUTTONS_NUMS; i++) {
            int currentButtonValue = startValue + i;
            if (currentButtonValue <= 29) {
                JButton imageButton = new JButton();
                try {
                    BufferedImage bufferedImage =
                            ImageIO.read(new File("img_baskin/baskin_flavor/" + currentButtonValue + ".png"));
                    Image scaledImage = bufferedImage.getScaledInstance(100, 110, Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(scaledImage);
                    imageButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            addFlavorSelection(imageIcon);
                        }
                    });

                    imageButton.setIcon(imageIcon);
                    centerPanel.add(imageButton);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                JButton blankButton = new JButton();
                centerPanel.add(blankButton);
            }
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }
    
    private void addFlavorSelection(ImageIcon imageIcon) {
        showFlavorSelections.addFlavor(imageIcon);
    }
    
    public static void main(String[] args) {
    	
    }
}
