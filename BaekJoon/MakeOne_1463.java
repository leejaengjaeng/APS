package baekjoon;

import java.util.Scanner;

public class MakeOne_1463
{
	private static final int INF = 987654321;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int toFind = Integer.parseInt(sc.nextLine());
		int D[] = new int[1000001];
		D[0] = INF;
		D[1] = 0;
		
		for(int i=2;i<=1000000;i++)
		{
			int case1 = i%3==0 ? i/3 : 0;
			int case2 = i%2==0 ? i/2 : 0;
			int case3 = i-1;
			D[i] = min(D[case1],D[case2],D[case3])+1;
		}
		System.out.println(D[toFind]);
	}
	public static int min(int c1,int c2,int c3)
	{
		int min = c1;
		
		if(c2 < min)
			min = c2;
		
		if(c3 < min)
			min = c3;

		return min;
	}
}