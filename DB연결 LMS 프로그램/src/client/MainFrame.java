package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import client.MainClient.JFrameWindowClosingEventHandler;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel_main;
	private JButton btnLogin;
	private JLabel label_icon, label_txt;
	private MainPanel mainPanel;
	MyActionListener_itn myaction_itn;
	MyActionListener_ln myaction_ln;
	MyActionListener_bg myaction_bg;
	MyActionListener_ft myaction_ft;
	MouseListener mouseListener;
	private String itnmenu[] = {"³×ÀÌ¹ö", "´ÙÀ½", "±¸±Û"};
	private JMenuItem itnMenuItem[] = new JMenuItem[3];
	private String lnmenu[] = {"ÇÏ¾á»ö", "°ËÁ¤»ö", "»¡°£»ö", "ÁÖÈ²»ö", "³ë¶õ»ö", "ÆÄ¶õ»ö", "¼Ò¶ó»ö", "ÃÊ·Ï»ö", "ºÐÈ«»ö", "º¸¶ó»ö", "È¸»ö", "¿¬ÇÑ È¸»ö", "¿ø·¡´ë·Î"}; 
	private JMenuItem lnMenuItem[] = new JMenuItem[13];
	private String bgmenu[] = {"ÇÏ¾á»ö", "°ËÁ¤»ö", "»¡°£»ö", "ÁÖÈ²»ö", "³ë¶õ»ö", "ÆÄ¶õ»ö", "¼Ò¶ó»ö", "ÃÊ·Ï»ö", "ºÐÈ«»ö", "º¸¶ó»ö", "È¸»ö", "¿¬ÇÑ È¸»ö", "¿ø·¡´ë·Î"}; 
	private JMenuItem bgMenuItem[] = new JMenuItem[13];
	private String ftmenu[] = {"¸¼Àº °íµñ", "ÇÑÄÄ °íµñ", "±Ã¼­", "±¼¸²", "Å¸ÀÌÆ÷_°¡½¿ÀÌÄá´Ú B", "Å¸ÀÌÆ÷_½ºÅ¸ÀÏÂ¯ B", "Å¸ÀÌÆ÷_°õÀÌ¶ûÅä³¢¶û B", "Serif", "¿ø·¡´ë·Î"};
	private JMenuItem ftMenuItem[] = new JMenuItem[9];
	private boolean now_State = true;
	private String userId;

	public MainFrame(Session session, ActionListener logoutAction, ActionListener buttonHandler, String userId, JFrameWindowClosingEventHandler windowEvent) {
		super("¸íÁö´ëÇÐ±³ ¼ö°­½ÅÃ»");
		this.myaction_itn = new MyActionListener_itn();
		this.myaction_ln = new MyActionListener_ln();
		this.myaction_bg = new MyActionListener_bg();
		this.myaction_ft = new MyActionListener_ft();
		this.mouseListener = new MouseListener();
		this.mainPanel = new MainPanel(session, logoutAction, buttonHandler, userId);
		this.userId = userId;
		this.addWindowListener(windowEvent);

		BorderLayout layout = new BorderLayout(5,5);

		JMenuBar mb = new JMenuBar(); 
		JMenu internetMenu = new JMenu("ÀÎÅÍ³Ý(I)");
		internetMenu.setMnemonic(KeyEvent.VK_I);
		for(int i=0; i<this.itnMenuItem.length; i++) {
			this.itnMenuItem[i] = new JMenuItem(this.itnmenu[i]);
			this.itnMenuItem[i].addActionListener(this.myaction_itn);
			internetMenu.add(this.itnMenuItem[i]);
		}

		JMenu lineMenu = new JMenu("Å×µÎ¸®(L)");
		lineMenu.setMnemonic(KeyEvent.VK_L);
		for(int i=0; i<this.lnMenuItem.length-1; i++) {
			this.lnMenuItem[i] = new JMenuItem(this.lnmenu[i]);
			this.lnMenuItem[i].addActionListener(this.myaction_ln);
			lineMenu.add(this.lnMenuItem[i]);
		}
		lineMenu.addSeparator();
		this.lnMenuItem[12] = new JMenuItem(this.lnmenu[12]);
		this.lnMenuItem[12].addActionListener(this.myaction_ln);
		this.lnMenuItem[12].setAccelerator(KeyStroke.getKeyStroke('L', Event.CTRL_MASK));
		lineMenu.add(this.lnMenuItem[12]);

		JMenu backgroundMenu = new JMenu("¹è°æ(B)");
		backgroundMenu.setMnemonic(KeyEvent.VK_B);
		for(int i=0; i<this.bgMenuItem.length-1; i++) {
			this.bgMenuItem[i] = new JMenuItem(this.bgmenu[i]);
			this.bgMenuItem[i].addActionListener(this.myaction_bg);
			backgroundMenu.add(this.bgMenuItem[i]);
		}
		backgroundMenu.addSeparator();
		this.bgMenuItem[12] = new JMenuItem(this.bgmenu[12]);
		this.bgMenuItem[12].addActionListener(this.myaction_bg);
		this.bgMenuItem[12].setAccelerator(KeyStroke.getKeyStroke('B', Event.CTRL_MASK));
		backgroundMenu.add(this.bgMenuItem[12]);

		JMenu fontMenu = new JMenu("ÆùÆ®(F)");
		fontMenu.setMnemonic(KeyEvent.VK_F);
		for(int i=0; i<this.ftMenuItem.length-1; i++) {
			this.ftMenuItem[i] = new JMenuItem(this.ftmenu[i]);
			this.ftMenuItem[i].addActionListener(this.myaction_ft);
			fontMenu.add(this.ftMenuItem[i]);
		}
		fontMenu.addSeparator();
		this.ftMenuItem[8] = new JMenuItem(this.ftmenu[8]);
		this.ftMenuItem[8].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.VK_F));
		this.ftMenuItem[8].addActionListener(this.myaction_ft);
		this.ftMenuItem[8].setAccelerator(KeyStroke.getKeyStroke('F', Event.CTRL_MASK));
		fontMenu.add(this.ftMenuItem[8]);

		mb.add(internetMenu);
		mb.add(lineMenu);
		mb.add(backgroundMenu);
		mb.add(fontMenu);
		setJMenuBar(mb);

		this.panel_main = new JPanel();
		this.panel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.panel_main);
		this.panel_main.setLayout(layout);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/mju_title.jpg");
		this.setIconImage(img);
		this.setSize(1620, 760);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		place_mainpage(panel_main, logoutAction, buttonHandler);

		this.add(this.mainPanel, BorderLayout.CENTER);
	}	

	public void place_mainpage(JPanel content_panel, ActionListener logoutAction, ActionListener buttonHandler) {
		JPanel panel_title = new JPanel();
		panel_title.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		panel_title.setBackground(Color.cyan);

		Icon mju_icon = new ImageIcon("img/mju_main.jpg");
		this.label_icon = new JLabel(mju_icon);
		this.label_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.label_icon.addMouseListener(this.mouseListener);
		this.label_txt = new JLabel("¸íÁö´ëÇÐ±³ ");	
		this.label_txt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.label_txt.setFont(new Font("DXÇÇ¿ÀÇÇ", Font.BOLD, 45));
		this.label_txt.addMouseListener(this.mouseListener);

		EtchedBorder eborder = new EtchedBorder();
		this.label_icon.setBorder(eborder);
		this.label_icon.setToolTipText("¸íÁö´ëÇÐ±³");

		panel_title.add(this.label_icon, BorderLayout.CENTER);
		panel_title.add(this.label_txt);

		content_panel.add(panel_title, BorderLayout.NORTH);
	}
	public void Login() {
		if(!now_State) {
			this.btnLogin.setText("·Î±×ÀÎ");
		}else {
			btnLogin.setText("·Î±×¾Æ¿ô");
		}
	}
	public void initialize(String ID) {
		this.mainPanel.initialize(ID);
	}
	public void finish(String ID) throws IOException {
		this.mainPanel.finish(ID);
	}
	private class MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("http://www.mju.ac.kr"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
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
	private class MyActionListener_itn implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			try {
				if(item==itnMenuItem[0]){

					Desktop.getDesktop().browse(new URI("https://www.naver.com"));

				} else if(item==itnMenuItem[1]){
					Desktop.getDesktop().browse(new URI("https://www.daum.net"));
				} else if(item==itnMenuItem[2]){
					Desktop.getDesktop().browse(new URI("https://www.google.com"));
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class MyActionListener_ln implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			if(item==lnMenuItem[0]){
				panel_main.setBackground(Color.WHITE);
			} else if(item==lnMenuItem[1]){
				panel_main.setBackground(Color.BLACK);
			} else if(item==lnMenuItem[2]){
				panel_main.setBackground(Color.RED);
			} else if(item==lnMenuItem[3]){
				panel_main.setBackground(Color.ORANGE);
			}  else if(item==lnMenuItem[4]){
				panel_main.setBackground(Color.YELLOW);
			}  else if(item==lnMenuItem[5]){
				panel_main.setBackground(Color.BLUE);
			}  else if(item==lnMenuItem[6]){
				panel_main.setBackground(Color.CYAN);
			}  else if(item==lnMenuItem[7]){
				panel_main.setBackground(Color.GREEN);
			}  else if(item==lnMenuItem[8]){
				panel_main.setBackground(Color.PINK);
			}  else if(item==lnMenuItem[9]){
				panel_main.setBackground(Color.magenta);
			}  else if(item==lnMenuItem[10]){
				panel_main.setBackground(Color.GRAY);
			}  else if(item==lnMenuItem[11]){
				panel_main.setBackground(Color.LIGHT_GRAY);
			}  else if(item==lnMenuItem[12]){
				panel_main.setBackground(null);
			}
		}
	}
	private class MyActionListener_bg implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			if(item==bgMenuItem[0]){
				panel_main.setBackground(Color.WHITE);
				mainPanel.setBackground(Color.WHITE);
				mainPanel.panel_basket.setBackground(Color.WHITE);
				mainPanel.panel_result.setBackground(Color.WHITE);
				mainPanel.panel_button.setBackground(Color.WHITE);
			} else if(item==bgMenuItem[1]){
				panel_main.setBackground(Color.BLACK);
				mainPanel.setBackground(Color.BLACK);
				mainPanel.panel_basket.setBackground(Color.BLACK);
				mainPanel.panel_result.setBackground(Color.BLACK);
				mainPanel.panel_button.setBackground(Color.BLACK);
			} else if(item==bgMenuItem[2]){
				panel_main.setBackground(Color.RED);
				mainPanel.setBackground(Color.RED);
				mainPanel.panel_basket.setBackground(Color.RED);
				mainPanel.panel_result.setBackground(Color.RED);
				mainPanel.panel_button.setBackground(Color.RED);
			} else if(item==bgMenuItem[3]){
				panel_main.setBackground(Color.ORANGE);
				mainPanel.setBackground(Color.ORANGE);
				mainPanel.panel_basket.setBackground(Color.ORANGE);
				mainPanel.panel_result.setBackground(Color.ORANGE);
				mainPanel.panel_button.setBackground(Color.ORANGE);
			}  else if(item==bgMenuItem[4]){
				panel_main.setBackground(Color.YELLOW);
				mainPanel.setBackground(Color.YELLOW);
				mainPanel.panel_basket.setBackground(Color.YELLOW);
				mainPanel.panel_result.setBackground(Color.YELLOW);
				mainPanel.panel_button.setBackground(Color.YELLOW);
			}  else if(item==bgMenuItem[5]){
				panel_main.setBackground(Color.BLUE);
				mainPanel.setBackground(Color.BLUE);
				mainPanel.panel_basket.setBackground(Color.BLUE);
				mainPanel.panel_result.setBackground(Color.BLUE);
				mainPanel.panel_button.setBackground(Color.BLUE);
			}  else if(item==bgMenuItem[6]){
				panel_main.setBackground(Color.CYAN);
				mainPanel.setBackground(Color.CYAN);
				mainPanel.panel_basket.setBackground(Color.CYAN);
				mainPanel.panel_result.setBackground(Color.CYAN);
				mainPanel.panel_button.setBackground(Color.CYAN);
			}  else if(item==bgMenuItem[7]){
				panel_main.setBackground(Color.GREEN);
				mainPanel.setBackground(Color.GREEN);
				mainPanel.panel_basket.setBackground(Color.GREEN);
				mainPanel.panel_result.setBackground(Color.GREEN);
				mainPanel.panel_button.setBackground(Color.GREEN);
			}  else if(item==bgMenuItem[8]){
				panel_main.setBackground(Color.PINK);
				mainPanel.setBackground(Color.PINK);
				mainPanel.panel_basket.setBackground(Color.PINK);
				mainPanel.panel_result.setBackground(Color.PINK);
				mainPanel.panel_button.setBackground(Color.PINK);
			}  else if(item==bgMenuItem[9]){
				panel_main.setBackground(Color.MAGENTA);
				mainPanel.setBackground(Color.MAGENTA);
				mainPanel.panel_basket.setBackground(Color.MAGENTA);
				mainPanel.panel_result.setBackground(Color.MAGENTA);
				mainPanel.panel_button.setBackground(Color.MAGENTA);
			}  else if(item==bgMenuItem[10]){
				panel_main.setBackground(Color.GRAY);
				mainPanel.setBackground(Color.GRAY);
				mainPanel.panel_basket.setBackground(Color.GRAY);
				mainPanel.panel_result.setBackground(Color.GRAY);
				mainPanel.panel_button.setBackground(Color.GRAY);
			}  else if(item==bgMenuItem[11]){
				panel_main.setBackground(Color.LIGHT_GRAY);
				mainPanel.setBackground(Color.LIGHT_GRAY);
				mainPanel.panel_basket.setBackground(Color.LIGHT_GRAY);
				mainPanel.panel_result.setBackground(Color.LIGHT_GRAY);
				mainPanel.panel_button.setBackground(Color.LIGHT_GRAY);
			}  else if(item==bgMenuItem[12]){
				panel_main.setBackground(null);
				mainPanel.setBackground(null);
				mainPanel.panel_basket.setBackground(null);
				mainPanel.panel_result.setBackground(null);
				mainPanel.panel_button.setBackground(null);
			}
		}
	}

	private class MyActionListener_ft implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			if(item==ftMenuItem[0]){
				label_txt.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 45));
				mainPanel.label_basket.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
				mainPanel.label_result.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
				mainPanel.label_credit_basket.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
				mainPanel.label_credit_result.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
				mainPanel.label_name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			} 
			else if(item==ftMenuItem[1]){
				label_txt.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 45));
				mainPanel.label_basket.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 20));
				mainPanel.label_result.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 20));
				mainPanel.label_credit_basket.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 15));
				mainPanel.label_credit_result.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 15));
				mainPanel.label_name.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 15));
			} 
			else if(item==ftMenuItem[2]){
				label_txt.setFont(new Font("±Ã¼­", Font.BOLD, 45));
				mainPanel.label_basket.setFont(new Font("±Ã¼­", Font.BOLD, 20));
				mainPanel.label_result.setFont(new Font("±Ã¼­", Font.BOLD, 20));
				mainPanel.label_credit_basket.setFont(new Font("±Ã¼­", Font.BOLD, 15));
				mainPanel.label_credit_result.setFont(new Font("±Ã¼­", Font.BOLD, 15));
				mainPanel.label_name.setFont(new Font("±Ã¼­", Font.BOLD, 15));
			} 
			else if(item==ftMenuItem[3]){
				label_txt.setFont(new Font("±¼¸²", Font.BOLD, 45));
				mainPanel.label_basket.setFont(new Font("±¼¸²", Font.BOLD, 20));
				mainPanel.label_result.setFont(new Font("±¼¸²", Font.BOLD, 20));
				mainPanel.label_credit_basket.setFont(new Font("±¼¸²", Font.BOLD, 15));
				mainPanel.label_credit_result.setFont(new Font("±¼¸²", Font.BOLD, 15));
				mainPanel.label_name.setFont(new Font("±¼¸²", Font.BOLD, 15));
			}  
			else if(item==ftMenuItem[4]){
				label_txt.setFont(new Font("Å¸ÀÌÆ÷_°¡½¿ÀÌÄá´Ú B", Font.BOLD, 45));
				mainPanel.label_basket.setFont(new Font("Å¸ÀÌÆ÷_°¡½¿ÀÌÄá´Ú B", Font.BOLD, 20));
				mainPanel.label_result.setFont(new Font("Å¸ÀÌÆ÷_°¡½¿ÀÌÄá´Ú B", Font.BOLD, 20));
				mainPanel.label_credit_basket.setFont(new Font("Å¸ÀÌÆ÷_°¡½¿ÀÌÄá´Ú B", Font.BOLD, 15));
				mainPanel.label_credit_result.setFont(new Font("Å¸ÀÌÆ÷_°¡½¿ÀÌÄá´Ú B", Font.BOLD, 15));
				mainPanel.label_name.setFont(new Font("Å¸ÀÌÆ÷_°¡½¿ÀÌÄá´Ú B", Font.BOLD, 15));
			}  
			else if(item==ftMenuItem[5]){
				label_txt.setFont(new Font("Å¸ÀÌÆ÷_½ºÅ¸ÀÏÂ¯ B", Font.BOLD, 45));
				mainPanel.label_basket.setFont(new Font("Å¸ÀÌÆ÷_½ºÅ¸ÀÏÂ¯ B", Font.BOLD, 20));
				mainPanel.label_result.setFont(new Font("Å¸ÀÌÆ÷_½ºÅ¸ÀÏÂ¯ B", Font.BOLD, 20));
				mainPanel.label_credit_basket.setFont(new Font("Å¸ÀÌÆ÷_½ºÅ¸ÀÏÂ¯ B", Font.BOLD, 15));
				mainPanel.label_credit_result.setFont(new Font("Å¸ÀÌÆ÷_½ºÅ¸ÀÏÂ¯ B", Font.BOLD, 15));
				mainPanel.label_name.setFont(new Font("Å¸ÀÌÆ÷_½ºÅ¸ÀÏÂ¯ B", Font.BOLD, 15));
			}  
			else if(item==ftMenuItem[6]){
				label_txt.setFont(new Font("Å¸ÀÌÆ÷_°õÀÌ¶ûÅä³¢¶û B", Font.BOLD, 45));
				mainPanel.label_basket.setFont(new Font("Å¸ÀÌÆ÷_°õÀÌ¶ûÅä³¢¶û B", Font.BOLD, 20));
				mainPanel.label_result.setFont(new Font("Å¸ÀÌÆ÷_°õÀÌ¶ûÅä³¢¶û B", Font.BOLD, 20));
				mainPanel.label_credit_basket.setFont(new Font("Å¸ÀÌÆ÷_°õÀÌ¶ûÅä³¢¶û B", Font.BOLD, 15));
				mainPanel.label_credit_result.setFont(new Font("Å¸ÀÌÆ÷_°õÀÌ¶ûÅä³¢¶û B", Font.BOLD, 15));
				mainPanel.label_name.setFont(new Font("Å¸ÀÌÆ÷_°õÀÌ¶ûÅä³¢¶û B", Font.BOLD, 15));
			}  
			else if(item==ftMenuItem[7]){
				label_txt.setFont(new Font("Serif", Font.BOLD, 45));
				mainPanel.label_basket.setFont(new Font("Serif", Font.BOLD, 20));
				mainPanel.label_result.setFont(new Font("Serif", Font.BOLD, 20));
				mainPanel.label_credit_basket.setFont(new Font("Serif", Font.BOLD, 15));
				mainPanel.label_credit_result.setFont(new Font("Serif", Font.BOLD, 15));
				mainPanel.label_name.setFont(new Font("Serif", Font.BOLD, 15));
			}  
			else if(item==ftMenuItem[8]){
				label_txt.setFont(new Font("DXÇÇ¿ÀÇÇ", Font.BOLD, 45));
				mainPanel.label_basket.setFont(new Font("DXÇÇ¿ÀÇÇ", Font.BOLD, 20));
				mainPanel.label_result.setFont(new Font("DXÇÇ¿ÀÇÇ", Font.BOLD, 20));
				mainPanel.label_credit_basket.setFont(new Font("DXÇÇ¿ÀÇÇ", Font.BOLD, 15));
				mainPanel.label_credit_result.setFont(new Font("DXÇÇ¿ÀÇÇ", Font.BOLD, 15));
				mainPanel.label_name.setFont(new Font("DXÇÇ¿ÀÇÇ", Font.BOLD, 15));
			}
		}
	}
}
