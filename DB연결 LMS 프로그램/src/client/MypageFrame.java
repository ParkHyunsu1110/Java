package client;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MypageFrame extends JFrame {

	private JTabbedPane tab;
	private JPanel panel_one, panel_two, panel_three;
	private BasketPanel basketPanel;
	private BasketPanel resultPanel;
	private DayTimeTableViewer timetable;
	private MouseListener mouse;

	public MypageFrame(String userId, Session session) {
		super("마이페이지");

		this.mouse = new MouseListener();
		this.tab = new JTabbedPane(JTabbedPane.TOP);

		this.panel_one = new JPanel();
		this.panel_two = new JPanel();
		this.panel_three = new JPanel();

		this.basketPanel = new BasketPanel(session, null);
		this.panel_one.add(this.basketPanel);

		this.resultPanel = new BasketPanel(session, null);
		this.panel_two.add(this.resultPanel);
		
		this.timetable = new DayTimeTableViewer();
		this.panel_three.add(this.timetable);
		
		JLabel label_everytime = new JLabel(new ImageIcon("img/everytime.jpg"));
		label_everytime.addMouseListener(this.mouse);
		label_everytime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.panel_three.add(label_everytime);
		
		JLabel label_everytime_txt = new JLabel("  https://everytime.kr/");
		label_everytime_txt.addMouseListener(this.mouse);
		label_everytime_txt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_everytime_txt.setFont(new Font("DX피오피", Font.BOLD, 45
				));
		this.panel_three.add(label_everytime_txt);

		this.tab.addTab("책가방 내역", panel_one);
		this.tab.addTab("수강신청 내역", panel_two);
		this.tab.addTab("나의 시간표", panel_three);

		getContentPane().add(tab, BorderLayout.CENTER);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/mju_title.jpg");
		this.setIconImage(img);
		setSize(850, 800);
		initialize(userId);
	}

	public void initialize(String ID) {
		this.basketPanel.initialize(ID, "basket");
		this.resultPanel.initialize(ID, "result");
	}
	
	private class MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://everytime.kr/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
}
