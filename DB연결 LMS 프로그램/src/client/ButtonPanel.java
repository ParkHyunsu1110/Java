package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import global.Buttons;
import global.Constants.EButton;

public class ButtonPanel extends JPanel {
	private JPanel panel_abata, panel_mju;
	private JLabel label_abata, label_empty, mju_tree;
	private String icon;
	Actionchange actionchange;
	private Icon abata_icon;
	private int count = 0;
	Buttons btn_logout, btn_inform, btn_mypage, btn_grade, btn_check, btn_change;
	
	public ButtonPanel(JLabel label_name, ActionListener logoutAction, ActionListener buttonHandler, String userId) {
		this.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));

		this.actionchange = new Actionchange();
		this.panel_abata = new JPanel();
		this.panel_abata.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		this.icon = "img/human_7.jpg";
		this.abata_icon = new ImageIcon(icon);
		this.label_abata = new JLabel();
		this.label_abata.setIcon(this.abata_icon);
		this.btn_change = new Buttons(this.actionchange, EButton.Change.getString());
		this.label_abata.setToolTipText(userId + "님");
		this.panel_abata.add(this.label_abata);
		this.panel_abata.add(this.btn_change);
		this.add(this.panel_abata);
		this.label_empty = new JLabel("     ");
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(label_name);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		
        this.btn_logout = new Buttons(buttonHandler, EButton.Logout.getString());
        this.btn_inform = new Buttons(buttonHandler, EButton.Inform.getString());
        this.btn_mypage = new Buttons(buttonHandler, EButton.Mypage.getString());
        this.btn_grade = new Buttons(buttonHandler, EButton.Grade.getString());
        this.btn_check = new Buttons(buttonHandler, EButton.Check.getString());
		
		ArrayList<JButton> btnNewButton_Right = new ArrayList<JButton>();
		btnNewButton_Right.add(btn_logout);
		btnNewButton_Right.add(btn_inform);
		btnNewButton_Right.add(btn_mypage);
		btnNewButton_Right.add(btn_grade);
		btnNewButton_Right.add(btn_check);
		btnNewButton_Right.add(new JButton());
		btnNewButton_Right.add(new JButton());

		for (int i = 0; i < btnNewButton_Right.size()-2; i++) {
			this.add(btnNewButton_Right.get(i));
			this.add(Box.createRigidArea(new Dimension(0,10)));
		}
		this.label_empty.setPreferredSize(new Dimension(0,60));
		this.add(this.label_empty);
		for (int i = btnNewButton_Right.size()-2; i < btnNewButton_Right.size(); i++) {
			btnNewButton_Right.get(i).addActionListener(buttonHandler);
			if(i == 5) {
				Icon omoke = new ImageIcon("img/omoke.jpg");
				btnNewButton_Right.get(5).setIcon(omoke);
				btnNewButton_Right.get(5).setActionCommand("오목게임");
			}else if(i == 6) {
				Icon hangman = new ImageIcon("img/hangman.jpg");
				btnNewButton_Right.get(6).setIcon(hangman);
				btnNewButton_Right.get(6).setActionCommand("행맨게임");
			}
			btnNewButton_Right.get(i).setPreferredSize(new Dimension(80,50));
			this.add(btnNewButton_Right.get(i));
		}		
		
		JLabel empty = new JLabel("   ");
		empty.setPreferredSize(new Dimension(50,25));
		this.add(empty);
		
		this.panel_mju = new JPanel();
		this.panel_mju.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		Icon mju_tree = new ImageIcon("img/mju_tree.jpg");
		this.mju_tree = new JLabel(mju_tree);
		this.mju_tree.setToolTipText("명지대학교");
		this.panel_mju.add(this.mju_tree);
		this.add(this.panel_mju);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	class Actionchange implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			abata_icon = new ImageIcon("img/human_" + count + ".jpg");
			count = count+1;
			label_abata.setIcon(abata_icon);
			if(count == 8) {
				count = 0;
			}
		}
	}	
}