/*
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

//class Solution {
public class DFSandBFS_Jaeng_JJu_2 {

	public static void main(String args[]) throws Exception	{
	    
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt(); // Number of vertex
		int e = sc.nextInt(); // Number of Edge
		int start = sc.nextInt(); // start point
	
		Vertex startV = new Vertex(start); // start Vertex
	
		VertexList vList = new VertexList(v);
		
		//���� �ϳ��� �޾Ƽ� �������� ��������Ʈ�� �ְ� ������ �� ������ ���� 
		int v1,v2=0;
		Vertex p1,p2=null;
		for(int i=0;i<e;i++)
		{
			v1 = sc.nextInt();
			v2 = sc.nextInt();
			vList.addVertex(v1);
			vList.addVertex(v2);
			p1 = vList.getVertex(v1);
			p2 = vList.getVertex(v2);
			p1.linkEdge(new Edge(v1,v2));
			p2.linkEdge(new Edge(v2,v1));
		}
		DFS dfs = new DFS();
		dfs.printDFS(vList, startV);

		//�湮������ 0���� �ʱ�ȭ 
		for(int i=0;i<v;i++)
		{
			vList.vArr[i].color = 0;
		}

		System.out.println();
		BFS bfs = new BFS();
		bfs.printBFS(vList, startV);

	}
}

class Vertex
{
	public int value;
	public int color; //0:White 1:Gray 2:Black
	public Edge link;
	public Vertex(int i)
	{
		value = i;
		color=0;
		link = null;
	}
	public void linkEdge(Edge e)
	{
		Edge tmp = link;
		//��ũ�� �ϳ��� ���� ���
		if(link == null)
			link = e;
		//���� ���� ���� �ֱ� ����
		else if(tmp.end>e.end)
		{
			link = e;
			e.nextEdge = tmp;
		}
		else
			tmp.addEdge(e);
	}
}
class Edge
{
	public int start,end;
	public Edge nextEdge;
	public Edge(int s,int e)
	{
		start = s;
		end = e;
		nextEdge = null;
	}
	public void addEdge(Edge e)
	{
		Edge tmp = this;
		while(tmp.nextEdge!=null)
		{
			//e.end�� tmp.end���� ������ ������ �ٲٰ� ����
			if(e.end < tmp.nextEdge.end)
			{
				e.nextEdge = tmp.nextEdge;
				tmp.nextEdge = e;
				return;
			}
			tmp = tmp.nextEdge;
		}
		tmp.nextEdge = e;
	}
}
class VertexList
{
	//�������� ���� ������ �迭
	public Vertex vArr[];
	public int saved;
	public VertexList(int n)
	{
		vArr = new Vertex[n];
		saved=0;
	}
	public void addVertex(int v)
	{	
		for(int i=0;i<saved;i++)
		{
			//�������� �迭�� ������ �׳� ����
			if(vArr[i].value==v)
				return;
		}
		vArr[saved++]=new Vertex(v);
	}
	//v���� ������ Vertex�� ��ȯ
	public Vertex getVertex(int v)
	{
		for(int i=0;i<saved;i++)
		{
			if(vArr[i].value == v)
				return vArr[i];
		}
		return null;
	}
}

class BFS
{
	public Queue<Integer> bfsQ;

	public BFS()
	{
		bfsQ = new LinkedList<Integer>();
	}
	
	public void printBFS(VertexList v,Vertex start)
	{
		Vertex process;
		Vertex checkColor;
		Edge e;
		bfsQ.add(start.value);
		start.color=2;
				
		while(bfsQ.isEmpty()==false)
		{
			process = v.getVertex(bfsQ.remove());
			System.out.print(process.value+" ");
			process.color=2;
			e = process.link;
			while(e!=null)
			{
				checkColor = v.getVertex(e.end);
				if(checkColor.color==0)
				{
					bfsQ.add(e.end);
					checkColor.color=1;
				}
				e = e.nextEdge;
			}
		}
	}
}

class DFS
{
	public Stack<Vertex> dfsS;
	public DFS()
	{
		dfsS = new Stack<Vertex>();
	}
	public void printDFS(VertexList v,Vertex start)
	{
		Vertex process = v.getVertex(start.value);
		Vertex checkColor;
		Edge e;
		
		dfsS.push(process);
		process.color=2;
		System.out.print(process.value+" ");
		
		while(dfsS.isEmpty()==false)
		{
			//�� �ٷ� dfsS.peek() �ϸ� �ȵ���?
			process = v.getVertex(dfsS.peek().value);
			
			e= process.link;
			
			while(e!=null)
			{
				checkColor = v.getVertex(e.end);
				if(checkColor.color==0)
				{
					checkColor.color=1;
					dfsS.push(checkColor);
					System.out.print(checkColor.value+" ");
					e = checkColor.link;
				}
				else
				{
					e = e.nextEdge;
				}
			}
			checkColor = dfsS.pop();
		}
	}
}
*/