
import java.util.Scanner;

public class Jennifer_A {
	
	//A B C D E F G H I J K L M N O P Q R S T U V W X Y Z =>26개 
	private final static int AlpaLength = 26;
	
	private static int countAlpa[];
	private static int rankAlpa[];
	
	public static void main(String[] args)
	{
		//countAlpa, rankAlpa 초기화 
		initArrs();
	
		Scanner sc = new Scanner(System.in);	
		String inputStr = sc.next();
		
		//counting 
		int strL = inputStr.length();
		char tmp='0';
		for(int i=0;i<strL;i++)
		{
			tmp = inputStr.charAt(i);
			countAlpa[tmp-'A']++;
		}
		
		//랭크 결정
		rankDecision();
		
		//출력
		printResult();
	}
	
	// 초기화 -> count = 0 , rank = 1 
	public static void initArrs()
	{
		countAlpa = new int[AlpaLength];
		rankAlpa = new int[AlpaLength];
		for(int i=0; i<AlpaLength;i++)
		{
			countAlpa[i] = 0;
			rankAlpa[i] = 1;
		}
	}
	
	// rankAlpa에 순위가 저장되고(1등이 둘이라면 2등은 없고 바로 3등)
	// 등장하지 않은 알파벳의 순위는 -1이 됨 
	public static void rankDecision()
	{
		//자기보다 빈도가 큰 값이 나오면 순위를 미룸 
		for(int i=0;i<AlpaLength;i++)
		{
			for(int j=0;j<AlpaLength;j++)
			{
				if(countAlpa[i] < countAlpa[j])
					rankAlpa[i]++;
			}
		}
		//등장하지 않은 알파벳의 순위를 -1로 
		for(int i=0;i<AlpaLength;i++)
		{
			if(countAlpa[i]==0)
				rankAlpa[i]=-1;
		}
	}

	public static void printResult()
	{
		//최대 AlpaLength등까지 나올수 있음으로 
		for(int i=AlpaLength; i>0 ; i--)
		{
			//rank를 앞에서 부터 순회 
			for(int j=0;j<AlpaLength;j++)
			{
				if(rankAlpa[j]==i)
				{
					int count= countAlpa[j];
					char toPrint = (char)(j+'A');
					for(int k=0;k<count;k++)
					{	
						System.out.print(toPrint);
					}
				}
			}
		}
	}
}


