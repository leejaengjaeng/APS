
import java.util.Scanner;

public class Jennifer_A {
	
	//A B C D E F G H I J K L M N O P Q R S T U V W X Y Z =>26�� 
	private final static int AlpaLength = 26;
	
	private static int countAlpa[];
	private static int rankAlpa[];
	
	public static void main(String[] args)
	{
		//countAlpa, rankAlpa �ʱ�ȭ 
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
		
		//��ũ ����
		rankDecision();
		
		//���
		printResult();
	}
	
	// �ʱ�ȭ -> count = 0 , rank = 1 
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
	
	// rankAlpa�� ������ ����ǰ�(1���� ���̶�� 2���� ���� �ٷ� 3��)
	// �������� ���� ���ĺ��� ������ -1�� �� 
	public static void rankDecision()
	{
		//�ڱ⺸�� �󵵰� ū ���� ������ ������ �̷� 
		for(int i=0;i<AlpaLength;i++)
		{
			for(int j=0;j<AlpaLength;j++)
			{
				if(countAlpa[i] < countAlpa[j])
					rankAlpa[i]++;
			}
		}
		//�������� ���� ���ĺ��� ������ -1�� 
		for(int i=0;i<AlpaLength;i++)
		{
			if(countAlpa[i]==0)
				rankAlpa[i]=-1;
		}
	}

	public static void printResult()
	{
		//�ִ� AlpaLength����� ���ü� �������� 
		for(int i=AlpaLength; i>0 ; i--)
		{
			//rank�� �տ��� ���� ��ȸ 
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


