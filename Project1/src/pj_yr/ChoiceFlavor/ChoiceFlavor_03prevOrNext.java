
package pj_yr.ChoiceFlavor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pj_yr.ConeAndCup.ConeAndCup_00frame;

public class ChoiceFlavor_03prevOrNext extends JPanel {
    Color beskinColor = new Color(236, 108, 165);
    
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
        	choiceFlavor_00frame.setVisible(false);	

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
        	ChoiceFlavor_02row2.getSelectedFlavorNames().stream().distinct().collect(Collectors.toList());;
        	System.out.println(ChoiceFlavor_02row2.getSelectedFlavorNames().stream().distinct().collect(Collectors.toList()));
        	ChoiceFlavor_02row2.getSelectedFlavorNames().clear();
        
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
        	// 버튼날리고
            showFlavorSelections.clearFlavorButtons();
            // 담아둔 아이스크림 flavorName들도 날릴게요
            ChoiceFlavor_02row2.clearSelectedFlavorNames();
        });
        add(cancelButton, BorderLayout.EAST);
        

    }
    


}
