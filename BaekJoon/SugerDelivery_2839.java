package baekjoon;
import java.util.Scanner;
/*
 */
public class SugerDelivery_2839
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.nextLine());
		
		int five=0;
		int bongCnt=0;
		
		while(five<input)
		{
			five+=5;
			bongCnt++;
		}
		if(five==input){
			System.out.println(bongCnt);
		}
		else{
			while(five>0)
			{
				bongCnt--;
				five  -= 5;
				int tmpInput = input-five;
				if(tmpInput%3==0){
					bongCnt+=(tmpInput/3);
					break;
				}
			}
			if(bongCnt==0) System.out.println("-1");
			else System.out.println(bongCnt);
		}
		
	}
}
