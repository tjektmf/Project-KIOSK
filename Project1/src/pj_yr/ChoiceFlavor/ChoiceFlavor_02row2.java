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


    public ChoiceFlavor_02row2(ChoiceFlavor_00frame frame, ChoiceFlavor_04showFlavorSelections showFlavorSelections) {
        this.frame = frame;
        this.showFlavorSelections = showFlavorSelections;
        setLayout(new BorderLayout());

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
                imageButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addFlavorSelection(imageIcon);
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
}
