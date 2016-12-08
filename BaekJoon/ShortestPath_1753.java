package baekjoon;
import java.util.Scanner;

/*
 * 	정점이 2만개 이기 때문에 2차원 배열로 짜면 메모리 폭발!
 * 	인접리스트로 짜면 30만개 뿐이니깐 할 수 있음!
 */
public class ShortestPath_1753
{
	private static final int INF = 987654321;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input[] = sc.nextLine().split(" ");
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		int startP = Integer.parseInt(sc.nextLine());
		
		Point pList[] = new Point[V+1];
		for(int i=0;i<=V;i++) 
			pList[i] = new Point();
		
		for(int i=0;i<E;i++)
		{
			input = sc.nextLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			
			pList[u].add(new Point(v,w));
		}
		
		int dist[] = new int[V+1];
		boolean isUsed[] = new boolean[V+1];
		for(int i=0;i<=V;i++) dist[i] = INF;
	
		dist[startP]=0;
		for(int i=1;i<=V;i++)
		{
			int minValue=INF;
			int minIndex=0;
			//최단 거리 찾기 
			for(int j=1;j<=V;j++)
			{
				if(!isUsed[j] && dist[j]<minValue)
				{
					minValue = dist[j];
					minIndex=j;
				}
			}
			Point pointer = pList[minIndex].link;
			//경로 갱신
			while(pointer!=null)
			{
				if(dist[pointer.value] > minValue+pointer.dist)
					dist[pointer.value] = minValue+pointer.dist;
				
				pointer = pointer.link;
			}
			isUsed[minIndex]=true;
		}
		
		for(int i=1;i<=V;i++)
		{
			if(dist[i]==INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
}
class Point
{
	public Point link;
	public Point last;
	public int value;
	public int dist;
	public Point()
	{
		value=0;
		dist=0;
		link=null;
		last=null;
	}
	public Point(int v,int d)
	{
		value=v;
		dist=d;
		link=null;
		last=null;
	}
	public void add(Point input)
	{
		if(last==null) 
		{
			link = input;
			last = input;
		}
		else
		{
			last.link = input;
			last = input;
		}
	}
}