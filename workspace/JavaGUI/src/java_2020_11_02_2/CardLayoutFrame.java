package java_2020_11_02_2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutFrame extends JFrame {
	JPanel panel_main, card1, card2, card3;
	CardLayout card = new CardLayout();
	Handler handler;
	public CardLayoutFrame() {
		this.setSize(500, 500);
		handler = new Handler();
		
		panel_main = new JPanel();
		panel_main.setLayout(card);
		panel_main.addMouseListener(handler);
		
		card1 = new JPanel();
		card1.setBackground(Color.lightGray);
		card1.add(new JLabel("Card 1"));
		panel_main.add(card1);
		
		card2 = new JPanel();
		card2.setBackground(Color.orange);
		card2.add(new JLabel("Card 2"));
		panel_main.add(card2);
		
		card3 = new JPanel();
		card3.setBackground(Color.cyan);
		card3.add(new JLabel("Card 3"));
		panel_main.add(card3);
		
		this.add(panel_main);
	}
	private class Handler extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			card.next(panel_main);
		}
	}
}
