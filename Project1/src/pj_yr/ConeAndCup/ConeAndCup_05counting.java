package pj_yr.ConeAndCup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConeAndCup_05counting {

	public ConeAndCup_05counting(JPanel panelName, int i) {
        JButton minusButtoni = new JButton("-");
        JTextField numberFieldi = new JTextField("0", 3); // 초기값은 0
        numberFieldi.setEditable(false);
        JButton plusButtoni = new JButton("+");

        // 버튼에 대한 액션 리스너 추가
        minusButtoni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentValue = Integer.parseInt(numberFieldi.getText());
                if (currentValue > 0) {
                	numberFieldi.setText(Integer.toString(currentValue - 1));
                }
            }
        });

        plusButtoni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentValue = Integer.parseInt(numberFieldi.getText());
                if (currentValue < 100) {
                	numberFieldi.setText(Integer.toString(currentValue + 1));
                }
            }
        });

        panelName.add(minusButtoni);
        panelName.add(numberFieldi);
        panelName.add(plusButtoni);

	}
	
}