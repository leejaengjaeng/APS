package baekjoon;
/*
 * 	������ �ؾߵǴµ�... �� �̰Ÿ��� 
 */
import java.util.Scanner;
import java.util.Stack;

public class StackProgression_1874
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<Integer>();

		int n = sc.nextInt();
		char result[] = new char[2*n];
		
		int nextInput=1;
		int resultCnt=0;
		boolean canMake = true;
		
		for(int in=0;in<n;in++)
		{
			int nextNum = sc.nextInt();

			// 1~n���� �� ������ ���ÿ� ���� ���� ���� ������ ���� ���� ������ ������ 
			while(nextNum>nextInput)
			{
				result[resultCnt++] = '+';
				st.push(nextInput++);
			}
			// 1~n���� �� ������ ���ÿ� ���� ���� ���� ������ ���� ���� ������ Ŭ�� 
			if(nextNum<nextInput)
			{
				result[resultCnt++] = '-';
				int top = st.pop();
				if(top!=nextNum)
				{
					canMake = false;
					break;
				}
			}
			else if(nextNum==nextInput)
			{
				result[resultCnt++] = '+';
				result[resultCnt++] = '-';
				nextInput++;
			}
		}
		
		if(canMake)
			for(char r : result)
				System.out.println(r);
		else
			System.out.println("NO");

	}
}