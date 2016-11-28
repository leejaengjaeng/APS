package baekjoon;

import java.util.Scanner;

public class RepeatString_2675
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int round = Integer.parseInt(sc.nextLine());
		for(int rnd=0;rnd<round;rnd++)
		{
			String inputs[] = sc.nextLine().split(" ");
			int repeat = Integer.parseInt(inputs[0]);
			String originalStr = inputs[1];
			StringBuffer newStr=new StringBuffer();
			for(int i=0;i<originalStr.length();i++)
			{
				char currentChar = originalStr.charAt(i);
				for(int j=0;j<repeat;j++)
					newStr.append(currentChar);
			}
			System.out.println(newStr);
		}
	}
}