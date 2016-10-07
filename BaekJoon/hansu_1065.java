package baekjoon;

import java.util.Scanner;

public class hansu_1065 {

	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);

		int toCalculate = sc.nextInt();
		int result=toCalculate;

		if(toCalculate>=100)
		{
			result=99+returnHansuStart100LastInput(toCalculate);
			if(toCalculate==1000)
				result=result-1;
		}
		System.out.println(result);
		
	}
	//100<=n<1000 의 사이의 값을 입력받아서 100<=inputValue사이 한수의 수를 반환
	private static int returnHansuStart100LastInput(int inputValue)
	{
		int countHansu=0;
		for(int calVal=100;calVal<=inputValue;calVal++)
		{
			int tmpCal=calVal;

			int var1   = tmpCal%10;	
			tmpCal = tmpCal/10;
			
			int var10 = tmpCal%10;
			tmpCal = tmpCal/10;
			
			int var100  = tmpCal%10;
			
			if((var100-var10) == (var10-var1))
			{
				countHansu++;
			}
		}
		
		return countHansu;
	}
	
}
