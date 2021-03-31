package java_2020_11_16_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame {
	JPanel panel;
	JLabel label_Korea, label_Math, label_English, label_Total, label_Aver;
	JTextField text_Korea, text_Math, text_English, text_Total, text_Aver;
	JButton btn_Total, btn_Aver;

	ActionHandler actionHandler = new ActionHandler();

	public MainFrame() {
		this.setSize(270, 220);
		panel = new JPanel();

		label_Korea = new JLabel("±¹¾î ¼ºÀû : ");
		text_Korea = new JTextField(15);

		label_Math = new JLabel("¼öÇÐ ¼ºÀû :");
		text_Math = new JTextField(15);

		label_English = new JLabel("¿µ¾î ¼ºÀû : ");
		text_English = new JTextField(15);

		label_Total = new JLabel("ÃÑÇÕ : ");
		text_Total = new JTextField(18);

		label_Aver = new JLabel("Æò±Õ : ");
		text_Aver = new JTextField(18);

		btn_Total = new JButton("ÃÑÇÕ");
		btn_Total.addActionListener(actionHandler);

		btn_Aver = new JButton("Æò±Õ");
		btn_Aver.addActionListener(actionHandler);

		panel.add(label_Korea);
		panel.add(text_Korea);
		panel.add(label_Math);
		panel.add(text_Math);
		panel.add(label_English);
		panel.add(text_English);
		panel.add(label_Total);
		panel.add(text_Total);
		panel.add(label_Aver);
		panel.add(text_Aver);
		panel.add(btn_Total);
		panel.add(btn_Aver);

		this.add(panel);
	}
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String clicked = e.getActionCommand();
			if (clicked.equals("ÃÑÇÕ"))
				Total();
			if (clicked.equals("Æò±Õ"))
				Aver();
		}
	}
	public void Total() {
		String sTotal;
		int iTotal;
		iTotal = Integer.parseInt(text_Korea.getText()) + Integer.parseInt(text_Math.getText())
				+ Integer.parseInt(text_English.getText());
		sTotal = Integer.toString(iTotal);
		text_Total.setText(sTotal);
	}
	public void Aver() {
		String sAver;
		int iTotal, iAver;
		iTotal = Integer.parseInt(text_Korea.getText()) + Integer.parseInt(text_Math.getText())
				+ Integer.parseInt(text_English.getText());
		iAver = iTotal / 3;
		sAver = Integer.toString(iAver);
		text_Aver.setText(sAver);
	}
}
