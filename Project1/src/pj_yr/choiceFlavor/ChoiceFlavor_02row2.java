package pj_yr.choiceFlavor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChoiceFlavor_02row2 extends JPanel {
    private JPanel centerPanel;
    private ChoiceFlavor_00frame frame;

    public ChoiceFlavor_02row2(ChoiceFlavor_00frame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        centerPanel = new JPanel(new GridLayout(4, 4));
        updateCenterPanel();
        add(centerPanel, BorderLayout.CENTER);

        JButton prevButton = new JButton("<<");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.getCurrentPanel() == 2) {
                    frame.setCurrentPanel(1);
                }            }
        });
        add(prevButton, BorderLayout.WEST);

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

    public void updateCenterPanel() {
        centerPanel.removeAll();

        int startValue = (frame.getCurrentPanel() - 1) * 16 + 1;
        for (int i = 0; i < 16; i++) {
            centerPanel.add(new JButton("Button " + (startValue + i)));
        }

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public static void main(String[] args) {
    }
}
