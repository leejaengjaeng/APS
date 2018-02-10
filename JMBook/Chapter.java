package JMBook;

/**
 * @author Jaeyoung Lee
 */
public enum Chapter {
	CH1("ch1_문제해결시작하기"),
	CH2("ch2_문제해결개관");


	private static final String DEFAULT_PACKAGE_PATH = "src/JMBook/";
	private static final String INPUT_FILE_POSTFIX = "_input";

	private String chapterName;
	Chapter(String chapterName){
		this.chapterName = chapterName;
	}

	public String getInputSource(String problemName){
		return DEFAULT_PACKAGE_PATH+chapterName+"/"+problemName+INPUT_FILE_POSTFIX;
	}
}
