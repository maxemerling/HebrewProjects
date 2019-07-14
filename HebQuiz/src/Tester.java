package programs.window;

import tools.ListFile;
import tools.Word;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Tester {

	private static void test1() {
		String s = "(h)cat ;(hello2) dog,,,,,,,,,,,,,,,,,(hell;o4)p1ig)";
		
		int start = s.indexOf('(');
		int end = s.indexOf(')');
		while (start >= 0) {
			if (end > 0) {
				s = s.substring(0, start) + s.substring(end + 1);
			} else {
				break;
			}
			start = s.indexOf('(');
			end = s.indexOf(')');
		}
		s = s.replaceAll(",", ";");
		s = s.replaceAll("[^a-zA-Z;]", "");
		s = s.replaceAll(";{2,}", ";");
		
		String[] answers = s.split("\\;");
		for (String str : answers) {
			System.out.println(str);
		}
	}

	
	private static void test2() {
		ListFile file = new ListFile("D:\\Programming\\Hebrew Words\\all.txt");
		Word currWord = Word.toWord(file.readLine(0));
		int longestEng = currWord.getDef().length();
		int longestEngIdx = 0;
		int longestHeb = Word.strip(currWord.getHeb()).length();
		for (int i = 1; i < file.getLineCount(); i++) {
			currWord = Word.toWord(file.readLine(i));
			int curr = currWord.getDef().length();
			if (curr > longestEng) {
				longestEng = curr;
				longestEngIdx = i;
			}
			curr = Word.strip(currWord.getHeb()).length();
			if (curr > longestHeb) {
				longestHeb = curr;
			}
		}
		
		System.out.println("Longest English: " + longestEng);
		System.out.println("Longest Hebrew: " + longestHeb);
		System.out.println(Word.toWord(file.readLine(longestEngIdx)).getDef());
	}

	public static void main(String[] args) {
		String s = "hello this is a test";
		System.out.println(s.indexOf("this"));
		System.out.println(s.indexOf("thistest"));
    }
}
