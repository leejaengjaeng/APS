package baekjoon;
/*
 * ���� ��ġ�� �������� �� �����ؼ� ���� ��� ���� ��츦 ������ ���
 * ifOne -> index-2�� ifOne, ifTwo �߿� �ִ밪 + W
 * ifTwo -> index-1�� ifOne �� + W
 */

import java.util.Scanner;

public class StairClimb_2579
{
	private static int W[];
	private static int ifOne[];
	private static int ifTwo[];
	
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		int stairNum = Integer.parseInt(sc.nextLine());
		W = new int[stairNum+1];
		ifOne = new int[stairNum+1];
		ifTwo = new int[stairNum+1];
		
		for(int i=1;i<=stairNum;i++)
			W[i] = Integer.parseInt(sc.nextLine());
		
		ifOne[1] = W[1]; ifTwo[1] = 0;
		for(int i=2;i<=stairNum;i++)
		{
			ifOne[i] = (ifOne[i-2] > ifTwo[i-2] ? ifOne[i-2]:ifTwo[i-2]) + W[i];
			ifTwo[i] = ifOne[i-1]+W[i];
		}
		
		System.out.println(ifOne[stairNum] > ifTwo[stairNum] ? ifOne[stairNum] : ifTwo[stairNum]);
	}
}