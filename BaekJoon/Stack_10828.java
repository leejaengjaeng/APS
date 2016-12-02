package baekjoon;
/*
 */
import java.util.Scanner;

public class Stack_10828
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int caseNum = Integer.parseInt(sc.nextLine());
		MyStack myStack = new MyStack();
		
		for(int caseCnt=0; caseCnt<caseNum; caseCnt++)
		{
			String cmd[] = sc.nextLine().split(" ");
			if(cmd[0].equals("push")) myStack.push(Integer.parseInt(cmd[1]));
			else if(cmd[0].equals("pop")) System.out.println(myStack.pop());
			else if(cmd[0].equals("size")) System.out.println(myStack.size());
			else if(cmd[0].equals("empty")) System.out.println(myStack.empty());
			else if(cmd[0].equals("top")) System.out.println(myStack.top());
			else System.out.println("Error : "+cmd[0]);
		}
	}
	
}
class MyStack
{
	private int values[];
	private int top;
	public MyStack()
	{
		values = new int[10000];
		top=-1;
	}
	public void push(int input)
	{
		values[++top]=input;
	}
	public int pop()
	{
		if(top==-1) return -1;
		return values[top--];
	}
	public int size()
	{
		return top+1;
	}
	public int empty()
	{
		if(top==-1) return 1;
		else return 0;
	}
	public int top()
	{
		if(top==-1)	return -1;
		return values[top];
	}
}

