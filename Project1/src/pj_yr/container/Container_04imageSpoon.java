package pj_yr.container;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Container_04imageSpoon {

	public Container_04imageSpoon(JLabel labelName, String route) {
		try {
			// 1. 이미지의 크기를 수정하기 위해 불러온다
			BufferedImage bufferedImage = ImageIO.read(new File(route));

			// 2. 불러온 이미지로부터 사이즈 조절된 새로운 인스턴스를 받을 수 있다
			Image scaledImage = bufferedImage.getScaledInstance(90, 50, Image.SCALE_SMOOTH);

			labelName.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}