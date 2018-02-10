package JMBook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Jaeyoung Lee
 */
public abstract class Problem {
	protected Scanner scanner;

	public Problem(){}

	protected void setInput(String inputSource) throws FileNotFoundException {
		this.scanner = new Scanner(new FileReader(inputSource));
	}

	public void run() throws IOException {
		int testCase = scanner.nextInt();
		int count = 0;
		while(count < testCase){
			long start = System.currentTimeMillis();
			solution();
			long end = System.currentTimeMillis();
			System.out.println("실행시간(s) : "+ (end-start)/1000.0);
			count++;
		}
	}

	protected abstract void solution() throws IOException;
}
