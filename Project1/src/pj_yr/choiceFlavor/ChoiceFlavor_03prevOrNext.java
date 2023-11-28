
package pj_yr.choiceFlavor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pj_yr.ConeAndCup.ConeAndCup_00frame;

public class ChoiceFlavor_03prevOrNext extends JPanel {
    Color beskinColor = new Color(236, 108, 165);
 //   ChoiceFlavor_00frame move = new ChoiceFlavor_00frame();

    public ChoiceFlavor_03prevOrNext(ChoiceFlavor_00frame choiceFlavor_00frame, 
                                      ChoiceFlavor_04showFlavorSelections showFlavorSelections) {
        setLayout(new BorderLayout());

        // 이전 버튼
        JButton prevButton = new JButton("이전");
        prevButton.setBackground(Color.white);
        prevButton.setForeground(beskinColor);
        prevButton.setPreferredSize(new Dimension(100, 30));
        prevButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        prevButton.addActionListener(e -> {
        	setVisible(false);	
  //      	move.setVisible(false);

            // ConeAndCup_00frame 열기
            ConeAndCup_00frame coneAndCupFrame = new ConeAndCup_00frame();
            coneAndCupFrame.setVisible(true);

        });
        add(prevButton, BorderLayout.WEST);

        // 담기 버튼
        JButton addButton = new JButton("담기");
        addButton.setBackground(beskinColor);
        addButton.setForeground(Color.white);
        addButton.setPreferredSize(new Dimension(350, 30));
        addButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        addButton.addActionListener(e -> {
            if (showFlavorSelections.getSelectedImageIcon() != null) {
            	String flavorName = showFlavorSelections.getSelectedImageIcon();
                System.out.println("선택된 플레이버: " + flavorName);
            } else {
                System.out.println("선택된 플레이버가 없습니다.");
            }
  //          move.setVisible(false);
        });
        add(addButton, BorderLayout.CENTER);

        // 취소 버튼
        JButton cancelButton = new JButton("취소");
        cancelButton.setBackground(Color.red);
        cancelButton.setForeground(Color.white);
        cancelButton.setPreferredSize(new Dimension(100, 30));
        cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        cancelButton.addActionListener(e -> { 
            // 취소 버튼 기능 구현
            showFlavorSelections.clearFlavorButtons();
        });
        add(cancelButton, BorderLayout.EAST);
    }
}
