/*
import java.util.Scanner;
import java.io.FileInputStream;

//class Main {
public class Tomato_Su0_1 {
	public static void main(String args[]) throws Exception	{
        
		Scanner sc = new Scanner(System.in);
		
		int col = sc.nextInt();
		int row = sc.nextInt();
		
		//row : 세로, col : 가로 
		int box[][] = new int[row][col];
		
		//익은 토마토를 넣을 큐
		tomaQ q = new tomaQ();
		
		//초기화, 익은 토마토를 큐에 넣음
		// -1 : 없음, 0 : 안익음, 1: 익음, 2: 처리됨 
		int tmp;
		for(int i=0 ; i<row ; i++)
		{
			for(int j=0;j<col;j++)
			{
				tmp = sc.nextInt();
				box[i][j] = tmp;
				if(tmp == 1)
				{
					q.add(new qNode(i,j,0));
				}
			}
		}
		
		int count =0;
		qNode check;
		int i,j;
		//큐에 계속 넣으면서 확인
		while(q.isEmpty()==false)
		{
			check = q.remove();
			i= check.px;
			j= check.py;
			count = check.day;

			System.out.println("==========");
			System.out.println(count);
			printBox(box,row,col);
				
			//처리한 토마토 2로 표시 
			box[i][j]=2;
				
			// ↑
			if(i-1>=0)
			{
				if(box[i-1][j]==0)
				{
					box[i-1][j] = 1;
					q.add(new qNode(i-1,j,count+1));
				}
			}
			// ↓
			if(i+1<row)
			{
				if(box[i+1][j]==0)
				{
					box[i+1][j]=1;
					q.add(new qNode(i+1,j,count+1));
				}	
			}
			// <-
			if(j-1>=0)
			{
				if(box[i][j-1]==0)
				{
					box[i][j-1]=1;
					q.add(new qNode(i,j-1,count+1));
				}	
			}
			// ->
			if(j+1<col)
			{
				if(box[i][j+1]==0)
				{
					box[i][j+1]=1;
					q.add(new qNode(i,j+1,count+1));
				}		
			}
			
		}
		
		if(isDone(box,row,col)==false) count=-1;
				
		System.out.println(count);
	}
	
	//현재 상자 상태 확인
	//return true : 완성, return false : 미완성
	public static boolean isDone(int[][] box,int row,int col)
	{
		for(int i=0 ; i<row ; i++)
		{
			for(int j=0;j<col;j++)
			{
				if(box[i][j]==0)
				{
					return false;
				}
			}
		}
		return true;
	}
	public static void printBox(int[][] box, int row,int col)
	{
		for(int i=0 ; i<row ; i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(box[i][j]+" ");
			}
			System.out.println();		
		}	
	}
}	
class qNode
{
	public int px,py,day;
	public qNode next;
	public qNode(int a, int b,int d)
	{
		px=a;
		py=b;
		day=d;
		next=null;
	}
}
class tomaQ
{
	public qNode start,end;
	
	public tomaQ()
	{
		start = null;
		end = null;
	}
	public qNode add(qNode in)
	{
		if(start==null)
		{
			start = in;
			end = in;
		}
		else
		{
			end.next = in;
			end = end.next;
		}
			
		return end;
	}
	public qNode remove()
	{
		qNode toReturn;
		
		if(start!=null)
		{
			toReturn = start;
			start = start.next;
		}
		else
		{
			toReturn = null;
		}
		
		return toReturn;
	}
	public boolean isEmpty()
	{
		if(start==null)
			return true;
		else
			return false;
	}
}
*/