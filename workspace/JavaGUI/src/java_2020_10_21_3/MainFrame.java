package java_2020_10_21_3;
import javax.swing.*;
public class MainFrame extends JFrame {
	public MainFrame() {
		this.setSize(500, 500);
		JPanel panel1 = new JPanel();
		
		JTextField textField = new JTextField(10);
		panel1.add(textField);
		
		JPasswordField passwordField = new JPasswordField(10);
		panel1.add(passwordField);
		
		JLabel label = new JLabel();
		label.setText("�ݰ�����!_!");
		panel1.add(label);
		
		JButton button = new JButton("��ư");
		panel1.add(button);
		
		this.add(panel1);
	}
}
