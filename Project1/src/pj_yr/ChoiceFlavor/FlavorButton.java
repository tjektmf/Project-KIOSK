package pj_yr.ChoiceFlavor;

import javax.swing.JButton;
//
public class FlavorButton extends JButton {
    private int flavorName;

    public FlavorButton(int flavorName) {
        this.flavorName = flavorName;
    }

    public int getFlavorName() {
        return flavorName;
    }
}
