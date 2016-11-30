package baekjoon;
/*
 * 같은 육각형 라인에있는 점들에 도달하는 거리는 모두 같음 
 */
import java.util.Scanner;

public class BeeHouse_2292
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		int step=1;
		if(N==1) step=1;
		else if(N==2) step=2;
		else
		{
			long startSum=2;
			while(startSum <= N)
			{
				startSum += 6*step;
				step++;
			}
		}
		System.out.println(step);
	}
	
}