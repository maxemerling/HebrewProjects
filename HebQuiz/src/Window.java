package programs.window;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Window extends JFrame {
	
	public static final Dimension size = new Dimension(300, 500);
	
	private JLabel text, correct, incorrect, remaining;
	private JTextField input;
	private JComboBox<String> listBox;
	private Container pane;
	
	public Window() {
		pane = new Container();

		pane.setPreferredSize(new Dimension(500, 300));
		this.setSize(pane.getPreferredSize());
		pane.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		listBox = new JComboBox<String>();
		listBox.setEditable(false);
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		pane.add(listBox, gbc);
		
		JPanel score = new JPanel();
		gbc.gridx = 1;
		pane.add(score,  gbc);
		score.setLayout(new GridLayout(0, 1));
		correct = new JLabel();
		incorrect = new JLabel();
		remaining = new JLabel();
		score.add(remaining);
		score.add(correct);
		score.add(incorrect);
		pane.add(score, gbc);
		
		(text = new JLabel())
			.setFont(new Font("Helvetica", Font.PLAIN, 50));
		gbc.weightx = 0;
		gbc.ipady = 50;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		pane.add(text, gbc);
		
		input = new JTextField();
		input.setFont(new Font("Helvetica", Font.PLAIN, 50));
		gbc.gridy = 2;
		pane.add(input, gbc);

		this.setContentPane(pane);
	}
	
	
	/*public Window() {
		setSize(size);
		
		text = new JLabel("");
		text.setFont(new Font("Helvetica", Font.PLAIN, 50));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.CENTER);
		
		input = new JTextField();
		input.setFont(new Font("Helvetica", Font.PLAIN, 50));
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(text, BorderLayout.CENTER);
		
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new BorderLayout());
		fieldPanel.add(input, BorderLayout.CENTER);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(textPanel, BorderLayout.PAGE_START);
		mainPanel.add(fieldPanel, BorderLayout.PAGE_END);
		
		this.setContentPane(mainPanel);
		
		setFocusable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
	}*/
	
	public void setText(String newText) {
		text.setText(newText);
		pane.revalidate();
	}
	
	public String getInput() {
		return input.getText();
	}
	
	public JTextField getTextField() {
		return input;
	}
	
}
