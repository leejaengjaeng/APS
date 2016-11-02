package baekjoon;
/*
 * 각 정점에 도달할수 있는 바로 전 정점의 두가지 위치 중 큰 값에 자신의 값을 더함 
 */

import java.util.Scanner;

public class NumberTriangle_1932
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int triSize = Integer.parseInt(sc.nextLine());

		int D[][] = new int[triSize+1][triSize+1];
		int W[][] = new int[triSize+1][triSize+1];

		// N x N 입력받기 -> 피라미드 모양으로 입력은 갱장히 귀찮다.. 
		for(int i=1;i<=triSize;i++)
		{
			String input[] = sc.nextLine().split(" ");
			for(int j=1;j<=input.length;j++)
				W[i][j] = Integer.parseInt(input[j-1]);
		}
		
		// 경로 계산
		D[1][1] = W[1][1];
		for(int i=2;i<=triSize;i++)
			for(int j=1;j<=i;j++)
				D[i][j] = (D[i-1][j-1] > D[i-1][j] ? D[i-1][j-1] : D[i-1][j]) + W[i][j];
		
		//최대값 구하기
		int max = 0;
		for(int i=1;i<=triSize;i++)
			if(D[triSize][i] > max)
				max = D[triSize][i];

		System.out.println(max);
	}
}