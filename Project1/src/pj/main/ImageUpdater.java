package pj.main;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


// IceCreamShopCover() 이미지부분만 따로 빼서 클래스 나눠보려 해본것.. @_@

public class ImageUpdater {
    private String[] imagePaths = { 
			"img/hyemi/베라img.png",
			"img/hyemi/ad1.png",
            "img/hyemi/ad2.png",
            "img/hyemi/ad3.png",
            "img/hyemi/ad4.png"
            };
    private int currentImgIndex;
    private JLabel mainLabel;
    private Timer timer;

    public ImageUpdater(String[] imagePaths, JLabel mainLabel) {
        this.imagePaths = imagePaths;
        this.mainLabel = mainLabel;
        this.currentImgIndex = 0;

        this.timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentImgIndex == 0) {
                    currentImgIndex++;
                }
                updateImage();
                currentImgIndex = (currentImgIndex + 1) % imagePaths.length;
            }
        });
        timer.start();
    }

    public void updateImage() {
        try {
            BufferedImage image = ImageIO.read(new File(imagePaths[currentImgIndex]));
            mainLabel.setIcon(new ImageIcon(image.getScaledInstance(540, 960, BufferedImage.SCALE_SMOOTH)));
        } catch (IOException e) {
            System.out.println("이미지 오류");
            e.printStackTrace();
        }
    }
}
