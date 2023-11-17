package pj.Coffee;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Coffee_Select2_1 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel imageLabel;
    private JPanel mainPanel;

    public Coffee_Select2_1() {
        initializeComponents();
        setLayout();
        setProperties();
    }

    private void initializeComponents() {
        imageLabel = new JLabel();
        mainPanel = new JPanel();
    }

    private void setLayout() {
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 540, 960);
        mainPanel.setOpaque(false);
    }

    private void setProperties() {
        imageLabel.setIcon(new ImageIcon("C:/pj/배경2.png"));
        setBounds(100, 100, 540, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
        add(imageLabel);
        imageLabel.add(mainPanel);
    }



    private void createGUI() {
        JButton homeBtn = new JButton("초기화면");
        JButton returnBtn = new JButton("카테고리");
        JButton addShotN = new JButton("추가안함");
        JButton addShotY = new JButton("샷추가");
        JButton syrupN = new JButton("추가안함");
        JButton syrupY = new JButton("시럽추가");
        JButton cupForBurial = new JButton("매장용컵");
        JButton disposableCup = new JButton("일회용컵");
        JButton reusableCup = new JButton("리유저블컵");
        JButton personalCup = new JButton("개인용컵");
        JButton prevBtn = new JButton("이전");
        JButton optionsBtn = new JButton("상품옵션선택");

        // Setting button bounds...

        mainPanel.add(homeBtn);
        mainPanel.add(returnBtn);
        mainPanel.add(addShotN);
        mainPanel.add(addShotY);
        mainPanel.add(syrupN);
        mainPanel.add(syrupY);
        mainPanel.add(cupForBurial);
        mainPanel.add(disposableCup);
        mainPanel.add(reusableCup);
        mainPanel.add(personalCup);
        mainPanel.add(prevBtn);
        mainPanel.add(optionsBtn);

        setVisible(true);
    }
    public static void main(String[] args) {
    	new Coffee_Select2_1().createGUI();
    }
}
