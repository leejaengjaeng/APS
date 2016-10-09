package baekjoon;

import java.util.Scanner;

public class OXquiz_8958 {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//그냥 Integer.parseInt(sc.nextLine()) 하면 런타임 에러 
		int count = sc.nextInt();
		sc.nextLine();
		String inputStr="";
		for(int i=0;i<count;i++)
		{
			inputStr = sc.nextLine();
			System.out.println(countScore(inputStr));
		}
		
	}
	public static int countScore(String inputStr)
	{
		int score=0;
		int addCount=0;
		for(int i=0;i<inputStr.length();i++)
		{
			if(inputStr.charAt(i)=='O')
			{
				addCount++;
				score += addCount;
			}
			else
				addCount=0;
		}
		return score;
		
	}
}