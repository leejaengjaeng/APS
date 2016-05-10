import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Bacon_Son_SSu_MJ {

	public static final int Default = 999999999;  
	public static int countArr[];
	public static int isChecked[]; // 0:White, 1:Gray, 2:Black
	public static int minValue = Default;
	public static int minNum = Default;
	public static int peoplesNum;
	public static int relations;
	public static qNode peoples[];
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		peoplesNum = sc.nextInt();
		relations = sc.nextInt();
		
		//n인덱스에 n번 사람을 저장하기 위함
		countArr = new int[peoplesNum+1];
		countArr[0] = Default;
		
		isChecked = new int[peoplesNum+1];
		isChecked[0] = 2;
		
		peoples = new qNode[peoplesNum+1];
		peoples[0] = new qNode(Default,Default);
		
		//peoples 만들기
		for(int i=1;i<=peoplesNum;i++)
		{
			peoples[i] = new qNode(i,0);
		}
		
		//관계 입력 받기
		int p1,p2;
		for(int i=0;i<relations;i++)
		{
			p1 = sc.nextInt();
			p2 = sc.nextInt();
			peoples[p1].add(new qNode(p2,0));
			peoples[p2].add(new qNode(p1,0));
		}
		
		//Bacon 탐색 시작
		Queue<Integer> bfsQ = new LinkedList();
		qNode checkNode;
		int tCount=0;
		int tMin=Default;
		for(int i=1;i<=peoplesNum;i++)
		{
			bfsQ.add(i);
			//i를 시작으로 하는 경로 탐색
			while(bfsQ.isEmpty()==false)
			{
				checkNode = peoples[bfsQ.remove()];
				isChecked[checkNode.value] = 2;	// make Black Node
				countArr[checkNode.value] = checkNode.count;
				tCount = checkNode.count;
				//bfs 처리
				while(checkNode.next!=null)
				{
					checkNode = checkNode.next;
					if(isChecked[checkNode.value]!=0) continue;
					else
					{
						isChecked[checkNode.value]=1;	// make Gray Node
						peoples[checkNode.value].count = tCount+1;
						bfsQ.add(checkNode.value);
					}
				}
			}
			//i를 시작으로 한 결과 확인
			tMin = countBacon();
			//같다 조건 안넣어주면 알아서 최소값중에 제일 앞의 값이 나올듯
			if(tMin < minValue)
			{
				minValue = tMin;
				minNum = i;
			}
//			System.out.println(i+"번째 ] minValue : "+minValue+" minNum : "+minNum);
//			printArr();
			resetStatus();
		}
		System.out.println(minNum);
	}
/*	
	public static void printArr()
	{
		System.out.println("countArr");
		for(int i=1;i<=peoplesNum;i++)
		{
			System.out.print(countArr[i]+", ");
		}
		System.out.println("\nisChecked");
		for(int i=1;i<=peoplesNum;i++)
		{
			System.out.print(isChecked[i]+", ");
		}
		System.out.println("\n===============================================\n");
		
	}
*/
	public static void resetStatus()
	{
		for(int i=1;i<=peoplesNum;i++)
		{
			countArr[i]=0;
			isChecked[i]=0;
			peoples[i].count=0;
		}
	}
	public static int countBacon()
	{
		int sum=0;
		for(int i=1;i<=peoplesNum;i++)
		{
			sum += countArr[i];
		}
		return sum;
	}
}
class qNode
{
	public int value;
	public int count;
	public qNode next;
	
	public qNode(int v, int c)
	{
		value = v;
		count = c;
		next = null;
	}
	public void add(qNode i)
	{
		qNode check = this.next;
		if(check == null)
			next = i;
		else
		{
			while(check.next!=null)
			{
				check = check.next;
			}
			check.next= i;
		}
	}	
}
