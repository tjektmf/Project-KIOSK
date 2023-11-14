package pj.choice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiceFrameSelect extends JPanel {

	ChoiceSelectIce choiceSelectIce;
	JButton choiceSelectNextBtn;
	JButton choiceSelectPrevBtn;
	
	public ChoiceFrameSelect(ChoiceSelectAll mainFrame) {
		
		// 얘도 카드에 붙일 5개의 패널 중 1번 패널에 붙일 패널임, 1번 패널에 ChoiceSelectIce를 붙인 ChoiceFrameSelect를 붙여야 함
		// 이거 5개 이름은 뭐로? 셀릭1~5? 일단 추가로 만드는걸 2~5로
		// 그럼 5개를 아우르는 새 카드패널부터 만들어야할듯 이름은 ChoiceSelectAll
		// all 패널을 메인프레임에 붙어야함 5개패널의 생성자에 들어갈 매개변수 변경이 필요함
		
		
		BorderLayout border = new BorderLayout(40, 40);
		setLayout(border);
		

		choiceSelectNextBtn = new JButton(">>");
		choiceSelectPrevBtn = new JButton("<<");
		choiceSelectIce = new ChoiceSelectIce(this);
	
		
		add(choiceSelectNextBtn, BorderLayout.EAST);
		add(choiceSelectPrevBtn, BorderLayout.WEST);
		add(choiceSelectIce, BorderLayout.CENTER);
	
	}
}
