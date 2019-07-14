package tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ListFile {
	
	private Path myPath;
	private int lineCount;
	
	public ListFile(String path) {
		if ((new File(path)).exists()) {
			myPath = Paths.get(path);
		} else {
			throw new IllegalArgumentException("File Doesn't Exist");
		}
		
		lineCount = findLineCount();
	}
	
	/**
	 * Counting starts at 0
	 */
	public String readLine(int lineNumber) {
		try (Stream<String> lines = Files.lines(myPath)) {
			return lines.skip(lineNumber).findFirst().get();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private int findLineCount() {
		try {
			return (int) Files.lines(myPath).count();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getLineCount() {
		return lineCount;
	}
}
