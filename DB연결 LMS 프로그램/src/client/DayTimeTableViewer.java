package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class DayTimeTableViewer extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel jPanelTop = null;
	private JPanel jPanelLeft = null;
	private DaySchedulePanel jPanelCenter = null;

	private int width = 6;
	private int startY = 0;
	private int endY = 20;


	public DayTimeTableViewer() {
		initialize();
	}

	private void initialize() {
		GridBagConstraints gridBagConstraintscenter = new GridBagConstraints();
		gridBagConstraintscenter.gridx = 1;
		gridBagConstraintscenter.weightx = this.width;
		gridBagConstraintscenter.fill = 0;
		gridBagConstraintscenter.weighty = this.endY;
		gridBagConstraintscenter.ipadx = 0;
		gridBagConstraintscenter.ipady = 0;
		gridBagConstraintscenter.anchor = 18;
		gridBagConstraintscenter.gridy = 1;
		GridBagConstraints gridBagConstraintsTop = new GridBagConstraints();
		gridBagConstraintsTop.gridx = 1;
		gridBagConstraintsTop.gridwidth = 1;
		gridBagConstraintsTop.weightx = this.width;
		gridBagConstraintsTop.fill = 0;
		gridBagConstraintsTop.weighty = 1.0D;
		gridBagConstraintsTop.insets = new Insets(0, 0, 0, 0);
		gridBagConstraintsTop.anchor = 16;
		gridBagConstraintsTop.gridy = 0;
		GridBagConstraints gridBagConstraintsLeft = new GridBagConstraints();
		gridBagConstraintsLeft.gridx = 0;
		gridBagConstraintsLeft.weightx = 1.0D;
		gridBagConstraintsLeft.weighty = this.endY;
		gridBagConstraintsLeft.fill = 0;
		gridBagConstraintsLeft.anchor = 12;
		gridBagConstraintsLeft.gridy = 1;

		setLayout(new GridBagLayout());
		add(getJPanelLeft(), gridBagConstraintsLeft);
		add(getJPanelTop(), gridBagConstraintsTop);
		add(getJPanelCenter(), gridBagConstraintscenter);
	}

	private JPanel getJPanelTop() {
		if (this.jPanelTop == null) {
			this.jPanelTop = new TopPanel(this.width);
		}
		return this.jPanelTop;
	}

	private JPanel getJPanelLeft() {
		if (this.jPanelLeft == null) {
			this.jPanelLeft = new LeftPanel(this.startY, this.endY);
		}
		return this.jPanelLeft;
	}

	private DaySchedulePanel getJPanelCenter() {
		if (this.jPanelCenter == null) {
			this.jPanelCenter = new DaySchedulePanel(this.width, this.startY, this.endY);
//			this.jPanelCenter.setDatas(this.datas)
		}
		return this.jPanelCenter;
	}
	static class LeftPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public LeftPanel(int ys, int ye) {
			setLayout(new GridBagLayout());
			for (int i = ys; i < ye; i += 2) {
				GridBagConstraints gridBagConstraintsOrder = new GridBagConstraints();
				gridBagConstraintsOrder.gridx = 0;
				gridBagConstraintsOrder.gridy = (i - ys);
				gridBagConstraintsOrder.gridheight = 2;
				GridBagConstraints gridBagConstraintsT00 = new GridBagConstraints();
				gridBagConstraintsT00.gridx = 1;
				gridBagConstraintsT00.gridy = (i - ys);

				GridBagConstraints gridBagConstraintsT30 = new GridBagConstraints();
				gridBagConstraintsT30.gridx = 1;
				gridBagConstraintsT30.gridy = (i - ys + 1);

				JLabel Order = new JLabel();
				Order.setHorizontalAlignment(0);
				Order.setHorizontalTextPosition(0);
				Order.setText(String.valueOf(i / 2 + 1));
				Order.setPreferredSize(new Dimension(55, 54));
				Order.setBorder(BorderFactory.createEtchedBorder(1));

				JLabel T00 = new JLabel();
				T00.setHorizontalAlignment(0);
				T00.setHorizontalTextPosition(0);
				T00.setText(i / 2 + 9 + ":00");
				T00.setPreferredSize(new Dimension(55, 27));
				T00.setBorder(BorderFactory.createEtchedBorder(1));

				JLabel T30 = new JLabel();
				T30.setHorizontalAlignment(0);
				T30.setHorizontalTextPosition(0);
				T30.setText(i / 2 + 9 + ":30");
				T30.setPreferredSize(new Dimension(55, 27));
				T30.setBorder(BorderFactory.createEtchedBorder(1));

				add(Order, gridBagConstraintsOrder);
				add(T00, gridBagConstraintsT00);
				add(T30, gridBagConstraintsT30);
			}
		}

		public LeftPanel() {
			this(0, 18);
		}
	}

	static class TopPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public TopPanel(int width) {
			setLayout(new GridBagLayout());

			for (int i = 0; i < width; i++) {
				GridBagConstraints gridBagConstraints = new GridBagConstraints();
				gridBagConstraints.fill = 1;
				gridBagConstraints.gridx = i;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.ipadx = 0;
				gridBagConstraints.insets = new Insets(0, 0, 0, 0);

				JLabel jLabel = new JLabel();
				jLabel.setHorizontalAlignment(0);
				jLabel.setBorder(BorderFactory.createEtchedBorder(1));
				jLabel.setPreferredSize(new Dimension(110, 35));
				String[] data = {"월", "화", "수", "목", "금", "토"};
				jLabel.setText(data[i]);
				jLabel.setBorder(BorderFactory.createEtchedBorder(1));
				jLabel.setHorizontalTextPosition(0);
				add(jLabel, gridBagConstraints);
			}
		}

		public TopPanel() {
			this(6);
		}
	}

	static class DaySchedulePanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private final Color odd = new Color(255, 255, 255);
		private final Color even = new Color(225, 225, 225);
		private int ys;

		public DaySchedulePanel(int width, int ys, int ye) {
			GridBagLayout layout = new GridBagLayout();
			this.ys = ys;
			layout.columnWeights = new double[width];
			layout.columnWidths = new int[width];
			layout.rowHeights = new int[ye - ys];
			layout.rowWeights = new double[ye - ys];
			for (int i = 0; i < width; i++) {
				layout.columnWeights[i] = 1.0D;
				layout.columnWidths[i] = 110;
			}
			for (int i = 0; i < ye - ys; i++) {
				layout.rowHeights[i] = 27;
				layout.rowWeights[i] = 1.0D;
			}
			setLayout(layout);
			setBorder(BorderFactory.createEtchedBorder(1));
			setPreferredSize(new Dimension(110 * width, 27 * (ye - ys)));
		}

		public DaySchedulePanel() {
			this(6, 0, 18);
		}

		public void paint(Graphics g) {
			int h = getHeight();
			int w = getWidth();
			g.setColor(this.odd);
			for (int i = 0; i < h; i += 54) {
				g.fillRect(0, i, w, 26);
			}
			g.setColor(this.even);
			for (int i = 27; i < h; i += 54) {
				g.fillRect(0, i, w, 26);
			}
			g.setColor(Color.GRAY);
			paintChildren(g);
			for (int i = 109; i < w; i += 110) {
				g.drawLine(i, 0, i, h);
			}
			paintBorder(g);
		}

		Random rand = new Random();
	}
}

/*
 * Location: D:\Downloads\pknutimetable-r31\pknutimetable-r31.jar!\gui\diaog\
 * DayTimeTableViewer.class Java compiler version: 6 (50.0) JD-Core Version:
 * 0.7.1
 */