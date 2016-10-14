package baekjoon;

/*
 *  시작점이 정해졌을때 다익스트라!
 *  	다익스트라 N+1번 돌리면 됨 
 *  
 *  플루이드 워셜은 O(n^3) 이고 다익스트라는 O(E+VlogV) 라서 
 *  V 1000개 정도는 다익스트라 V+1번 돌리는게 훨씬 빠름
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
		
		//초기화
		distToParty = new int[N+1];
		paths = new int[N+1][N+1];
		for(int i=0;i<=N;i++)
			for(int j=0;j<=N;j++)
				paths[i][j] = INF;
		
		//거리 입력
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
		
		//다익스트라
		for(int i=1;i<=N;i++)
		{
			if(i!=X) distToParty[i] = DijkstraStartToDest(i, X, N);
			else distToParty[i]=0;
		}
		distToHome = DijkstraDestToStart(X, N);
		
		//정답 출력
		int ans = -1;
		for(int i=1;i<=N;i++)
		{
			int time = distToParty[i] + distToHome[i];
			if(time > ans)
				ans = time;
		}
		System.out.println(ans);		
	}
	
	// 시작점 -> 도착점 시간 구하는 함수
	public static int DijkstraStartToDest(int start,int dest,int N)
	{
		//초기화
		boolean isUsed[] = new boolean[N+1];
		int dist[] = new int[N+1];
		for(int i=0;i<=N;i++)
			dist[i] = INF;
		
		//다익스트라
		dist[start]=0;
		for(int i=0;i<N;i++)
		{
			int minPath = INF+1;
			int currentV = 0;
			
			//가장 짧은 거리 찾기 
			for(int j=1;j<=N;j++)
			{
				if(!isUsed[j] && dist[j] < minPath)
				{
					minPath = dist[j];
					currentV = j;
				}
			}
			
			//방문 표시
			if(currentV==dest || currentV==0) break;
			isUsed[currentV] = true;
			
			//주변 정점 갱신
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
	
	// 도착점부터 모든 점까지 시간을 구하는 함수 
	public static int[] DijkstraDestToStart(int start,int N)
	{
		//초기화
		boolean isUsed[] = new boolean[N+1];
		int dist[] = new int[N+1];
		for(int i=0;i<=N;i++)
			dist[i] = INF;
		
		//다익스트라
		dist[start]=0;
		for(int i=0;i<N;i++)
		{
			int minPath = INF+1;
			int currentV = 0;
			
			//가장 짧은 거리 찾기 
			for(int j=1;j<=N;j++)
			{
				if(!isUsed[j] && dist[j] < minPath)
				{
					minPath = dist[j];
					currentV = j;
				}
			}
			
			//방문 표시
			if(currentV==0) break;
			isUsed[currentV] = true;
			
			//주변 정점 갱신
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
