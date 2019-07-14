package programs.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Paths;

import tools.Word;
import tools.ListFile;

public class Program {
	
	Window myWindow;
	ListFile myList;
	Word currWord;
	
	public Program() {
		myWindow = new Window();
		myList = new ListFile(Paths.get("").getParent().get);
		nextWord();

		myWindow.getTextField().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (currWord.checkEng(myWindow.getInput())) {
						System.out.println("correct");
						myWindow.getTextField().setText("");
						nextWord();
					} else {
						System.out.println("incorrect");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
	}
	
	private void nextWord() {
		myWindow.setText((currWord = getRandWord()).getHeb());
		System.out.println(currWord.getDef());
	}
	
	private Word getRandWord() {
		return Word.toWord(myList.readLine((int) (Math.random() * myList.getLineCount())));
	}
	
	public void start() {
		myWindow.setVisible(true);
	}
	
	public static void main(String[] args) {
		Program p = new Program();
		p.start();
	}
}
