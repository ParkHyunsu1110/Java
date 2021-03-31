package global;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Buttons extends JButton {
	
	public Color color = new Color(1,41,102);
	private int count = 0;
	
	public Buttons(ActionListener buttonHandler, String txt) {
		this.addActionListener(buttonHandler);
		this.setText(txt);
		this.setHorizontalAlignment(this.CENTER);
		decorate();
	}
 
    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
    }

	@Override
	protected void paintComponent(Graphics g) {
	    int width = getWidth();
	    int height = getHeight();
	 
	    Graphics2D graphics = (Graphics2D) g;
	 
	    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    
	    if (getModel().isArmed()) {
	        graphics.setColor(color.darker());
	    } else if (getModel().isRollover()) {
	        graphics.setColor(color.brighter());
	    } else {
	        graphics.setColor(color);
	    }
	 
	    graphics.fillRoundRect(0, 0, width, height, 10, 10);
	 
	    FontMetrics fontMetrics = graphics.getFontMetrics();
	    Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
	 
	    int textX = (width - stringBounds.width) / 2;
	    int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
	 
	    graphics.setColor(Color.WHITE);
	    graphics.setFont(new Font("DXÇÇ¿ÀÇÇ", Font.BOLD, 15));
	    graphics.drawString(getText(), textX, textY);
	    graphics.dispose();
	 
	    super.paintComponent(g);
	}
}
