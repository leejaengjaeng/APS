/*
import java.util.Scanner;
import java.io.FileInputStream;

//class Solution {
class Jump_Jaeng_1{
	public static void main(String args[]) throws Exception	{
	  
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;
		
		int size;
		// �ۼ��ִ� �ִ� �Ÿ�
		int K;
		
		
		int current=0;
		//�� ���ִ��� Ȯ���� ���� ����
		int lastHop=0;
		int count=0;
		
		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) 
		{
			current = 0;
			lastHop = 0;
			count = 0;
			
			size = sc.nextInt();
			
			//������� ���� 0�� ����
			Stack st = new Stack(size+1);
			st.push(0);
			
			for(int i=0;i<size;i++)
			{
				st.push(sc.nextInt());
			}
			K = sc.nextInt();
			

			if(st.getTop() > -1)
				current = st.pop();
			else
				count=-1;
			
			while(st.getTop() > -1)
			{
				//lastHop�� -1�� �ʱ�ȭ
				//��ĭ�� �̵� ���ҽ� -1�� ����
				lastHop=-1;
			
				while(st.getTop() > -1)
				{
					if(current - st.getTopValue() <= K)
					{
						lastHop = st.pop();
						continue;
					}
					else
						break;
				}
				if(lastHop == -1)
				{
					count =-1;
					break;
				}
				else
				{
					current = lastHop;
					count++;
				}
			}

        

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(count);
		}
	}
}

class Stack{

	private int top;
	private int[] stones;
	private int size;
	
	// ���� ���� ��ŭ �迭�� ����
	public Stack(int i)
	{
		top = 0;
		size = i;
		stones = new int[size];
	}
	
	// ���� ���� ���� ������ �� ���� ��ȯ
	public int pop()
	{
		int returnValue;
		
		//������ ������� -1�� ��ȯ
		if(top==0){ returnValue=-1;}
		
		//���ÿ� ���� ������ �� ���� ��ȯ�ϰ� top�� �ϳ� ���� 
		//�迭 ������ ������ --top���� �ؾ��� 
		else { returnValue = stones[--top]; }
			
		return returnValue;
	}
	
	public int getTop()
	{
		if(top ==0)
			return -1;
		else
			return top;
	}
	
	public int getTopValue()
	{
		if(top ==0)
			return -1;
		else
			return stones[top-1];
	}
	
	//���� top�� ��ġ�� ��ȯ
	public int push(int i)
	{
		//������ �� ã���� �����ʰ� -1�� ��ȯ 
		if(top>=size)
		{
			return -1;
		}
		else
		{
			stones[top++] = i;
		}
		return top;
	}
}
*/