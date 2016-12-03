/*
 * 	class 이름이 Deque로 했어서 런타임 에러인가?
 * 	그건 모르겠고 else에 괄호 안달아서 그랬음 
 */
import java.util.Scanner;

public class Deque_10866
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		MyDeque myDq = new MyDeque();
		
		for(int tc=0;tc<testCase;tc++)
		{
			String input[] = sc.nextLine().split(" ");
			String cmd = input[0]; 
			if(cmd.equals("push_front")) 	myDq.push_front(new Node(Integer.parseInt(input[1])));
			else if(cmd.equals("push_back"))myDq.push_back(new Node(Integer.parseInt(input[1])));
			else if(cmd.equals("pop_front"))System.out.println(myDq.pop_front());
			else if(cmd.equals("pop_back")) System.out.println(myDq.pop_back());
			else if(cmd.equals("size"))	  	System.out.println(myDq.getSize());
			else if(cmd.equals("empty"))	System.out.println(myDq.empty());
			else if(cmd.equals("front"))	System.out.println(myDq.front());
			else if(cmd.equals("back"))	 	System.out.println(myDq.back());
			else 							System.out.println("Error : "+cmd);
		}
	}
	
}
class MyDeque
{
	private Node front;
	private Node end;
	private int size;
	public MyDeque()
	{
		front = null;
		end = null;
		size = 0;
	}
	public int empty()
	{
		if(size==0) return 1;
		else return 0;
	}
	
	public void push_front(Node input)
	{
		if(this.empty()==1)
		{
			front = input;
			end = input;
			size++;
		}
		else
		{
			front.setPrevNode(input);
			front = input;
			size++;
		}
	}
	
	public void push_back(Node input)
	{
		if(this.empty()==1)
		{
			front = input;
			end = input;
			size++;
		}
		else
		{
			end.setNextNode(input);
			end = input;
			size++;
		}
	}
	
	public int pop_front()
	{
		if(this.empty()==1) return -1;
		else
		{
			size--;
			Node toPop = front;
			if(size==0)
			{
				end = null;
				front = null;
			}
			else
			{
				front = front.nextNode;
				front.prevNode = null;
			}
			return toPop.value;
		}
	}
	
	public int pop_back()
	{
		if(this.empty()==1) return -1;
		else
		{
			size--;
			Node toPop = end;
			if(size==0)
			{
				end = null;
				front = null;
			}
			else
			{
				end = end.prevNode;
				end.nextNode = null;
			}
			return toPop.value;
		}
	}
	
	public int front()
	{
		if(this.empty()==1) return -1;
		else return front.value;
	}
	
	public int back()
	{
		if(this.empty()==1) return -1;
		else return end.value;
	}
	
	public int getSize()
	{
		return size;
	}
	
}
class Node
{
	public Node prevNode;
	public Node nextNode;
	public int value;
	public Node(int value)
	{
		this.value = value;
	}
	public void setPrevNode(Node prev)
	{
		this.prevNode = prev;
		prev.nextNode = this;
	}
	public void setNextNode(Node next)
	{
		this.nextNode = next;
		next.prevNode = this;
	}

}