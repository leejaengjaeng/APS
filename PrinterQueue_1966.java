/*
 * 	Task�� Ŭ������ ���� ���� ã�� ������ �ְ� 
 *  �켱������ �����ؼ� ���� �켱������ ���� ���� ���Ë� ���� ť�� ����
 *  	�켱������ ���� ���� ���̰� ���� ã�� ���̶�� ���
 *  	�켱������ ���� ���� �������� ���� ã�� ���� �ƴ϶�� ī��Ʈ�� ����
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue_1966
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		for(int tc = 0 ; tc<testCase; tc++)
		{
			String inputStr[] = sc.nextLine().split(" ");
			
			int taskNum = Integer.parseInt(inputStr[0]);
			int wantToKnow = Integer.parseInt(inputStr[1]);
			List<Integer> priList = new ArrayList<Integer>();
			Queue<Task> myQ = new LinkedList<Task>();
			
			String taskPri[] = sc.nextLine().split(" ");
			for(int i=0;i<taskNum;i++)
			{
				int pri = Integer.parseInt(taskPri[i]);
				priList.add(pri);
				if(i==wantToKnow) myQ.add(new Task(pri,true));
				else myQ.add(new Task(pri,false));
			}
			
			//�� ã��
			Collections.sort(priList);
			int lastIndex = priList.size()-1;
			int nextPriority = priList.get(lastIndex);
			boolean endFlag = false;
			int printCnt=0;
			while(!endFlag)
			{
				Task t = myQ.remove();
				if(t.getPriority()!=nextPriority) myQ.add(t);
				else
				{
					if(t.isWantToKnow()==true)
					{
						printCnt++;
						endFlag=true;
					}
					else
					{
						printCnt++;
						nextPriority = priList.get(--lastIndex);
					}
				}
			}
			System.out.println(printCnt);
		}
	}
}

class Task
{
	private boolean wantToKnow;
	private int priority;
	public Task(int pri, boolean wantToKnow)
	{
		this.wantToKnow = wantToKnow;
		this.priority = pri;
	}
	public boolean isWantToKnow()
	{
		return wantToKnow;
	}
	public int getPriority()
	{
		return priority;
	}
}