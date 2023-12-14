package pj_yr.Container;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Container_05counting {

	public Container_05counting(JPanel panelName, int i) {
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

        minusButtoni.setPreferredSize(new java.awt.Dimension(30, 20));
        plusButtoni.setPreferredSize(new java.awt.Dimension(30, 20));
        minusButtoni.setFont(new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 8));
        plusButtoni.setFont(new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 8));

        numberFieldi.setPreferredSize(new Dimension(50, 30));        

        panelName.add(minusButtoni);
        panelName.add(numberFieldi);
        panelName.add(plusButtoni);

	}
}