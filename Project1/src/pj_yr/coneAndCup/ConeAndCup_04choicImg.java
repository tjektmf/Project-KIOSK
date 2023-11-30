package pj_yr.coneAndCup;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ConeAndCup_04choicImg {
	// 이미지 경로는 매개변수로 나중에 추가
	public ConeAndCup_04choicImg(JLabel labelName, String route) {
		try {
			// 1. 이미지의 크기를 수정하기 위해 불러온다
			BufferedImage bufferedImage = ImageIO.read(new File(route));

			// 2. 불러온 이미지로부터 사이즈 조절된 새로운 인스턴스를 받을 수 있다
			Image scaledImage = bufferedImage.getScaledInstance(160, 200, Image.SCALE_SMOOTH);

			labelName.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}