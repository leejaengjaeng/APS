package baekjoon;
import java.util.PriorityQueue;
/*
 * 	구현을 해야되는데... 걍 이거말고 
 */
import java.util.Scanner;

public class Sort2_2751
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int numCount = sc.nextInt();

		for(int numCnt=0;numCnt < numCount; numCnt++ )
		{
			pq.add(numCnt);
			pq.add(numCnt+95162);
		}

		while(!pq.isEmpty())pq.poll();
		
		System.out.println("Done");

		/*
		for(int numCnt=0;numCnt < numCount; numCnt++ )
			pq.add(sc.nextInt());

		while(!pq.isEmpty())
			System.out.println(pq.poll());
			*/
	}
}