package baekjoon;
/*
 * �� ������ �����Ҽ� �ִ� �ٷ� �� ������ �ΰ��� ��ġ �� ū ���� �ڽ��� ���� ���� 
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

		// N x N �Է¹ޱ� -> �Ƕ�̵� ������� �Է��� ������ ������.. 
		for(int i=1;i<=triSize;i++)
		{
			String input[] = sc.nextLine().split(" ");
			for(int j=1;j<=input.length;j++)
				W[i][j] = Integer.parseInt(input[j-1]);
		}
		
		// ��� ���
		D[1][1] = W[1][1];
		for(int i=2;i<=triSize;i++)
			for(int j=1;j<=i;j++)
				D[i][j] = (D[i-1][j-1] > D[i-1][j] ? D[i-1][j-1] : D[i-1][j]) + W[i][j];
		
		//�ִ밪 ���ϱ�
		int max = 0;
		for(int i=1;i<=triSize;i++)
			if(D[triSize][i] > max)
				max = D[triSize][i];

		System.out.println(max);
	}
}