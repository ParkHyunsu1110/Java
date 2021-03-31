package java_2020_12_07_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class GToolBar extends JToolBar {
	private GDrawingPanel drawingPanel;
	private JButton curvButton;
	private JButton redButton, yellowButton, blueButton, blackButton, whiteButton;
	public GToolBar() {
		ActionHandler action = new ActionHandler();
		
		this.curvButton = new JButton("°î¼±");
		this.curvButton.addActionListener(action);
		this.add(this.curvButton);
		
		ColorHandler color = new ColorHandler();
		
		this.redButton = new JButton("»¡°­");
		this.redButton.setBackground(Color.RED);
		this.redButton.addActionListener(color);
		this.add(this.redButton);
		
		this.yellowButton = new JButton("³ë¶û");
		this.yellowButton.setBackground(Color.YELLOW);
		this.yellowButton.addActionListener(color);
		this.add(this.yellowButton);
		
		this.blueButton = new JButton("ÆÄ¶û");
		this.blueButton.setBackground(Color.BLUE);
		this.blueButton.addActionListener(color);
		this.add(this.blueButton);
		
		this.blackButton = new JButton("°ËÁ¤");
		this.blackButton.setBackground(Color.BLACK);
		this.blackButton.addActionListener(color);
		this.add(this.blackButton);
		
		this.whiteButton = new JButton("ÇÏ¾ç");
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
