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
		// 뛸수있는 최대 거리
		int K;
		
		
		int current=0;
		//뛸 수있는지 확인을 위한 변수
		int lastHop=0;
		int count=0;
		
		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) 
		{
			current = 0;
			lastHop = 0;
			count = 0;
			
			size = sc.nextInt();
			
			//출발점을 위해 0을 삽입
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
				//lastHop을 -1로 초기화
				//한칸도 이동 못할시 -1로 유지
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

        

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(count);
		}
	}
}

class Stack{

	private int top;
	private int[] stones;
	private int size;
	
	// 돌의 갯수 만큼 배열을 생성
	public Stack(int i)
	{
		top = 0;
		size = i;
		stones = new int[size];
	}
	
	// 가장 위의 값을 꺼내고 그 값을 반환
	public int pop()
	{
		int returnValue;
		
		//스택이 비었으면 -1을 반환
		if(top==0){ returnValue=-1;}
		
		//스택에 값이 있으면 그 값을 반환하고 top을 하나 내림 
		//배열 번지수 때문에 --top으로 해야함 
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
	
	//현재 top의 위치를 반환
	public int push(int i)
	{
		//스택이 꽉 찾으면 넣지않고 -1을 반환 
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