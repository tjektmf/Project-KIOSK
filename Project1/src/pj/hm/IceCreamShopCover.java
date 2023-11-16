package pj.hm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class IceCreamShopCover extends JFrame {

    public IceCreamShopCover() {
        setTitle("베스킨라빈스");
        setLayout(new BorderLayout());

        // 이미지를 표시할 JLabel
        JLabel mainLabel = new JLabel();
        // 투명한 패널 위에 글씨를 표시할 JLabel
        JLabel textLabel = new JLabel("화면을 클릭하세요");
        // 이미지 파일 경로
        String imagePath = "C:/Users/Gi7E-36/Desktop/img/베라img.png"; // 파일 확장자 추가
        
        Timer change = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
			}
			String imagePath2 = "C:/Users/Gi7E-36/Desktop/img/ad1.png";
        });
        
        for(int i = 0 ; i < 5; i++) {
        	change.start();
        }
        change.stop();

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            Image scaledImage = image.getScaledInstance(540, 960, Image.SCALE_SMOOTH);
            mainLabel.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
        	System.out.println("이미지오류");
            e.printStackTrace();
        }

        // 투명한 패널을 만들어 글씨를 포함시키고 위치 설정
        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        textPanel.setSize(540, 960);
        textPanel.setBackground(new Color(0,0,0,0)); // 투명 설정
        add(textPanel);
        textPanel.add(textLabel);

        // 전체를 감싸는 패널
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(mainLabel, BorderLayout.CENTER);

        // 전체 패널에 마우스 클릭 리스너 추가
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 화면 클릭 시 카테고리 페이지를 표시
                new CategoryHome();
                dispose();
            }
        });

        add(mainPanel, BorderLayout.CENTER);

        // 프레임 표시 설정
        pack();
        setBounds(300, 300, 540, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IceCreamShopCover());
    }
}
