package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ObstacleCourse_4485 {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int probCnt=0;
		int size=0;
		do
		{
			size = Integer.parseInt(sc.nextLine());
			if(size==0)	break;
			
			probCnt++;
			boolean isUsedPoint[][] = new boolean[size][size];
			int dist[][] = new int[size][size];
			
			int base[][] = new int[size][size];
			Queue<Point> priQ = new PriorityQueue(size,new PointComp());
			
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
					base[i][j] = sc.nextInt();
				sc.nextLine();
			}
			
		
			
			//시작 정점 셋팅
			priQ.add(new Point(0,0,base[0][0]));
			dist[0][0] = base[0][0];
			isUsedPoint[0][0]=true;
				
			while(!priQ.isEmpty())
			{
				Point cp = priQ.remove();
				int ci=cp.x;
				int cj=cp.y;
				dist[ci][cj] = cp.dist;
				
				//사방 탐색
				if(ci-1>=0 && !isUsedPoint[ci-1][cj])
				{
					isUsedPoint[ci-1][cj]=true;
					priQ.add(new Point(ci-1,cj,cp.dist+base[ci-1][cj]));
				}
				if(cj-1>=0 && !isUsedPoint[ci][cj-1])
				{
					isUsedPoint[ci][cj-1]=true;
					priQ.add(new Point(ci,cj-1,cp.dist+base[ci][cj-1]));
				}
				if((ci+1)<size && !isUsedPoint[ci+1][cj])
				{
					isUsedPoint[ci+1][cj]=true;
					priQ.add(new Point(ci+1,cj,cp.dist+base[ci+1][cj]));
				}
				if((cj+1)<size && !isUsedPoint[ci][cj+1])
				{
					isUsedPoint[ci][cj+1]=true;
					priQ.add(new Point(ci,cj+1,cp.dist+base[ci][cj+1]));
				}
			}

			System.out.println("Problem "+probCnt+": "+dist[size-1][size-1]);
		}while(size!=0);
	}
}

class Point
{
	public int x;
	public int y;
	public int dist;
	
	public Point(int px,int py,int distance)
	{
		x = px;
		y = py;
		dist = distance;
	}
}
class PointComp implements Comparator<Point>
{
	@Override
	public int compare(Point a, Point b)
	{
		return a.dist < b.dist ? -1:1;
	}	
}