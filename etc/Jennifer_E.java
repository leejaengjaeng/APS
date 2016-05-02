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
		
		//�ʱ�ȭ
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
		
		//2���� �̻� ��ġ�� �κ� ���ڿ� ã�� 
		makePartition(arrJ,arrI);
		
		//�� ���ڿ��� ���ĺ� ���� ��� jennifer�� input�� �־��� 
		countAlpabet(jenniferStr,inputStr);
		
		//partition�� ���Ե� ù ���ڵ��� jennifer����, input���� �󸶳� �������ֳ� Ȯ��
		//jennifer���� ���� input���� ������ ������ �� ũ�⸸ŭ�� ��������ó�� ���ؼ� ������ ����� ���������
		int revise=checkRevise(inputStr,jenniferStr);
		
		//������,input ���ڿ����� �κ���ġ�ϴ� ���ڿ� ����
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
		//last! input�� ���� ���ڿ��� jennifer�� ������ ���� ��� �� ����ŭ ����Ƚ�� +
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
	//partiton�� �ִ� ���� 2���� ���ϸ� ������ �Ÿ��� ����
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
				
				//��ġ �ϴ� ���� �߰�
				else
				{
					int ti=i, tj=j;
				
					//�ִ� ����� ���� ��ġ�ϴ��� Ȯ��
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
		//���ڿ��� ���� �� ����
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
