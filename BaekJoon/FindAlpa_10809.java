package baekjoon;

import java.util.Scanner;

public class FindAlpa_10809
{
	private final static int ALPA_SIZE=26;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int alpa[] = new int[ALPA_SIZE];
		
		for(int i=0;i<ALPA_SIZE;i++)
			alpa[i]=-1;
		
		String word = sc.nextLine();
		for(int i=0;i<word.length();i++)
		{
			char ch = word.charAt(i);
			
			if(alpa[ch-'a']==-1) alpa[ch-'a']=i;
			else continue;
		}
		
		for(int i=0;i<ALPA_SIZE;i++)
			System.out.print(alpa[i]+" ");
	}
	
}