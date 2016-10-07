package baekjoon;

import java.util.Scanner;

public class NumberOfNumber_2577 {

	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//그냥 Integer.parseInt(sc.nextLine()) 하면 런타임 에러 
		int num1 = sc.nextInt();
		sc.nextLine();
		int num2 = sc.nextInt();
		sc.nextLine();
		int num3 = sc.nextInt();
		sc.nextLine();
		int[] answerArray = calAnswer(num1, num2, num3);
		for(int i=0;i<10;i++)
		{
			System.out.println(answerArray[i]);
		}
	}
	public static int[] calAnswer(int A,int B,int C)
	{
		int[] answerArray = new int[10];
		
		for(int i=0;i<10;i++)
			answerArray[i]=0;
		int gop = A*B*C;
		
		if(gop==0)
			answerArray[0]=1;
		else
		{
			while(gop>0)
			{
				answerArray[gop%10]++;
				gop = gop/10;
			}
		}
		
		return answerArray;
		
	}
}