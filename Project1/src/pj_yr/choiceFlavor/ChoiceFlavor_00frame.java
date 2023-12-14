package pj_yr.choiceFlavor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ChoiceFlavor_00frame extends JFrame {
    private int currentPanel;
    
    public void disapear() {
    	setVisible(false);
    }

    public ChoiceFlavor_00frame() {
    	
        Color beskinColor = new Color(236, 108, 165);

    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(555, 960);
        
        ChoiceFlavor_01row1 row1 = new ChoiceFlavor_01row1(this);
        ChoiceFlavor_04showFlavorSelections showFlavorSelections = new ChoiceFlavor_04showFlavorSelections();
        ChoiceFlavor_02row2 row2 = new ChoiceFlavor_02row2(this, showFlavorSelections);
        
        add(row1, BorderLayout.NORTH);
        add(row2);
        add(showFlavorSelections, BorderLayout.SOUTH);

        setCurrentPanel(1);
        
    }

    public int getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(int currentPanel) {
        this.currentPanel = currentPanel;
        getContentPane().removeAll();
        ChoiceFlavor_01row1 row1 = new ChoiceFlavor_01row1(this);
        ChoiceFlavor_04showFlavorSelections showFlavorSelections = new ChoiceFlavor_04showFlavorSelections();
        ChoiceFlavor_02row2 row2 = new ChoiceFlavor_02row2(this, showFlavorSelections);

        add(row1, BorderLayout.NORTH);
        add(row2);
        add(showFlavorSelections, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
    	ChoiceFlavor_00frame frame = new ChoiceFlavor_00frame();
        frame.setVisible(true);
    }
}
