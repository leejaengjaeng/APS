import java.util.Scanner;

public class Jennifer_E {

	public static int jennifer[];
	public static int input[];
	public static String partition[];
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.next();
		String jenniferStr = "JENNIFERSOFT";

		jennifer = new int[26];
		input = new int[26];
		partition = new String[jenniferStr.length()];
		char[] arrJ = new char[jenniferStr.length()];
		char[] arrI = new char[inputStr.length()];
		
		//초기화
		for(int i=0;i<26;i++)
		{
			jennifer[i]= 0;
			input[i] =0;
		}
		for(int i=0;i<jenniferStr.length();i++)
		{
			partition[0]="0";
		}
		
		arrJ = jenniferStr.toCharArray();
		arrI = inputStr.toCharArray();
		
		//2글자 이상 겹치는 부분 문자열 찾기 
		makePartition(arrJ,arrI);
		
		//각 문자열의 알파벳 수를 세어서 jennifer와 input에 넣어줌 
		countAlpabet(jenniferStr,inputStr);
		
		//partition에 포함된 첫 문자들이 jennifer에서, input에서 얼마나 떨어져있나 확인
		//jennifer에서 보다 input에서 간격이 넓으면 그 크기만큼은 수정으로처리 못해서 마지막 결과에 합해줘야함
		int revise=checkRevise(inputStr,jenniferStr);
		
		//제니퍼,input 문자열에서 부분일치하는 문자열 제거
		int index=0;
		for(int i=0;partition[i]!=null;i++)
		{
			for(int j=0;j<partition[i].length();j++)
			{
				index = (int)partition[i].charAt(j)-'A';
				jennifer[index]--;
				input[index]--;
			}
		}
		
		/*
		//last! input에 남은 문자열이 jennifer에 남은것 보다 길면 그 차만큼 변경횟수 +
		int remainI = countArr(input);
		int remainJ = countArr(jennifer);
		int returnValue=remainJ;
		if(remainI > remainJ)
		{
			returnValue += (remainI-remainJ);
		}
		*/
		int returnValue = countArr(jennifer)+revise;
		System.out.println(returnValue);
		
	}
	//partiton에 있는 값을 2개씩 비교하며 사이의 거리를 측정
	public static int checkRevise(String input,String jennifer)
	{
		int revise=0;
		if(partition[0] == "0") return revise;
		else
		{
			int prevIPos=0,prevJPos=0,findIPos,findJPos;
			char toFind;
			for(int i=0;partition[i]!="0";i++)
			{
				System.out.println(partition[i]);
				toFind = partition[i].charAt(0);
				findIPos = findPos(input,toFind);
				findJPos = findPos(jennifer,toFind);
				
				if((findJPos-prevJPos)<(findIPos-prevIPos))
					revise += findIPos-prevIPos;
				
				prevIPos = findIPos;
				prevJPos = findJPos;
			}
			
		}
		
		return revise;
	}
	public static int findPos(String str,char index)
	{
		for(int i=0;i<str.length();i++)
		{
			if(index == str.charAt(i)) return i;
		}
		return -1;
	}
	public static int countArr(int[] arr)
	{
		int ret=0;
		for(int i=0;i<26;i++)
			ret+=arr[i];
		return ret;
	}
	public static void makePartition(char[] jennifer,char[] input)
	{
		int pCount=0;
		int matchCount=0;
		for(int i=0;i<input.length;i++)
		{
			for(int j=0;j<jennifer.length;j++)
			{
				if(i>=input.length) break;
				
				System.out.println(jennifer.length+":"+i+","+j);
				if(input[i]!=jennifer[j]) continue;
				
				//일치 하는 문자 발견
				else
				{
					int ti=i, tj=j;
				
					//최대 몇글자 까지 일치하는지 확인
					while(ti<input.length && tj<jennifer.length && input[ti]==jennifer[tj])
					{
						matchCount++;
						ti++;
						tj++;
					}
					String pString="";
					for(int ii=i;ii<ti;ii++)
					{
						pString+=input[ii];
					}
					partition[pCount++] = pString;
					matchCount=0;
					j=tj;
					i=ti;
				}
						
			}
		}
	}
	
	public static void countAlpabet(String jenniferStr, String inputStr)
	{
		//문자열속 문자 수 저장
		for(int i=0;i<jenniferStr.length();i++)
		{
			jennifer[jenniferStr.charAt(i)-'A']++;
		}
		for(int i=0;i<inputStr.length();i++)
		{
			input[inputStr.charAt(i)-'A']++;
		}
	}
}
