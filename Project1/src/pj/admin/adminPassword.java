package pj.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import pj.menu.IceCreamShopCover;

public class adminPassword  extends JFrame{

	// 1. IceCreamShopCover() 우측하단 키 누르면 ->  adminPassword()
	// 2. adminPassword() 에서 비밀번호 입력(비밀번호 111111) (맞으면 adminPage() / 틀리면 IceCreamShopCover())
	
	private String passWord = "111111";
	
	public adminPassword() {
		super("관리자 페이지");
		setLayout(null);
		
		JLabel label = new JLabel("관리자 비밀번호: ");
		label.setBounds(50,150,100,30);
		JPasswordField pw = new JPasswordField(50);
		
		pw.setLocation(150,150);
		pw.setSize(200,30);
		
		add(label);
		add(pw);
		
		JButton click = new JButton("로그인");
		 click.setBounds(200, 200, 100, 30);
		 
		 click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(passWord.equals(new String(pw.getPassword()))) {
					new adminPage();
				} else {
					new IceCreamShopCover();
				}
			}
			 
		 });
		
		 add(click);
		 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(540, 960);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		new adminPassword();
	}
	
	 
}