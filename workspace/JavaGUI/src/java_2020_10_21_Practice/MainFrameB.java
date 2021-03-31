package java_2020_10_21_Practice;
import javax.swing.*;
public class MainFrameB extends JFrame {
	public MainFrameB() {
		setSize(350, 100);
		
		JPanel mainPanel = new JPanel();
		
		JLabel idLabel = new JLabel("ID : ");
		JTextField idTf = new JTextField(10);
		System.out.println();
		JLabel pwLabel = new JLabel("PW : ");
		JPasswordField pwF = new JPasswordField(10);
		JButton loginBtn = new JButton("·Î±×ÀÎ");
		
		mainPanel.add(idLabel);
		mainPanel.add(idTf);
		mainPanel.add(pwLabel);
		mainPanel.add(pwF);
		mainPanel.add(loginBtn);
		add(mainPanel);
		
	}
}
