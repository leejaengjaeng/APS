/*
 *  사이즈는 고려하지 않음
 */
import java.util.Scanner;

public class Queue_10845
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int caseNum = Integer.parseInt(sc.nextLine());
		MyQueue myQ = new MyQueue();
		
		for(int caseCnt=0; caseCnt<caseNum; caseCnt++)
		{
			String cmd[] = sc.nextLine().split(" ");
			if(cmd[0].equals("push")) myQ.push(Integer.parseInt(cmd[1]));
			else if(cmd[0].equals("pop")) System.out.println(myQ.pop());
			else if(cmd[0].equals("size")) System.out.println(myQ.size());
			else if(cmd[0].equals("empty")) System.out.println(myQ.empty());
			else if(cmd[0].equals("front")) System.out.println(myQ.front());
			else if(cmd[0].equals("back")) System.out.println(myQ.back());
			else System.out.println("Error : "+cmd[0]);
		}
	}
	
}
class MyQueue
{
	private int values[];
	private int end;
	private int front; 
	
	public MyQueue()
	{
		values = new int[10000];
		end = -1;
		front = -1;
	}
	public int empty()
	{
		if(front==-1 && end==-1) return 1;
		else return 0;
	}
	
	public void push(int input)
	{
		if(this.empty()==1)
		{
			values[++end] = input;
			front = 0;
		}
		else
			values[++end] = input;
	}
	public int pop()
	{
		if(this.empty()==1)	return -1;
		else
		{
			if(front == end) 
			{
				int retVal = values[front];
				front=-1;
				end=-1;
				return retVal;
			}
			return values[front++];
		}
	}
	public int size()
	{
		if(this.empty()==1) return 0;
		return end-front+1;
	}
	public int front()
	{
		if(this.empty()==1) return -1;
		else return values[front];
	}
	public int back()
	{
		if(this.empty()==1) return -1;
		else return values[end];
	}
}
