package pj_yr.ChoiceFlavor;

import javax.swing.JButton;

public class FlavorButton extends JButton {
    private int flavorName;

    public FlavorButton(String text, int flavorName) {
        super(text);
        this.flavorName = flavorName;
    }

    public int getFlavorName() {
        return flavorName;
    }
}
