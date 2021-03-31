package java_2020_10_28_1;

import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	JPanel panel_main, panel_input;
	JButton btnAdd, btnCancel;
	JTextField nameTf, koreanTf, mathTf, englishTf;
	JTable table;
	JScrollPane scrollPane;
	
	DefaultTableModel model;
	
	ActionHandler actionHandler;
	
	public MainFrame() {
		this.setSize(600, 600);
		panel_main = new JPanel();
		panel_input = new JPanel();
		panel_input.setLayout(new BoxLayout(panel_input, BoxLayout.X_AXIS));
		
		actionHandler = new ActionHandler();
		
		String header[] = {"학생이름", "국어", "수학","영어"};
		String contents[][] = {
				{"학생1", "100", "86", "74"},
				{"학생2", "98", "79", "94"},
				{"학생3", "88", "84", "68"}
		};
		
		model = new DefaultTableModel(contents, header);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		panel_main.add(scrollPane);
			
		nameTf = new JTextField(5); panel_input.add(nameTf);
		koreanTf = new JTextField(3); panel_input.add(koreanTf);
		mathTf = new JTextField(3); panel_input.add(mathTf);
		englishTf = new JTextField(3); panel_input.add(englishTf);
		
		btnAdd = new JButton("추가"); panel_input.add(btnAdd);
		btnAdd.addActionListener(actionHandler);
		
		btnCancel = new JButton("취소"); panel_input.add(btnCancel);
		btnCancel.addActionListener(actionHandler);
		
		add(panel_main, BorderLayout.CENTER);
		add(panel_input, BorderLayout.SOUTH);
	}
	public void input() {
		String input[] = new String[4];
		
		input[0] = nameTf.getText();
		input[1] = koreanTf.getText();
		input[2] = mathTf.getText();
		input[3] = englishTf.getText();
		
		model.addRow(input);
		
		nameTf.setText("");
		koreanTf.setText("");
		mathTf.setText("");
		englishTf.setText("");
	}
	public void cancel() {
		model.removeRow(table.getSelectedRow());
	}
	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String action = e.getActionCommand();
			
			if(action.equals("추가")) input();
			else if(action.equals("취소")) cancel();
		}
		
	}
}
