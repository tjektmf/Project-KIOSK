package pj_yr.choiceFlavor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChoiceFlavor_01row1 extends JPanel {
    Color beskinColor = new Color(236, 108, 165);

    public ChoiceFlavor_01row1(ChoiceFlavor_00frame choiceFlavor_00frame) {
        setLayout(new BorderLayout());

        JLabel label1a = new JLabel("옵션", SwingConstants.CENTER);
        label1a.setPreferredSize(new Dimension(270, 80));
        label1a.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        JLabel label1b = new JLabel("플레이버", SwingConstants.CENTER);
        label1b.setPreferredSize(new Dimension(270, 80));
        label1b.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        label1b.setForeground(beskinColor);

        add(label1a, BorderLayout.WEST);
        add(label1b, BorderLayout.EAST);
    }
}