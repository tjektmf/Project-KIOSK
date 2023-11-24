   package pj.Coffee;
   import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
   import java.awt.event.ActionEvent;
   import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
   import javax.swing.JButton;
   import javax.swing.JFrame;
   import javax.swing.JLabel;
   import javax.swing.JPanel;

   import pj.choice.ChoiceSelectCoffee;

   public class Coffee_Options extends JPanel {
	   
	   private BufferedImage[] images;

		 private static BufferedImage[] loadImages() {
		        BufferedImage[] images = new BufferedImage[10]; // 이미지 개수에 맞게 배열 크기 조절

		        // 이미지 파일 경로
		        String[] imagePaths = {
		        		"img/hodong/배경1.png",
		        		"img/hodong/배경2.png",
		        		"img/hodong/배경3.png",
		        		"img/hodong/배경4.png",
		        		"img/hodong/배경5.png",
		        		"img/hodong/배경6.png",
		        		"img/hodong/배경7.png",
		        		"img/hodong/배경8.png",
		        		"img/hodong/배경9.png",
		        		"img/hodong/배경10.png"			
		        };
		        // 이미지를 배열에 로드
		        for (int i = 0; i < images.length; i++) {
		            try {
		                images[i] = ImageIO.read(new File(imagePaths[i]));
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }

		        return images;
		    }
		
      
   public Coffee_Options() {
      CardLayout cardLayout = new CardLayout();
      JLabel imageLabel = new JLabel(new ImageIcon(loadImages()[0]));// loadImages()[] []안에 숫자가 바뀌면 배경이미지가 바뀐다 ㅎㅎ
      JFrame Coffee1 = new JFrame();
      JPanel mainPanel = new JPanel();
   //   JButton HomeBtn = new JButton();

      
      imageLabel.setIcon(new ImageIcon("img/hodong/배경2.png"));

      Coffee1.setBounds(100, 100, 550, 960);

   //   JButton HomeBtn = new JButton("초기화면");
   //   JButton ReturnBtn = new JButton("카테고리");
      JButton AddShotN = new JButton(new ImageIcon("img/hodong/추가안함P.png"));
      AddShotN.setBorderPainted(false); // 버튼 테두리 투명화 작업
      AddShotN.setOpaque(false); // 버튼 테두리 투명화 작업
      AddShotN.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
      JButton AddShotY = new JButton(new ImageIcon("img/hodong/샷추가G.png"));
      AddShotY.setBorderPainted(false); // 버튼 테두리 투명화 작업
      AddShotY.setOpaque(false); // 버튼 테두리 투명화 작업
      AddShotY.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
      JButton SyrupN = new JButton(new ImageIcon("img/hodong/추가안함P.png"));
      SyrupN.setBorderPainted(false); // 버튼 테두리 투명화 작업
      SyrupN.setOpaque(false); // 버튼 테두리 투명화 작업
      SyrupN.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
      JButton SyrupY = new JButton(new ImageIcon("img/hodong/시럽추가G.png"));
      SyrupY.setBorderPainted(false); // 버튼 테두리 투명화 작업
      SyrupY.setOpaque(false); // 버튼 테두리 투명화 작업
      SyrupY.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
      JButton CupForBurial = new JButton(new ImageIcon("img/hodong/매장용컵P.png"));
      CupForBurial.setBorderPainted(false); // 버튼 테두리 투명화 작업
      CupForBurial.setOpaque(false); // 버튼 테두리 투명화 작업
      CupForBurial.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
      JButton DisposableCup = new JButton(new ImageIcon("img/hodong/일회용컵G.png"));
      DisposableCup.setBorderPainted(false); // 버튼 테두리 투명화 작업
      DisposableCup.setOpaque(false); // 버튼 테두리 투명화 작업
      DisposableCup.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
//      JButton ReusableCup = new JButton("리유저블컵");
//      JButton PersonalCup = new JButton("개인용컵");
      JButton PrevBtn = new JButton(new ImageIcon("img/hodong/이전.png"));
      PrevBtn.setBorderPainted(false); // 버튼 테두리 투명화 작업
      PrevBtn.setOpaque(false); // 버튼 테두리 투명화 작업
      PrevBtn.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업
      JButton OptionsBtn = new JButton(new ImageIcon("img/hodong/결제하기.png"));
      OptionsBtn.setBorderPainted(false); // 버튼 테두리 투명화 작업
      OptionsBtn.setOpaque(false); // 버튼 테두리 투명화 작업
      OptionsBtn.setBackground(new Color(0, 0, 0, 0)); // 버튼 투명화 작업

      // 버튼들 위치 정하는 작업
   //   HomeBtn.setBounds(10, 20, 50, 50);
   //   ReturnBtn.setBounds(468, 20, 50, 50);
      AddShotN.setBounds(160, 220, 100, 90);
      AddShotY.setBounds(270, 220, 100, 90);
      SyrupN.setBounds(160, 340, 100, 90);
      SyrupY.setBounds(270, 340, 100, 90);
      CupForBurial.setBounds(160, 450, 100, 90);
      DisposableCup.setBounds(270, 450, 100, 90);
//      ReusableCup.setBounds(380, 420, 100, 90);
//      PersonalCup.setBounds(160, 520, 100, 90);
      PrevBtn.setBounds(20, 600, 140, 90);
      OptionsBtn.setBounds(180, 600, 330, 90);

      // 메인 페널에 버튼 추가
      mainPanel.setLayout(null);
   //   mainPanel.add(HomeBtn);
   //   mainPanel.add(ReturnBtn);
      mainPanel.add(AddShotN);
      mainPanel.add(AddShotY);
      mainPanel.add(SyrupN);
      mainPanel.add(SyrupY);
      mainPanel.add(CupForBurial);
      mainPanel.add(DisposableCup);
//      mainPanel.add(ReusableCup);
//      mainPanel.add(PersonalCup);
      mainPanel.add(PrevBtn);
      mainPanel.add(OptionsBtn);
      mainPanel.add(imageLabel);
      mainPanel.setBounds(0,0,540,960); // 메인 페널 생성
      mainPanel.setOpaque(false); // 메인 페널 투명화
      
      
      // 프레임에 이미지 레이블 추가 후  이미지 레이블에 메인 페널 올리기
      Coffee1.add(imageLabel);
      Coffee1.setLayout(new GridLayout());
      Coffee1.add(mainPanel);
      Coffee1.setLocationRelativeTo(null);
      imageLabel.add(mainPanel);
      //PrevBtn.setLayout(cardLayout);
      
      PrevBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Coffee1.setVisible(false);
            
         }
      });

      Coffee1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Coffee1.setVisible(true);
   }
         
      public static void main(String[] args) {
      new Coffee_Options();
      }
   }