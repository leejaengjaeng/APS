package baekjoon;

/*
 *  �������� ���������� ���ͽ�Ʈ��!
 *  	���ͽ�Ʈ�� N+1�� ������ �� 
 *  
 *  �÷��̵� ������ O(n^3) �̰� ���ͽ�Ʈ��� O(E+VlogV) �� 
 *  V 1000�� ������ ���ͽ�Ʈ�� V+1�� �����°� �ξ� ����
 */


import java.util.Scanner;

public class party_1238 {
	
	public static int paths[][];
	public static int distToParty[];
	public static int distToHome[];
	public static final int INF = 987654321;
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		String inputStr[] = sc.nextLine().split(" ");
		int N = Integer.parseInt(inputStr[0]);
		int M = Integer.parseInt(inputStr[1]);
		int X = Integer.parseInt(inputStr[2]);
		
		//�ʱ�ȭ
		distToParty = new int[N+1];
		paths = new int[N+1][N+1];
		for(int i=0;i<=N;i++)
			for(int j=0;j<=N;j++)
				paths[i][j] = INF;
		
		//�Ÿ� �Է�
		for(int i=0;i<M;i++)
		{
			inputStr = sc.nextLine().split(" ");
			int st = Integer.parseInt(inputStr[0]);
			int end = Integer.parseInt(inputStr[1]);
			int time = Integer.parseInt(inputStr[2]);
			if(paths[st][end] != INF)
				paths[st][end] = paths[st][end] < time ? paths[st][end] : time;
			else
				paths[st][end] = time;			
		}
		
		//���ͽ�Ʈ��
		for(int i=1;i<=N;i++)
		{
			if(i!=X) distToParty[i] = DijkstraStartToDest(i, X, N);
			else distToParty[i]=0;
		}
		distToHome = DijkstraDestToStart(X, N);
		
		//���� ���
		int ans = -1;
		for(int i=1;i<=N;i++)
		{
			int time = distToParty[i] + distToHome[i];
			if(time > ans)
				ans = time;
		}
		System.out.println(ans);		
	}
	
	// ������ -> ������ �ð� ���ϴ� �Լ�
	public static int DijkstraStartToDest(int start,int dest,int N)
	{
		//�ʱ�ȭ
		boolean isUsed[] = new boolean[N+1];
		int dist[] = new int[N+1];
		for(int i=0;i<=N;i++)
			dist[i] = INF;
		
		//���ͽ�Ʈ��
		dist[start]=0;
		for(int i=0;i<N;i++)
		{
			int minPath = INF+1;
			int currentV = 0;
			
			//���� ª�� �Ÿ� ã�� 
			for(int j=1;j<=N;j++)
			{
				if(!isUsed[j] && dist[j] < minPath)
				{
					minPath = dist[j];
					currentV = j;
				}
			}
			
			//�湮 ǥ��
			if(currentV==dest || currentV==0) break;
			isUsed[currentV] = true;
			
			//�ֺ� ���� ����
			for(int j=1;j<=N;j++)
			{
				if(!isUsed[j] && paths[currentV][j]!=INF)
				{
					int path1 = dist[j];
					int path2 = dist[currentV]+paths[currentV][j];
					dist[j] = path1 < path2 ? path1 : path2; 
				}
			}
		}
		return dist[dest];
	}
	
	// ���������� ��� ������ �ð��� ���ϴ� �Լ� 
	public static int[] DijkstraDestToStart(int start,int N)
	{
		//�ʱ�ȭ
		boolean isUsed[] = new boolean[N+1];
		int dist[] = new int[N+1];
		for(int i=0;i<=N;i++)
			dist[i] = INF;
		
		//���ͽ�Ʈ��
		dist[start]=0;
		for(int i=0;i<N;i++)
		{
			int minPath = INF+1;
			int currentV = 0;
			
			//���� ª�� �Ÿ� ã�� 
			for(int j=1;j<=N;j++)
			{
				if(!isUsed[j] && dist[j] < minPath)
				{
					minPath = dist[j];
					currentV = j;
				}
			}
			
			//�湮 ǥ��
			if(currentV==0) break;
			isUsed[currentV] = true;
			
			//�ֺ� ���� ����
			for(int j=1;j<=N;j++)
			{
				if(!isUsed[j] && paths[currentV][j]!=INF)
				{
					int path1 = dist[j];
					int path2 = dist[currentV]+paths[currentV][j];
					dist[j] = path1 < path2 ? path1 : path2; 
				}
			}
		}
		return dist;
	}
}
