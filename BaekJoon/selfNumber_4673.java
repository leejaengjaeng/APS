package baekjoon;

public class selfNumber_4673 {

	static boolean isNotSelfNumber[] = new boolean[10040];
	
	public static void main(String[] args)
	{
		for(int i=1;i<=10000;i++)
		{
			isNotSelfNumber[functionD(i)] = true;
		}
		for(int i=1;i<=10000;i++)
		{
			if(isNotSelfNumber[i]==false)
				System.out.println(i);
		}
		
	}
	//inputValue = 양의 정수
	private static int functionD(int inputValue)
	{
		int resultD=inputValue;
		int jarisu = countJarisu(inputValue);
		for(int i=0;i<jarisu;i++)
		{
			resultD += inputValue%10;
			inputValue = inputValue/10;
		}
		return resultD;
	}
	//자리수 카운트
	private static int countJarisu(int inputValue)
	{
		int jarisu=0;
		
		while(inputValue>0)
		{
			inputValue = inputValue/10;
			jarisu++;
		}
		
		return jarisu;
	}
}
