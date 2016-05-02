import java.util.Scanner;
import java.util.Stack;

public class Jennifer_C {

	//public static int points[][]; //[np][2] 
	public static double dist[][];
	public static int nP;
	public static final double INFINITY = Double.MAX_VALUE;
	//0:미방문, 1:방문중, 2:후퇴, 3:모든 정점 방문 
	public static int visited[];
	public static double shortest = INFINITY;
	public static int shortestPath[];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		nP = sc.nextInt();
		
		//(10,10),(0,0) 포함 
		Point p[] = new Point[nP+2];
		
		dist = new double[nP+2][nP+2];
		visited = new int[nP+2];
		
		p[0] = new Point(0,0);
		p[nP+1] = new Point(10,10);
		
		int inputTmp=0;
		for(int i=1;i<=nP;i++)
		{
			inputTmp = sc.nextInt();
			p[i] = new Point(inputTmp,sc.nextInt());
		}
		double calTmp=0;
		for(int i=0; i<nP+2;i++)
		{
			for(int j=i;j<nP+2;j++)
			{
				if(i==j) dist[i][j] = INFINITY;
				else 
				{
					calTmp = calDist(p[i],p[j]);
					dist[i][j] = calTmp;
					dist[j][i] = calTmp;
				}
			}
		}
		
		Stack st = new Stack();
		st.push(0);
		while(!st.isEmpty())
		{
			
		}
	}
	
		
	public static boolean isVisitAll(int current)
	{
		for(int i=0;i<nP+1;i++)
		{
			if(current == i) continue;
			if(visited[i]==0) return false;
		}
		return true;
	}
	public static double calDist(Point p1,Point p2)
	{
		double retValue = Math.pow((p1.px-p2.px),2)
					+Math.pow((p1.py-p2.py),2);
		return Math.sqrt(retValue);
	}
	public static void setVisitedZero()
	{
		for(int i=0;i<nP+2;i++)
			visited[i]=0;
		visited[0]=1;
	}
}
class Point
{
	public int px;
	public int py;
	public Point(int x,int y)
	{
		px=x;
		py=y;
	}
}
/*
class Point
{
	public int px;
	public int py;
	public Point link;
	public double weight;
	
	Point(int x,int y,double w)
	{
		px=x;
		py=y;
		link=null;
		weight = w;
	}
}*/