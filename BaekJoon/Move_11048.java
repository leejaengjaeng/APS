import java.util.Scanner;
/*
 * 	한 점에 도달 할 수있는 루트가 3가지씩 뿐, 
 *  근데 가로 세로 첫줄에 있는 점들은 한가지 방법씩 밖에 없으니깐 그 친구들 먼저 최대 값을 정해줌,
 *  2,2 위치부터 j를 증가시키면서 
 *  1,1 2,1 1,2 셋중 가장 큰 값에 자기 값을 더한게 그 점에서 가질수 있는 최대 사탕
 */
public class Move_11048 {
	public static void main(String[] agrs)
	{
		Scanner sc = new Scanner(System.in);
		//초기화
		String nAndM[] = sc.nextLine().split(" ");
		int N = Integer.parseInt(nAndM[0]);
		int M = Integer.parseInt(nAndM[1]);
	
		int board[][] = new int[N+1][M+1];
		
		
		//입력 받기
		for(int i=1;i<=N;i++)
		{
			String inputStr[] = sc.nextLine().split(" ");
			for(int j=1;j<=M;j++)
				board[i][j]=Integer.parseInt(inputStr[j-1]);
		}
		
		//N=1,M=1인것들 초기 셋팅
		for(int i=1;i<=N;i++)
			board[i][1] += board[i-1][1];
		for(int i=1;i<=M;i++)
			board[1][i] += board[1][i-1];

		//순회하며 목적지까지 가기
		for(int i=2;i<=N;i++)
		{
			for(int j=2;j<=M;j++)
			{
				int num1 = board[i-1][j-1];
				int num2 = board[i][j-1];
				int num3 = board[i-1][j];
				board[i][j] += max(num1,num2,num3);
			}
		}
		System.out.println(board[N][M]);
	}
	public static int max(int num1,int num2, int num3)
	{
		int max=num1;
		if(num2>max)
			max= num2;
		if(num3>max)
			max=num3;
		return max;
	}

}
