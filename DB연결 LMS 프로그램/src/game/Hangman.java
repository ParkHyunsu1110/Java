package game;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Hangman extends JFrame {	
	private JLabel commandTitle = new JLabel("영어 소문자를 입력하시오."), knownWordLabel, wrongGuesses = new JLabel();
	private String[] hidden = {"rainbow", "student", "professor", "guess", "lecture", "department", 
			"library", "android", "ox", "game", "java", "physon", "programming"};
	private String selected;
	private JTextField wordTextField = new JTextField(20);
	private BufferedImage hangmanImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
	private JPanel hangmanPanel, inputPanel;
	private String wordToGuess = null;
	private int numOfWrongGuesses = 0, trynum = 0;
	private String wrongGuessesString = "틀린 문자: ", wordKnown = "";

	public Hangman(String title) {
		super(title);
		setLayout(new BorderLayout());
		drawHangmanStand(hangmanImage);

		wordTextField.setToolTipText("Net Connection: Leave Blank for Random Word");
		inputPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.ipadx = 1;
		gridBagConstraints.gridy = 1;
		inputPanel.add(commandTitle, gridBagConstraints);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		inputPanel.add(wordTextField, gridBagConstraints);

		Random random = new Random();
		int rd = random.nextInt(13);
		if(rd == 0) selected = hidden[0];
		else if(rd == 1) selected = hidden[1];
		else if(rd == 2) selected = hidden[2];
		else if(rd == 3) selected = hidden[3];
		else if(rd == 4) selected = hidden[4];
		else if(rd == 5) selected = hidden[5];
		else if(rd == 6) selected = hidden[6];
		else if(rd == 7) selected = hidden[7];
		else if(rd == 8) selected = hidden[8];
		else if(rd == 9) selected = hidden[9];
		else if(rd == 10) selected = hidden[10];
		else if(rd == 11) selected = hidden[11];
		else if(rd == 12) selected = hidden[12];

		add(inputPanel);

		wordTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (wordToGuess == null) {
                    wordToGuess = selected.toLowerCase();
                    String displayWord = "";
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        wordKnown += "_";
                        displayWord += " _ ";
                    }
                    knownWordLabel = new JLabel(displayWord);
                    GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
                    gridBagConstraints1.gridx = 1;
                    gridBagConstraints1.gridy = 2;
                    gridBagConstraints1.gridwidth = 2;
                    inputPanel.add(knownWordLabel, gridBagConstraints1);
                    gridBagConstraints1 = new GridBagConstraints();
                    gridBagConstraints1.gridx = 1;
                    gridBagConstraints1.gridy = 3;
                    gridBagConstraints1.gridwidth = 2;
                    inputPanel.add(wrongGuesses, gridBagConstraints1);

                    return;
                }

                if (wordToGuess.indexOf(wordTextField.getText()) >= 0) {
                    guessRight();
                } else {
                    guessWrong();
                    wordTextField.setText("");
                }
            }
        });
		setSize(1000, 600);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		showChangedHangman();
		revalidate();
	}

	private void guessRight() {
		trynum++;
		String guess = wordTextField.getText().toLowerCase();
		addGuessToKnownWord(guess);
		String displayString = "";
		for (int i = 0; i < wordKnown.length(); i++) {
			displayString += wordKnown.substring(i, i + 1) + " ";
		}
		knownWordLabel.setText(displayString);

		if (wordKnown.indexOf("_") < 0) {
			JOptionPane.showMessageDialog(this, "축하합니다! " + trynum + "번만에 성공하셨습니다.");
			this.dispose();
		}
		wordTextField.setText("");
	}

	private void addGuessToKnownWord(String guess) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (int index = wordToGuess.indexOf(guess);
				index >= 0;
				index = wordToGuess.indexOf(guess, index + 1)) {
			indexes.add(index);
		}
		for (int i = 0; i < indexes.size(); i++) {
			int index = indexes.get(i);
			StringBuilder stringBuilder = new StringBuilder(wordKnown);
			stringBuilder.replace(index, index + guess.length(), guess);
			wordKnown = stringBuilder.toString();
		}
	}

	private void guessWrong() {
		trynum++;
		numOfWrongGuesses++;
		wrongGuessesString += wordTextField.getText() + ", ";
		wrongGuesses.setText(wrongGuessesString);
		Graphics2D g = (Graphics2D) hangmanImage.getGraphics();
		int x = 250, y = 200;
		g.setStroke(new BasicStroke(2));
		g.setColor(Color.BLACK);

		switch (numOfWrongGuesses) {
		case 1: // Head
			g.drawOval(-20 + x, y, 40, 40);
			break;
		case 2: // Body
			g.drawLine(x, y + 40, x, y + 40 + 80);
			break;
		case 3: // R Arm
			g.drawLine(x, y + 40 + 20, x + 20, y + 40 + 60);
			break;
		case 4: // L Arm
			g.drawLine(x, y + 40 + 20, x - 20, y + 40 + 60);
			break;
		case 5: // R Leg
			g.drawLine(x, y + 40 + 80, x + 20, y + 40 + 80 + 40);
			break;
		case 6: // L Leg
			g.drawLine(x, y + 40 + 80, x - 20, y + 40 + 80 + 40);
			break;
		case 7:
			g.setColor(Color.RED);
			g.drawLine(-10+x, y, -20+x, -20+y);
			break;
		case 8:
			g.setColor(Color.RED);
			g.drawLine(x, y, x, -20+y);
			break;
		case 9:
			g.setColor(Color.RED);
			g.drawLine(x+10, y, x+20, -20+y);
			break;
		default:
			JOptionPane.showMessageDialog(this, "졌습니다. 정답은" + wordToGuess + "입니다.");
			this.dispose();
			break;
		}
		g.dispose();
		showChangedHangman();
		revalidate();
	}

	private void showChangedHangman() {
		if (hangmanPanel != null)
			remove(hangmanPanel);
		hangmanPanel = new JPanel();
		hangmanPanel.add(new JLabel(new ImageIcon(hangmanImage)));
		add(hangmanPanel, BorderLayout.WEST);
		revalidate();
	}

	private static void drawHangmanStand(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setStroke(new BasicStroke(2));
		g.setColor(Color.BLACK);

		g.drawLine(10, 475, 250, 475);
		g.drawLine(100, 475, 100, 100);
		g.drawLine(100, 100, 250, 100);
		g.drawLine(250, 100, 250, 200);

		g.dispose();
	}
}