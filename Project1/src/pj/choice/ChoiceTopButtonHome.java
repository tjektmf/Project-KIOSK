package pj.choice;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceTopButtonHome extends JButton {

	JButton choiceTopButtonHome;

	public ChoiceTopButtonHome(ChoiceFrameTop mainFrame) {
		

		BufferedImage image;
		try {
			image = ImageIO.read(new File("img/daseul/home.png"));
			Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	ImageIcon home = new ImageIcon("img/daseul/home.png");
	//	setIcon(home);
	//	setText("Home");
		setBackground(new Color(255,255,255));
		setBorderPainted(false);
		
		mainFrame.choiceTopButtonHome = choiceTopButtonHome;

	}
}