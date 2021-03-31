package java_2020_11_30_4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GToolBar extends JToolBar {
	private GDrawingPanel drawingPanel;
	private JButton rectangleButton, ellipseButton, lineButton;
	public GToolBar() {	
		ActionHandler action = new ActionHandler();
		
		this.rectangleButton = new JButton( "네모" );
		this.rectangleButton.addActionListener(action);
		this.add(this.rectangleButton);
		
		this.ellipseButton = new JButton("원");
		this.ellipseButton.addActionListener(action);
		this.add(this.ellipseButton);
		
		this.lineButton = new JButton( "선" );
		this.lineButton.addActionListener(action);
		this.add(this.lineButton);
	}
	public void setAssociation( GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}
	public class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			drawingPanel.setCurrentTool(e.getActionCommand());
		}
		
	}
}
