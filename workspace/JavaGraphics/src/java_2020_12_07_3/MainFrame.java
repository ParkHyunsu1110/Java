package java_2020_12_07_3;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private GToolBar toolBar;
	 private GDrawingPanel drawingPanel;
	 
	 public MainFrame() {
	  this.setSize(500, 500);
	  this.setLayout(new BorderLayout());
	  
	  this.toolBar = new GToolBar();
	  this.add(this.toolBar, BorderLayout.NORTH);
	  
	  this.drawingPanel = new GDrawingPanel();
	  this.add(this.drawingPanel, BorderLayout.CENTER);
	  
	  this.toolBar.setAssociation( this.drawingPanel );
	 }
}
