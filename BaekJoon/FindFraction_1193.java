package baekjoon;
/*
 * 좀 어거지로 푼 듯한 느낌이 많이 있다 
 * 
 * 입력한 값에 근접한 N/N 값을 찾고 
 * 그다음 부터 순차탐색 
 */
import java.util.Scanner;

public class FindFraction_1193
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		
		int sum=1;
		int midCnt=1;
		while(sum<=X)
		{
			sum = sum+4*midCnt;
			midCnt++;
		}
		midCnt--;
		int distance = X -(sum-4*midCnt);
		
		int bunja = midCnt;
		int bunmo = midCnt;
	
		if(X==2)
		{
			bunja=1;
			bunmo=2;
		}
		else if(X==3)
		{
			bunja=2;
			bunmo=1;
		}
		else if(X==4)
		{
			bunja=3;
			bunmo=1;
		}
		else
		{
			boolean upFlag	 = false;
			boolean downFlag = false;
			boolean isUpDirection = true;
			while(distance!=0)
			{
				if(upFlag==true)
				{
					bunmo++;
					upFlag=false;
					distance--;
					isUpDirection=false;
					continue;
				}
				if(downFlag==true)
				{
					bunja++;
					downFlag=false;
					distance--;
					isUpDirection=true;
					continue;
				}
				if(isUpDirection)
				{
					bunja--;
					bunmo++;
					if(bunja==1) upFlag=true;
					distance--;
					continue;
				}
				if(!isUpDirection)
				{
					bunja++;
					bunmo--;
					if(bunmo==1) downFlag=true;
					distance--;
					continue;
				}
			}
		}
		System.out.println(bunja+"/"+bunmo);
	}
	
}