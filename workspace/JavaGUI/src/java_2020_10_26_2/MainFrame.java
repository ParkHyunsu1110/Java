package java_2020_10_26_2;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1;
	
	String[] fruits = {"apple", "banana", "orange", "kiwi", "mango",
			"peach", "strawberry", "watermelon", "cherry"};
	
	JPanel panel;
	JList list;
	JLabel label;
	Icon img;
	ListSelectionHandler listSelectionHandler;
	
	public MainFrame() {
		this.listSelectionHandler = new ListSelectionHandler();
		this.setSize(400, 600);
		
		this.panel = new JPanel();
		this.list = new JList(fruits);
		this.list.addListSelectionListener(this.listSelectionHandler);
		this.panel.add(this.list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.list);
		scrollPane.setPreferredSize(new Dimension(100, 100));
		this.panel.add(scrollPane);
		
		this.img = new ImageIcon("data/apple.jpg");
		this.label = new JLabel();
		this.label.setIcon(this.img);
		this.panel.add(this.label);
		
		this.add(this.panel);	
		this.list.setSelectedIndex(0);
	}
	private class ListSelectionHandler implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			String name = (String) list.getSelectedValue();
			img = new ImageIcon("data/" + name + ".jpg");
			label.setIcon(img);
		}
		
	}
}
