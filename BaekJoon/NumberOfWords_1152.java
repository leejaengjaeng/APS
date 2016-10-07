package baekjoon;

import java.util.Scanner;

public class NumberOfWords_1152 {

	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		int numberOfWords=0;
		boolean isBeforeSpace;
		
		if(inputStr.length()!=0)
		{
			if(inputStr.charAt(0)==' ')
				isBeforeSpace=true;
			else
				isBeforeSpace=false;
			
			for(int i=1;i<inputStr.length();i++)
			{
				if(isBeforeSpace==false && inputStr.charAt(i)==' ')
					numberOfWords++;
				
				if(inputStr.charAt(i)==' ')
					isBeforeSpace=true;
				else
					isBeforeSpace=false;
			}
			if(isBeforeSpace==false) numberOfWords++;
		}
		System.out.println(numberOfWords);
	}
}