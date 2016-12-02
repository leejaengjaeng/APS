package baekjoon;
/*
 * 	구현을 해야되는데... 걍 이거말고 
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

			// 1~n까지 중 다음에 스택에 넣을 값이 만들 수열의 다음 순서 값보다 작을때 
			while(nextNum>nextInput)
			{
				result[resultCnt++] = '+';
				st.push(nextInput++);
			}
			// 1~n까지 중 다음에 스택에 넣을 값이 만들 수열의 다음 순서 값보다 클때 
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