package baekjoon;
import java.util.Scanner;
/*
 * 	INF가 너무 크면 3번 더하면서 오버플로우가 날 수 있음
 * 
 * 	1 -> n1 -> n2 -> N
 *  1 -> n2 -> n1 -> N
 *  둘중에 더 작은 값 출력 
 */
public class SpecificShortestPath_1504
{
	private static final int INF = 87654321;
	
	private static int base[][];
	private static int N;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input[] = sc.nextLine().split(" ");
		N = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		
		base = new int[N+1][N+1];
		for(int i=0;i<E;i++){
			input = sc.nextLine().split(" ");
			int p1 = Integer.parseInt(input[0]);
			int p2 = Integer.parseInt(input[1]);
			int value = Integer.parseInt(input[2]);

			//양 방향 거리는 같을 수 밖에 없음
			if(base[p1][p2]==0){
				base[p1][p2] = value;
				base[p2][p1] = value;
			}
			else if(base[p1][p2] > value){
					base[p1][p2] = value;
					base[p2][p1] = value;
				}
			else{
				continue;
			}
		}
		
		input = sc.nextLine().split(" ");
		int mustP1 = Integer.parseInt(input[0]);
		int mustP2 = Integer.parseInt(input[1]);

		// 1 -> mustP1 -> mustP2 -> N
		int distPath1 = 0;
		distPath1 += djikstra(1, mustP1);
		distPath1 += djikstra(mustP1, mustP2);
		distPath1 += djikstra(mustP2, N);
		
		// 1 -> mustP2 -> mustP1 -> N
		int distPath2 = 0;
		distPath2 += djikstra(1, mustP2);
		distPath2 += djikstra(mustP2, mustP1);
		distPath2 += djikstra(mustP1, N);

		int minDist = distPath1 < distPath2 ? distPath1 : distPath2;
		
		if(minDist>=INF) System.out.println("-1");
		else System.out.println(minDist);
		
	}
	private static int djikstra(int startP, int endP)
	{
		boolean used[] = new boolean[N+1];
		int dist[] = new int[N+1];
		for(int i=0;i<=N;i++)
			dist[i]=INF;
		
		dist[startP]=0;
		for(int i=0;i<N;i++)
		{
			int minValue=INF;
			int minIndex=0;
			for(int j=1;j<=N;j++)
			{
				if(used[j]==false && minValue>dist[j])
				{
					minValue=dist[j];
					minIndex=j;
				}
			}
			
			for(int j=1;j<=N;j++)
			{
				if(base[minIndex][j]!=0 && (dist[j]>(minValue+base[minIndex][j])) ){
					dist[j] = minValue+base[minIndex][j];

				}
			}
			used[minIndex]=true;
		}
		
		return dist[endP];
	}
}
