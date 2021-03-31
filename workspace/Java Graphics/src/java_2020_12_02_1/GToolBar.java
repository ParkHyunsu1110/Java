package java_2020_12_02_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GToolBar extends JToolBar {
	private GDrawingPanel drawingPanel;
	private JButton rectangleButton, ellipseButton, lineButton;
	private JButton redButton, yellowButton, blueButton, blackButton, whiteButton;
	public GToolBar() {
		ActionHandler action = new ActionHandler();
		
		this.rectangleButton = new JButton("�׸�");
		this.rectangleButton.addActionListener(action);
		this.add(this.rectangleButton);
		
		this.ellipseButton = new JButton("��");
		this.ellipseButton.addActionListener(action);
		this.add(this.ellipseButton);
		
		this.lineButton = new JButton("��");
		this.lineButton.addActionListener(action);
		this.add(this.lineButton);
		
		ColorHandler color = new ColorHandler();
		
		this.redButton = new JButton("����");
		this.redButton.setBackground(Color.RED);
		this.redButton.addActionListener(color);
		this.add(this.redButton);
		
		this.yellowButton = new JButton("���");
		this.yellowButton.setBackground(Color.YELLOW);
		this.yellowButton.addActionListener(color);
		this.add(this.yellowButton);
		
		this.blueButton = new JButton("�Ķ�");
		this.blueButton.setBackground(Color.BLUE);
		this.blueButton.addActionListener(color);
		this.add(this.blueButton);
		
		this.blackButton = new JButton("����");
		this.blackButton.setBackground(Color.BLACK);
		this.blackButton.addActionListener(color);
		this.add(this.blackButton);
		
		this.whiteButton = new JButton("�Ͼ�");
		this.whiteButton.setBackground(Color.WHITE);
		this.whiteButton.addActionListener(color);
		this.add(this.whiteButton);
	}
	public void setAssociation(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}
	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			drawingPanel.setCurrentTool(e.getActionCommand());
		}
		
	}
	public class ColorHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			drawingPanel.setCurrentColor(e.getActionCommand());
		}		
	}
}
