import java.util.Scanner;
/*
 * 	�� ���� ���� �� ���ִ� ��Ʈ�� 3������ ��, 
 *  �ٵ� ���� ���� ù�ٿ� �ִ� ������ �Ѱ��� ����� �ۿ� �����ϱ� �� ģ���� ���� �ִ� ���� ������,
 *  2,2 ��ġ���� j�� ������Ű�鼭 
 *  1,1 2,1 1,2 ���� ���� ū ���� �ڱ� ���� ���Ѱ� �� ������ ������ �ִ� �ִ� ����
 */
public class Move_11048 {
	public static void main(String[] agrs)
	{
		Scanner sc = new Scanner(System.in);
		//�ʱ�ȭ
		String nAndM[] = sc.nextLine().split(" ");
		int N = Integer.parseInt(nAndM[0]);
		int M = Integer.parseInt(nAndM[1]);
	
		int board[][] = new int[N+1][M+1];
		
		
		//�Է� �ޱ�
		for(int i=1;i<=N;i++)
		{
			String inputStr[] = sc.nextLine().split(" ");
			for(int j=1;j<=M;j++)
				board[i][j]=Integer.parseInt(inputStr[j-1]);
		}
		
		//N=1,M=1�ΰ͵� �ʱ� ����
		for(int i=1;i<=N;i++)
			board[i][1] += board[i-1][1];
		for(int i=1;i<=M;i++)
			board[1][i] += board[1][i-1];

		//��ȸ�ϸ� ���������� ����
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
