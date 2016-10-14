package baekjoon;

/*
 * 다익스트라 기본문제
 */

import java.util.Scanner;
 
public class minimumCost_1916 {
     
	public final static int INF = 987654321;
    public static int paths[][];
    public static int dist[];
    public static boolean visited[];
     
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int cityNum = Integer.parseInt(sc.nextLine());
        int busNum = Integer.parseInt(sc.nextLine());
         
        paths = new int[cityNum+1][cityNum+1];
        dist = new int[cityNum+1];
        visited = new boolean[cityNum+1];
         
        //path 초기화
        for(int i=0;i<=cityNum;i++)
        	for(int j=0;j<=cityNum;j++)
        		paths[i][j]=INF;
        //dist 초기화
        for(int i=0;i<=cityNum;i++)
            dist[i] = INF;
        //경로 입력
        for(int i=1;i<=busNum;i++)
        {
        	String inputStr[] = sc.nextLine().split(" ");
            int start = Integer.parseInt(inputStr[0]);
            int end = Integer.parseInt(inputStr[1]);
            int dist = Integer.parseInt(inputStr[2]);
            
            if(paths[start][end]!=INF)
				paths[start][end] =	paths[start][end] < dist ? paths[start][end] : dist;
			else				
				paths[start][end] = dist;
	
        }
        
        String inputStr[] = sc.nextLine().split(" ");
        int startP = Integer.parseInt(inputStr[0]);
        int endP = Integer.parseInt(inputStr[1]);
        
        
        //다익스트라
        dist[startP]=0; //초기점을 startP로 잡도록 dist를 0으로 초기화 
        //반복횟수가 칠해야되는 정점수 이상이면 selectedPoint가 디폴트 값으로들어감 -> 디폴트값 -1이면 런타임 에러 
        for(int i=0;i<cityNum;i++) 
        {
        	int minPath = INF+1;
        	int selectedPoint= 0;
        	//가장 짧은 거리 찾기 
        	// -> 우선 순위큐에서 자동으로 최소 경로 뽑아주는걸 수동으로 구현 
        	for(int j=1;j<=cityNum;j++)
        	{
        		if(!visited[j] && minPath > dist[j])
        		{
        			minPath=dist[j];
        			selectedPoint=j;
        		}
        	}
        	visited[selectedPoint]=true;

        	//찾고자 하는 정점이 방문되면 종료
        	if(selectedPoint==endP || selectedPoint==0) break;
        	
        	// 경로 갱신
        	for(int j=1;j<=cityNum;j++)
        	{
        		//방문한적 없고, 현재 정점에 인접한 정점까지 길이를 갱신
        		if(!visited[j] && paths[selectedPoint][j]!=INF)
        		{
        			int dist1 = dist[j];
        			int dist2 = dist[selectedPoint]+paths[selectedPoint][j];
        			dist[j] = dist1 < dist2 ? dist1:dist2;   			
        		}
        	}	
        }
        System.out.println(dist[endP]);
        
         
    }     
}
