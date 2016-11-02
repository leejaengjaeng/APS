package baekjoon;

import java.util.Scanner;

public class LeeChinSu_2193
{
	public static void main(String[] args)
	{
		long D1[] = new long[91];
		long D2[] = new long[91];
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		D1[0] = 1; D2[0]=0;
		D1[1] = 1; D2[1]=0;
		for(int i=2;i<=90;i++)
		{
			D1[i] = D1[i-1]+D2[i-1];
			D2[i] = D1[i-1];
		}
		System.out.println(D1[N-1]+D2[N-1]);
	}
}