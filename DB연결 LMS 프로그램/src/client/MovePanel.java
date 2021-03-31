package client;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import global.Buttons;
import global.Constants.EMovePanel;

public class MovePanel extends JPanel {
	private static final long serialVersionUID = EMovePanel.serialVersionUID.getInt();
	Buttons btn_left, btn_right;
	public Buttons getLeftButton() {
		return btn_left;
	}
	public Buttons getRightButton() {
		return btn_right;
	}
	
	public MovePanel(ActionListener actionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.btn_left = new Buttons(actionHandler, EMovePanel.Left.getString());
		this.btn_left.setActionCommand(EMovePanel.LeftButton.getString());
		this.add(this.btn_left);
		
		this.add(Box.createRigidArea(new Dimension(0,10)));
		
		this.btn_right = new Buttons(actionHandler, EMovePanel.Right.getString());
		this.btn_right.setActionCommand(EMovePanel.RightButton.getString());
		this.add(this.btn_right);
	}
	public void initialize() {
		
	}
}
