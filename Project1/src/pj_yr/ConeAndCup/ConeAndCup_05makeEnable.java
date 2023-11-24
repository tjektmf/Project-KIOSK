package pj_yr.ConeAndCup;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ConeAndCup_05makeEnable {

	public ConeAndCup_05makeEnable() {
		
	}

    // 패널을 생성하고 초기 상태를 설정하는 메서드
    private JPanel createCountingPanel(Color color, int index) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(160, 40));
        // 초기 상태에서는 비활성화
        setPanelEnabled(index, false);
        new ConeAndCup_05counting(panel, index);
        return panel;
    }

    // 패널을 활성화 또는 비활성화 하는 메서드
    private void setPanelEnabled(int index, boolean enabled) {
        Component[] components = ((JPanel) jp.getComponent(4)).getComponents(); // 다섯 번째 행의 패널들
        if (components.length > index && components[index] instanceof JPanel) {
            for (Component comp : ((JPanel) components[index]).getComponents()) {
                if (comp instanceof JButton) {
                    comp.setEnabled(enabled);
                }
            }
        }
    }

    // 패널을 선택된 버튼의 인덱스에 따라 활성화 또는 비활성화 하는 메서드
    private void setPanelEnabled(int index) {
        Component[] components = ((JPanel) jp.getComponent(4)).getComponents(); // 다섯 번째 행의 패널들
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JPanel) {
                for (Component comp : ((JPanel) components[i]).getComponents()) {
                    if (comp instanceof JButton) {
                        comp.setEnabled(i == index);
                    }
                }
            }
        }
    }

}

