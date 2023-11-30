
package pj_yr.ChoiceFlavor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pj.choice.ChoiceFrameBuyList;
import pj_yr.ConeAndCup.ConeAndCup_00frame;

public class ChoiceFlavor_03prevOrNext extends JPanel {
	Color beskinColor = new Color(236, 108, 165);

	String[] SAVED_FLAVORLIST = new String[6];

	private final ChoiceFlavor_02row2 choiceFlavor_02row2;
	private final ChoiceFlavor_00frame choiceFlavor_00frame;
	private final ChoiceFlavor_04showFlavorSelections showFlavorSelections;
	ChoiceFrameBuyList choiceFrameBuyList;

//	ChoiceFlavor_02row2 choiceFlavor_02row2 = new ChoiceFlavor_02row2(choiceFlavor_00frame, showFlavorSelections);

	boolean delete = false;

	public String SAVED_FLAVORLIST(int index) {

		return SAVED_FLAVORLIST[index];
	}

	public boolean delete_out() {
		if (delete) {
			return true;
		} else {
			return false;
		}
	}

	public ChoiceFlavor_03prevOrNext(ChoiceFlavor_00frame choiceFlavor_00frame,
			ChoiceFlavor_04showFlavorSelections showFlavorSelections, ChoiceFlavor_02row2 choiceFlavor_02row2) {
		this.choiceFlavor_02row2 = choiceFlavor_02row2;
		this.choiceFlavor_00frame = choiceFlavor_00frame;
		this.showFlavorSelections = showFlavorSelections;

		choiceFrameBuyList = ChoiceFrameBuyList.getInstance();
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

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				choiceFlavor_00frame.disapear();
				for (int i = 0; i < 9; i++) {
					if (choiceFrameBuyList.SAVED_BUYLIST2(i).getText() == "") {
						for (int j = 0; j < 6; j++) {
							System.out.print(choiceFlavor_02row2.SAVED_FLAVORLIST_NEW(j) + ", ");
						}
						choiceFrameBuyList.SAVED_BUYLIST2(i).setText(choiceFlavor_02row2.SAVED_FLAVORLIST_NEW(0));
						choiceFrameBuyList.SAVED_BUYLIST3(i).setText(choiceFlavor_02row2.SAVED_FLAVORLIST_NEW(1));
						choiceFrameBuyList.SAVED_BUYLIST4(i).setText(choiceFlavor_02row2.SAVED_FLAVORLIST_NEW(2));
						choiceFrameBuyList.SAVED_BUYLIST5(i).setText(choiceFlavor_02row2.SAVED_FLAVORLIST_NEW(3));
						choiceFrameBuyList.SAVED_BUYLIST6(i).setText(choiceFlavor_02row2.SAVED_FLAVORLIST_NEW(4));
				//		choiceFrameBuyList.SAVED_BUYLIST7(i).setText(choiceFlavor_02row2.SAVED_FLAVORLIST_NEW(5));
						break;
					}
				}

			}
		});
		addButton.setBackground(beskinColor);
		addButton.setForeground(Color.white);
		addButton.setPreferredSize(new Dimension(350, 30));
		addButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		addButton.addActionListener(e -> {
			ChoiceFlavor_02row2.getSelectedFlavorNames();
			System.out.println(ChoiceFlavor_02row2.getSelectedFlavorNames());
		});
		add(addButton, BorderLayout.CENTER);

		// 취소 버튼
		JButton cancelButton = new JButton("취소");

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				choiceFlavor_02row2.delete = true;

			}
		});
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